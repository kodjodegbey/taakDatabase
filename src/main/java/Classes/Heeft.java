package Classes;

public class Heeft {

    private int tip_id;
    private String naam;

    public Heeft() {
    }

    public Heeft(int tip_id, String naam) {
        this.tip_id = tip_id;
        this.naam = naam;
    }

    public int getTip_id() {
        return tip_id;
    }

    public void setTip_id(int tip_id) {
        this.tip_id = tip_id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    @Override
    public String toString() {
        return "Heeft{" +
                "tip_id=" + tip_id +
                ", naam='" + naam + '\'' +
                '}';
    }
}
