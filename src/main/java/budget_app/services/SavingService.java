package budget_app.services;

import budget_app.models.Saving;
import budget_app.repository.SavingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class SavingService {
    @Autowired
    SavingRepository savingRepository;

    public List<Saving> getAllSavings() {
        return savingRepository.findAll();
    }

    public Saving getSavingById(Long id){return savingRepository.getById(id);}

    public void addSaving(Saving saving) {
        savingRepository.save(saving);
    }

    public void deleteSaving(Long id) {
        savingRepository.deleteById(id);
    }

    public Saving getSavingAccountThree() {
        return savingRepository.getById(3L);
    }

    public void currentSavingBalance() {

    }

    public Float getSavingBalance() {
        return savingRepository.getSavingBalance();
    }

    public List<Saving> findNameWhereTimestampIsGreaterThan(String name, Timestamp timestamp1){
        return savingRepository.findByNameIsAndTimestampGreaterThan(name,timestamp1);
    }

}
