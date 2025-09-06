package project1;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static long timeAtStart= System.nanoTime();

    public static void main(String[] args) {
        //Scanner sc= new Scanner(System.in);

        //conexion llenado= new conexion();
        //llenado.filldb();
        int n=1000;

        ArrayList<hiloConexion> listaConexiones= new ArrayList<hiloConexion>();

        for( int i = 0; i <n; i++ ){
            listaConexiones.add(new hiloConexion());
            listaConexiones.get(i).simulacion= new conexion();
        }

        double startTime= currentTime();

        for( int i = 0; i <n; i++ ){
            listaConexiones.get(i).start();
        }
        for (int j=0; j<n; j++){
            try{
            listaConexiones.get(j).join();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        double endTime= currentTime();

        System.out.println("-------------------------------------------------");
        System.out.println("Nro de conexiones: "+n);
        System.out.println("Start of connection "+": "+startTime);
        System.out.println("End of connection "+": "+endTime);
    }

    public static double currentTime(){
        long timeAtEnd= System.nanoTime();
        return (timeAtEnd-timeAtStart)/1000000000.0;
    }
}