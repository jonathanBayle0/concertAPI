# Projet Spring - ConcertAPI

## Développeurs :
 - BAYLE Jonathan
 - LE BUHAN Marie

## Description générale :
L'API permet de réaliser une gestion CRUD des concerts, salles et soirées sur une base de donnée mysql (nommée concert) et une base de donnée mongoDB (nommée gestionevenement)

A noter : La vérification sur l'existence du groupe lors de la création/modification d'un concert (ligne 41 de ConcertServiceImpl) est commenté car la vérification nécessite un appel à l'API "GroupeAPI".

## Description détaillé : 
### Port utilisé : 8083

### Gestion des concerts : 
- Récupérer tous les concerts ou créer/modifier un concert : “/concerts”.

Pour la création d’un concert, il faut ajouter un body JSON de la forme : 
 {
    "conId": "6",
    "conDateDebut": "2023-02-21 22:05:00",
    "conDateFin": "2023-02-21 23:35:00",
    "soiId": "1",
    "groId": "3"
}
- Récupérer/supprimer le concerts d’id 1 : “/concerts/1”
- Récupérer les concerts associé au groupe d’id 1 : “/concerts/1/groupe”
- Récupérer une photo liée au concert d’id 1 : “/concerts/photos/1”
- Récupérer un article lié au concert d’id 1 : “/concerts/articles/1”
-Sauvegarder une information (article ou photo) lié à un concert : “/concerts/information”.

Il faut ajouter un body de la forme : 
{
  "infType": "concert",
  "infCible": 3,
  "infNom": "Whilemina Dominguez",
  "infDate": "21-02-22",
  "infTypeContenu": "article",
  "infContenu": "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
}


### Gestion des salles : 
- Récupérer tous les salles ou créer/modifier une salle : “/salles”

Pour la création d’une salle, il faut ajouter un body JSON de la forme : 
{
        "salId": "2",
        "salNom": "Agora",
        "salAdresse": "15 rue agora, 29150, Chateaulin",
        "salCapacite": 50,
        "salNomGestionnaire": "LeTout",
        "salPrenomGestionnaire": "Claude",
        "salAssociation": ""
    }
- Récupérer tous les concerts de la salle d’id 1: “/salles/1/concerts”
- Récupérer/supprimer la salle d’id 1 : “/salles/1”
- Récupérer une photo liée à la salle d’id 1 : “/salles/photos/1”
- Récupérer un article lié à la salle d’id 1 : “/salles/articles/1”
- Sauvegarder une information (article ou photo) liée à une salle : “/salles/informations”.
 
Il faut ajouter un body de la forme : 
{
  "infType": "salle",
  "infCible": 3,
  "infNom": "Whilemina Dominguez",
  "infDate": "21-02-22",
  "infTypeContenu": "article",
  "infContenu": "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
}

### Gestion des soirées: 
- Récupérer toutes les soirees ou créer/modifier une soiree : “/soirees”.

Pour la création d’une soirée, il faut ajouter un body JSON de la forme : 
{
    "salId" : "8",
    "salNom": "RunArePuns",
    "salAdresse": "16, 29290, Briec",
    "salCapacite": 15,
    "salNomGestionnaire": "Murphy",
    "salPrenomGestionnaire": "Eddy",
    "salAssociation": ""
}
- Récupérer tous les concerts de la soirée d’id 1: “/soirees/1/concerts”
- Récupérer/supprimer la soiree d’id 1 : “/soirees/1”
- Récupérer une photo liée à la soiree d’id 1 : “/soirees/photos/1”
- Récupérer un article lié à la soiree d’id 1 : “/soirees/articles/1”
- Sauvegarder une information (article ou photo) liée à la soiree : “/soirees/informations”
