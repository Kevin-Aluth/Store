public class Main{
    static boolean hasQuit = false; 

    //userò la convenzione delle parentesi graffe di java giusto perché mi sento buono
    public static void main(String[] args) {
        Utilities.accounts.add(new Account("kevinoh", "ciao123", true));
        Utilities.prodotti.add(new Prodotto("sapone", 7, 100)); 
        Utilities.prodotti.add(new Prodotto("shampoo", 12, 70)); 
        Utilities.prodotti.add(new Prodotto("schiuma da barba", 15, 40)); 
        Utilities.prodotti.add(new Prodotto("rasoio", 19, 60)); 
        while(!hasQuit){
            mostraMenuAccesso();

            if(Utilities.activeAccount != null)System.out.println("Benvenuto, " + Utilities.activeAccount.getUsername());
            while(Utilities.activeAccount != null){
                mostraMenu(Utilities.activeAccount.getIsAdmin());
            }
        } 
    }

    static void mostraMenu(boolean isAdmin)
    {
        System.out.println("Seleziona un'opzione: "); 
        if(isAdmin){
            System.out.println("0) Quitta\n1) Visualizza prodotti\n2) Cerca prodotto\n3) Aggiungi prodotto" +
            "\n4) Modifica prodotto\n5) Rimuovi prodotto"); 
        }
        else{
            System.out.println("0) Quitta\n1) Visualizza prodotti" +
            "\n2) Cerca prodotto"); 
        }
        //switch case for input and preventing adming privileges for non admin accounts
        String input = Utilities.myScanner.nextLine(); 
        switch (input) {
            case "1":
                Utilities.mostraProdotti(); 
                break;
            case "2": 
                Utilities.cercaProdotto(); 
                break; 
            case "3":
                if(isAdmin) Utilities.aggiungiProdotto();
                else System.out.println("Seleziona opzione valida");  
                break; 
            case "4":
                if(isAdmin) Utilities.modificaProdotto();
                else System.out.println("Seleziona opzione valida"); 
                break; 
            case "5":
                if(isAdmin) Utilities.rimuoviProdotto();
                else System.out.println("Seleziona opzione valida"); 
                break; 
            case "0": 
                Utilities.activeAccount = null; 
                break; 
            default:
                break;
        }
    }

    static void mostraMenuAccesso()
    {
        System.out.println("Seleziona un'opzione: ");
        System.out.println("0) Quitta\n1) Accedi\n2) Registrati");
        String input = ""; 
        input = Utilities.myScanner.nextLine(); 
        //switch case for inputs
        switch (input) {
            case "1":
                Utilities.Accedi();
                break;
            case "2": 
                Utilities.Registrati();
                break; 
            case "0": 
                hasQuit = true; 
                break; 
            default:
                break;
        }
    }
}