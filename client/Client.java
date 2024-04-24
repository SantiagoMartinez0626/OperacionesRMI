import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String [] args) {
        try {

            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

            Product laptop = (Product) registry.lookup("l");
            Product mobile = (Product) registry.lookup("m");
            Product charger = (Product) registry.lookup("c");
            Product bike = (Product) registry.lookup("b");

            System.out.println("El nombre del portátil es " + laptop.getName());
            System.out.println("La descripción es " + laptop.getDescription());
            System.out.println("El precio es " + laptop.getPrice());

            System.out.println(mobile.getName());
            System.out.println(charger.getName());
            System.out.println(bike.getName());

        } catch(Exception e) {
            System.out.println("Error del lado del cliente..." + e);
        }
    }
}