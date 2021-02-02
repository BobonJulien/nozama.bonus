Feature: Rechercher un produit
  Scenario: Rechercher un produit dans le catalogue
    Given je suis sur la homepage nozama
    When je choisis une categorie
    And je selectionne le produit recherche
    And jenregistre le produit dans le panier
    Then larticle est ajoute au panier

  
