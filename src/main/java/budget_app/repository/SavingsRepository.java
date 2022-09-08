package budget_app.repository;

import budget_app.models.Savings;
import budget_app.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.sql.Timestamp;
import java.util.List;

@Repository
public interface SavingsRepository extends JpaRepository<Savings, Long> {

    @Query(value="SELECT SUM(current_amount) FROM Savings", nativeQuery = true)
    Float getSavingBalance();

    Float findByTargetAmountGreaterThan(int amount);

    List<Savings> findByNameIsAndTimestampGreaterThan(String name, Timestamp timestamp1);

}
