package com.btcag.bootcamp;

import java.util.Scanner;

public class RobotWars {

    public static void main(String[] args) {
        //Begrüßung

        System.out.println("          ________        ");
        System.out.println("         /  _____/_______  ");
        System.out.println("        /   \\  __\\_  __ \\ ");
        System.out.println("        \\    \\_\\  \\  | \\/ ");
        System.out.println("         \\______  /__|    ");
        System.out.println("                \\/        ");
        System.out.println("     ____     ____      ");
        System.out.println("    |    |   |    |    ");
        System.out.println("    |____|___|____|____");
        System.out.println("      \\=============/");
        System.out.println("       \\___________/");
        System.out.println("        / /     \\ \\");
        System.out.println("       /_/       \\_\\");
        System.out.println();
        System.out.println("   Welcome, %s, to the Ultimate Robot Clash!");
        System.out.println();


        Scanner scanner = new Scanner(System.in);

        // Spieler 1 und Spieler 2 Namen einlesen
        String spieler1 = eingabeSpielerName(scanner, 1);
        String spieler2 = eingabeSpielerName(scanner, 2);

        // Spielfeld initialisieren (hier: erstmal 5x5)
        char[][] spielfeld = new char[5][5];
        initialisiereSpielfeld(spielfeld);

        // Roboter-Positionen der beiden Spieler (beide beginnen in der Ecke)
        int[] positionSpieler1 = {0, 0}; // Startposition Spieler 1
        int[] positionSpieler2 = {4, 4}; // Startposition Spieler 2

        // Roboter der beiden Spieler auf Startpositionen
        spielfeld[positionSpieler1[0]][positionSpieler1[1]] = 'X'; // Spieler 1 Roboter 'X'
        spielfeld[positionSpieler2[0]][positionSpieler2[1]] = 'O'; // Spieler 2 Roboter 'O'

        druckeSpielfeld(spielfeld);

        boolean spielLäuft = true;
        int zugNummer = 0;

        while (spielLäuft) {
            // Spieler abwechselnd ziehen lassen
            if (zugNummer % 2 == 0) {
                System.out.println(spieler1 + " ist am Zug.");
                bewegeRoboter(spielfeld, positionSpieler1, scanner, 'X'); // Spieler 1 (X)
            } else {
                System.out.println(spieler2 + " ist am Zug.");
                bewegeRoboter(spielfeld, positionSpieler2, scanner, 'O'); // Spieler 2 (O)
            }

            // Spielfeld nach jedem Zug anzeigen
            druckeSpielfeld(spielfeld);

            // Zugnummer erhöhen, (hier endet nach 20 Zügen endet das Spiel)
            zugNummer++;
            if (zugNummer >= 20) {
                spielLäuft = false;
            }
        }

        System.out.println("Das Spiel ist beendet.");
        scanner.close();
    }

    // Funktion, um den Spielernamen einzugeben
    public static String eingabeSpielerName(Scanner scanner, int spielerNummer) {
        String spieler = "";
        while (spieler.length() < 3 || spieler.length() > 15) {
            System.out.println("Geben Sie den Namen des Spielers " + spielerNummer + " ein (zwischen 3 und 15 Zeichen):");
            spieler = scanner.nextLine();
        }
        return spieler;
    }

    // Funktion zum Initialisieren des Spielfeldes
    public static void initialisiereSpielfeld(char[][] spielfeld) {
        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length; j++) {
                spielfeld[i][j] = ' '; // Leere Felder mit einem Leerzeichen füllen
            }
        }
    }

    // Funktion zum Drucken des Spielfeldes
    public static void druckeSpielfeld(char[][] spielfeld) {
        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length; j++) {
                System.out.print("[" + spielfeld[i][j] + "]");
            }
            System.out.println(); // Nächste Zeile nach jeder Reihe
        }
    }

    // Funktion zur Bewegung des Roboters eines Spielers
    public static void bewegeRoboter(char[][] spielfeld, int[] position, Scanner scanner, char symbol) {
        // Alte Position löschen
        spielfeld[position[0]][position[1]] = ' ';

        boolean gültigeBewegung = false;
        while (!gültigeBewegung) {
            System.out.println("Bewegen Sie den Roboter (W: oben, S: unten, A: links, D: rechts):");
            char bewegung = scanner.next().charAt(0);

            int neueReihe = position[0];
            int neueSpalte = position[1];

            // Bewegung je nach Eingabe
            if (bewegung == 'W' || bewegung == 'w') {
                neueReihe--; // Nach oben
            } else if (bewegung == 'S' || bewegung == 's') {
                neueReihe++; // Nach unten
            } else if (bewegung == 'A' || bewegung == 'a') {
                neueSpalte--; // Nach links
            } else if (bewegung == 'D' || bewegung == 'd') {
                neueSpalte++; // Nach rechts
            }

            // Prüfen, ob die neue Position innerhalb des Spielfeldes liegt
            if (neueReihe >= 0 && neueReihe < 5 && neueSpalte >= 0 && neueSpalte < 5) {
                position[0] = neueReihe;
                position[1] = neueSpalte;
                gültigeBewegung = true; // Bewegung ist gültig
            } else {
                System.out.println("Ungültige Bewegung. Bitte wählen Sie eine gültige Richtung.");
            }
        }

        // Neue Position des Roboters setzen
        spielfeld[position[0]][position[1]] = symbol;
    }
}






