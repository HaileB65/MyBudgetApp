package budget_app.repository;

import budget_app.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT SUM(amount) FROM Transaction")
    Float getBalance();

    List<Transaction> findByCustomerNameIsAndTimestampGreaterThan(String customerName, Timestamp timestamp1);

    List<Transaction> findByTimestampGreaterThan(Timestamp timestamp1);

}
