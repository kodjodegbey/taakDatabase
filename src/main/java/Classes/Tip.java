package Classes;

import java.sql.Blob;

public class Tip {

    private String naam, tekst;
    private int tip_id;
    private Blob bijlage;

    public Tip() {
    }

    public Tip(String naam, String tekst, int tip_id, Blob bijlage) {
        this.naam = naam;
        this.tekst = tekst;
        this.tip_id = tip_id;
        this.bijlage = bijlage;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public int getTip_id() {
        return tip_id;
    }

    public void setTip_id(int tip_id) {
        this.tip_id = tip_id;
    }

    public Blob getBijlage() {
        return bijlage;
    }

    public void setBijlage(Blob bijlage) {
        this.bijlage = bijlage;
    }

    @Override
    public String toString() {
        return "Tip{" +
                "naam='" + naam + '\'' +
                ", text='" + tekst + '\'' +
                ", bijlage=" + bijlage +
                '}';
    }
}
