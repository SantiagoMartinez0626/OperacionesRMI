import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String [] args ) {
        try{

            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            System.out.println("El servidor ha sido iniciado...");

            ProductImpl p1 = new ProductImpl("Laptop", "lenovo laptop", 1240.5);
            ProductImpl p2 = new ProductImpl("Mobile", "Mi mobile", 240.1);
            ProductImpl p3 = new ProductImpl("Power Charger", "Lenovo charger", 240.1);
            ProductImpl p4 = new ProductImpl("MoterBike", "Yamaha Biker", 38000.24);

            Product stub1 = (Product) UnicastRemoteObject.exportObject(p1,0);
            Product stub2 = (Product) UnicastRemoteObject.exportObject(p2,0);
            Product stub3 = (Product) UnicastRemoteObject.exportObject(p3,0);
            Product stub4 = (Product) UnicastRemoteObject.exportObject(p4,0);


            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

            registry.rebind("l", stub1);
            registry.rebind("m", stub2);
            registry.rebind("c", stub3);
            registry.rebind("b", stub4);

            System.out.println("Se ha completado la exportación y vinculación de objetos..");

        } catch(Exception e) {
            System.out.println("Algún error del servidor..." + e);
        }
    }
}