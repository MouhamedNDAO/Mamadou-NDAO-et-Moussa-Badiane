from django.shortcuts import render

# Create your views here.
from django.shortcuts import render, get_object_or_404, redirect
from django.contrib.auth.decorators import login_required
from .models import Panier
from .forms import PanierForm

# Liste des produits dans le panier
@login_required
def liste_panier(request):
    panier = Panier.objects.filter(client=request.user)
    total = sum(item.produit.prix * item.quantite for item in panier)
    return render(request, 'panier/liste.html', {'panier': panier, 'total': total})

# Ajouter un produit au panier
@login_required
def ajouter_panier(request):
    if request.method == 'POST':
        form = PanierForm(request.POST)
        if form.is_valid():
            panier_item, created = Panier.objects.get_or_create(
                client=request.user,
                produit=form.cleaned_data['produit'],
                defaults={'quantite': form.cleaned_data['quantite']}
            )
            if not created:
                panier_item.quantite += form.cleaned_data['quantite']
                panier_item.save()
            return redirect('liste_panier')
    else:
        form = PanierForm()
    return render(request, 'panier/formulaire.html', {'form': form, 'titre': 'Ajouter au panier'})

# Modifier la quantité d'un produit dans le panier
@login_required
def modifier_panier(request, pk):
    panier_item = get_object_or_404(Panier, pk=pk, client=request.user)
    if request.method == 'POST':
        form = PanierForm(request.POST, instance=panier_item)
        if form.is_valid():
            form.save()
            return redirect('liste_panier')
    else:
        form = PanierForm(instance=panier_item)
    return render(request, 'panier/formulaire.html', {'form': form, 'titre': 'Modifier la quantité'})

# Supprimer un produit du panier
@login_required
def supprimer_panier(request, pk):
    panier_item = get_object_or_404(Panier, pk=pk, client=request.user)
    if request.method == 'POST':
        panier_item.delete()
        return redirect('liste_panier')
    return render(request, 'panier/confirmer_suppression.html', {'panier_item': panier_item})
