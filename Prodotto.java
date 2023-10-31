public class Prodotto implements Comparable<Prodotto> {
    private String nome; 
    private int prezzo; 
    private int quantita;
    
    public String getNome() {
        return nome;
    }
    public int getPrezzo() {
        return prezzo;
    }
    public int getQuantita() {
        return quantita;
    }

    public Prodotto(String nome, int prezzo, int quantita) 
    {
        this.nome = nome; 
        this.prezzo = prezzo; 
        this.quantita = quantita; 
    }

    @Override
    public String toString(){
        return "Nome: " + nome + ". Prezzo: " + prezzo + "$. Quantita': " + quantita; 
    }

    @Override 
    public int compareTo(Prodotto o){
        return nome.compareTo(o.getNome()); 
    }
}
