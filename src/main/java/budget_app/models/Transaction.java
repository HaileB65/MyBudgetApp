package budget_app.models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

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

    @Column(name = "timestamp")
    @CreationTimestamp //this adds the default timestamp on save
    private Timestamp timestamp;

}
