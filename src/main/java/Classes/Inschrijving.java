package Classes;

public class Inschrijving {
    private  String grootte,rijksregister,naam;
    private int kinderen, volwassenen,prijs;

    public Inschrijving() {
    }

    public Inschrijving(String grootte, String rijksregister, String naam, int kinderen, int volwassenen, int prijs) {
        this.grootte = grootte;
        this.rijksregister = rijksregister;
        this.naam = naam;
        this.kinderen = kinderen;
        this.volwassenen = volwassenen;
        this.prijs = prijs;
    }

    public String getGrootte() {
        return grootte;
    }

    public void setGrootte(String grootte) {
        this.grootte = grootte;
    }

    public String getRijksregister() {
        return rijksregister;
    }

    public void setRijksregister(String rijksregister) {
        this.rijksregister = rijksregister;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getKinderen() {
        return kinderen;
    }

    public void setKinderen(int kinderen) {
        this.kinderen = kinderen;
    }

    public int getVolwassenen() {
        return volwassenen;
    }

    public void setVolwassenen(int volwassenen) {
        this.volwassenen = volwassenen;
    }

    public int getPrijs() {
        return prijs;
    }

    public void setPrijs(int prijs) {
        this.prijs = prijs;
    }

    @Override
    public String toString() {
        return "Inschrijving{" +
                "grootte='" + grootte + '\'' +
                ", rijksregister='" + rijksregister + '\'' +
                ", naam='" + naam + '\'' +
                ", kinderen=" + kinderen +
                ", volwassenen=" + volwassenen +
                ", prijs=" + prijs +
                '}';
    }
}
