package com.example.pokemon_spiel;

import java.util.Random;
import java.util.Scanner;

public class Spiel {

    private Pokemon pokemon1;
    private Pokemon pokemon2;

    private boolean gameOver;  //false

    int aktuelleAttacke = 0;

    //input vom User
    Scanner input = new Scanner(System.in);

    //constructor

    public Spiel(){
        pokemon1 = new Pokemon(200);
        pokemon2 = new Pokemon(200);
        spielen();
    }

    public void spielen(){
        do{

            zeigeEingabe();
            duell(aktuelleAttacke);

        }while (!gameOver);


    }

    public void zeigeEingabe(){
        int auswahl;



        while(true){
            System.out.println("Bitte waehlen Sie eiene Attacke: ");
            System.out.println(" [1] Standard Attacke");
            System.out.println(" [2] Super Attacke");

            while(!input.hasNextInt()){
                String eingabe = input.next();
                System.out.printf("\"%s\" ist Keine Korrekte Auswahl. %n" , eingabe);
                continue;

            }

            auswahl = input.nextInt();

            if(auswahl == 1){
                aktuelleAttacke = pokemon1.StandardAngriff();
                break;
            }else if(auswahl == 2){
                aktuelleAttacke = pokemon1.SuperAngriff();
                break;
            }else{
                System.out.println("Bitte waehlen Sie eine korrekte attacke");
                continue;
            }

        }
    }


    public void duell(int aktuelleAttacke){
        pokemon2.setLebenspunkte(pokemon2.getLebenspunkte() - aktuelleAttacke);

        System.out.println("Pokemon 1 hat mit " + aktuelleAttacke + " angegriffen"); //50
        System.out.println("pokemon 2 Lebenspunkte" + pokemon2.getLebenspunkte()); //150

        Random random = new Random();
        int auswahlGegner = random.nextInt(2) + 1;
        int aktuelleAttackeGegner = 0;

        if(auswahlGegner == 1){
            aktuelleAttackeGegner =pokemon2.StandardAngriff();
        }else if(auswahlGegner == 2){
            aktuelleAttackeGegner =pokemon2.SuperAngriff();

        }

        pokemon1.setLebenspunkte(pokemon1.getLebenspunkte() - aktuelleAttackeGegner);
        System.out.println("Pokemon 2 hat mit " + aktuelleAttackeGegner + " angegriffen");
        System.out.println("pokemon 1 Lebenspunkte" + pokemon1.getLebenspunkte());


        if(pokemon1.getLebenspunkte() <= 0){
            ZeigeResultat();
        }else if (pokemon2.getLebenspunkte() <= 0){
            ZeigeResultat();
        }
    }

    public void ZeigeResultat(){
        gameOver = true;
        System.out.println("Resultate: ");
        System.out.println("Pokemon 1 Lebenspunkte: " + pokemon1.getLebenspunkte());
        System.out.println("Pokemon 2 Lebenspunkte: " + pokemon2.getLebenspunkte());

        if(pokemon1.getLebenspunkte() > pokemon2.getLebenspunkte()){
            System.out.println("Pokemon 1 hat gewonnen!");
        }else {
            System.out.println("Pokemon 2 hat gewonnen!");
        }
    }

}
