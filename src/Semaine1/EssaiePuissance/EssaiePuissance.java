package Semaine1.EssaiePuissance;

public class EssaiePuissance {

    public static void main(String[] args)
    {
        int x = 3;
        int y = 11;
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
