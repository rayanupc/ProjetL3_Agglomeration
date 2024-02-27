# Projet de Bornes de Recharge pour Véhicules Électriques

## Description du Projet

Avec la généralisation des véhicules électriques, l'installation de bornes de recharge devient cruciale. Ce projet propose le développement d'un logiciel en Java visant à déterminer les emplacements optimaux pour la construction de parkings équipés de bornes de recharge au sein d'une communauté d'agglomération. Les principales contraintes du projet sont l'accessibilité et l'économie.

## Contraintes du projets

1. **Accessibilité :**
    - Chaque ville doit posséder ses bornes, ou être directement reliée à une ville
    qui possède des bornes.

2. **Économie :**
    - Le coût du projet doit être le plus bas possible, ce qui signifie que le nombre de bornes à construire doit être le plus petit possible.


## Objectifs du Projet

1. **Représentation des Villes et des Routes :**
   - Mise en place d'une représentation graphique des villes au sein de la communauté d'agglomération, avec les routes les reliant.

2. **Simulation de la Construction de Parkings Équipés :**
   - Développement d'une simulation permettant d'ajouter des parkings équipés de bornes de recharge dans les différentes villes de la communauté.

3. **Contrôle de l'Accessibilité :**
   - Implémentation d'un algorithme garantissant que chaque ville possède ses bornes ou est directement reliée à une ville équipée.

4. **Calcul du Coût :**
   - Mise en place d'un système de calcul du coût du projet, en prenant en compte le nombre de zones de recharge à construire.

5. **Optimisation des Coûts :**
   - Développement d'algorithmes visant à minimiser le coût global du projet tout en respectant les contraintes.

## Organisation du Projet

- `..\projetJava_djibril_rayan\Projet_installation_bornes_electriques\src\up\mi\da\agglomeration` <br> : Contient le code source Java du projet lié a la gestion de l'agglomération.
- `..\projetJava_djibril_rayan\Projet_installation_bornes_electriques\src\up\mi\da\exception` <br> : Contient le code source Java des classes d'exception.
- `..\projetJava_djibril_rayan\Projet_installation_bornes_electriques\test\up\mi\da\allTest` <br> : Contient le code des testes unitaire de notre programme.

## Prérequis

- JDK (Java Development Kit) installé sur la machine.
- Un environnement de développement Java tel que Eclipse, IntelliJ, ou tout autre de votre choix (afin de faciliter la visualisation du code source).
- Bibliothèque GraphStream
- Bibliothèque JavaFx 17.0.9
- Bibliothèque Junit5

## Instruction de rédaction pour le fichier 'monAgglomeration'
Votre fichier décrivant l'agglomération devra respecter une certaine syntaxe. <br>Prenons par
exemple les villes A et B.<br>
Création de la ville A : ville(A)<br>
Ajout d’une route entre A et B : route(A,B)<br>
Ajout d’une zone de recharge dans la ville A : recharge(A)<br>
Un exemple de fichier d'agglomération :<br><br>
ville(A)<br>
ville(B)<br>
ville(C)<br>
ville(D)<br>
ville(E)<br>
route(A,B)<br>
route(A,D)<br>
route(B,C)<br>
route(D,E)<br>
recharge(B)<br>
recharge(E)<br>

## Utilisation

### en passant par un IDE
#### Attention ! si vous exécuter le programme via un IDE tel eclipse il est possible qu'à la fin le graphe ne s'afiche.

1. Exécutez le point d'entrée du programme : `ApplicationAgglomeration.java`.
2. Suivez les instructions, laissez vous guider. 


### en passant par le terminal

1. Placez vous dans le répertoire du fichier applicationPAA.jar
2. lancer le fichier applicationPAA.jar avec la commande suivante : <br>
`java -jar applicationPAA.jar chemin/vers/votre/fichier.txt ` 

## Fonctionnalités Implémenter
### Obligatoire
1. Menu permettant d'interagir avec l'agglomération et les différentes fonctionnalités lié a celle-ci.<br> (ajout des villes, ajout des routes...)<br>
2. Ajout de ville dans l'agglomération <br>
3. Ajout de route reliant les villes entres elles .<br>
4. Ajout ou suppression de borne de recharge dans les villes choisis. <br>
5. Vérification des conditions d'accessibilité aux zones de recharges avant de poser ou de retirer une borne. <br>
6. Fonctionnalité permettant de lire une agglomération à partir d'un 'fichier.txt'. <br>
7. Algorithme permettant de trouver automatiquement la solution la plus optimal . <br>
7. Sauvegarde de l'agglomération et de la solution dans un 'fichier.txt'.

### Secondaire
1. Pour la résolution manuelle, le programme détecte si l'utilisateur ne peux plus retirer de zone de recharge et donc s'il est arrivé à une solution au problème d'optimisation.
2. L'utilisateur à le choix de sauvegarder son agglomeration dans un fichier par defaut (sauvegardeAgglomeration.txt fourni dans le fichier .zip du projet).
3. Affichage d'une interface graphique permettant de visualiser l'agglomeration sous forme de graphe avec les zone de recharge en choissant 4.fin dans le menu principal.
4. Nous avons gérer toutes les exceptions possibles du programme (fichier introuvable, fichier ne respectant pas le format d'ecriture de l'agglomeartion demandé, les differentes exceptions d'entré au clavier).
5. Le programme détecte si l'agglomeration détecte si l'agglomeration donné ne possède aucune borne ou possède des bornes mais ne respecte pas la condition d'accessibilité, et renvoi un message corresspondant à la situation.

#### visualisation du graphe
Nous avons implémenté une visualisation du graphe contenant la solution optimale au problème. <br> À la toute fin du programme, une fenêtre s'affiche contenant le graphe avec en rouge les villes possédant une borne.<br>
Nous avons utilisé GraphStream.

#### Algorithme modifié
Nous avons utiliser notre propre algorithme pour la resolution optimale automatique.<br>
Tout d'abord l'algorithme detecte les villes ayant le plus de voisin (le nombre maximal de voisin dans l'agglomeration). Si le nombre de ces villes est inferieur à la moitier des villes de l'agglomeartion on place une zone de recharge dans ces villes (ceci pourrait accélérer le processus dans certain cas).
Ensuite, On choisi les villes n'ayant pas de borne puis on isole cette ville et ses villes voisines ce qui va nous faire une petit enssemble de ville (appelé sous agglomeration dans notre programme). On cherche dans cet enssemble ville quelle ville pourrait satisfaire le plus de ville de notre agglomeration si on lui posait une zone de recharge, et enfin on pose la zone de recharge dans la ville qui satisfera le plus de ville de notre agglomeration.

#### Test Unitaires
Nous avons aussi ajouté des tests unitaires couvrant quasiment la totalité de nos méthodes.
## Fonctionnalités manquante
## Remerciment
Nous vous remercions pour avoir lu ce README et nous espérons que notre travail vous plaira.
#### Rayan ALMOHAIZE 
#### Djibril DAHOUB 