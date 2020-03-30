import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


public class BreadthFirstSearch {

    public State algorithm(State start) {
        if (start.goalState()) {
            return start;
        }
        Queue<State> frontier = new LinkedList<State>();//First In First Out
        Set<State> visited = new HashSet<State>();//Monadika stoixeia
        frontier.add(start);
        while (true) {
            if (frontier.isEmpty()){
                return null;//den brhka tipota
        }
        State state = frontier.poll();//Get first element of the queue then remove it
        visited.add(state);
        List<State> successors = state.generateSuccessors();
        for (State child : successors) {
            if (!visited.contains(child) || !frontier.contains(child)) {
                if (child.goalState()) {
                    return child;
                }
                else frontier.add(child);
            }


        }

    }
    }



    }



