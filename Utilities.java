import java.util.ArrayList;
import java.util.Collections;
import java.util.List; 
import java.util.Scanner;

public class Utilities{
    //NOTA: E' capitato che a volte veniva stampato il menu del Main due volte.
    //per risolvere questa cosa ho aggiunto un nextLine() vuoto dove era necessario.
    public static List<Account> accounts = new ArrayList<>(); 
    public static List<Prodotto> prodotti = new ArrayList<>(); 
    public static Account activeAccount = null; 
    public static Scanner myScanner = new Scanner(System.in); 

    public static void Registrati(){
        //getting username input and checking if username exists
        boolean exists = false; 
        String usernameInput; 
        do{
            System.out.println("Inserisci unsername: ");
            usernameInput = myScanner.nextLine(); 
            usernameInput = usernameInput.toLowerCase(); 
            for(int i = 0; i < accounts.size(); i++)
            {
                if(accounts.get(i).getUsername().equals(usernameInput)){
                    exists = true;
                    System.out.println("Username esiste gia'. "); 
                    break;  
                }
                else exists = false; 
            }
        }while(exists); 
        //adding password
        System.out.println("Inserisci password: ");
        String passwordInput = myScanner.nextLine(); 
        //adding user to list
        accounts.add(new Account(usernameInput, passwordInput, false)); 
    }

    public static void Accedi(){
        String usernameInput = myScanner.nextLine(); 
        usernameInput = usernameInput.toLowerCase(); 
        
        //checking if username exists
        for(int i = 0; i < accounts.size(); i++)
        {
            if(usernameInput.equals(accounts.get(i).getUsername())){
                activeAccount = accounts.get(i); 
                break; 
            } 
        }
        //checking if account and passwords match
        if(activeAccount != null)
        {
            String usernamePassword = myScanner.nextLine(); 
            if(!usernamePassword.equals(activeAccount.getPassword())){
                System.out.println("Accesso negato");
                activeAccount = null; 
            }
            else{
                System.out.println("Accesso eseguito");
            }
        }
        else{
            System.out.println("Username inesistente");
        }
    }

    public static void aggiungiProdotto(){
        //getting name and checking if it already exists
        boolean isNameCorrect = true; 
        System.out.println("Inserisci nome prodotto: ");
        String nome = myScanner.nextLine(); 
        nome = nome.toLowerCase(); 
        for(int i = 0; i < prodotti.size(); i++){
            if(prodotti.get(i).getNome().equals(nome)) {
                isNameCorrect = false; 
            } 
        }
        //getting price and amt
        System.out.println("Inserisci prezzo: "); 
        int prezzo = myScanner.nextInt(); 
        System.out.println("Inserisci quantita' disponibile del prodotto: "); 
        int quantita = myScanner.nextInt(); 

        //adding product
        if(isNameCorrect){
            System.out.println("Prodotto aggiunto. ");
            myScanner.nextLine(); 
            prodotti.add(new Prodotto(nome, prezzo, quantita)); 
        }
        else{
            System.out.println("Impossibile aggiungere, prodotto con lo stesso nome gia' esistente. "); 
            myScanner.nextLine(); 
        }
    }

    public static void rimuoviProdotto(){
        //getting name
        System.out.println("Seleziona nome del prodotto da eliminare: "); 
        String nome = myScanner.nextLine(); 
        nome = nome.toLowerCase(); 
        boolean hasDeleted = false; 
        //removing product if it exists
        for(int i = 0; i < prodotti.size(); i++){
            if(prodotti.get(i).getNome().equals(nome)) {
                prodotti.remove(i);
                hasDeleted = true; 
                System.out.println("Prodotto rimosso. ");
                break; 
            } 
        }
        if(!hasDeleted) System.out.println("Prodotto inesistente. ");
    }

    public static void mostraProdotti()
    {
        //printing products with a for
        System.out.println("Prodotti disopnibili"); 
        for(Prodotto j : prodotti){
            System.out.println(j);
        }
    }

    public static void modificaProdotto(){
        System.out.println("Seleziona nome del prodotto da modificare: "); 
        String nome = myScanner.nextLine(); 
        nome = nome.toLowerCase(); 
        int numToChange = -1; 
        //setting numToChange to right product
        for(int i = 0; i < prodotti.size(); i++){
            if(prodotti.get(i).getNome().equals(nome)){
                numToChange = i; 
                break; 
            } 
        }
        //modifying product if name is unique or equal to the old one
        if(numToChange == -1){
            System.out.println("Prodotto inesistente. ");
        }
        else{
            System.out.println("Inserisci nome: ");
            nome = myScanner.nextLine(); 
            nome = nome.toLowerCase(); 
            System.out.println("Inserisci prezzo: ");
            int prezzo = myScanner.nextInt(); 
            System.out.println("Inserisci quantita': ");
            int quantita = myScanner.nextInt(); 
            
            boolean haModificato = true; 
            for(int i = 0; i < prodotti.size(); i++){
                if(nome.equals(prodotti.get(i).getNome()) && i != numToChange){
                    haModificato = false; 
                    System.out.println("Impossibile modificare: nome prodotto gia' esistente");
                    myScanner.nextLine(); 
                    break; 
                }
            }
            if(haModificato){
                prodotti.remove(numToChange); 
                prodotti.add(numToChange, new Prodotto(nome, prezzo, quantita)); 
                System.out.println("Prodotto modificato"); 
                myScanner.nextLine(); 
            }
        }
    }

    public static void cercaProdotto(){
        System.out.print("Cerca...");
        String nome = myScanner.nextLine(); 
        nome = nome.toLowerCase(); 
        System.out.println("Risultati ricerca: ");
        List<Prodotto> newProdotti = new ArrayList<>(); 
        //ricerca attraverso la funzione contains
        for(int i = 0; i < prodotti.size(); i++){
            if(prodotti.get(i).getNome().contains(nome)){
                newProdotti.add(prodotti.get(i)); 
            }
        }
        //stampa della nuova lista coi nomi che contengono la stringa cercata
        //il sort avviene correttamente grazie all'override di "compareTo"
        Collections.sort(newProdotti); 
        for(Prodotto j : newProdotti){
            System.out.println(j);
        }
    }
}