package semaine5;

import java.time.LocalTime;

public class HeureV3 {
    // champs :
    private final int heures;           // 0 ≤ heures < 24
    private final int minutes;          // 0 ≤ minutes < 60
    private final int secondes;         // 0 ≤ secondes < 60

    // constructeurs :
    public HeureV3(int h, int m, int s){// initialise l'heure à h:m:s
        if((h >= 0 && h < 24) && (m >= 0 && m < 60) && (s >= 0 && s < 60)){
            this.heures = h;
            this.minutes = m;
            this.secondes = s;
        }else{
            throw new IllegalArgumentException();
        }
    }
    public HeureV3(int h, int m){ // initialise l'heure à h:m:00
        this(h, m, 0);
    }
    public HeureV3(int h){ // initialise l'heure à h:00:00
        this(h, 0, 0);
    }

    // méthodes d'instance :
    public int getHeures(){ return this.heures; }
    public int getMinutes(){ return  this.minutes; }
    public int getSecondes(){ return this.secondes; }

    public int enSecondes(){  // secondes depuis 00:00:00
        return this.heures*3600 + this.minutes*60 + this.secondes;
    }
    public int compareTo(HeureV3 h){ // renvoie une valeur négative, nulle ou positive selon que this < h, this == h ou this > h
        return this.enSecondes() - h.enSecondes();
    }

    public HeureV3 ajouter(int nbSecondes){
       return enHeure(this.enSecondes() + nbSecondes % 86400);
    }

    public String toString(){ // sous la forme hh:mm:ss
        return String.format("%02d:%02d:%02d", this.heures,this.minutes,this.secondes);
    }

    // méthodes de classe :
    public static HeureV3 enHeure(int nbSecondes){
        int h, m, s;

        m = nbSecondes / 60;
        s = nbSecondes % 60;
        if(s < 0){
            s += 60;
            m --;
        }
        h = m / 60;

        m %= 60;
        if (m < 0) {
            m+= 60;
            h -- ;
        }
        h %= 24;
        if(h < 0){
            h += 24;
        }

        return new HeureV3(h, m, s);
    }
    public static HeureV3 maintenant(){ // renvoie l'heure courante ; utilise LocalTime.now()
        LocalTime date = LocalTime.now();
        int h = date.getHour();
        int m = date.getMinute();
        int s = date.getSecond();

        return new HeureV3(h,m,s);
    }

    // constantes de classe :
    public static final HeureV3 MIDI = new HeureV3(12,0,0);
    public static final HeureV3 MINUIT = new HeureV3(0,0,0);
}
