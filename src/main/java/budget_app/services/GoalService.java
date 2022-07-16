package budget_app.services;

import budget_app.models.Budget;
import budget_app.models.Goal;

import java.util.Scanner;

public class GoalService {

    public void createNewGoal(){
        Goal newGoal = new Goal();

        Scanner userInput1 = new Scanner(System.in);
        System.out.println("Enter new goal name:");
        String newGoalName = userInput1.nextLine();

        System.out.println("Enter goal current amount:");
        Integer goalCurrentAmount = userInput1.nextInt();

        System.out.println("Enter goal target amount:");
        Integer goalTargetAmount = userInput1.nextInt();

        System.out.println("Monthly contribution towards goal:");
        Integer goalMonthlyContribution = userInput1.nextInt();

        newGoal.setName(newGoalName);
        newGoal.setCurrentAmount(goalCurrentAmount);
        newGoal.setTargetAmount(goalTargetAmount);
        newGoal.setMonthlyContribution(goalMonthlyContribution);
    }

    public void editGoal(){
        Scanner userInput1 = new Scanner(System.in);
        System.out.println("Enter Goal name to edit");
        String goalToEdit = userInput1.nextLine();

        System.out.println("Enter goal current amount:");
        Integer goalCurrentAmount = userInput1.nextInt();

        System.out.println("Enter goal target amount:");
        Integer goalTargetAmount = userInput1.nextInt();

        System.out.println("Monthly contribution towards goal:");
        Integer goalMonthlyContribution = userInput1.nextInt();

//        newGoal.setName(newGoalName);
//        newGoal.setCurrentAmount(goalCurrentAmount);
//        newGoal.setTargetAmount(goalTargetAmount);
//        newGoal.setMonthlyContribution(goalMonthlyContribution);
    }
}
