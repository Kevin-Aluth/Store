public class Main{
    static boolean hasQuit = false; 

    //userò la convenzione delle parentesi graffe di java giusto perché mi sento buono
    public static void main(String[] args) {
        Utilities.accounts.add(new Account("kevinoh", "ciao123", true));
        while(Utilities.activeAccount == null && !hasQuit){
            mostraMenuAccesso();
        } 

        if(Utilities.activeAccount != null)
        {
            System.out.println("Benvenuto, " + Utilities.activeAccount.getUsername());
            while(!hasQuit){
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
                hasQuit = true; 
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