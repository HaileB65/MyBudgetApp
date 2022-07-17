package budget_app.services;

import budget_app.BudgetApp;
import budget_app.models.Budget;
import budget_app.models.Goal;
import budget_app.models.User;

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
        User.goalList.add(newGoal);
        User.goalNamesList.add(newGoalName);

        System.out.println(newGoalName + " goal created");
    }

    public void editGoal(){
        System.out.println("Available goals to edit");
        for (Goal goal : User.goalList) {
            System.out.println(goal.getName());
        }
        System.out.println();

        Scanner userInput2 = new Scanner(System.in);
        System.out.println("Enter Goal name to edit");
        String goalToEdit = userInput2.nextLine();
        while(!User.goalNamesList.contains(goalToEdit)){
            System.out.println("please enter a goal name that already exists");
            System.out.println("List of existing goals:");
            for (Goal goal : User.goalList) {
                System.out.println(goal.getName());
            }
            goalToEdit = userInput2.nextLine();
            if(User.goalNamesList.contains(goalToEdit)){
                break;
            }

            System.out.println("return to Edit Goal menu? Enter 'y' or 'n'.");
            if(BudgetApp.yesOrNoPrompt()) {
                BudgetApp.editGoalsMenu();
            }
        }

        Scanner userInput1 = new Scanner(System.in);
        System.out.println("Enter updated goal name:");
        String updatedGoalName = userInput1.nextLine();
        System.out.println("Enter goal current amount:");
        Integer updatedGoalCurrentAmount = userInput1.nextInt();
        System.out.println("Enter goal target amount:");
        Integer updatedGoalTargetAmount = userInput1.nextInt();
        System.out.println("Monthly contribution towards goal:");
        Integer updatedGoalMonthlyContribution = userInput1.nextInt();

        if(goalToEdit == BudgetApp.user.goal.getName()) {
            BudgetApp.user.goal.setName(updatedGoalName);
            BudgetApp.user.goal.setCurrentAmount(updatedGoalCurrentAmount);
            BudgetApp.user.goal.setTargetAmount(updatedGoalTargetAmount);
            BudgetApp.user.goal.setMonthlyContribution(updatedGoalMonthlyContribution);
        }
        if(goalToEdit == BudgetApp.user.goal2.getName()) {
            BudgetApp.user.goal2.setName(updatedGoalName);
            BudgetApp.user.goal2.setCurrentAmount(updatedGoalCurrentAmount);
            BudgetApp.user.goal2.setTargetAmount(updatedGoalTargetAmount);
            BudgetApp.user.goal2.setMonthlyContribution(updatedGoalMonthlyContribution);
        }
        if(goalToEdit == BudgetApp.user.goal2.getName()) {
            // how to set values to a goal that a user created?
        }

        System.out.println("goal edit complete");
    }

    public void printGoalNamesList(){
        System.out.println("printing out goal list");
        System.out.println(BudgetApp.user.goalNamesList);

    }

}
