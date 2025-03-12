from django import forms
from .models import Commande

class CommandeForm(forms.ModelForm):
    class Meta:
        model = Commande
        fields = ['statut']
        widgets = {
            'statut': forms.Select(attrs={'class': 'form-control'}),
        }
