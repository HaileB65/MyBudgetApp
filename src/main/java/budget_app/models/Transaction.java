package budget_app.models;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name="transactions")
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String customerName;
    String venderName;
    int amount = 0;

}
