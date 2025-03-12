from django.urls import path
from .views import liste_categories, ajouter_categorie, modifier_categorie, supprimer_categorie

urlpatterns = [
    path('', liste_categories, name='liste_categories'),
    path('ajouter/', ajouter_categorie, name='ajouter_categorie'),
    path('modifier/<int:pk>/', modifier_categorie, name='modifier_categorie'),
    path('supprimer/<int:pk>/', supprimer_categorie, name='supprimer_categorie'),
]
