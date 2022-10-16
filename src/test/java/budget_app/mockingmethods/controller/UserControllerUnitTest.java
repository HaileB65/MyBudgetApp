package budget_app.mockingmethods.controller;

import budget_app.controllers.UserController;
import budget_app.models.User;
import budget_app.security.PasswordService;
import budget_app.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UserController.class)
public class UserControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private PasswordService passwordService;

    @Test
    public void whenValidInput_thenReturns200() throws Exception {
        when(userService.getAllUsers()).thenReturn(Arrays.asList(
                User.builder()
                        .username("fdkal")
                        .password("dfa")
                        .id(1L)
                        .email("fda@fda.com,")
                        .firstName("fda")
                        .lastName("dfa")
                        .build(),
                User.builder()
                        .username("qdsfa")
                        .password("Smitdfah")
                        .id(4L)
                        .email("alexSmith@gmail.com,")
                        .firstName("Alex")
                        .lastName("Smith")
                        .build(),
                User.builder()
                        .username("qdsfa")
                        .password("Smitdfah")
                        .id(4L)
                        .email("alexSmith@gmail.com,")
                        .firstName("Alex")
                        .lastName("Smith")
                        .build()
        ));

        mockMvc.perform(get("/users")
                        .with(user("hui").password("hello"))
                        .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
