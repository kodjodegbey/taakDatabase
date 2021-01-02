package Classes;

public class ContractEnPrijs {
    private  int prijs,contract_id;

    public ContractEnPrijs(int prijs, int contract_id) {
        this.prijs = prijs;
        this.contract_id = contract_id;
    }

    public ContractEnPrijs() {
    }

    public int getPrijs() {
        return prijs;
    }

    public void setPrijs(int prijs) {
        this.prijs = prijs;
    }

    public int getContract_id() {
        return contract_id;
    }

    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    @Override
    public String toString() {
        return "ContractEnPrijs{" +
                "prijs=" + prijs +
                ", contract_id=" + contract_id +
                '}';
    }


}
