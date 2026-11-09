# Liste des tâches

Pour prendre une tâche : mettez votre nom dans la colonne **Qui**. Quand elle est mergée dans `main`, cochez-la (`[x]`).
Une tâche = une branche = une Pull Request (voir [CONTRIBUTING.md](CONTRIBUTING.md)).

Taille : 🟢 petit (< 30 min) · 🟡 moyen (~1 h) · 🔴 gros (plusieurs heures)

## Ordre conseillé

Les tâches de la **vague 1** sont indépendantes : tout le monde peut commencer en même temps. Les vagues suivantes ont besoin des précédentes. Le rapport (F) peut démarrer tout de suite et avancer en parallèle.

```
Vague 1 : A1 A3 A4 B1 B2 B3 B4 C1 D1 D3   +  F1 F3 F7 (rapport)
Vague 2 : A2 C2 D2
Vague 3 : D4
Vague 4 : E1 E2  +  F4 F5 F6
Fin     : F8 G1
```

## A. Cases (sujet 1.1 à 1.3)

| Fait | # | Tâche | Fichier(s) | Dépend de | Taille | Qui |
|---|---|---|---|---|---|---|
| [ ] | A1 | `acheter()` et `toString()` d'une case achetable. Format : `Gare de Lyon (coût : 20000) - sans propriétaire` / `- propriétaire : Bidule` | `Achetable` | — | 🟢 | |
| [ ] | A2 | `calculLoyer()` des gares : 0 si pas de propriétaire ou si on est chez soi, sinon 2500 × nb de gares du propriétaire | `Gare` | B2 | 🟢 | |
| [ ] | A3 | `calculLoyer()` des terrains (L = L0 + a·nm + b·nh) et `toString()` : `Rue Crébillon (coût : 45000) - propriétaire : Bidule, 2 maisons, loyer = 1500` | `Constructible` | — | 🟡 | |
| [ ] | A4 | Construction : `construireMaison()` / `construireHotel()`. Choisir les règles (prix, max 4 maisons, hôtel = 4 maisons…), **les noter dans `rapport/hypotheses.md`**, et décider à quel moment un joueur construit pendant son tour | `Constructible` (+ `Joueur` pour le moment où on construit) | — | 🔴 | |

## B. Plateau (sujet 2)

| Fait | # | Tâche | Fichier(s) | Dépend de | Taille | Qui |
|---|---|---|---|---|---|---|
| [ ] | B1 | `initPlateau()` : créer les 40 cases dans l'ordre (Départ, terrains, 4 gares, Prison, Chance…), avec prix et loyers L0, a, b | `Plateau` | — | 🟡 | |
| [ ] | B2 | `nbGares(Joueur j)` : compter les gares possédées par `j` (utiliser `instanceof`) | `Plateau` | — | 🟢 | |
| [ ] | B3 | `affiche()` : afficher toutes les cases avec leur `toString()` (un numéro devant chaque case, c'est un plus) | `Plateau` | — | 🟢 | |
| [ ] | B4 | `avance(Case c, int d)` : renvoyer la case `d` cases plus loin, circulairement (modulo 40) | `Plateau` | — | 🟢 | |

## C. Joueurs (sujet 3)

| Fait | # | Tâche | Fichier(s) | Dépend de | Taille | Qui |
|---|---|---|---|---|---|---|
| [ ] | C1 | `payer(int x, Joueur j)` : débiter / créditer, lancer `NoMoreMoney` si pas assez d'argent. Décider ce qu'on fait de l'argent restant d'un joueur en faillite (hypothèse) | `Joueur`, `NoMoreMoney` | — | 🟢 | |
| [ ] | C2 | `tourDeJeu()` du joueur : lancer le dé, avancer, afficher « Le joueur XX est en YY », acheter si dé impair (case libre + assez d'argent), payer le loyer | `Joueur` | A1, A2, A3, B4, C1 | 🟡 | |

## D. Partie complète (sujet 4)

| Fait | # | Tâche | Fichier(s) | Dépend de | Taille | Qui |
|---|---|---|---|---|---|---|
| [ ] | D1 | `finDePartie()` : vrai s'il reste 1 joueur ou si la limite de tours est atteinte (gérer le compteur `nbToursJoues`) | `Plateau` | — | 🟢 | |
| [ ] | D2 | Compléter `affiche()` : liste des joueurs, leur fortune et les cases qu'ils possèdent | `Plateau` | B3 | 🟡 | |
| [ ] | D3 | `liberer()` : la case redevient sans propriétaire, maisons et hôtels retirés | `Achetable`, `Constructible` | — | 🟢 | |
| [ ] | D4 | `tourDeJeu()` du plateau : faire jouer tout le monde jusqu'à la fin ; si `NoMoreMoney` → éliminer le joueur, libérer ses propriétés, afficher un message, revérifier la fin. À la fin : annoncer le vainqueur ou la situation finale. Décommenter l'appel dans `Monopoly.main` | `Plateau`, `Monopoly` | C2, D1, D2, D3 | 🔴 | |

## E. Qualité

| Fait | # | Tâche | Fichier(s) | Dépend de | Taille | Qui |
|---|---|---|---|---|---|---|
| [ ] | E1 | Tester des parties complètes : 2, 3, 4 joueurs, petite et grande limite de tours, élimination, gare à 2-3 propriétaires… Noter les bugs et les corriger (ou les signaler) | tous | D4 | 🟡 | |
| [ ] | E2 | Passer sur la Javadoc : toutes les classes, constructeurs et méthodes publiques avec `@param`, `@return`, `@throws` ; commentaires internes là où c'est utile | tous | D4 | 🟡 | |
| [ ] | E3 | Relire les Pull Requests des autres (tâche continue, à partager) | — | — | 🟡 | |

## F. Compte rendu PDF (sujet 5)

| Fait | # | Tâche | Dépend de | Taille | Qui |
|---|---|---|---|---|---|
| [ ] | F1 | Diagramme de classes final (partir de `rapport/diagrammes/README.md`), à remettre à jour à la fin pour coller au code | — puis D4 | 🟡 | |
| [ ] | F2 | Justifier les choix de conception : répartition des responsabilités, relations entre classes, héritage, encapsulation, polymorphisme (`calculLoyer`, `toString`) | A, B, C | 🟡 | |
| [ ] | F3 | Rédiger les hypothèses et leurs conséquences (à partir de `rapport/hypotheses.md`) | — | 🟢 | |
| [ ] | F4 | Exemples d'exécution commentés (copies de sortie console + explications) | D4 | 🟡 | |
| [ ] | F5 | Bilan : ce qui marche, limites, difficultés restantes | E1 | 🟢 | |
| [ ] | F6 | Retour d'expérience collectif : organisation, difficultés, choix réussis / à revoir, outils et IA (`rapport/usage-ia.md`), enseignements. Avec des exemples concrets | tout | 🟡 | |
| [ ] | F7 | Partie « Organisation du groupe » : qui a fait quoi (à partir de ce tableau) | — | 🟢 | |
| [ ] | F8 | Assembler et mettre en forme le PDF final, le déposer dans `rapport/` | F1 à F7 | 🟡 | |

## G. Rendu

| Fait | # | Tâche | Dépend de | Taille | Qui |
|---|---|---|---|---|---|
| [ ] | G1 | Vérification finale : le projet s'ouvre dans NetBeans, compile, lance une simulation ; le README est à jour (limite de tours, arguments) ; le PDF est là | tout | 🟢 | |
