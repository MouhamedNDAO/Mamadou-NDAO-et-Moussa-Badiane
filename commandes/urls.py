from django.urls import path
from .views import liste_commandes, passer_commande, modifier_commande, supprimer_commande

urlpatterns = [
    path('', liste_commandes, name='liste_commandes'),
    path('passer/', passer_commande, name='passer_commande'),
    path('modifier/<int:pk>/', modifier_commande, name='modifier_commande'),
    path('supprimer/<int:pk>/', supprimer_commande, name='supprimer_commande'),
]
