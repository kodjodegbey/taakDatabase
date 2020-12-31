package Classes;

public class Product {
    private String naam;
    private boolean inbegrepen;

    public Product() {
    }

    public Product(String naam, boolean inbegrepen) {
        this.naam = naam;
        this.inbegrepen = inbegrepen;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public boolean isInbegrepen() {
        return inbegrepen;
    }

    public void setInbegrepen(boolean inbegrepen) {
        this.inbegrepen = inbegrepen;
    }

    @Override
    public String toString() {
        return "Prouct{" +
                "naam='" + naam + '\'' +
                ", inbegrepen=" + inbegrepen +
                '}';
    }
}
