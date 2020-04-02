import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(" Missionaries and Cannibals Problem ");
        System.out.println("\t 1. Breadth-first search");
        String choice = null;

        do {
            System.out.println("Select something: ");
            System.out.println("1 for BFS ");
            System.out.println("Type exit to EXIT");
            Scanner scan = new Scanner(System.in);
            choice = scan.nextLine();
            State initialState = new State (3, 0, 3, 0, boatPos.left);
            switch (choice) {
                case "1":
                    executeBFS(initialState);
                    break;
                case "2":
                    System.out.println("PLEASE CHOOSE 1");
                    break;
                case "exit":
                    System.out.println("Exiting menu");
                    break;
                default:
                    System.out.println("Please choose 1.");
                break;

            }
        } while ( !choice.equals("exit"));


    }
    private static void executeBFS(State start) {
        BreadthFirstSearch search = new BreadthFirstSearch();
        State solution = search.algorithm(start);
        printSolution(solution);
    }


    private static void printSolution(State solution) {
        if (null == solution) {
            System.out.print("\n No solution found.");
        } else {
            System.out.println("\nSolution (MissionaryLeft,CannibalLeft,boat,MissionaryRight,CannibalRight): ");

            List<State> path = new ArrayList<State>();
            State state = solution;
            while(null!=state) {
                path.add(state);
                state = state.getParentS();
            }

            int mhkos = path.size() - 1;
            for (int i = mhkos; i >= 0; i--) {
                state = path.get(i);
                if (state.goalState()) {
                    System.out.print(state.toString());
                } else {
                    System.out.print(state.toString() + " -> ");
                }
            }
            System.out.println("\nMhkos monopatiou lushs: " + mhkos);

        }
}
}