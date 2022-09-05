package budget_app.services;

import budget_app.models.Savings;
import budget_app.repository.SavingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class SavingsService {
    @Autowired
    SavingsRepository savingsRepository;

    public List<Savings> getAllSavings() {
        return savingsRepository.findAll();
    }

    public void addSavings(Savings savings) {
        savingsRepository.save(savings);
    }

    public void deleteSavings(Long id) {
        savingsRepository.deleteById(id);
    }

    public Savings getSavingAccountOne() {
        return savingsRepository.getById(1L);
    }

    public void updateSavingAccountOne(Savings saving) {
        savingsRepository.save(saving);
    }

    public Float getSavingBalance() {
        return savingsRepository.getSavingBalance();
    }

//    public List<Savings> findByNameBetween(String name, Timestamp timestamp1, Timestamp timestamp2) {
//        return savingsRepository.findByNameBetween(name, timestamp1, timestamp2);
//    }

}

