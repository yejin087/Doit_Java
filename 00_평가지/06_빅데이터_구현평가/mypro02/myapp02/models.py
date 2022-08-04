from django.db import models
from datetime import datetime


# Create your models here.
class Board(models.Model):
    idx=models.AutoField(primary_key=True)
    writer=models.CharField(null=False,max_length=50)
    title=models.CharField(null=False,max_length=200)
    content=models.TextField(null=False)
    hit=models.IntegerField(default=0)
    post_date=models.DateTimeField(default=datetime.now,blank=True)
    filename=models.CharField(null=True,blank=True,default='',max_length=500)
    filesize=models.IntegerField(default=0)
    down=models.IntegerField(default=0)

    def hit_up(self):
      self.hit +=1

    def down_up(self):
      self.down += 1  

class Comment(models.Model):
  idx=models.AutoField(primary_key=True)
  board_idx = models.ForeignKey(Board, on_delete=models.CASCADE)
  writer=models.CharField(null=False, max_length=50)
  content=models.TextField(null=False)
  post_date=models.DateTimeField(default=datetime.now,blank=True)   
  
  
class Forecast(models.Model):
    city=models.CharField(null=False, max_length=500)
    tmef=models.TextField(null=True)  
    wf=models.TextField(null=True)  
    tmn=models.IntegerField(default=0)  
    tmx=models.IntegerField(default=0)  
    
class Movie(models.Model):
    title = models.CharField(null=False, max_length=500)
    point= models.CharField(null=False, max_length=500)
    content= models.CharField(null=False, max_length=500)
