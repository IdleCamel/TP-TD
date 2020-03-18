package Semaine4;

import java.util.Random;

public class De2 {

    // attibuts
    private static final Random rand = new Random();
    private short valeur = -1;

    //constructeur
    public De2(){}

    // Méthodes d'instance
    public short getValeur(){
        if(this.valeur == -1){
            throw new IllegalStateException("lancer le de d'abord");
        }
        else{
            return valeur;
        }
    }

    public short getValeurCachee() {
        if(this.valeur == -1){
            throw new IllegalStateException("lancer le de d'abord");
        }
        else{
            return (short) (7 - getValeur());
        }
    }

    public void lancer(){
        valeur = (short) ((short) rand.nextInt(6) + 1); // +1 car les bornes sont exclue, on a donc un nb entre 0 et 5 si on ne fait pas +1
    }

    @Override //pour dire que l'on surchage une methode existante
    public String toString(){ return String.valueOf(getValeur()); }
    // si on ne redefinit pas la methode toString, java utilise la methode de java.util
}
