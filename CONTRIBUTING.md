# Organisation du groupe

## Répartition proposée

Chaque partie correspond à des `TODO` dans le code (cherchez `TODO 1.3`, `TODO 2.1`…). Mettez votre nom dans la colonne « Responsables » : ça servira directement pour la partie « contributions » du rapport.

| Partie | Contenu | Fichiers | Responsables |
|---|---|---|---|
| **A. Cases** (1.1–1.3) | `acheter()`, `toString()`, `calculLoyer()`, construction de maisons/hôtels | `Achetable`, `Gare`, `Constructible` | |
| **B. Plateau** (2.1–2.3) | `initPlateau()` (40 cases), `nbGares()`, `affiche()`, `avance()` | `Plateau` | |
| **C. Joueurs** (3.1–3.3) | `payer()` + `NoMoreMoney`, `tourDeJeu()` d'un joueur | `Joueur`, `NoMoreMoney` | |
| **D. Partie complète** (4.1–4.3) | `finDePartie()`, affichage des joueurs, boucle de jeu, élimination + `liberer()` | `Plateau`, `Achetable`, `Constructible` | |
| **E. Rapport** (5) | diagramme de classes, choix de conception, hypothèses, exemples d'exécution, retour d'expérience | `rapport/` | |
| **F. Relecture / tests** | relire les PR, tester des parties complètes, Javadoc | tous | |

Les parties dépendent les unes des autres (D a besoin de A, B et C). Les signatures des méthodes sont déjà fixées dans le squelette : **ne les changez pas sans prévenir le groupe**, comme ça chacun peut avancer en parallèle.

## Règles Git

1. **On ne pousse jamais directement sur `main`.**
2. Une branche par partie :
   ```bash
   git checkout main
   git pull
   git checkout -b partie-a-cases
   ```
3. Des commits petits et clairs :
   ```bash
   git add .
   git commit -m "Calcul du loyer des gares"
   git push -u origin partie-a-cases
   ```
4. Sur GitHub, ouvrir une **Pull Request** vers `main`. Au moins une autre personne la relit avant de merger.
5. Avant d'ouvrir une PR, vérifier que **le projet compile** (F6 dans NetBeans).
6. En cas de conflit : `git pull origin main` sur votre branche, régler le conflit dans NetBeans, recommiter.

## Conventions de code

- Javadoc sur chaque classe, constructeur et méthode publique (`@param`, `@return`, `@throws`) — c'est demandé dans le sujet.
- Noms en français, comme dans le sujet (`calculLoyer`, `nbGares`…).
- Les règles qu'on invente quand le sujet laisse le choix (prix d'une maison, nombre max de maisons…) sont notées dans [`rapport/hypotheses.md`](rapport/hypotheses.md).

## IA

Le rapport demande de préciser l'usage des agents d'IA. Si vous en utilisez, notez rapidement dans [`rapport/usage-ia.md`](rapport/usage-ia.md) ce que vous lui avez demandé et comment vous avez vérifié le résultat.
