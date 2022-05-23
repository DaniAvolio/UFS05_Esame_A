package org.example;
import java.net.Socket;
import java.util.ArrayList;
import com.google.gson.Gson;

public class App 
{
    static ArrayList<Piatto> piatti = new ArrayList<>();
    static int portNumber=1234;
    static Socket clientSocket;

    public static void main( String[] args )
    {
        buildProductList();


    }
    static void buildProductList() {
        piatti.add(new Piatto(1, "Spaghetti con le vongole", 19.99, "piatto a base di vongole veraci"));
        piatti.add(new Piatto(2, "Pennette al pomodoro fresco", 9.99, "piatto a base di penne al pomodoro del Vesuvio"));
        piatti.add(new Piatto(3, "Scialatielli allo scoglio", 24.99, "piatto a base di vongole, gamberi, cozze e calamari"));
        piatti.add(new Piatto(4, "Cotoletta alla milanese", 14.99, "piatto a base di petto di pollo 100% italiano"));
        piatti.add(new Piatto(5, "Tagliatelle alla Bolognese", 14.99, "piatto a base di ragù di carne"));
    }






}
