from django import forms
from .models import Panier

class PanierForm(forms.ModelForm):
    class Meta:
        model = Panier
        fields = ['produit', 'quantite']
        widgets = {
            'produit': forms.Select(attrs={'class': 'form-control'}),
            'quantite': forms.NumberInput(attrs={'class': 'form-control', 'min': 1}),
        }
