package Semaine1.Year;
import java.util.*;

public class Test {

    public static void main(String[] args) {
        Year y1 = Year.of(2019);
        Year y2 = Year.of(2020);

        System.out.println(y1.isBefore(y2));
        System.out.println(y1.minusYears(2020));
        System.out.println(y1.plusYears(2020));
        System.out.println(Year.parse("2020"));

        Scanner sc = new Scanner(System.in);
        String year = sc.next();

        bisextille(year);

        Quiz();
    }

    public static void bisextille(String year){
        Year y = Year.parse(year);
        Year bisextileSuivant = y;
        Year bisextilleAvant = y;

        if(y.isLeap()) {
            bisextileSuivant = y.plusYears(4);
            bisextilleAvant = y.minusYears(4);

            System.out.println("l'annee est bisextille il y a donc 366 jours l'annee bisextile avant est: " + bisextilleAvant + " l'annee bisextile suivante est: " + bisextileSuivant);
        }
        else{
            while (!bisextileSuivant.isLeap()){
                bisextileSuivant = bisextileSuivant.plusYears(1);
            }
            while (!bisextilleAvant.isLeap()) {
                bisextilleAvant = bisextilleAvant.minusYears(1);
            }

            System.out.println("l'annee n'est pas bisextille");
            System.out.println("l'annee bisextile suivante sera en " + bisextileSuivant);
            System.out.println("l'annee bisextile avant etais en " + bisextilleAvant);
        }
    }

    public static void Quiz(){
        HashMap<String, Year> jos = new HashMap<>();
        jos.put("Chamonix", Year.of(1924));
        jos.put("Saint-Moritz", Year.of(1928));
        jos.put("Lake Placid", Year.of(1932));
        jos.put("Lake Placid", Year.of(1932));
        jos.put("Garmisch-Partenkirchen", Year.of(1936));
        jos.put("Saint-Moritz", Year.of(1948));
        jos.put("Oslo", Year.of(1952));
        jos.put("Cortina d'Ampezzo", Year.of(1956));
        jos.put("Squaw Valley", Year.of(1960));
        jos.put("Innsbruck", Year.of(1964));
        jos.put("Grenoble", Year.of(1968));
        jos.put("Sapporo", Year.of(1972));
        jos.put("Innsbruck", Year.of(1976));
        jos.put("Lake Placid", Year.of(1980));
        jos.put("Sarajevo", Year.of(1984));
        jos.put("Calgary", Year.of(1988));
        jos.put("Albertville", Year.of(1992));
        jos.put("Lillehammer", Year.of(1994));
        jos.put("Nagano", Year.of(1998));
        jos.put("Salt Lake City", Year.of(2002));
        jos.put("Turin", Year.of(2006));
        jos.put("Vancouver", Year.of(2010));
        jos.put("Sotchi", Year.of(2014));
        jos.put("PyeongChang", Year.of(2018));

        Random rnd = new Random();
        int nb = rnd.nextInt(jos.size());

        Object[] ville = jos.keySet().toArray();
        String villeAceuile = ville[nb].toString();

        Object[] ListeReponse = jos.values().toArray();
        Year reponse = (Year)ListeReponse[nb];

        System.out.println("En quelle année les derniers JO de " + villeAceuile +  " ont-ils eu lieu ?");

        Scanner sc = new Scanner(System.in);


        String yearQuiz = sc.next();
        Year repYear = Year.parse(yearQuiz);

        if (repYear == reponse) {
            System.out.print("Bravo la reponse etais bien: " + reponse);
        } else {
            System.out.print("Dommage la reponse etais: " + reponse);
        }
    }
}

