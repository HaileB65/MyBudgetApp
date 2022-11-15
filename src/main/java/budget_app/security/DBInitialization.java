package budget_app.security;

import budget_app.models.User;
import budget_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DBInitialization {
    @Autowired
    UserRepository userRepository;

    @PostConstruct
    private void postConstruct(){
        User defaultUser = new User(3L, "John", "Smith",
                "johnsmith@yahoo.com", "John", "Smith");
        userRepository.save(defaultUser);

    }

}
