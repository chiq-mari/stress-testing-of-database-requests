package project1;

public class hiloConexion extends Thread{
    conexion simulacion;

    @Override
    public void run() {
        System.out.println("Iniciando conexion de hilo " + this.getName());
        simulacion.createConnection();
        simulacion.exeQuery("select * from tabla");
        simulacion.closeConnection();
        System.out.println("Finaliza conexion de hilo "+this.getName());
    }

}
