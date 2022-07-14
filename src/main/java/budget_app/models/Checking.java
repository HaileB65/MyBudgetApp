package budget_app.models;

public class Checking {
    int id;
    String customer;
    String venderName;
    int amount;
    int dateOfTransaction;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getVenderName() {
        return venderName;
    }

    public void setVenderName(String venderName) {
        this.venderName = venderName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setDateOfTransaction(int dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }

    @Override
    public String toString() {
        return "Checking{" +
                "id=" + id +
                ", customer='" + customer + '\'' +
                ", venderName='" + venderName + '\'' +
                ", amount=" + amount +
                ", dateOfTransaction=" + dateOfTransaction +
                '}';
    }
}
