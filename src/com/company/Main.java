package com.company;

/*
    Ein-/Ausgabe-Strams
    Aufgabe 1)
        Schreiben Sie in eine Datei mit dem Namen input.dat einen beliebigen Text und speichern Sie diesen im Programmordner.
        Lesen Sie anschließend den Text aus der Datei ein und führen Sie folgende Bearbeitungsschritte durch:
            1. der Text soll in UpperCase umgewandelt werden
            2. jede Zeile erhält eine fortlaufende Nummer
        Schreiben Sie anschließend den Text in eine zweite Datei mit dem Namen output.dat
 */

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        File inputfile = new File("./input.dat");
        FileReader fr = null;

        File outputfile = new File("./output.dat");
        FileWriter fw = null;

        int zeichen;
        char buchstabe;
        int zeilen = 0;
        String zeile = zeilen + "\t";
        ArrayList<String> text = new ArrayList<String>(0);

        try {
            fr = new FileReader(inputfile);
            fw = new FileWriter(outputfile);
            // Alle Zeilen lesen und in ArrayList speichern
            while ((zeichen = fr.read()) != -1) {
                buchstabe = (char) zeichen;
                if (buchstabe != '\n'){
                    zeile += buchstabe;
                } else {
                    text.add(zeilen, zeile);
                    zeilen++;
                    zeile = zeilen + "\t";
                }
            }
            // ArrayList Zeile für Zeile in Datei schreiben
            for(int i=0; i<text.size(); i++) {
                zeile = text.get(i).toUpperCase();
                for (int j=0; j<zeile.length(); j++){
                    fw.write(zeile.charAt(j));
                }
                fw.write('\n');
            }

            fr.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}