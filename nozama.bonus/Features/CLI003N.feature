Feature: Effectuer une recherche
Scenario: Effectuer une recherche avec le formulaire
Given je suis sur la page nozama
When je rentre le nom dun produit dans la barre de recherche
And je clique sur le bouton de recherche
And selectionne le produit recherche
And que jenregistre le produit dans mon panier
Then le produit recherche est ajoute dans le panier