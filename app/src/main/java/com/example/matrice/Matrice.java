package com.example.matrice;

public class Matrice {

    // Fonction de validation
    public boolean validation (String chaine) {

        chaine = chaine.replaceAll(" {2,}", " ").replaceAll(" ,", ",").replaceAll(", ", ",");
        String tableau [] = chaine.split(",");
        boolean validation = false;
        int dim [] = new int [tableau.length];

        int k = 0;
        while (k < tableau.length) {
            dim [k] = tableau [k].split(" ").length;
            if (k == 0 || (k > 0 && dim [k] == dim [k-1])) {

                String chaines [] = chaine.replaceAll(",", " ").split(" ");
                int longueur = chaines.length;

                if (longueur > 1 && longueur < 17 && (longueur == 3 || longueur == 9 || longueur % 2 == 0)) {

                    int i = 0;
                    while (i < longueur) {

                        if (chaines [i].isEmpty()) {
                            validation = false;
                            break;
                        } else {
                            try {
                                Double.parseDouble(chaines[i]);
                                if (chaines [i].length() <= 8) {
                                    validation = true;
                                } else {
                                    validation = false;
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                validation = false;
                                break;
                            }
                        }
                        i++;
                    }
                } else {
                    validation = false;
                }
            } else {
                validation = false;
                break;
            }
            k++;
        }

        return validation;
    }

    // Fonction de validation de matrices pour la somme
    public boolean validationSomme (double mat1 [][], double mat2 [][]) {

        boolean valSom = false;
        int m1 = mat1.length, m2 = mat2.length, n1 = mat1 [0].length, n2 = mat2 [0].length;
        if (m1 == m2 && n1 == n2) {
            valSom = true;
        }

        return valSom;
    }

    // Fonction de validation de matrices pour le produit
    public boolean validationProduit (double Mat1 [][], double Mat2 [][]) {

        boolean valPro = false;
        int m = Mat2.length, n = Mat1 [0].length;
        if (m == n) {
            valPro = true;
        }

        return valPro;
    }

    // Récupération d'une matrice
    public double[][] recupMat (String chaine) {

        // Eliminer tout espace inutil
        chaine = chaine.replaceAll(" {2,}", " ").replaceAll(" ,", ",").replaceAll(", ", ",");

        // Explosion de la chaine en tableau par les virgules
        String tab [] = chaine.split(",");

        // Nombre de lignes
        int m = tab.length;

        // Explosion du premier element du tableau tab en tableau par les espaces
        String tab0 [] = tab [0].split(" ");

        // Nombre de colonnes
        int n = tab0.length;

        // Remplacer les espaces par des virgules
        String nouvelleChaine  = chaine.replaceAll(" ", ",");

        // Explosion de la nouvelle chaine en tableau par les virgules
        String tableau [] = nouvelleChaine.split(",");

        // Déclaration de la matrice de retour
        double matrice [][] = new double [m][n];

        // Récupération

        int i = 0, j, k = 0;
        while (i < m) {
            j = 0;
            while (j < n) {

                // Récupération des valeurs de << tableau >> converties en << double >>
                matrice [i][j] = Double.parseDouble(tableau [k]);
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

    // Fonction qui fait la somme de deux matrices
    public double [][] somme (double [][] matrice1, double [][] matrice2) {

        int i = 0, j, m = matrice1.length, n = matrice1[0].length;
        double sommeMatrice [][] = new double [m][n];

        while (i < m) {
            j = 0;
            while (j < n) {
                sommeMatrice [i][j] = matrice1 [i][j] + matrice2 [i][j];
                j++;
            }
            i++;
        }

        return sommeMatrice;
    }

    // Fonction qui fait le produit de deux matrices
    public double [][] produit (double matrix1 [][], double matrix2 [][]) {

        int i = 0, j, k, m = matrix1.length, n = matrix2 [0].length, p = matrix2.length;
        double produitMatrice [][] = new double [m][n];

        while (i < m) {
            j = 0;
            while (j < n) {
                k = 0;
                while (k < p) {
                    produitMatrice [i][j] +=  matrix1 [i][k] * matrix2 [k][j];
                    k++;
                }
                j++;
            }
            i++;
        }

        return produitMatrice;
    }

    // Fonction d'affichage d'une matrice
    public String afficher_matrice (double matrice [][]) {

        String chaine = "";
        int m = matrice.length, n = matrice [0].length;

        int i = 0, j;
        while (i < m) {
            j = 0;
            while (j < n) {
                if (this.isint(matrice [i][j])) {
                    chaine += (int) matrice [i][j] + "     ";
                } else {
                    chaine += matrice [i][j] + "     ";
                }
                j++;
            }
            chaine += "\n\n";
            i++;
        }

        return chaine;
    }
}
