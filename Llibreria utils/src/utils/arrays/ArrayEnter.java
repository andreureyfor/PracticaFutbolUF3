package utils.arrays;

public class ArrayEnter {
    
    // definim una constant pel numero d'equips màxim que considerem que pot tenir la lliga
    // aquesta constant la farem servir per definir la llargada del arrays

    public static int max(int[] valors) {
        // calcular la nota maxima
        int max = valors[0];
        for (int i = 0; i < valors.length; i++) {
            if (valors[i] > max) {
                max = valors[i];
            }
        }
        return max;
    }

    public static int min(int[] valors) {
        // calcular la nota minima
        int min = valors[0];
        for (int i = 0; i < valors.length; i++) {
            if (valors[i] < min) {
                min = valors[i];
            }
        }
        return min;
    }

    public static int mitjana(int[] valors) {
        // calcular la mitjana
        int suma = 0;
        for (int i = 0; i < valors.length; i++) {
            suma += valors[i];
        }
        int mitjana = suma / valors.length;
        return mitjana;
    }

    // retorna l'index de l'element maxim
    public static int posmax(int[] valors) {
        // calcular la nota maxima
        int pos = 0;
        int max = valors[0];
        for (int i = 0; i < valors.length; i++) {
            if (valors[i] > max) {
                max = valors[i];
                pos = i;
            }
        }
        return pos;
    }

    // retorna l'index de l'element minim
    public static int posmin(int[] valors) {
        // calcular la nota minima
        int pos = 0;
        int min = valors[0];
        for (int i = 0; i < valors.length ; i++) {
            if (valors[i] < min) {
                min = valors[i];
                pos = i;
            }
        }
        return pos;
    }

    public static void visualitzar(int[] valors) {
        // imprimir array
        for (int i = 0; i < valors.length; i++) {
            System.out.print(valors[i] + " ");
        }
        System.out.println("");
    }

    public static int factorial(int facto) {

        int suma = facto;

        for (int i = facto - 1; i > 0; i--) {
            suma *= i;
        }
        System.out.println(suma);
        return suma;
    }

    public static int posicio(int[] numeros, int pos) {

        boolean corrector = true;
        for (int i = 0; i < numeros.length; i++) {
            if (pos == i) {
                return pos;
            } else {
                corrector = false;
            }
        }
        if (!corrector) {
            pos = -1;
        }
        return pos;
    }

    public static void arrayOrdenat(int[] numeros) {

        int comp;
        for (int i = 0; i < numeros.length; i++) {
            for (int j = i + 1; j < numeros.length; j++) {
                if (numeros[i] > numeros[j]) {
                    comp = numeros[i];
                    numeros[i] = numeros[j];
                    numeros[j] = comp;
                }
            }
        }
    }
    
     public static void visualitzarBidimensional(String[] noms, int[][] nums){
        for (int i = 0; i < noms.length && noms[i] != null; i++) {
            System.out.printf("\n%15s", noms[i]);
            for (int j = 0; j < nums[i].length; j++) {
                System.out.printf("%10d", nums[i][j]);
            }
        }
    }
     
    public static int posmaxBidimensional(int[][] valors, String[] equips, int maxPunts, int indMax) {
        
        for (int i = 0; i < valors.length && equips[i] != null; i++) {
            if (valors[i][4] > maxPunts) {
                maxPunts = valors[i][4];
                indMax = i;
            }
        }
        return indMax;
    }

    // retorna l'index de l'element minim
    public static int posminBidimensional(int[][] valors, String[] equips, int minPunts, int indMin) {
        
        for (int i = 0; i < valors.length && equips[i] != null; i++) {
            if (valors[i][4] < minPunts) {
                minPunts = valors[i][4];
                indMin = i;
            }
        }
        return indMin;
    }
    
    
    

}
