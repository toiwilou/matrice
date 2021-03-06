package com.example.matrice;

public class OperationsMatriceCarree {
    
    public double determinant (double matrice [][]) {
        
        int i = 0, j, k, n = matrice.length, p = 0;
        int compteur [] = new int [n-2];
        double a = 0, b = 0, c = 0, d = 0, determinant = 0;

        if (n == 2) {
            determinant = (matrice [0][0] * matrice [1][1]) - (matrice [0][1] * matrice [1][0]);
        } else if (n == 3){
            j = 0; compteur [0] = 0;
            while (j < n) {

                k = 0;
                while (k < n) {

                    if (k != j) {
                        a = matrice [n-2][k]; b = matrice [n-1][k]; p = k+1; break;
                    } k++;
                }

                while (p < n) {

                    if (p != j) {
                        c = matrice [n-2][p]; d = matrice [n-1][p]; break;
                    } p++;
                }

                determinant += Math.pow((-1), compteur [0]) * matrice [0][j] * ((a * d) - (c * b));
                compteur [0]++;
                j++;
            }
        } else {
            compteur [0] = 0;
            while (i < n) {

                j = 0; compteur [1] = 0;
                while (j < n) {

                    if (j != i) {
                        k = 0;
                        while (k < n) {

                            if (k != i && k != j) {
                                a = matrice [n-2][k]; b = matrice [n-1][k]; p = k+1; break;
                            } k++;
                        }

                        while (p < n) {

                            if (p != i && p != j) {
                                c = matrice [n-2][p]; d = matrice [n-1][p]; break;
                            } p++;
                        }

                        determinant += Math.pow((-1), compteur [0]) * matrice [0][i] * Math.pow((-1), compteur [1]) * matrice [n-3][j] * ((a * d) - (c * b));
                        compteur [1]++;
                    } j++;
                } i++; compteur [0] ++;
            }
        }

        return determinant;
    }
}
