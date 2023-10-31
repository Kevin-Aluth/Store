import java.util.ArrayList;
import java.util.List; 
import java.util.Scanner;

public class Utilities{
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
        Scanner myScanner = new Scanner(System.in);
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
}