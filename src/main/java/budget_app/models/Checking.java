package budget_app.models;

public class Checking {
    int id;
    String customerName;
    String venderName;
    int amount = 0;
    int dateOfTransaction = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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
                ", customer='" + customerName + '\'' +
                ", venderName='" + venderName + '\'' +
                ", amount=" + amount +
                ", dateOfTransaction=" + dateOfTransaction +
                '}';
    }
}
