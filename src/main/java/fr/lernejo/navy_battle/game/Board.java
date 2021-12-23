package fr.lernejo.navy_battle.game;

/**
 Terrain de jeu
 */
public class Board {
    // Mer
    final int BMer = 0;
    // Bateau
    final int BBateau = 1;
    // Loupé
    final int BDebris = 2;
    // Touché
    final int BTir = 3;
    // Largeur maximale
    final int LGMAX = 10;
    // Hauteur maximale
    final int HTMAX = 10;
    public final int hauteur;
    public final int largeur;
    public final int[][] cases;

    public Board(int hauteur, int largeur, int[][] cases) {
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.cases = cases;
    }

    public static int evalCase(final Board tr, int j, int k) {
        return tr.cases[j][k];
    }
    public static void fixerCase(Board tr, int j, int k, int valeur) {
        tr.cases[j][k] = valeur;
    }
    public char symboleDe(int x) {
        if (x == BMer || x == BBateau) {
            return'~';
        } else if (x == BTir) {
            return'o';
        } else {
            return'x';
        }
    }
        public void afficherTerrain(final Board tr)
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


