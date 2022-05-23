package org.example;
import java.io.IOException;
import java.net.ServerSocket;
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
        ClientHandler ch = new ClientHandler();
        //inizializzazione
        System.out.println("Server Started...");
        ServerSocket serverSocket = null;
        //inizializzo serversocket
        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            //inizializzo clientsocket e la connessione

            System.out.println("Accepting client...");
            try {
                assert serverSocket != null;
                clientSocket = serverSocket.accept();
                System.out.println("Client Accepted");
            } catch (IOException e) {
                e.printStackTrace();
            }
            //chiamo la funzione per gestire il client
            ch.ManageClient();
            //chiamo la funzione per il processing
            ch.processl();
            try {
                clientSocket.close();
                System.out.println("...Client quit...");
                System.out.println("Server restarting...");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static void buildProductList() {
        piatti.add(new Piatto(1, "Spaghetti con le vongole", 19.99, "piatto a base di vongole veraci"));
        piatti.add(new Piatto(2, "Pennette al pomodoro fresco", 9.99, "piatto a base di penne al pomodoro del Vesuvio"));
        piatti.add(new Piatto(3, "Scialatielli allo scoglio", 24.99, "piatto a base di vongole, gamberi, cozze e calamari"));
        piatti.add(new Piatto(4, "Cotoletta alla milanese", 14.99, "piatto a base di petto di pollo 100% italiano"));
        piatti.add(new Piatto(5, "Tagliatelle alla Bolognese", 14.99, "piatto a base di ragù di carne"));
    }

    //SEZIONE FUNZIONI

    static String all(){
        Gson gson = new Gson();
        String result = "";
        result=gson.toJson(piatti);
        return result;
    }
    static String allsorted(){
        Gson gson = new Gson();
        String result = "";
        piatti.sort((Piatto p1, Piatto p2)-> {
            return p1.getNome().compareTo(p2.getNome());
        });
        result=gson.toJson(piatti);
        return result;
    }
    static String more_expensive(){
        Gson gson = new Gson();
        String result = "";
        int select=0;
        double max=0;

        for(int i=0;i<piatti.size();i++)
        {
            double elemento=piatti.get(i).getPrezzo();
            if(elemento > max){
                max = elemento;
                select=i;
            }
        }
        result= gson.toJson(piatti.get(select));
        return result;
}

    //FINE SEZIONE FUNZIONI

}
