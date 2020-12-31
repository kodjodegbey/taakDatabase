package Classes;

public class Prouct {
    private String naam;
    private boolean inbegrepen;

    public Prouct() {
    }

    public Prouct(String naam, boolean inbegrepen) {
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
