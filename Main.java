public class Main{
    //userò la convenzione delle parentesi graffe di java giusto perché mi sento buono
    public static void main(String[] args) {
        Utilities.accounts.add(new Account("kevinoh", "ciao123", true));
        while(Utilities.activeAccount == null)
        {
            mostraMenuAccesso();
            //this is a comment
        } 
    }

    static void mostraMenuAccesso()
    {
        System.out.println("Seleziona un'opzione: ");
        System.out.println("1) Accedi\n2) Registrati");
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
            default:
                break;
        }
    }
}