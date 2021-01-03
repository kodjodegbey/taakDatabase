package Classes;

public class Boerderij {

    private String naam,straat;
    private  int nummer,postcode,boerderij_id;
    private String email;


    public Boerderij(){

    }

    public Boerderij(int boerderij_id,String naam, String straat, int nummer, int postcode,String email) {
        this.naam = naam;
        this.straat = straat;
        this.nummer = nummer;
        this.postcode = postcode;
        this.email = email;
        this.boerderij_id=boerderij_id;
    }


    public String getEmails() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public int getBoerderij_id() {
        return boerderij_id;
    }

    public void setBoerderij_id(int boerderij_id) {
        this.boerderij_id = boerderij_id;
    }

    @Override
    public String toString() {
        return "Boerderij{" +
                "naam='" + naam + '\'' +
                ", straat='" + straat + '\'' +
                ", nummer=" + nummer +
                ", postcode=" + postcode +
                ", email=" + email +
                '}';
    }
}
