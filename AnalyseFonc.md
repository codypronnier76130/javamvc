# Projet Java


# Projet Java

## LIVRABLES :

- Analyser le besoin (Cf. Analyse Fonctionnelle – Voir cours Gestion de projet)
- Réaliser un mini-planning (échéancier) avec les lots principaux à fournir
- A la fin de la première journée : fournir des engagements à l’intervenant
- Réaliser un MCD et construire la base de données en conséquences
- Créer un nouveau projet en Java
- Construire la logique métier
- Construire les vues (avec optionnellement des données statiques)
- Lier l’ensemble à la base de données (données dynamiques)
- Rendre une application fonctionnelle
- Fournir un manuel d’utilisation clair et accessible
- Fournir une documentation technique décrivant le modèle de données (classes,
    interactions) ; a minima la javadoc générée

---

## MODULES :

### IMPORTANTS :




- Module rapport de mission    -> Cody
- Module de statisfaction      -> Cody
- Module Incidents             -> Paul
- Module missions              -> Paul
- Module Civils                -> Alex
- Module Organisation          -> Alex
- Module Super Héros           -> Noé
- Module Super Vilains         -> Noé


### MOINS IMPORTANtS :

- Module de crise
- Module de litige



## ANALYSE FONCTIONNELLE :

### ACTIONS :

#### CIVILS :


- Inscriptions (prio)
- Connection à l'application (prio)
- Peuvent faire partie d'une organisation (prio)
- Répondre au système de satisfaction (prio)
- Déclarer un incident  (prio)
- Alerte fin de mission (pas prio)



#### ORGANISATIONS :


- Peuvent réaliser les actions des civils. (prio)
- Alerte fin de mission (pas prio)

#### SUPER HEROS :


- Réaliser les actions des civils. (prio)
- Inscriptions super héro (prio)
- Participer aux missions (prio)
- Alerte pour les prévenir d'une mission (pas prio)
- Ecrire le rapport de mission (prio)
- Alerte fin de mission (pas prio)
- Recenser les super vilains (pas prio)



#### Autorité Compétente


- Donner suite à l'incident (boolean) (prio)
- Déclenche la mission (prio)
  - Affecter un ou plusieurs super héros (prio)
  - Donner le niveau d'urgence (prio)
  - Détailler la mission (prio)
- Valider la fin de mission (prio)
- Alerte fin de mission (pas prio)
- Recenser les super vilains (pas prio)


#### Maître suprème


- TOUT


#### SUPER VILAIN :


- Réaliser les actions des civils EN TANT QUE CIVIL (Super Vilain non démasqué) (prio)


## FONCTIONALITES DE L'APP :


- Inscripton Civils (prio)
- Inscripton Civils Super Héro (prio)
- Connection (prio)
- Déclarations d'un incident (prio)
- Création d'une mission (prio)
- Création d'un rapport de mission (prio)
- Regarder la fiche d'un super vilain TT le monde (pas prio)
- Regarder la fiche d'un super Héro TT le monde (pas prio)
- Lancement d'une alerte (pas prio)
- Gestions d'utilisateurs (prio)
- Envoyer un courrier (pas prio)
- Formulaire de satisfaction (prio)
- Système de Like au super héro (pas prio)
- Afficher un historique des missions (pas prio)
- Afficher les missions en cours (pas prio)
- Validation d'une mission (prio)


#### Modules ecartés :

##### Module de crise :


  - Déclaration des incidents majeurs suite aux missions


##### Module de litige :


  - Détails de la déclaration d'incident


###### D'ici la fin de semaine nous esperons avoir realisé les taches prioritaires notées ci-dessus et nous tenterons de realiser les modules écartés 
