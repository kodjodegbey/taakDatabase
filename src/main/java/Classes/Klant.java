package Classes;

import java.util.ArrayList;

public class Klant {
    private String rijksregister,gsmNr,naam,voornaam,straat;
    private int postcode,nummer,week;
    private boolean pakket_afgehaal;
    private int contract_id ;
    private ArrayList<String> emails;

    public Klant() {
    }

    public Klant(String rijksregister, String gsmNr, String naam, String voornaam, String straat, int postcode, int nummer, int week, boolean pakket_afgehaal, int contract_id, ArrayList<String> emails) {
        this.rijksregister = rijksregister;
        this.gsmNr = gsmNr;
        this.naam = naam;
        this.voornaam = voornaam;
        this.straat = straat;
        this.postcode = postcode;
        this.nummer = nummer;
        this.week = week;
        this.pakket_afgehaal = pakket_afgehaal;
        this.contract_id = contract_id;
        this.emails = emails;
    }

    public String getRijksregister() {
        return rijksregister;
    }

    public void setRijksregister(String rijksregister) {
        this.rijksregister = rijksregister;
    }

    public String getGsmNr() {
        return gsmNr;
    }

    public void setGsmNr(String gsmNr) {
        this.gsmNr = gsmNr;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public ArrayList<String> getEmails() {
        return emails;
    }

    public void setEmails(ArrayList<String> emails) {
        this.emails = emails;
    }

    public boolean isPakket_afgehaal() {
        return pakket_afgehaal;
    }

    public void setPakket_afgehaal(boolean pakket_afgehaal) {
        this.pakket_afgehaal = pakket_afgehaal;
    }

    public int getContract_id() {
        return contract_id;
    }

    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    @Override
    public String toString() {
        return "Klant{" +
                "rijksregister='" + rijksregister + '\'' +
                ", gsmNr='" + gsmNr + '\'' +
                ", naam='" + naam + '\'' +
                ", voornaam='" + voornaam + '\'' +
                ", straat='" + straat + '\'' +
                ", postcode=" + postcode +
                ", nummer=" + nummer +
                ", week=" + week +
                ", pakket_afgehaal=" + pakket_afgehaal +
                ", contract_id=" + contract_id +
                '}';
    }
}
