package budget_app.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="checking")
@Data
public class Checking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String customerName;
    String venderName;
    int amount = 0;

}
