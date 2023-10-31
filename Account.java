public class Account {
    private String username; 
    private String password;
    private boolean isAdmin; 

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public boolean getIsAdmin(){
        return isAdmin; 
    }

    public Account(String username, String password, boolean isAdmin){
        this.username = username; 
        this.password = password; 
        this.isAdmin = isAdmin; 
    }

    @Override
    public String toString(){
        return "Username: " + username + ". Is admin: " + isAdmin; 
    }
}
