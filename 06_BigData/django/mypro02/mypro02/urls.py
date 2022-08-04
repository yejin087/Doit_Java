"""mypro02 URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/4.0/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path
from myapp02 import views
from django.urls import path
from django.contrib.auth import views as auth_views

urlpatterns = [
    path('admin/', admin.site.urls),
    path('', views.write_form),
    path('write_form/', views.write_form),
    path('insert/', views.insert),
    
    path('list/', views.list_board),
    path('list_page/', views.list_page),
    
    path('detail/<int:board_idx>', views.detail),
    
    path('delete/<int:board_idx>/', views.delete),
    path('update_form/<int:board_idx>/', views.update_form),
    path('update/', views.update),
    
    path('comment_insert/', views.comment_insert),
    
    path('download/', views.download),
    path('download_count/', views.download_count),
    
    path('signup/', views.signup),
    path('loginform/', views.loginform),
    path('login/', auth_views.LoginView.as_view(template_name='common/login.html'), name='login'),
    path('logout/', auth_views.LogoutView.as_view(), name='logout'),
    
    path('melon/', views.melon),
    path('wordcloud/', views.wordcloud),
    path('weather/', views.weather),
    path('movie/', views.movie),
    path('movie_chart/', views.movie_chart),
    path('water/', views.water),
  

]
