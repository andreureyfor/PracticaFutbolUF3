package utils.arrays;

public class ArrayDouble {

    public static double max(double[] valors) {
        // calcular la nota maxima
        double max = valors[0];
        for (int i = 0; i < valors.length; i++) {
            if (valors[i] > max) {
                max = valors[i];
            }
        }
        return max;
    }

    public static double min(double[] valors) {
        // calcular la nota minima
        double min = valors[0];
        for (int i = 0; i < valors.length; i++) {
            if (valors[i] < min) {
                min = valors[i];
            }
        }
        return min;
    }

    public static double mitjana(double[] valors) {
        // calcular la mitjana
        double suma = 0;
        for (int i = 0; i < valors.length; i++) {
            suma += valors[i];
        }
        double mitjana = suma / valors.length;
        return mitjana;
    }

    // retorna l'index de l'element maxim
    public static int posmax(double[] valors) {
        // calcular la nota maxima
        int pos = 0;
        double max = valors[0];
        for (int i = 0; i < valors.length; i++) {
            if (valors[i] > max) {
                max = valors[i];
                pos = i;
            }
        }
        return pos;
    }

    // retorna l'index de l'element minim
    public static int posmin(double[] valors) {
        // calcular la nota maxima
        int pos = 0;
        double min = valors[0];
        for (int i = 0; i < valors.length; i++) {
            if (valors[i] < min) {
                min = valors[i];
                pos = i;
            }
        }
        return pos;
    }

    public static void visualitzar(double[] valors) {
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

    public static int posicio(double[] numeros, int pos) {

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

    public static void arrayOrdenat(double[] numeros) {

        double comp;
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

}
