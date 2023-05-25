package uf3.practica.futbol.segonNivellDescomposicio;

import utils.arrays.ArrayEnter;
import utils.arrays.ArrayString;
import utils.consola.LecturaConsola;


/**
 * 
 * @author andreu
 */
public class VisualitzacioDades {
    
    /**
     * Aquest metode servira per a poder visualitzar la classificacio de la lliga.
     */
    public static void visualitzarDades(String[] equips, int[][] punts){
        
        visualizarCapçalera();
        ArrayEnter.visualitzarBidimensional(equips, punts);
    }
    
    /**
     * Aqui podrem mostra que es cada puntuacio
     */
    public static void visualizarCapçalera(){
        
        System.out.printf("\n\033[31m%15s %10s %10s %10s %10s %10s %-8s %-8s %10s", "Equip", "Jugats", "Guanyats", "Empatats", "Perduts", "PUNTS   ", "G.Favor", "G.Contra  ", "Diferencia");
    }
    
    /**
     * L'utilitzarem per a que un cop acabada la opcio retorni al menu
     */
    public static void retornaMenu(){
        
        System.out.println("\n\nPrem RETURN per continuar...");
                LecturaConsola.buidaBuffer();
        
    }
    
    /**
     * Aqui podrem visualitzar els noms del equips de la lliga ordenats
     * @param noms li donarem l'array de noms dels equips
     * @param noms2 l'utilitzarem per a ordenar l'array de noms
     */
    public static void visualitzarArray(String[] noms, String[] noms2) {
        
        // es visualitza els noms d'equips ordenats
        for (int i = 0; i < noms.length && noms2[i] != null; i++) {
            System.out.println(noms[i]);
        }
    }
    
    /**
     * Servira per a poder visualitzar qui es lider i qui es cuer per puntuacions de la lliga.
     */
    public static void mostrarPrimerUltimEquip(String[] equips, int[][] punts){
        
        System.out.printf("\n       \033[31m%15s %10s %10s %10s %10s %10s %-8s %-8s %10s", "Equip", "Jugats", "Guanyats", "Empatats", "Perduts", "PUNTS   ", "G.Favor", "G.Contra  ", "Diferencia");
        ArrayString.visualitzarMaxMin(punts, equips);
    }
    
    
}
