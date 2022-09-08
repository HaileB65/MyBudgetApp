package budget_app.mockingmethods.controller;

import budget_app.BudgetApp;
import budget_app.TestUtil;
import budget_app.controllers.UserController;
import budget_app.exceptions.NoSuchUserException;
import budget_app.models.User;
import budget_app.services.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest(UserController.class)
//@ContextConfiguration(classes = BudgetApp.class)

//@SpringBootTest(classes = UserController.class) //, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
//@AutoConfigureMockMvc

@WebMvcTest(UserController.class)
//@ContextConfiguration(classes = BudgetApp.class)
public class UserControllerUnitTest {

    @MockBean
    UserService userService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testFindUserByIdNormalBehavior() throws Exception {
        //create user
        User user1 = User.builder()
                .id(1L)
                .firstName("Luna")
                .lastName("Gonzales")
                .email("teiwo@gmail.com")
                .username("bye")
                .password("later")
                .build();

        //when RecipeService's getRecipeById() method is called with any Long passed in
        when(userService.findUserById(anyLong()))
                //return the above defined user
                .thenReturn(user1);

        //test that the controller works properly when the above user is guaranteed to be returned from its
        //FindUserById() method call
        mockMvc.perform(get("/user/1"))
                //expect 200 OK
                .andExpect(status().isOk())
                //expect JSON in the body
                .andExpect(content().contentType("application/json"))
                //expect the JSON matches the Recipe returned from getRecipeById()
                .andExpect(content().string(TestUtil.convertObjectToJsonString(user1)));

    }

    @Test
    public void testFindUserByIdFailureBehavior() throws Exception {
        when(userService.findUserById(any()))
                .thenThrow(new NoSuchUserException("test this is in body"));

        mockMvc.perform(get("/editUser/" + 1L))
                //print response
                .andDo(print())
                //expect status 404 NOT FOUND
                .andExpect(status().isNotFound())
                //confirm that HTTP body contains correct error message
                .andExpect(content().string(containsString("test this is in body")));
    }
}
