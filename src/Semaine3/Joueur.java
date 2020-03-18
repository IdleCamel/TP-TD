package Semaine3;

//import org.jetbrains.annotations.NotNull;
import semaine2.De;

import java.util.ArrayList;
import java.util.Scanner;

public class Joueur {
    private String pseudo;
    private int score;

    public Joueur(String pseudo) {
        this.pseudo = pseudo;
    }

    @Override
    public String toString() {
        return "Joueur{" + "pseudo='" + pseudo + '\'' + ", score=" + score + '}';
    }

    public String getPseudo(){
        return this.pseudo;
    }

    public int getScore(){
        return this.score;
    }

    public void commencerLaPartie(){
        this.score = 0;
    }

    public void lancer( De d){
        d.lancer();
        this.score += d.getValeur();
    }

    public boolean estElimine(){
        return this.score > 15;
    }

    public boolean aGagne(){
        return this.score == 15;
    }

    public boolean veutArreter(){
        return false;
    }
}
