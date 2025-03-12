from django.http import HttpResponse
from django.shortcuts import render, get_object_or_404, redirect
from django.template import loader

from .models import Produit
from .forms import ProduitForm


# Create your views here.

# Accueil du site web (liste des produits)
def accueil(request):
    produits = Produit.objects.all()
    return render(request, 'produits/accueil.html', {'produits': produits})


# Liste des produits
def liste_produits(request):
    produits = Produit.objects.all()
    return render(request, 'produits/liste.html', {'produits': produits})

#Details Produit
def details(request, id):
    produits= Produit.objects.get(id=id)
    template = loader.get_template('produits/details.html')
    context = {
        'produits': produits,
    }
    return HttpResponse(template.render(context, request))


# Ajouter un produit
def ajouter_produit(request):
    if request.method == 'POST':
        form = ProduitForm(request.POST, request.FILES)
        if form.is_valid():
            form.save()
            return redirect('liste_produits')
    else:
        form = ProduitForm()
    return render(request, 'produits/formulaire.html', {'form': form, 'titre': 'Ajouter un produit'})

# Modifier un produit
def modifier_produit(request, pk):
    produit = get_object_or_404(Produit, pk=pk)
    if request.method == 'POST':
        form = ProduitForm(request.POST, request.FILES, instance=produit)
        if form.is_valid():
            form.save()
            return redirect('liste_produits')
    else:
        form = ProduitForm(instance=produit)
    return render(request, 'produits/formulaire.html', {'form': form, 'titre': 'Modifier un produit'})

# Supprimer un produit
def supprimer_produit(request, pk):
    produit = get_object_or_404(Produit, pk=pk)
    if request.method == 'POST':
        produit.delete()
        return redirect('liste_produits')
    return render(request, 'produits/confirmer_suppression.html', {'produit': produit})
