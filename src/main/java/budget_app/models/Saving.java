package budget_app.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="savings")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Saving {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    int currentAmount = 0;

    @Column(name = "timestamp")
    @CreationTimestamp //this adds the default timestamp on save
    private Timestamp timestamp;

}
