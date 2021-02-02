Feature: login nozama
Scenario: verification du login nozama
Given navigateur Chrome ouvert et application sur homepage
When renseigner username password
And valider le formulaire
Then verifier que je suis connecte avec login et mdp