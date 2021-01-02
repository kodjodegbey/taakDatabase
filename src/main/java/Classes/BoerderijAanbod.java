package Classes;

public class BoerderijAanbod {
    private  String grootte,naam;
    private int volwassenen,kinderen,prijs,pakket_id;
    private int boerderij_id;

    public BoerderijAanbod() {
    }

    public BoerderijAanbod(String grootte, String naam, int volwassenen, int kinderen, int prijs,int pakket_id,int boerderij_id) {
        this.grootte = grootte;
        this.naam = naam;
        this.volwassenen = volwassenen;
        this.kinderen = kinderen;
        this.prijs = prijs;
        this.pakket_id = pakket_id;
        this.boerderij_id = boerderij_id;
    }

    public int getBoerderij_id() {
        return boerderij_id;
    }

    public void setBoerderij_id(int boerderij_id) {
        this.boerderij_id = boerderij_id;
    }

    public int getPakket_id() {
        return pakket_id;
    }

    public void setPakket_id(int pakket_id) {
        this.pakket_id = pakket_id;
    }

    public String getGrootte() {
        return grootte;
    }

    public void setGrootte(String grootte) {
        this.grootte = grootte;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getVolwassenen() {
        return volwassenen;
    }

    public void setVolwassenen(int volwassenen) {
        this.volwassenen = volwassenen;
    }

    public int getKinderen() {
        return kinderen;
    }

    public void setKinderen(int kinderen) {
        this.kinderen = kinderen;
    }

    public int getPrijs() {
        return prijs;
    }

    public void setPrijs(int prijs) {
        this.prijs = prijs;
    }

    @Override
    public String toString() {
        return "BoerderijAanbod{" +
                "grootte='" + grootte + '\'' +
                ", naam='" + naam + '\'' +
                ", volwassenen=" + volwassenen +
                ", kinderen=" + kinderen +
                ", prijs=" + prijs +
                ", pakket_id=" + pakket_id +
                '}';
    }
}
