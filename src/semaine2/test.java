package semaine2;

public class test {
    public static void main(String[] args) {

        //int nbLancer = 1000000000;

        //int[] h1 = calculPerent(nbLancer);
        //Afficher(h1, nbLancer);

        //int[][] h = calculPerent2de(nbLancer);
        //AfficherTab2Dimension(h, nbLancer);

        //int[][][][][] h = calculPerent5de(nbLancer);
        //AfficherTab5Dimension(h, nbLancer);

        JeuxDivision();
        System.gc();

    }

    public static  int[] calculPerent(int nbLancer){
        De d = new De();
        int[] h = {0, 0, 0, 0, 0, 0}; //histogramme des valeurs du dé

        for (int i = 0; i < nbLancer; i++) {
            d.lancer();
            h[d.getValeur() - 1]++;
        }
        return h;
    }

    public static void Afficher(int[] h, int nbLancer){

        for (int val: h) {
            float percent = (float)val / nbLancer * 100;
            System.out.println(percent + " %");
        }
    }

    public static int[][] calculPerent2de(int nbLancer){
        De d = new De();
        De d2 = new De();

        int[][] h = new int[6][6]; //histogramme des valeurs du dé

        for (int i = 0; i < nbLancer;i++) {
                d.lancer();
                d2.lancer();
                h[d.getValeur() - 1][d2.getValeur() -1]++;

        }
        return h;
    }

    public static void AfficherTab2Dimension(int[][] h, int nbLancer){

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++){
                float percent = (float)h[i][j] / nbLancer * 100;
                System.out.println(percent + " %");
            }
        }
    }

    public static int[][][][][] calculPerent5de(int nbLancer){
        De d = new De();
        De d1 = new De();
        De d2 = new De();
        De d3 = new De();
        De d4 = new De();

        int[][][][][] h = new int[6][6][6][6][6]; //histogramme des valeurs du dé

        for (int i = 0; i < nbLancer;i++) {
            d.lancer();
            d1.lancer();
            d2.lancer();
            d3.lancer();
            d4.lancer();

            h[d.getValeur() - 1][d1.getValeur() -1][d2.getValeur() -1][d3.getValeur() -1][d4.getValeur() -1]++;

        }
        return h;
    }

    public static void AfficherTab5Dimension(int[][][][][] h, int nbLancer){

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++){
                for (int k = 0; k < 6; k++){
                    for (int l = 0; l < 6; l++){
                        for (int m = 0; m < 6; m++) {
                            float percent = (float)h[i][j][k][l][m] / nbLancer * 100;
                            System.out.println(percent + " %");
                        }
                    }
                }
            }
        }
    }

    public static void JeuxDivision(){
        De d1 = new De();
        De d2 = new De();

        d1.lancer();
        d2.lancer();

        int somme = d1.getValeur() + d2.getValeur();

        d1.lancer();

        if((somme % d1.getValeur()) == 0){
            System.out.println("gagne: " + d1.getValeur() + " divise bien " + somme);
        }
        else {
            System.out.println("perdu: " + d1.getValeur() + " ne divise pas " + somme);
        }
    }
}