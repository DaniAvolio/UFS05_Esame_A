package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static org.example.App.*;


public class ClientHandler {

    private static BufferedReader in;
    private static PrintWriter out;

    public ClientHandler() {
    }

    public static void ManageClient() {
        //receive bufferedreader for input
        in = null;
        try {
            assert clientSocket != null;
            in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //inizializzo printwriter per l output, cioe per la risposta del server
        out = null;
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Processo : il server riceve la stringa nel client, fa i suoi calcoli e spedisce il risultato
    public static void processl(){
        try {
            out.println("BENVENUTO CLIENT");
            out.println("\nQuesta e' la lista di comandi che puoi digitare :");
            out.println("all -> per la lista di tutti i piatti presenti nel database");
            out.println("all_sorted -> per la lista di tutti i piatti presenti nel database in ordinamento AB");
            out.println("more_expensive -> per il piatto piu' costoso presente nel database");
            String s;
            while ((s = in.readLine()) != null)  {
                System.out.println("Ricevuto : "+s);
                switch (s){
                    case "more_expensive":
                        out.println(more_expensive());
                        out.flush();
                        break;

                    case "all":
                        out.println(all());
                        out.flush();
                        break;

                    case "all_sorted" :
                        out.println(allsorted());
                        out.flush();
                        break;
                    default:
                        out.println("Il comando inserito non esiste! Devi inserire uno dei comandi sopraelencati!");
                        out.flush();
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
