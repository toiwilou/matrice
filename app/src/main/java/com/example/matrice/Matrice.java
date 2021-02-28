package com.example.matrice;

public class Matrice {

    // Récupération d'une matrice
    public double[][] recupMat (String chaine) {

        // Eliminer tout espace inutil
        chaine = chaine.replaceAll(" {2,}", " ").replaceAll(" ,", ",").replaceAll(", ", ",");

        // Explosion de la chaine en tableau par les virgules
        String tab [] = chaine.split(",");

        // Remplacer les espaces par des virgules
        String nouvelleChaine  = chaine.replaceAll(" ", ",");

        // Explosion de la nouvelle chaine en tableau par les virgules
        String tableau [] = nouvelleChaine.split(",");

        // Nombre de lignes
        int m = tab.length;

        // Explosion du premier element du tableau tab en tableau par les espaces
        String tab0 [] = tab[0].split(" ");

        // Nombre de colonnes
        int n = tab0.length;

        // Déclaration de la matrice de retour
        double matrice [][] = new double[m][n];

        // Récupération

        int i = 0, j, k = 0;
        while (i < m) {
            j = 0;
            while (j < n) {

                // Récupération des valeurs de << tableau >> converties en << double >>
                matrice[i][j] = Double.parseDouble(tableau[k]);
                j++; k++;
            }
            i++;
        }

        // Matrice de retour
        return matrice;
    }

    // Fonction de vérification d'entiers
    public boolean isint (double valeur) {

        boolean verification = false;
        int intValeur = (int) valeur;

        if (valeur == intValeur) {
            verification = true;
        }

        return verification;
    }

    // Fonction d'affichage d'une matrice
    public String afficher_matrice (double matrice [][]) {

        String chaine = "";
        int m = matrice.length, n = matrice[0].length;

        int i = 0, j;
        while (i < m) {
            j = 0;
            while (j < n) {
                if (this.isint(matrice[i][j])) {
                    chaine += (int) matrice[i][j] + "     ";
                } else {
                    chaine += matrice[i][j] + "     ";
                }
                j++;
            }
            chaine += "\n\n";
            i++;
        }

        return chaine;
    }
}
