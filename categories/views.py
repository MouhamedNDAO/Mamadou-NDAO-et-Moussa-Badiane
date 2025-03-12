from django.shortcuts import render, get_object_or_404, redirect
from .models import Categorie
from .forms import CategorieForm

# Liste des catégories
def liste_categories(request):
    categories = Categorie.objects.all()
    return render(request, 'categories/liste.html', {'categories': categories})

# Ajouter une catégorie
def ajouter_categorie(request):
    if request.method == 'POST':
        form = CategorieForm(request.POST)
        if form.is_valid():
            form.save()
            return redirect('liste_categories')
    else:
        form = CategorieForm()
    return render(request, 'categories/formulaire.html', {'form': form, 'titre': 'Ajouter une catégorie'})

# Modifier une catégorie
def modifier_categorie(request, pk):
    categorie = get_object_or_404(Categorie, pk=pk)
    if request.method == 'POST':
        form = CategorieForm(request.POST, instance=categorie)
        if form.is_valid():
            form.save()
            return redirect('liste_categories')
    else:
        form = CategorieForm(instance=categorie)
    return render(request, 'categories/formulaire.html', {'form': form, 'titre': 'Modifier une catégorie'})

# Supprimer une catégorie
def supprimer_categorie(request, pk):
    categorie = get_object_or_404(Categorie, pk=pk)
    if request.method == 'POST':
        categorie.delete()
        return redirect('liste_categories')
    return render(request, 'categories/confirmer_suppression.html', {'categorie': categorie})
