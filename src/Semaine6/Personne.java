package Semaine6;

import java.time.LocalDate;
import java.util.ArrayList;

public class Personne {
    // champs :
    private String nom;
    private ArrayList<String> prenoms;
    private LocalDate dateNaissance;

    // constructeurs :
    public Personne(String n, String p, LocalDate d ) {
        // initialise une personne de nom n, de prénom p et de date de naissance d
        this.nom = n;
        prenoms = new ArrayList<>();
        prenoms.add(p);
        this.dateNaissance = d;
    }
    public Personne(String n, ArrayList<String> lp, LocalDate d ) {
        // initialise une personne de nom n, dont les prénoms sont dans la liste lp et de date de naissance d
        this.nom = n;
        prenoms = new ArrayList<>();
        prenoms.addAll(lp);
        this.dateNaissance = d;
    }

    // méthodes d'instance:
    public String getNom(){
        return this.nom;
    }
    public String getPrenom(){
        return this.prenoms.get(0);
    }
    public String getPrenom(int i) {
        // le ième prénom (numérotés à partir de 1)
        return this.prenoms.get(i);
    }
    public String getPrenoms() {
        // une chaîne contenant les prénoms séparés par des espaces
        String prenomChaine = "";
        for (String prenom: this.prenoms) {
            prenomChaine += (prenom + " ");
        }
        return prenomChaine;
    }
    public int getNbPrenoms() {
        // le nombre de prénoms
        return prenoms.size();
    }
    public ArrayList<String> getListeDesPrenoms(){
        return this.prenoms;
    }
    public LocalDate getDateNaissance(){
        return this.dateNaissance;
    }
    public int getAge() {
        // age actuel en années;
        return LocalDate.now().getYear() - this.dateNaissance.getYear();
    }
    public int getAge(LocalDate d) {
        // l'age de cette personne à la date d
        return d.getYear() - this.dateNaissance.getYear();
    }

    // méthodes d'instance redéfinie :
    @Override public String toString() {
        // sous la forme Nom Prenoms (dateNaissance)
        if(prenoms.size() == 0){
            return this.nom + " " + this.prenoms.get(0) + " " + this.dateNaissance;
        }
        else {
            return  this.nom + " " + this.getListeDesPrenoms().toString() + " " + this.dateNaissance;
        }
    }
}
