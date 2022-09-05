package budget_app.repository;

import budget_app.models.Savings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.sql.Timestamp;

@Repository
public interface SavingsRepository extends JpaRepository<Savings, Long> {

    @Query(value="SELECT SUM(current_amount) FROM Savings", nativeQuery = true)
    Float getSavingBalance();

    Float findByTargetAmountGreaterThan(int amount);

//    List<Savings> findByNameBetween(String name, Timestamp timeStamp1, Timestamp timeStamp2);

}
