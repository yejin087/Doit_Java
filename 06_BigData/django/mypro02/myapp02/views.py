from csv import field_size_limit
from urllib import response
from django.shortcuts import render, redirect
from django.views.decorators.csrf import csrf_exempt
from django.http.response import HttpResponse, JsonResponse
from django.db.models import Q
import urllib.parse
import math
from django.core.paginator import Paginator
from myapp02.models import Board, Comment, Forecast, Movie


from .form import UserForm
from django.contrib.auth import authenticate,login
from django.contrib.auth.decorators import login_required
from myapp02 import bigdataprocess
import json
from django.db.models.aggregates import Avg,Count
import pandas as pd

UPLOAD_DIR = 'D:\\Workspace\\PythonProjects\\django\\upload\\'

def water(request):
    water_dict = bigdataprocess.make_waterconcat()
    paginator = Paginator(tuple(water_dict.items()),10)
    page = request.GET.get('page','1')
    print('page' , page)
    posts = paginator.get_page(page)
    print('posts' , posts)
    
    return render(request,'bigdata/water.html',{'water':water_dict.items(),'posts' : posts})

def movie(request):
    
    data = []
    bigdataprocess.movie_crawling(data)
    
    for r in data:
        dto = Movie(title=r[0],
                    point=r[1],
                    content=r[2])
        dto.save()
    return redirect('/')
    
    
def movie_chart(request):

    data = Movie.objects.values('title').annotate(point_avg = Avg('point'))[:10]
    df = pd.DataFrame(data)
    bigdataprocess.make_chart(df.title, df.point_avg)

    return render( request, "bigdata/movie.html", {"data":data, "img_data":'movie_fig.png'})
   
def weather(request):
    last_date = Forecast.objects.values('tmef').order_by('-tmef')[:1]
    weather = {}
    bigdataprocess.weather_forecast(last_date, weather)
    
    for i in weather:
        for j in weather[i]:
            print(j)
            dto = Forecast(city=i, tmef=j[0], wf=j[1], tmn=j[2], tmx=j[3])
            dto.save()

    result = Forecast.objects.filter(city='부산')
    result1 = Forecast.objects.filter(city='부산').values('wf').annotate(dcount=Count('wf')).values('dcount','wf')

    print('query1' + str(result1.query))    
    # query1 
    # SELECT `myapp02_forecast`.`wf`, COUNT(`myapp02_forecast`.`wf`) AS `dcount` 
    # FROM `myapp02_forecast` 
    # WHERE `myapp02_forecast`.`city` = 부산 
    # GROUP BY `myapp02_forecast`.`wf` 
    # ORDER BY NULL

    df = pd.DataFrame(result1)
    image_dic = bigdataprocess.weather_make_chart(result, df.wf, df.dcount)
    return render(request, "bigdata/weather.html",{"img_data" : image_dic})
    
def wordcloud(request):
    a_path = "D:\\Workspace\\PythonProjects\\json\\"
    data = json.loads(open(a_path+'4차 산업혁명.json', 'r', encoding='utf-8').read())
    bigdataprocess.make_wordCloud(data)
    return render(request, 'bigdata/wordcloud.html', {'img_data' : 'k_cloud.png'})

def melon(request):
    datas = []
    bigdataprocess.melon_crawling(datas)
    return render(request,'bigdata/melon.html', {'data' : datas})

def loginform(request):
        return render(request,'common/login.html')


def signup(request):
    
    if request.method == "POST":
        form = UserForm(request.POST)
        if form.is_valid():
            print('singup Post is vaild')
            form.save()
            username = form.cleaned_data.get('username')
            raw_password = form.cleaned_data.get('password1')
            user = authenticate(username=username, password=raw_password)
            login(request,user)
        else:
            print('singup Post is invaild')
    else:
        form = UserForm()
        
    return render(request,'common/signup.html', {'form' : form})


@login_required(login_url='/login/')
def write_form (request):
    return render(request, 'board/write_form.html')


@csrf_exempt
def insert(request):
    fname = ''
    fsize = 0
    print("insert")
    if 'file' in request.FILES:
        print("file file")
        file = request.FILES['file']
        fname = file.name
        fsize = file.size
        fp = open("%s%s" % (UPLOAD_DIR, fname), 'wb')
        for chunk in file.chunks():
            fp.write(chunk)
        fp.close()
        
    dto = Board(writer= request.POST['writer'],
                title = request.POST.get('title'),
                content = request.POST.get('content'),
                filename = fname,
                filesize = fsize
            )
    
    dto.save()
    
    return redirect("/list_page/")

#전체보기--- 기본
def list_board(request): 
  boardList = Board.objects.all()
  
  context = {'boardList': boardList}
  return render(request, 'board/list.html',context)  

def list_page(request):
    board = Board.objects
    boardList = Board.objects.all()
    paginator = Paginator(boardList,3)
    page = request.GET.get('page','1')
    print('page' , page)
    posts = paginator.get_page(page)
    print('posts' , posts)
    return render(request, 'board/list.html', {'boardList' : boardList, 'posts' : posts})
    

def detail(request, board_idx):
    dto = Board.objects.get(idx=board_idx)
    
    context = {'dto': dto}
    return render(request, 'board/detail.html', context)


def delete(request, board_idx):
    dto = Board.objects.get(idx=board_idx).delete()
    return redirect("/list/")


# 수정 폼
def update_form(request,board_idx ) :
  dto = Board.objects.get(idx = board_idx)
  return  render(request, 'board/update_form.html', {'dto' :dto })



# 수정
@csrf_exempt
def update(request):
  id = request.POST['idx']

  dto = Board.objects.get(idx = id)
  fname = dto.filename
  fsize = dto.filesize

  if 'file' in request.FILES:
    file = request.FILES['file']
    fname = file.name
    fsize = file.size
    fp = open('%s%s' %(UPLOAD_DIR, fname),'wb')
    for chunk in file.chunks():
      fp.write(chunk)
    fp.close()

  dto_update = Board(id, 
          writer = request.POST['writer'],
          title = request.POST['title'],
          content = request.POST['content'],
          filename = fname,
          filesize =fsize          
          )
  dto_update.save()        
  return redirect("/list/")


# comment insert
@csrf_exempt
@login_required(login_url='/login/')
def comment_insert(request):  
  id = request.POST['idx']
  dto = Comment(board_idx_id = id,
                writer ='aa',
                content = request.POST['content'])
  dto.save()
  return redirect("/detail/"+id)

# download_count
def download_count(request):
  id = request.GET['idx']
  print('id : ', id)

  dto = Board.objects.get(idx =  id)
  dto.down_up()
  dto.save()
  count = dto.down
  print('count' , count)

  return JsonResponse({'idx': id , 'count' : count})


# 다운로드
def download(request):
  id = request.GET['idx']

  dto = Board.objects.get(idx = id)
  path =  UPLOAD_DIR + dto.filename
  
  filename = urllib.parse.quote(dto.filename)  # 장고 4.0
  print('filename : ', filename)
  
  with open(path, 'rb') as file:
    response = HttpResponse(file.read(),
              content_type='application/octet-stream')
    response['Content-Disposition']="attachment;filename*=UTF-8''{0}".format(filename)          
  
    return response




   