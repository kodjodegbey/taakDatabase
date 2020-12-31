package Classes;

public class BoerderijAanbod {

    private int contract_id,prijs,boerderij_id,pakket_id;

    public BoerderijAanbod() {

    }

    public BoerderijAanbod(int contract_id, int prijs, int boerderij_id, int pakket_id) {
        this.contract_id = contract_id;
        this.prijs = prijs;
        this.boerderij_id = boerderij_id;
        this.pakket_id = pakket_id;
    }

    public int getContract_id() {
        return contract_id;
    }

    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    public int getPrijs() {
        return prijs;
    }

    public void setPrijs(int prijs) {
        this.prijs = prijs;
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

    @Override
    public String toString() {
        return "BoerderijAanbod{" +
                "contract_id=" + contract_id +
                ", prijs=" + prijs +
                ", boerderij_id=" + boerderij_id +
                ", pakket_id=" + pakket_id +
                '}';
    }
}
