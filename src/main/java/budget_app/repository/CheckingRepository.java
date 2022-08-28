package budget_app.repository;

import budget_app.models.Checking;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingRepository extends JpaRepository<Checking, Long> {

    @Query("SELECT SUM(amount) FROM Checking")
    Float getBalance();
}
