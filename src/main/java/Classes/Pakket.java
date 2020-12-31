package Classes;

public class Pakket {
    private int pakket_id,kind,volwassen;
    private String grootte;

    public Pakket() {
    }

    public Pakket(int pakket_id, int kind, int volwassen, String grootte) {
        this.pakket_id = pakket_id;
        this.kind = kind;
        this.volwassen = volwassen;
        this.grootte = grootte;
    }

    public int getPakket_id() {
        return pakket_id;
    }

    public void setPakket_id(int pakket_id) {
        this.pakket_id = pakket_id;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public int getVolwassen() {
        return volwassen;
    }

    public void setVolwassen(int volwassen) {
        this.volwassen = volwassen;
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
                ", kind=" + kind +
                ", volwassen=" + volwassen +
                ", grootte='" + grootte + '\'' +
                '}';
    }
}
