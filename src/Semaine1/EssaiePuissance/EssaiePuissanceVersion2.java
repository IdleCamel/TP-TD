package Semaine1.EssaiePuissance;

public class EssaiePuissanceVersion2 {

    public static void main(String[] args)
    {
        // Attention, il faut verifier que le nombre de parametre est coherent avec le nombre de parametre demande
        int x = Integer.parseInt(args[0]); //lis le premier argument passe en parameter
        int y = Integer.parseInt(args[1]); //lis le second argument pass en parameter
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
