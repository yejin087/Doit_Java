import pandas as pd
import re
from nltk.tokenize import word_tokenize
from nltk.corpus import stopwords
from nltk.stem import WordNetLemmatizer
from wordcloud import STOPWORDS, WordCloud
import nltk
import json
from konlpy.tag import Okt
from collections import Counter
import matplotlib
import matplotlib.pyplot as plt
from matplotlib import font_manager, rc
from docutils.parsers.rst.directives import encoding
import matplotlib as mpl
import requests 
from bs4 import BeautifulSoup
import urllib

def call_getVillageWaterQuality():
    url = 'http://apis.data.go.kr/6260000/TownWaterQualityService/getVillageWaterQuality'
    params ={'serviceKey' : 'l9KDvSgYZZPF7NGBPKjJgV6/pU+fhBakLsJSW1avERVypdf2WAD6J4uaF5XHRhOYdZnLhUFU/XFa5W8z+5wGqw==', 
            'pageNo' : '1', 
            'numOfRows' : '745',
            'resultType' : 'json', 
            }
    res = requests.get(url, params=params)
    
    global df_quailty
    df_quailty = pd.DataFrame(res.json()['getVillageWaterQuality']['item'])
    df_quailty.rename(columns = {'argGugun' : 'siguCd', 'argHjd' : 'dongCd'}, inplace = True)

def call_getGugunDong():
    url = 'http://apis.data.go.kr/6260000/TownWaterQualityService/getGugunDong'
    params ={'serviceKey' : 'l9KDvSgYZZPF7NGBPKjJgV6/pU+fhBakLsJSW1avERVypdf2WAD6J4uaF5XHRhOYdZnLhUFU/XFa5W8z+5wGqw==', 
            'pageNo' : '1', 
            'numOfRows' : '252',
            'resultType' : 'json'
            }
        
    res = requests.get(url, params=params)
 
    global df_gundong, dongNm
    df_gundong = pd.DataFrame(res.json()['getGugunDong']['item'])
    dongNm = df_gundong['dongNm']

def make_waterconcat():
    # call_getVillageWaterQuality()
    # call_getGugunDong()
    
    water_total_csv = pd.read_csv('D:/Workspace/PythonProjects/csv/busan_water_total.csv',encoding='utf-8-sig')
    df_water = pd.DataFrame(water_total_csv)
    print(df_water)

    # df_concat = pd.merge(df_gundong ,df_quailty, on = ["dongCd","siguCd"])
    return df_water.to_dict('index')


def movie_crawling(data):
    url = 'https://movie.daum.net/ranking/reservation'

    req = requests.get(url)
    html = req.text
    soup = BeautifulSoup(html, 'html.parser')

    posters = soup.select_one('#mainContent > div > div.box_ranking > ol')
    for poster in posters.select('li'):
        title = poster.select_one('strong.tit_item > a').get_text()
        rate = poster.select_one('span.txt_append > span.info_txt > .txt_grade').get_text()
        reservationrate = poster.select_one('span.txt_append > span.info_txt > .txt_num').get_text()[:-1]
        data.append([title, rate, reservationrate])
    print(data)
    
def make_chart(titles, points):
    font_name = font_manager.FontProperties(fname='C:\\Windows\\Fonts\\NanumBarunGothic.ttf').get_name() 
    rc('font', family=font_name)
    plt.cla()
    plt.ylabel('rate')
    plt.xlabel('title')
    plt.bar(range(len(titles)), points, align='center')
    plt.xticks(range(len(titles)), list(titles), rotation=30, fontsize=5)
    plt.savefig('./static/images/movie_fig.png', dpi=100)
    
def melon_crawling(datas):
    header = {'User-Agent':'Mozilla/5.0'}
    url = 'https://www.melon.com/chart/index.htm'
    req = requests.get(url, headers=header)
    html = req.text
    soup = BeautifulSoup(html,'html.parser')

    trs = soup.select('#frm > div > table > tbody > tr')

    for tr in trs:
        rank = tr.select_one('.rank').text
        title = tr.select_one('.wrap_song_info').select_one('a').string
        singer = tr.select_one('.rank02').select_one('a').string
        album = tr.select_one('.rank03').select_one('a').string
        tmp = dict()
        tmp['rank'] = rank
        tmp['title'] = title
        tmp['singer'] = singer
        tmp['ablum'] = album
        datas.append(tmp)


def make_wordCloud(data):
    font_path = 'C:/Windows/Fonts/malgun.ttf'
    message = ''
    
    
    for item in data:
        if 'message' in item.keys():
            message = message + re.sub(r'[^\w]', ' ', item['message'])
            
    nlp = Okt()
    message_N = nlp.nouns(message)
    count = Counter(message_N)

    word_count = dict()

    for tag, counts in count.most_common(80):
        if len(str(tag)) > 1:
            word_count[tag] = counts
            
    
    wc = WordCloud(font_path, background_color='ivory', width=800, height=600)
    cloud = wc.generate_from_frequencies(word_count)
    plt.figure(figsize=(8,8))
    plt.imshow(cloud)
    plt.axis('off')
    cloud.to_file('./static/images/k_cloud.png')
    
    
def weather_forecast(last_date, weather):
    req = requests.get('https://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp')
    soup = BeautifulSoup(req.text,'lxml')
    locations = soup.select("location")

    # city, tmef, wf,tmn, tmx
    for location in locations:
        city = location.select_one('city').text
        weather[city] =[]
        for data in location.select('data'):
            if len(last_date) == 0 or data.find('tmef').text > last_date[0]['tmef']:
                tmef = data.select_one('tmEf').text
                wf = data.select_one('wf').text
                tmn = data.select_one('tmn').text
                tmx = data.select_one('tmx').text
                weather[city].append([tmef, wf, tmn, tmx])
                
    
    
def weather_make_chart(result, wfs, dcounts):
    font_name = font_manager.FontProperties(fname='C:\\Windows\\Fonts\\NanumBarunGothic.ttf').get_name()
    mpl.rc('font', family=font_name)
    
    high = []
    low = []
    xdata = []
    

    for row in result.values_list():
        high.append(row[5])
        low.append(row[4])
        xdata.append(row[2].split('-')[2])
        
    plt.cla()
    plt.figure(figsize=(10,6))
    plt.plot(xdata, low, label='low')
    plt.plot(xdata, high, label='high')
    plt.legend()
    # plt.savefig( os.path.join(STATIC_DIR,'images\\weather_plot.png'), dpi=300)
    plt.savefig('./static/images/weather_plot.png',dpi=300)
    
    plt.cla()
    plt.bar(wfs, dcounts)
    plt.savefig('./static/images/weather_bar.png',dpi=300)
    
    plt.cla()
    plt.pie(dcounts, labels=wfs, autopct='%.1f%%')
    plt.savefig('./static/images/weather_pie.png',dpi=300)
    
    image_dic = {'plot' : 'weather_plot.png', 'bar' : 'weather_bar.png', 'pie' : 'weather_pie.png'}
    return image_dic
        
   

    
    
            