from django.urls import path
from .views import liste_panier, ajouter_panier, modifier_panier, supprimer_panier

urlpatterns = [
    path('', liste_panier, name='liste_panier'),
    path('ajouter/', ajouter_panier, name='ajouter_panier'),
    path('modifier/<int:pk>/', modifier_panier, name='modifier_panier'),
    path('supprimer/<int:pk>/', supprimer_panier, name='supprimer_panier'),
]
