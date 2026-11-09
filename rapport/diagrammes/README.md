# Diagrammes

Mettez ici le diagramme de classes (export PNG/PDF + source : PlantUML, draw.io, StarUML…).

Point de départ (PlantUML, cohérent avec le squelette) :

```plantuml
@startuml
abstract class Case { #nom : String }
class CaseSpeciale
abstract class Achetable {
  #prix : int
  #proprietaire : Joueur
  +acheter(j : Joueur)
  +liberer()
  +{abstract} calculLoyer(visiteur : Joueur) : int
}
class Gare
class Constructible {
  -loyerBase : int
  -loyerParMaison : int
  -loyerParHotel : int
  -nbMaisons : int
  -nbHotels : int
  +construireMaison()
  +construireHotel()
}
class Plateau {
  -plateau : ArrayList<Case>
  -joueurs : LinkedList<Joueur>
  -limiteTours : int
  +nbGares(j : Joueur) : int
  +affiche()
  +avance(c : Case, d : int) : Case
  +finDePartie() : boolean
  +tourDeJeu()
}
class Joueur {
  -nom : String
  -fortune : int
  -position : Case
  +payer(x : int, j : Joueur)
  +nbGares() : int
  +tourDeJeu()
}
class NoMoreMoney
Exception <|-- NoMoreMoney

Case <|-- CaseSpeciale
Case <|-- Achetable
Achetable <|-- Gare
Achetable <|-- Constructible
Plateau *-- "40" Case
Plateau o-- "*" Joueur
Achetable --> "0..1" Joueur : proprietaire
Joueur --> Case : position
Joueur --> Plateau
@enduml
```
