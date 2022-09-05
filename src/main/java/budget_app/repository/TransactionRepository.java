package budget_app.repository;

import budget_app.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT SUM(amount) FROM Transaction")
    Float getBalance();

//    List<Transaction> findByNameIsBetween(String name);
}
