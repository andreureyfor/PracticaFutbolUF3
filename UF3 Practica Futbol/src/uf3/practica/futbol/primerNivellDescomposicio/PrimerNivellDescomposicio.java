package uf3.practica.futbol.primerNivellDescomposicio;

import uf3.practica.futbol.persistenciadades.PersistenciaDades;
import uf3.practica.futbol.segonNivellDescomposicio.ActualitzacioDades;
import static uf3.practica.futbol.segonNivellDescomposicio.ActualitzacioDades.modificarEquip;
import uf3.practica.futbol.segonNivellDescomposicio.VisualitzacioDades;
import static uf3.practica.futbol.segonNivellDescomposicio.VisualitzacioDades.retornaMenu;
import utils.arrays.ArrayString;
import utils.consola.LecturaConsola;

/**
 * En aquesta classe podem veure el menu que li apareixera a l'usuari i el switch que representa les diferents opcions del menu.
 * @author andreu
 */
public class PrimerNivellDescomposicio {
    
        public static final int NUMERO_EQUIPS = 40;
        public static int numEquips = 0;
        
        
    /**
     * Aquest metode conte la visualitzacio del menu
     * Hi haura una variable que conte la seleccio que fa l'usuari i mentre no sigui igual a 7 es fara un bucle del menu.
     */
    public static void mostrarMenu(){
        
         // creem els arrays amb uns valors inicials, per tenir dades introduïdes quan executem el programa
        String[] equipsCodi = {"Barcelona", "Real Madrid", "Real Sociedad", "Athletic", "Atletico Madrid", "Real Betis", "Osasuna CF", "Rayo Vallecano", "Villareal", "Valencia", "Mallorca", "Valladolid", "Girona CF", "Almeria CF", "Getafe CF", "Espanyol", "Celta de Vigo", "Sevilla CF", "Cadiz CF", "Elche CF"};
        // En aquest array bidimensional, s'emmagatzema les puntuacions dels equips de la lliga. 
        // Cada fila emmagatzema les puntuacions de l'equip situat en la mateixa posició que la fila
        // Cada columna d'aquest array guarda la següent informació:
        // Columna 0: partits jugats
        // Columna 1: partits guanyats
        // Columna 2: partits empatats
        // Columna 3: partits perduts
        // Columna 4: punts totals
        // Columna 5: gols a favor
        // Columna 6: gols en contra
        // Columna 7: diferència de gols
        int[][] puntsCodi = {{14, 12, 1, 1, 37, 33, 5, 28},
        //Real Madrid
        {14, 11, 2, 1, 35, 33, 14, 19},
        //Real Sociedad
        {14, 8, 2, 4, 26, 19, 17, 2},
        //Athletic Club
        {14, 7, 3, 4, 24, 24, 14, 10},
        //Atlético de Madrid
        {14, 7, 3, 4, 24, 21, 14, 10},
        //Betis
        {14, 7, 3, 4, 24, 17, 12, 5},
        //Osasuna
        {14, 7, 2, 5, 23, 16, 14, 2},
        //Rayo Vallecano
        {14, 6, 4, 4, 22, 20, 16, 4},
        //Villarreal
        {14, 6, 3, 5, 21, 15, 10, 5},
        //Valencia
        {14, 5, 4, 5, 19, 22, 15, 7},
        //Mallorca
        {14, 5, 4, 5, 19, 13, 13, 0},
        //Valladolid
        {14, 5, 2, 7, 17, 13, 21, -8},
        //Girona    
        {14, 4, 4, 6, 16, 20, 22, -2},
        //Almería
        {14, 5, 5, 8, 16, 16, 22, -6},
        //Getafe
        {14, 3, 5, 6, 14, 12, 20, -8},
        //Espanyol
        {14, 2, 6, 6, 12, 16, 22, -6},
        //Celta de Vigo
        {14, 3, 3, 8, 12, 14, 26, -12},
        //Sevilla
        {14, 2, 5, 7, 11, 13, 22, -9},
        //Cadiz
        {14, 2, 5, 7, 11, 9, 26, -17},
        //Elche
        {14, 0, 4, 10, 4, 10, 31, -21}};
        
        
        
        String[] equips = new String[NUMERO_EQUIPS]; // inicialitza per defecte a null
        int[][] punts = new int[NUMERO_EQUIPS][8];  // inicialitza per defecte a zero
        
        numEquips = equipsCodi.length;
        int opcio;
        ArrayString.copiaDeDosArray(equips, equipsCodi, punts, puntsCodi);
        
        
        PersistenciaDades.llegirEquips(equips, punts);
        
        for (int i = equipsCodi.length; i < equips.length; i++) {
            if (equips[i] != null) {
                ++numEquips;
            }
        }
        
        do {
            
            System.out.println("\nGESTIÓ PUNTUACIONS EQUIPS LLIGA");
            System.out.println("___________________________________________________________");

            System.out.println("\nOpcions que pots triar: \n");
            System.out.println("1. Visualitza les dades dels equips");
            System.out.println("2. Visualitza els noms dels equips ordenats");
            System.out.println("3. Visualitza les dades d'un equip, per nom equip");
            System.out.println("4. Visualitza les dades de l'equip lider i de l'equip cuer");
            System.out.println("5. Introdueix dades de nou equip");
            System.out.println("6. Modificar dades d'un equip");
            System.out.println("7. Sortir");
            System.out.println("\nTria una opció: ");
            System.out.println("____________________________________________________________");

            opcio = LecturaConsola.llegirEnter();
            
            tractarOpcio(opcio, equips, punts);
        } while (opcio != 7);
    }
    
    /**
     * Aqui es on es tractara l'opcio de l'usuari, on cada CASE fara les opcions del menu.
     * case 1 Visualitza les dades dels equips
     * case 2 Visualitza els noms dels equips ordenats
     * case 3 Visualitza les dades d'un equip, per nom equip
     * case 4 Visualitza les dades de l'equip lider i de l'equip cuer"
     * case 5 Introdueix dades de nou equip
     * case 6 Modificar dades d'un equip
     * case 7 Sortir
     * @param opcio Recollira la dada que li pasa l'usuari per a triar una opcio al switch
     * @param equips Li pasa l'array de noms dels equips
     * @param punts Li pasa l'array de puntuacions dels equips
     */
    public static void tractarOpcio(int opcio, String[] equips, int[][] punts){
        
        switch (opcio) {

                case 1:
                    VisualitzacioDades.visualitzarDades(equips, punts);
                    break;
                case 2:
                    String[] equipsOrd = new String[numEquips];
                    ActualitzacioDades.ordenarEquips(equipsOrd, equips, punts);
                    break;
                case 3:
                    ActualitzacioDades.buscarUnEquip(equips, punts);
                    break;
                case 4:
                    VisualitzacioDades.mostrarPrimerUltimEquip(equips, punts);
                    break;
                case 5:
                    System.out.println("_______________ ALTA D'EQUIP NOU _______________");
                    int indTrobat = 0;
                    boolean trobat = false;
                    ActualitzacioDades.introduirNouEquip(indTrobat, trobat, equips, punts);                
                    break;
                case 6:
                    
                    System.out.println("\n_______________ MODIFICACIÓ DE DADES D'UN EQUIP _______________");
                    System.out.println("\nIntrodueix el nom de l'equip que vols modificar:");
                    String equip = LecturaConsola.llegirString();

                    trobat = false;
                    indTrobat = 0;
                    int i = 0;
                    
                    modificarEquip(trobat, indTrobat, i, equip, equips, punts);
                    break;
                case 7:
                    PersistenciaDades.escriureEquips(equips, punts);
                    System.out.println("ADEU....");
                    break;
                default:
                    System.out.println("Opció no correcta");
            }
        retornaMenu();
        
    }
}

