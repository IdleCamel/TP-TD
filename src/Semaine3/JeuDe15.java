package Semaine3;

import semaine2.De;

import java.util.ArrayList;

public class JeuDe15 {
    private ArrayList<Joueur> lesJoueurs;
    private De leDe = new De();


    public JeuDe15(ArrayList<Joueur> lesJoueurs) {
        this.lesJoueurs = lesJoueurs;
    }


    public ArrayList<Joueur> getLesJoueurs() {
        return lesJoueurs;
    }

    public void faireJouerUnePartie(Joueur j){
        while (j.veutArreter() || !j.estElimine() || j.aGagne()){
            j.lancer(leDe);
        }
    }


    public void jouerUnePartie(){
        for (Joueur j : lesJoueurs){
            faireJouerUnePartie(j);
            System.out.println(j.toString());
        }
    }

    public ArrayList<Joueur> lesGagnants(){
        ArrayList listGagnant = new ArrayList<Joueur>();
        Joueur gagnant = lesJoueurs.get(1);

        for (Joueur j : lesJoueurs){
            if (j.aGagne()) {
                listGagnant.add(j);
                break;
            }
            else if(j.getScore() <= gagnant.getScore()){
                gagnant = j;
                listGagnant.add(gagnant);
            }
        }
        return listGagnant;
    }
}
