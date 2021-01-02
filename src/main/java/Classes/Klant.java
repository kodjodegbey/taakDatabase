package Classes;

public class Klant {
    private String rijksregister, gsm_nummer,naam,voornaam,straat;
    private int postcode,nummer,week;
    private boolean afgehaal;
    private int contract_id ;
    private String email;

    public Klant() {
    }

    public Klant(String rijksregister, String gsm_nummer, String naam, String voornaam, String straat,
                 int postcode, int nummer, int week, boolean afgehaal, int contract_id, String email) {
        this.rijksregister = rijksregister;
        this.gsm_nummer = gsm_nummer;
        this.naam = naam;
        this.voornaam = voornaam;
        this.straat = straat;
        this.postcode = postcode;
        this.nummer = nummer;
        this.week = week;
        this.afgehaal = afgehaal;
        this.contract_id = contract_id;
        this.email = email;
    }

    public String getRijksregister() {
        return rijksregister;
    }

    public void setRijksregister(String rijksregister) {
        this.rijksregister = rijksregister;
    }

    public String getGsm_nummer() {
        return gsm_nummer;
    }

    public void setGsm_nummer(String gsm_nummer) {
        this.gsm_nummer = gsm_nummer;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAfgehaal() {
        return afgehaal;
    }

    public void setAfgehaal(boolean afgehaal) {
        this.afgehaal = afgehaal;
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
                ", gsm_nummer='" + gsm_nummer + '\'' +
                ", naam='" + naam + '\'' +
                ", voornaam='" + voornaam + '\'' +
                ", straat='" + straat + '\'' +
                ", postcode=" + postcode +
                ", nummer=" + nummer +
                ", week=" + week +
                ", afgehaal=" + afgehaal +
                ", contract_id=" + contract_id +
                ", email='" + email + '\'' +
                '}';
    }
}
