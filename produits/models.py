from django.db import models
from categories.models import Categorie


# Create your models here.
class Produit(models.Model):
    nom = models.CharField(max_length=255)
    description = models.TextField(blank=True, null=True)
    prix = models.DecimalField(max_digits=10, decimal_places=2)
    stock = models.PositiveIntegerField(default=0)
    image = models.ImageField(upload_to='produits/', blank=True, null=True)
    categorie = models.ForeignKey(Categorie, on_delete=models.CASCADE, related_name="produits")
    date_ajout = models.DateTimeField(auto_now_add=True)

    def __str__(self):
        return self.nom
