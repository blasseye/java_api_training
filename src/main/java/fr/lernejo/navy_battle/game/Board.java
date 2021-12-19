package fr.lernejo.navy_battle.game;

/**
 Terrain de jeu
 */
public class Board {
    // Mer
    final static int BMer = 0;
    // Bateau
    final static int BBateau = 1;
    // Loupé
    final static int BDebris = 2;
    // Touché
    final static int BTir = 3;
    // Largeur maximale
    final static int LGMAX = 10;
    // Hauteur maximale
    final static int HTMAX = 10;
    public int hauteur;
    public int largeur;
    public int[][] cases;

    public static int evalCase(final Board tr, int j, int k) {
        return tr.cases[j][k];
    }
    public static void fixerCase(Board tr, int j, int k, int valeur) {
        tr.cases[j][k] = valeur;
    }
    public static char symboleDe(int x) {
        if (x == BMer || x == BBateau) {
            return'~';
        } else if (x == BTir) {
            return'o';
        } else {
            return'x';
        }
    }
        public static void afficherTerrain(final Board tr)
        {
            for (int j = 0; j < tr.hauteur; ++j)
            {
                for (int k = 0; k < tr.largeur; ++k)
                {
                    System.out.print(symboleDe(evalCase(tr,j,k)));
                }
                System.out.println();
            }
        }
}


