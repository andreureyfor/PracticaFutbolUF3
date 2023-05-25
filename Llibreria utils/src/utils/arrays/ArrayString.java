package utils.arrays;

import static utils.arrays.ArrayEnter.posmaxBidimensional;
import static utils.arrays.ArrayEnter.posminBidimensional;

public class ArrayString {

    public static void copiaDeDosArray(String[] noms, String[] noms2, int[][] punts, int[][] punts2) {

        for (int i = 0; i < noms2.length; i++) {
            noms[i] = noms2[i];
            for (int j = 0; j < punts2[i].length; j++) {
                punts[i][j] = punts2[i][j];

            }
        }
    }

    public static void copiaDeUnArray(String[] noms, String[] nomsOrd, int numEquips) {
        for (int i = 0; i < numEquips; i++) {
            nomsOrd[i] = noms[i];
        }
    }

    public static void arrayOrdenat(String[] nomsOrd, int numEquips) {

        String tmp;
        for (int i = 0; i < numEquips - 1; i++) {
            // des de l'últim fins al següent de la i
            for (int j = numEquips - 1; j > i; j--) {
                if (nomsOrd[j] != null) {
                    if (nomsOrd[j].compareToIgnoreCase(nomsOrd[j - 1]) < 0) {
                        tmp = nomsOrd[j];
                        nomsOrd[j] = nomsOrd[j - 1];
                        nomsOrd[j - 1] = tmp;
                    }
                }
            }
        }
    }

    public static void trobarEquip(String[] noms, String nom, int[][] punts) {

        boolean trobat = false;
        //cerquem el nom d'equip a l'array de noms
        int i = 0;
        for (i = 0; i < noms.length && noms[i] != null; i++) {
            if (nom.equalsIgnoreCase(noms[i])) {
                trobat = true;
                break;
            }
        }
        if (trobat) {
            System.out.printf("\n\033[31m%15s %10s %10s %10s %10s %10s %-8s %-8s %10s", "Equip", "Jugats", "Guanyats", "Empatats", "Perduts", "PUNTS   ", "G.Favor", "G.Contra  ", "Diferencia");
            System.out.printf("\n%15s", noms[i]);
            for (int j = 0; j < punts[i].length; j++) {
                System.out.printf("%10d", punts[i][j]);
            }
        } else {
            System.out.println("No s'ha trobat aquest nom d'equip");
        }
    }

    public static void visualitzarMaxMin(int[][] nums, String[] noms) {
        
        int maxPunts = nums[0][4],
                indMax = 0;
        int minPunts = nums[0][4],
                indMin = 0;
        
        int max = posmaxBidimensional(nums, noms, maxPunts, indMax);
        int min = posminBidimensional(nums, noms, minPunts, indMin);

        visualitzarprimer(max, noms, nums);
        visualitzaultim(min, noms, nums);

        
    }
    

    public static void visualitzarprimer(int indMax, String[] noms, int[][] nums) {

        System.out.printf("\nLIDER %15s", noms[indMax]);
        for (int j = 0; j < nums[indMax].length; j++) {
            System.out.printf("%10d", nums[indMax][j]);
        }

    }

    public static void visualitzaultim(int indMin, String[] noms, int[][] nums) {

        System.out.printf("\nCUER  %15s", noms[indMin]);
        for (int j = 0; j < nums[indMin].length; j++) {
            System.out.printf("%10d", nums[indMin][j]);
        }

    }

    public static void quicksort(String A[], int izq, int der) {

        String pivote = A[izq]; // tomamos primer elemento como pivote
        int i = izq;         // i realiza la búsqueda de izquierda a derecha
        int j = der -1;         // j realiza la búsqueda de derecha a izquierda
        String aux;

        while (i < j) {                          // mientras no se crucen las búsquedas
            while (A[i].compareToIgnoreCase(pivote) <= 0 && i < j) {
                i++; // busca elemento mayor que pivote
            }
            while (A[j].compareToIgnoreCase(pivote) > 0) {
                j--;           // busca elemento menor que pivote
            }
            if (i < j) {                        // si no se han cruzado                      
                aux = A[i];                      // los intercambia
                A[i] = A[j];
                A[j] = aux;
            }
        }

        A[izq] = A[j];      // se coloca el pivote en su lugar de forma que tendremos                                    
        A[j] = pivote;      // los menores a su izquierda y los mayores a su derecha

        if (izq < j - 1) {
            quicksort(A, izq, j);          // ordenamos subarray izquierdo
        }
        if (j + 1 < der) {
            quicksort(A, j + 1, der);          // ordenamos subarray derecho
        }
    }

}
