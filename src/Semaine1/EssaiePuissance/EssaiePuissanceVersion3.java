package Semaine1.EssaiePuissance;

import java.util.Scanner;

public class EssaiePuissanceVersion3 {

    public static void main(String[] args)
    {
        //creation d'un objet scanner
        Scanner sc = new Scanner(System.in);

        System.out.print(("entrez un premier nombre: "));
        int x = sc.nextInt(); //lis un nombre entre sur la console

        System.out.print("entrez la puissance voulu: ");
        int y = sc.nextInt(); //lis in nombre entre sur la console

        System.out.println(x + " puissance " + y + " = "
                + puissance(x, y));
    }

    public static long puissance(int a, int k) {
        long res = 1;
        long p = a;
        for (int i = k; i > 0; i = i / 2) {
            if (i % 2 == 1) {
                res = res * p;
            }
            p = p * p;
        }
        return res;
    }
}