from django.contrib.auth.models import User
from django import forms
from django.contrib.auth.forms import UserCreationForm

class  UserForm(UserCreationForm):
    email = forms.EmailField(label = 'email')
    
    class Meta:
        model = User
        fields = ("username","email")
        