package budget_app.models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="savings")
@Data
public class Savings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    int targetAmount = 0;
    int currentAmount = 0;

    @Column(name = "timestamp")
    @CreationTimestamp //this adds the default timestamp on save
    private Timestamp timestamp;

}
