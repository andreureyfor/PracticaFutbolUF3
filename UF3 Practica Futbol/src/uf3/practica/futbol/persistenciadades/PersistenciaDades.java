
package uf3.practica.futbol.persistenciadades;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PersistenciaDades {
    
    // Ruta dels fitxers
    static final String FITXER_EQUIPS = "fitxers/dades/fitxerEquips.dat";
    
    public static void llegirEquips(String[] equips, int[][] punts){
            
        try (FileInputStream fis = new FileInputStream(FITXER_EQUIPS);
                DataInputStream dis = new DataInputStream(fis)){
            
            for (int i = 0; i < equips.length; i++) {
                
                equips[i] = dis.readUTF();
                punts[i][0] = dis.readInt();
                punts[i][1] = dis.readInt();
                punts[i][2] = dis.readInt();
                punts[i][3] = dis.readInt();
                punts[i][4] = dis.readInt();
                punts[i][5] = dis.readInt();
                punts[i][6] = dis.readInt();
                punts[i][7] = dis.readInt();
                
            }
            
        } catch (FileNotFoundException ex){
            
        } catch (EOFException ex) {
            System.out.println("Fitxer " + FITXER_EQUIPS + "llegit correctament.");
        } catch (IOException ex) {
            System.out.println("Error en el fitxer: " + FITXER_EQUIPS);
        }
    
    }
    
    
    public static void escriureEquips(String[] equips, int[][] punts){
            
        try (FileOutputStream fos = new FileOutputStream(FITXER_EQUIPS,false); 
               DataOutputStream dos = new DataOutputStream(fos)){
            
            for (int i = 0; i < equips.length && equips[i] != null; i++) {
                if (equips[i] != null) {
                dos.writeUTF(equips[i]);
                dos.writeInt(punts[i][0]);
                dos.writeInt(punts[i][1]);
                dos.writeInt(punts[i][2]);
                dos.writeInt(punts[i][3]);
                dos.writeInt(punts[i][4]);
                dos.writeInt(punts[i][5]);
                dos.writeInt(punts[i][6]);
                dos.writeInt(punts[i][7]);
                }
            }
            
        } catch (FileNotFoundException ex){
            System.out.println("Fitxer no trobat: " + FITXER_EQUIPS);
        } catch (IOException ex) {
            System.out.println("Error en el fitxer: " + FITXER_EQUIPS);
        }
    
    }
    
    
    
    
}
