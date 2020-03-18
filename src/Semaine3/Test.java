package Semaine3;

import semaine2.De;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Joueur j1 = new Joueur("Jean");
        Joueur j2 = new Joueur("Bob");
        Joueur j3 = new Joueur("Val");

        De d = new De();
        ArrayList lesJoueurs = new ArrayList<Joueur>();

        lesJoueurs.add(j1);
        lesJoueurs.add(j2);
        lesJoueurs.add(j3);

        JeuDe15 jeux = new JeuDe15(lesJoueurs);
        jeux.jouerUnePartie();
        System.out.println(jeux.lesGagnants());

    }
}
