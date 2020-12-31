package Classes;

public class Pakket {
    private int pakket_id, kinderen, volwassenen;
    private String grootte;

    public Pakket() {
    }

    public Pakket(int pakket_id, int kinderen, int volwassenen, String grootte) {
        this.pakket_id = pakket_id;
        this.kinderen = kinderen;
        this.volwassenen = volwassenen;
        this.grootte = grootte;
    }

    public int getPakket_id() {
        return pakket_id;
    }

    public void setPakket_id(int pakket_id) {
        this.pakket_id = pakket_id;
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

    public String getGrootte() {
        return grootte;
    }

    public void setGrootte(String grootte) {
        this.grootte = grootte;
    }

    @Override
    public String toString() {
        return "Pakket{" +
                "pakket_id=" + pakket_id +
                ", kind=" + kinderen +
                ", volwassen=" + volwassenen +
                ", grootte='" + grootte + '\'' +
                '}';
    }
}
