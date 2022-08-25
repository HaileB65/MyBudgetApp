package budget_app.models;

import lombok.Data;
import javax.persistence.*;

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

}
