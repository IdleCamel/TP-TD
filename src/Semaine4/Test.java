package Semaine4;

import java.time.DateTimeException;

public class Test {
    public static void main(String[] args) {

        // Essaie des erreurs sur De2
        De2 d = new De2();

        try{
            d.getValeur();
        }
        catch (IllegalStateException e){
            e.printStackTrace(System.out);
        }

        d.lancer();

        try {
            d.getValeur();
        }
        catch (IllegalStateException e){
            e.printStackTrace(System.out);
        }

        // Essaie des erreurs sur Year2
        try {
            Year2.of(1000000000);
        }
        catch (DateTimeException e){
            e.printStackTrace(System.out);
        }

        try {
            Year2.of(2000);
        }
        catch (DateTimeException e){
            e.printStackTrace(System.out);
        }

        // Essaie des erreurs sur Exponentiation
        try{
            Exponentiation.puissance(1, -10);
        }
        catch (IllegalArgumentException e){
            e.printStackTrace(System.out);
        }

        try{
            Exponentiation.puissance(1, 2);
        }
        catch (IllegalArgumentException e){
            e.printStackTrace(System.out);
        }
    }
}
