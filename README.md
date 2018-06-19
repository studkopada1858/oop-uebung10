_Übungsaufgabe zur Veranstaltung [Programmieren 2](https://hsro-wif-prg2.github.io) im [Bachelorstudiengang Wirtschaftsinformatik](https://www.fh-rosenheim.de/technik/informatik-mathematik/wirtschaftsinformatik-bachelor/) an der [Hochschule Rosenheim](http://www.fh-rosenheim.de)._


# Übung 10: Abstrakte Basisklassen


# Bessere Bremsen

In der letzten [Übung 9: Vererbung](https://github.com/hsro-wif-prg2/uebung09) hatten wir den Unterschied zwischen Basisklassen (`extends`) und Interfaces (`implements`) erarbeitet.
Da die unterschiedlichen Bremsen (Scheiben-, Trommel- und Cantileverbremsen) zwar mechanisch sehr unterschiedlich aufgebaut sind, aber alle im Prinzip bremsen können, wählten wir hier ein Interface.
Das hatte den Nachteil, dass nun die einzelnen Bremsvarianten nun eben die Bremse _implementieren_, aber nicht _erweitern_.
Möchte man nun aber z.B. Attribute wie `hersteller` für alle Bremsen vorschreiben, so gibt es zwei Möglichkeiten:

### Umwandlung des Interfaces in eine Klasse mit den entsprechenden Attributen

```java
// (A)
class Bremse {
	private String hersteller;
	public Bremse(String h) {
		this.hersteller = h;
	}
	public void bremsen() {
		// ???
	}
}

class Scheibenbremse extends Bremse {
	// ...
}
```

### Erweiterung des Interfaces um entsprechende Getter/Settermethoden

```java
// (B)
interface Bremse {
	void bremsen();
	String getHersteller();
	void setHersteller(String h);
}

class Scheibenbremse implements Bremse {
	private String hersteller;

	public void bremsen() {
		// ...
	}
	public String getHersteller() {	
		return hersteller;
	}
	public void setHersteller(String h) {
		this.hersteller = h;
	}
}
```

Die erste Version (A) hat den Nachteil, dass man nun in `Bremse` die Methode `bremsen` implementieren muss, ohne aber zu wissen, welche Bremsenart es ist -- sofern das überhaupt semantisch sinnvoll ist!
Die zweite Version (B) hat den Nachteil, dass man nun in jeder Realisierung von `Bremse` eine separate Variable für den `hersteller` anlegen muss.

Die Lösung ist eine _abstrakte Basisklasse_ (`abstract class`), in der die Methode `bremsen` als `abstract` markiert ist, und nicht implementiert wird (kein `{ ... }`, sondern `;`)

## Aufgabe

Gegeben ist ein Teil der Musterlösung der letzten Aufgabe, in der `Bremse` ein Interface ist.

1. Zeichnen Sie ein UML Diagramm. Modellieren Sie dazu die `Bremse` als abstrakte Basisklasse, welche Hersteller (`String`) und Seriennummer (`String`) als private Attribute modelliert und die Methoden `void bremsen()` und `void brauchtService()` vorschreibt.
2. Passen Sie die vorgegebene Implementierung so an, dass sie dem UML Diagramm entspricht. Verwenden Sie Fantasiewerte für Hersteller und Seriennummer. 
3. Stellen Sie sicher, dass alle Tests in `BremseTests` erfolgreich laufen.


# Dreidimensionale Formen

![Formen](formen.png)

Die oben abgebildeten Formen Dreiecksprisma, Quader, Zylinder und zylindrisches Rohr sind einfache Volumina, welche sich aus der Grundfläche mal der Höhe berechnen.
Modellieren Sie die vier Formen unter der Verwendung einer gemeinsamen Basisklasse.

Im Paket `ueb10.formen` sind bereits die Klassendateien `Volumen.java`, `DreiecksPrisma`, `Quader.java`, `Zylinder.java` und `ZylindrischesRohr.java` angelegt.

1. Zeichnen Sie ein UML Diagramm, das die Klassen in geeignete Vererbungsbeziehungen setzt.
	1. Ein `Volumen` soll mit der Methode `double volumen()` das eigentliche Volumen (also Grundfläche mal Höhe) berechnen, Codeduplikate aber vermieden werden.
	2. Verdeutlichen Sie sich, welche Werte zur Berechnung des Volumens nötig sind, und in welcher Klasse diese bestimmt werden können.
2. Vervollständigen Sie die vorgegebenen Klassenrümpfe entsprechend Ihrem Diagramm, und implementieren Sie die Methoden.
3. Stellen Sie sicher Tests in `VolumenTests` erfolgreich sind.

## Hinweise 

- Rechnen Sie durchwegs mit Gleitkommazahlen.
- Die Dreiecksfläche kann mit dem [Satz von Heron](https://de.wikipedia.org/wiki/Dreiecksfl%C3%A4che) aus den drei Seitenlängen berechnet werden.
- Der Querschnitt eines Rohres kann mit dem Innen- und Aussenradius berechnet werden.
- Es ist eine abstrakte Basisklasse erforderlich, welche sowohl konkrete als auch abstrakte Methoden hat.
- Mit genug Vorüberlegungen kann Top-Down gearbeitet werden; unter Umständen fällt Ihnen aber Bottom-Up einfacher. Implementieren Sie hierzu zunächst die Logik für zwei Klassen, um dann Gemeinsamkeiten zu isolieren.
