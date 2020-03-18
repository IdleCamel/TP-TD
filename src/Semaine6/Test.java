package Semaine6;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws FileNotFoundException {
        String path = "/Users/snoke/Desktop/coursIUT/S2/P21/TP-TD/src/Semaine6/fichierPersonne.txt";
        ArrayList<Personne> listPersone = lirePersonne(path);
    }

    public static ArrayList<Personne> lirePersonne(String fichier) throws FileNotFoundException {
        ArrayList<Personne> res = new ArrayList<>();
        Scanner sc = new Scanner(new File(fichier));
        String name;
        ArrayList<String> prenom = new ArrayList<>();
        LocalDate naissance;

        while (sc.hasNextLine())
        {
            String ligne = sc.nextLine();
            String[] ligneSplit = ligne.split(" ");
            name = ligneSplit[0];

            for (int i = 1; i < ligneSplit.length - 2; i++){
                prenom.add(ligneSplit[i]);
            }

            naissance = LocalDate.parse(ligneSplit[ligneSplit.length -1], DateTimeFormatter.ofPattern("d/M/yyyy"));

            res.add(new Personne(name,prenom,naissance));
        }
        return  res;
    }

}
