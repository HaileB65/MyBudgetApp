package budget_app.mockingmethods.services;

import budget_app.BudgetApp;
import budget_app.exceptions.NoSuchUserException;
import budget_app.models.User;
import budget_app.repository.UserRepository;
import budget_app.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = UserService.class)
public class UserServiceUnitTest {
    @MockBean
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Test
    public void testFindUserByIdSuccessBehavior() throws Exception {
        User user1 = User.builder()
                .id(1L)
                .firstName("Rex")
                .lastName("Smith")
                .email("fdjaa@gmail.com")
                .username("me")
                .password("you")
                .build();

        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user1));

        assertThat(userService.findUserById(1L)).isEqualTo(user1);
    }

    @Test
    public void testGetRecipeByIdFailureBehavior() {
        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(NoSuchUserException.class, () -> {
            userService.findUserById(1L);
        });
    }
}