from django.shortcuts import render

# Create your views here.

def write_form(request):
    return render(request, 'board/write.html')
