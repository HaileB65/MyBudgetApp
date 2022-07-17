package budget_app.models;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class User {
    int id;
    String firstName;
    String lastName;
    String email;

    public Budget budget = new Budget();
    public Checking checking= new Checking();
    public Savings savings = new Savings();
    public Goal goal = new Goal();
    public Goal goal2 = new Goal();

    public static ArrayList<Goal> goalList = new ArrayList<>();
    public static ArrayList<String> goalNamesList =  new ArrayList<>(Arrays. asList("goal", "goal2"));


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
