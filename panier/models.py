from django.db import models
from django.contrib.auth.models import User
from produits.models import Produit

# Create your models here.

class Panier(models.Model):
    client = models.ForeignKey(User, on_delete=models.CASCADE)
    produit = models.ForeignKey(Produit, on_delete=models.CASCADE)
    quantite = models.PositiveIntegerField(default=1)
    date_ajout = models.DateTimeField(auto_now_add=True)

    def __str__(self):
        return f"{self.client.username} - {self.produit.nom} ({self.quantite})"
