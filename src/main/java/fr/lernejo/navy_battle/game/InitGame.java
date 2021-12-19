package fr.lernejo.navy_battle.game;

import java.util.Scanner;

public class InitBoard {
    public static int saisirEntier(int binf, int bsup)
    {
        Scanner input = new Scanner(System.in);
        int n = binf - 1;
        while (!(binf <= n && n <= bsup))
        {
            System.out.print("Entier dans [" + binf + ".." + bsup + "]? ");
            n = input.nextInt();
        }
        return n;
    }

}
