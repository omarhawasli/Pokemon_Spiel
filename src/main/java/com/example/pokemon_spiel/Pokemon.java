package com.example.pokemon_spiel;

import java.util.Random;

public class Pokemon {

    //lebenspunkte
    //zwei attacken
    private int lebenspunkte;
    private int aktuelleAngriff;

    public Pokemon(int lebenspunkte){
        this.lebenspunkte = lebenspunkte;
    }

    public int StandardAngriff(){
        Random random = new Random();
        aktuelleAngriff = random.nextInt(20)  + 1;
        return aktuelleAngriff;
    }

    public int SuperAngriff(){
        Random random = new Random();
        aktuelleAngriff = random.nextInt(50)  + 1;
        return aktuelleAngriff;
    }

    public int getLebenspunkte(){
        return lebenspunkte;
    }

    public void setLebenspunkte(int lebenspunkte){
        if(lebenspunkte <= 0 ){
            this.lebenspunkte = 0;
        }else{
            this.lebenspunkte = lebenspunkte;

        }
    }



}
