
package utils.consola;

import java.util.Scanner;

public class LecturaConsola {
    public static Scanner teclat = new Scanner(System.in);
    
    public static int llegirEnter(){
        boolean ok = false;
        int enter = 0;
        do{
            if (teclat.hasNextInt()){
                enter = teclat.nextInt();
                ok = true;
            } else{
                System.out.println("Intodueix, si us plau, un enter");
                teclat.nextLine();
            }
        }while (!ok);
        return enter;
    }

    public static double llegirDouble(){
        boolean ok = false;
        double real = 0;
        do{
            if (teclat.hasNextDouble()){
                real = teclat.nextDouble();
                ok = true;
            } else{
                System.out.println("Intodueix, si us plau, un real");
                teclat.nextLine();
            }
        }while (!ok);
        return real;
    }

    public static byte llegirByte(){
        boolean ok = false;
        byte bite = 0;
        do{
            if (teclat.hasNextByte()){
                bite = teclat.nextByte();
                ok = true;
            } else{
                System.out.println("Intodueix, si us plau, un byte");
                teclat.nextLine();
            }
        }while (!ok);
        return bite;
    }
    
    public static short llegirShort(){
        boolean ok = false;
        short curt = 0;
        do{
            if (teclat.hasNextShort()){
                curt = teclat.nextShort();
                ok = true;
            } else{
                System.out.println("Intodueix, si us plau, un short");
                teclat.nextLine();
            }
        }while (!ok);
        return curt;
    }
    
    public static long llegirLong(){
        boolean ok = false;
        long llarg = 0;
        do{
            if (teclat.hasNextLong()){
                llarg = teclat.nextLong();
                ok = true;
            } else{
                System.out.println("Intodueix, si us plau, un long");
                teclat.nextLine();
            }
        }while (!ok);
        return llarg;
    }
    
    public static float llegirFloat(){
        boolean ok = false;
        float flotant = 0;
        do{
            if (teclat.hasNextFloat()){
                flotant = teclat.nextFloat();
                ok = true;
            } else{
                System.out.println("Intodueix, si us plau, un float");
                teclat.nextLine();
            }
        }while (!ok);
        return flotant;
    }
    
    public static boolean llegirBoolean(){
        boolean ok = false;
        boolean bolea = false;
        do{
            if (teclat.hasNextBoolean()){
                bolea = teclat.nextBoolean();
                ok = true;
            } else{
                System.out.println("Intodueix, si us plau, un boolean");
                teclat.nextLine();
            }
        }while (!ok);
        return bolea;
    }
    
    public static String llegirString(){
        
        teclat.nextLine();
        
        return teclat.nextLine();
    }
    
    public static void buidaBuffer (){
        
        teclat.nextLine();
        teclat.nextLine();
        
    }
}
