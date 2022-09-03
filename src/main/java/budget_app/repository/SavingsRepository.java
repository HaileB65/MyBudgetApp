package budget_app.repository;

import budget_app.models.Savings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsRepository extends JpaRepository<Savings, Long> {

    @Query(value="SELECT SUM(current_amount) FROM Savings", nativeQuery = true)
    Float getSavingBalance();

    Float findByTargetAmountGreaterThan(int amount);

}
