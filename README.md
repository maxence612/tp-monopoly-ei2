# Monopoly simplifié — TP1 MEDEV

Projet collectif de la promo (Option Informatique, TP1 MEDEV) : un Monopoly simplifié en Java qui reprend les concepts objet du cours (héritage, classes abstraites, polymorphisme, exceptions, collections).

> Rendu attendu : **le projet Java complet (NetBeans)** + **un compte rendu PDF** (voir [`rapport/`](rapport/)).

## Environnement

| Outil | Version |
|---|---|
| JDK | 17 ou plus |
| IDE | Apache NetBeans (projet Maven, s'ouvre directement) |
| Build | Maven (intégré à NetBeans) |

## Ouvrir le projet dans NetBeans

1. `File > Open Project…`
2. Choisir le dossier `tp-monopoly` (NetBeans le reconnaît grâce au `pom.xml`)
3. `Run > Run Project` (F6)

## Compiler et lancer en ligne de commande

Avec Maven :

```bash
mvn compile exec:java
```

Sans Maven (JDK seul) :

```bash
javac -d target/classes src/main/java/fr/ecn/medev/monopoly/*.java
java -cp target/classes fr.ecn.medev.monopoly.Monopoly 50 Alice Bob Chloé
```

## Paramètres

```
Monopoly [limiteTours] [joueur1 joueur2 ...]
```

| Paramètre | Rôle | Défaut |
|---|---|---|
| `limiteTours` | Nombre maximal de tours complets (strictement positif) | `50` |
| `joueurN` | Noms des joueurs | `Alice Bob Chloé` |

Dans NetBeans : `Projet > Properties > Run > Arguments`.

## Structure

```
src/main/java/fr/ecn/medev/monopoly/
├── Case.java            # classe abstraite (1.1)
├── CaseSpeciale.java    # Départ, Prison, Chance… (1.1)
├── Achetable.java       # abstraite : prix, propriétaire, acheter() (1.1-1.3)
├── Gare.java            # loyer = 2500 × nb de gares (1.3)
├── Constructible.java   # maisons/hôtels, L = L0 + a·nm + b·nh (1.1-1.3)
├── Plateau.java         # 40 cases, joueurs, avance, fin de partie (2, 4)
├── Joueur.java          # nom, fortune, position, payer, tourDeJeu (3)
├── NoMoreMoney.java     # exception de défaut de paiement (3.2)
└── Monopoly.java        # main
rapport/                 # compte rendu, diagramme de classes
```

## Travailler à plusieurs

Voir [CONTRIBUTING.md](CONTRIBUTING.md) : répartition des parties et règles Git.
