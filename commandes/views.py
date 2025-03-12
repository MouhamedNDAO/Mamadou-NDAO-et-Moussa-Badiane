from django.shortcuts import render, get_object_or_404, redirect
from django.contrib.auth.decorators import login_required
from .models import Commande, CommandeDetail
from panier.models import Panier
from .forms import CommandeForm

# Create your views here.

# Liste des commandes d'un client
@login_required
def liste_commandes(request):
    commandes = Commande.objects.filter(client=request.user)
    return render(request, 'commandes/liste.html', {'commandes': commandes})

# Passer une commande à partir du panier
@login_required
def passer_commande(request):
    panier = Panier.objects.filter(client=request.user)

    if not panier.exists():
        return redirect('liste_panier')

    commande = Commande.objects.create(client=request.user, total=0)

    total_commande = 0
    for item in panier:
        CommandeDetail.objects.create(
            commande=commande,
            produit=item.produit,
            quantite=item.quantite,
            sous_total=item.produit.prix * item.quantite
        )
        total_commande += item.produit.prix * item.quantite

    commande.total = total_commande
    commande.save()
    
    panier.delete()

    return redirect('liste_commandes')

# Modifier le statut d'une commande
@login_required
def modifier_commande(request, pk):
    commande = get_object_or_404(Commande, pk=pk, client=request.user)
    if request.method == 'POST':
        form = CommandeForm(request.POST, instance=commande)
        if form.is_valid():
            form.save()
            return redirect('liste_commandes')
    else:
        form = CommandeForm(instance=commande)
    return render(request, 'commandes/formulaire.html', {'form': form, 'titre': 'Modifier la commande'})

# Supprimer une commande
@login_required
def supprimer_commande(request, pk):
    commande = get_object_or_404(Commande, pk=pk, client=request.user)
    if request.method == 'POST':
        commande.delete()
        return redirect('liste_commandes')
    return render(request, 'commandes/confirmer_suppression.html', {'commande': commande})
