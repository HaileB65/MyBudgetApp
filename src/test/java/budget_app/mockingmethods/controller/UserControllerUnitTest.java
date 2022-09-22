package budget_app.mockingmethods.controller;

import budget_app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerUnitTest {

    @MockBean
    UserService userService;

    @Autowired
    MockMvc mockMvc;

    //test the UserController


}
