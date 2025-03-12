from django.urls import path
from .views import accueil, liste_produits, ajouter_produit, modifier_produit, supprimer_produit, details

urlpatterns = [
     path('', accueil, name='accueil'),
    path('liste_produits/', liste_produits, name='liste_produits'),
    path('details/<int:id>', details, name='details'),
    path('ajouter/', ajouter_produit, name='ajouter_produit'),
    path('modifier/<int:pk>/', modifier_produit, name='modifier_produit'),
    path('supprimer/<int:pk>/', supprimer_produit, name='supprimer_produit'),
]
