package uf3.practica.futbol.segonNivellDescomposicio;


import static uf3.practica.futbol.primerNivellDescomposicio.PrimerNivellDescomposicio.numEquips;
import static uf3.practica.futbol.segonNivellDescomposicio.VisualitzacioDades.visualitzarArray;
import utils.arrays.ArrayString;
import utils.consola.LecturaConsola;

/**
 * En aquesta classe veurem la segona fase de descomposicio del codi.
 * Aqui trobarem tots els metodes que creen, actualitzen o modifiquen dades.
 * @author andreu
 */
public class ActualitzacioDades {
    
    /**
     * Amb aquest metode ordenarem alfabeticament tots els equips que juguen a la lliga.
     * @param equipsOrd Agafara l'array que ordenara alfabeticament
     */
    public static void ordenarEquips(String[] equipsOrd, String[] equips, int[][] punts){
        
        int izq = 0;
                    
        ArrayString.copiaDeUnArray(equips, equipsOrd, numEquips);
        ArrayString.quicksort(equipsOrd, izq, numEquips);
        visualitzarArray(equipsOrd, equips);
        
    }
    
    /**
     * Aqui podrem cercar qualsevol equip de la lliga que el usuari vulgui. 
     */
    public static void buscarUnEquip(String[] equips, int[][] punts){
        System.out.println("Introdueix el nom d'equip del que vols visualitzar les puntuacions: ");
        String equip = LecturaConsola.llegirString();
        ArrayString.trobarEquip(equips, equip, punts);
    }
    
    /**
     * Aqui afegirem nous equips a la lliga.
     * Si el equip ja existeix no el deixara crear.
     * @param indTrobat en cas de que el trobi guardara la posicio del index on es troba el equip
     */
    public static void introduirNouEquip(int indTrobat, boolean trobat, String[] equips, int[][] punts) {
        int i = 0;
        String equipNou = " ";
        if (numEquips == equips.length) {
            // Comprova si ha arribat al final de l'array, no hi ha més espai
            System.out.println("\nNO es poden donar d'alta més equips, no hi ha més espai...");
        } else {

            System.out.print("\nIntrodueix el nom del nou equip: ");
            equipNou = LecturaConsola.llegirString();

            trobat = false;

            //cerca el nom d'equip a l'array de noms
            i = 0;
            for (i = 0; i < equips.length && !trobat; i++) {
                if (equipNou.equalsIgnoreCase(equips[i])) {
                    trobat = true;
                    indTrobat = i;
                }
            }
        }
        
        introduirDades(i ,trobat, equipNou, equips, punts);
    }
    
    /**
     * Aqui afegirem les dades dels nous equips afegits.
     * @param i guardara el valor de la posicio de l'equip existent
     * @param trobat guardara si el equip ja existeix
     * @param equipNou emmagatzema el nom del nou equip
     */
    public static void introduirDades(int i, boolean trobat, String equipNou, String[] equips, int[][] punts) {

        if (trobat) {

            System.out.println("HO SENTIM, aquest equip ja existeix!!!, no el pots donar d'alta");
            System.out.printf("\n\033[31m%15s %10s %10s %10s %10s %10s %-8s %-8s %10s", "Equip", "Jugats", "Guanyats", "Empatats", "Perduts", "PUNTS   ", "G.Favor", "G.Contra  ", "Diferencia");
            System.out.printf("\n%15s", equips[i]);

            for (int j = 0; j < punts[i].length; j++) {
                System.out.printf("%10d", punts[i][j]);
            }

        } else { //donem d'alta el nou equip, doncs no existeix i hi ha espai

            // si no troba el nom de l'equip vol dir que no existeix en l'array i el podem donar d'alta
            // assigna a l'array de noms d'equip el nom d'equip introduït per l'usuari
            equips[numEquips] = equipNou;

            System.out.print("\nPartits GUANYATS: ");
            punts[numEquips][1] = LecturaConsola.llegirEnter();
            System.out.print("\nPartits EMPATATS: ");
            punts[numEquips][2] = LecturaConsola.llegirEnter();
            System.out.print("\nPartits PERDUTS: ");
            punts[numEquips][3] = LecturaConsola.llegirEnter();
            System.out.print("\nGols A FAVOR: ");
            punts[numEquips][5] = LecturaConsola.llegirEnter();
            System.out.print("\nGols EN CONTRA: ");
            punts[numEquips][6] = LecturaConsola.llegirEnter();

            // Calcula el numero de partits jugats a partir dels partits guanyats, empatats i perduts
            punts[numEquips][0] = punts[numEquips][1] + punts[numEquips][2] + punts[numEquips][3];

            // Calcula el numero de punts totals de l'equip a partir dels partits guanyats, empatats i perduts
            punts[numEquips][4] = (punts[numEquips][1] * 3) + punts[numEquips][2];

            // Calcula la diferència de gols
            punts[numEquips][7] = punts[numEquips][5] - punts[numEquips][6];

            System.out.println("\n Equip donat d'ALTA correctament!!");

            System.out.printf("\n\033[31m%15s %10s %10s %10s %10s %10s %-8s %-8s %10s", "Equip", "Jugats", "Guanyats", "Empatats", "Perduts", "PUNTS   ", "G.Favor", "G.Contra  ", "Diferencia");
            System.out.printf("\n%15s", equips[numEquips]);
            for (int j = 0; j < punts[numEquips].length; j++) {
                System.out.printf("%10d", punts[numEquips][j]);
            }

            // incrementa la variable que porta compter del numero d'equips introduïts
            numEquips++;
            

        }
    }
    
    /**
     * Comparara si el equip que l'usuari li a introduit es troba a la lliga entrara a modificar-lo.
     * @param trobat indicara si l'equip existeix o no
     * @param indTrobat emmagatzema la posicio de on es troba l'equip
     * @param equip aqui s'emagatzemara el nom de l'quip introduit per l'usuari
     */
    public static void modificarEquip (boolean trobat,int indTrobat, int i, String equip, String[] equips, int[][] punts){

        for (i = 0; i < equips.length && (!trobat); i++) {
            if (equip.equalsIgnoreCase(equips[i])) {
                trobat = true;
                indTrobat = i;
                System.out.printf("\n\033[31m%15s %10s %10s %10s %10s %10s %-8s %-8s %10s", "Equip", "Jugats", "Guanyats", "Empatats", "Perduts", "PUNTS   ", "G.Favor", "G.Contra  ", "Diferencia");
                System.out.printf("\n%15s", equips[i]);

                for (int j = 0; j < punts[i].length; j++) {
                    System.out.printf("%10d", punts[i][j]);
                }
            }

        }
        modificarDades(trobat, indTrobat, equips, punts);
    }
    
    /**
     * Aqui si l'equip es que existeix preguntara quines dades vol que es conservin i quines vol cambiar.
     * @param trobat indicacio si el equip s'ha trobat
     * @param punts array on es modificaran les noves puntuacions
     */
    public static void modificarDades (boolean trobat,int indTrobat, String[] equips, int[][] punts){
        
        if (!trobat) {
            // No troba l'equip, per tant, no es pot modificar
            System.out.println("No s'ha trobat aquest equip");
        } else {
            // S'ha trobat l'equip, es demana a l'usuari quina informació vol modificar.
            System.out.println("\nVols modificar el NOM equip? " + equips[indTrobat] + " (s/n)");
            char mod = LecturaConsola.teclat.nextLine().charAt(0);
            if (mod == 's' || mod == 'S') {
                System.out.print("Nom d'equip: ");
                equips[indTrobat] = LecturaConsola.teclat.nextLine();
            }

            System.out.println("Vols modificar partits GUANYATs? " + punts[indTrobat][1] + " (s/n)");
            mod = LecturaConsola.teclat.nextLine().charAt(0);
            if (mod == 's' || mod == 'S') {
                System.out.print("Partits guanyats:  ");
                punts[indTrobat][1] = LecturaConsola.llegirEnter();
                LecturaConsola.teclat.nextLine();
            }

            System.out.println("Vols modificar partits EMPATATS? " + punts[indTrobat][2] + " (s/n)");
            mod = LecturaConsola.teclat.nextLine().charAt(0);
            if (mod == 's' || mod == 'S') {
                System.out.print("Partits empatats:  ");
                punts[indTrobat][2] = LecturaConsola.llegirEnter();
                LecturaConsola.teclat.nextLine();
            }

            System.out.println("Vols modificar partits PERDUTS? " + punts[indTrobat][3] + " (s/n)");
            mod = LecturaConsola.teclat.nextLine().charAt(0);
            if (mod == 's' || mod == 'S') {
                System.out.print("Partits perduts:  ");
                punts[indTrobat][3] = LecturaConsola.llegirEnter();
                LecturaConsola.teclat.nextLine();
            }

            System.out.println("Vols modificar gols A FAVOR? " + punts[indTrobat][5] + "  (s/n)");
            mod = LecturaConsola.teclat.nextLine().charAt(0);
            if (mod == 's' || mod == 'S') {
                System.out.print("Gols a favor:  ");
                punts[indTrobat][5] = LecturaConsola.llegirEnter();
                LecturaConsola.teclat.nextLine();
            }

            System.out.println("Vols modificar gols EN CONTRA? " + punts[indTrobat][6] + "  (s/n)");
            mod = LecturaConsola.teclat.nextLine().charAt(0);
            if (mod == 's' || mod == 'S') {
                System.out.print("Gols en contra:  ");
                punts[indTrobat][6] = LecturaConsola.llegirEnter();
                LecturaConsola.teclat.nextLine();
            }

            // Calcula el numero de partits jugats a partir dels partits guanyats, empatats i perduts
            punts[indTrobat][0] = punts[indTrobat][1] + punts[indTrobat][2] + punts[indTrobat][3];

            // Calcula el numero de punts totals de l'equip a partir dels partits guanyats, empatats i perduts
            punts[indTrobat][4] = (punts[indTrobat][1] * 3) + punts[indTrobat][2];

            // Calcula la diferència de gols
            punts[indTrobat][7] = punts[indTrobat][5] - punts[indTrobat][6];

            System.out.println("\n Equip MODIFICAT correctament!!");

            // tornem a visualitzar les dades actualitzades 
            System.out.printf("\n\033[31m%15s %10s %10s %10s %10s %10s %-8s %-8s %10s", "Equip", "Jugats", "Guanyats", "Empatats", "Perduts", "PUNTS   ", "G.Favor", "G.Contra  ", "Diferencia");
            System.out.printf("\n%15s", equips[indTrobat]);
            for (int j = 0; j < punts[indTrobat].length; j++) {
                System.out.printf("%10d", punts[indTrobat][j]);
            }

        }
        
    }

    
}
