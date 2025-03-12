from django.db import models
from django.contrib.auth.models import User
from produits.models import Produit

class Commande(models.Model):
    STATUTS = [
        ('en_attente', 'En attente'),
        ('validee', 'Validée'),
        ('annulee', 'Annulée'),
    ]

    client = models.ForeignKey(User, on_delete=models.CASCADE)
    date_commande = models.DateTimeField(auto_now_add=True)
    statut = models.CharField(max_length=20, choices=STATUTS, default='en_attente')
    total = models.DecimalField(max_digits=10, decimal_places=2, default=0.00)

    def __str__(self):
        return f"Commande {self.id} - {self.client.username} ({self.get_statut_display()})"

class CommandeDetail(models.Model):
    commande = models.ForeignKey(Commande, on_delete=models.CASCADE, related_name="details")
    produit = models.ForeignKey(Produit, on_delete=models.CASCADE)
    quantite = models.PositiveIntegerField()
    sous_total = models.DecimalField(max_digits=10, decimal_places=2, editable=False)

    def save(self, *args, **kwargs):
        self.sous_total = self.produit.prix * self.quantite
        super().save(*args, **kwargs)

    def __str__(self):
        return f"{self.produit.nom} x{self.quantite} (Commande {self.commande.id})"
