import java.util.ArrayList;
import java.util.List;

enum boatPos {right,left}//Metablhth Theshs Barkas

public class State {

    private  int    missL;
    private  int    missR;
    private  int    cannL;
    private  int    cannR;
    private boatPos boat;
    private State   ParentS;//den mpainei ston constructor giati tha parei timh apthn methodo

    public State(int missL, int missR, int cannL, int cannR,boatPos boat) {
        this.missL = missL;
        this.missR = missR;
        this.cannL = cannL;
        this.cannR = cannR;
        this.boat=boat;
    }



    //Elegxos oti se mia katastash tha exoume swstes times pediou
    public boolean ValidState(){
        if(missL>=0 && missR>=0 && cannL>=0 && cannR>=0 && (missL==0 || missL>=cannL ) &&
                (missR==0 || missR>=cannR))
             { return true;}

             else return false;
    }

    public boatPos getBoat() {
        return boat;
    }
    //GoalState
    public boolean goalState() {
        if (cannL==0 && missL==0)
            return true;
        else return false;
    }
public List<State> generateSuccessors() {
    List<State> successors=new ArrayList<State>();
    if (boat == boatPos.left) {//Thesh Barkas sta Aristera
        testAndAdd(successors,new State(missL,  missR,  cannL-1,  cannR+1, boatPos.right));//Kanibalos deksia
        testAndAdd(successors,new State(missL,  missR,  cannL-2,  cannR+2, boatPos.right));//2 kanibaloi deksia
        testAndAdd(successors,new State(missL-1,  missR+1,  cannL,  cannR, boatPos.right));//Ierapostolos deksia
        testAndAdd(successors,new State(missL-2,  missR+2,  cannL,  cannR, boatPos.right));// 2 Ierapostoloi deksia}
        testAndAdd(successors,new State(missL-1,  missR+1,  cannL-1,  cannR+1, boatPos.right));//1 Ierapostolos kai enas kanibalos deksia
    }
    else{//Thesh Barkas sta Deksia
        testAndAdd(successors,new State(missL,  missR,  cannL+1,  cannR-1, boatPos.left));//Kanibalos aristera
        testAndAdd(successors,new State(missL,  missR,  cannL+2,  cannR-2, boatPos.left));//2 kanibaloi aristera
        testAndAdd(successors,new State(missL+1,  missR-1,  cannL,  cannR, boatPos.left));//Ierapostolos aristera
        testAndAdd(successors,new State(missL+2,  missR-2,  cannL,  cannR, boatPos.left));// 2 Ierapostoloi aristera
        testAndAdd(successors,new State(missL+1,  missR-1,  cannL+1,  cannR-1, boatPos.left));//1 Ierapostolos kai enas kanibalos aristera

    }
    return successors;
}
    private void testAndAdd(List<State> successors, State newState) {
        if (newState.ValidState()) {
            newState.setParentS(this);
            successors.add(newState);
        }
    }
/////////////////////////////////////////////////////////////
//                       SETTERS & GETTERS                //
    public State getParentS() {
        return ParentS;
    }

    public void setParentS(State parentS) {
        ParentS = parentS;
    }

    public void setBoat(boatPos boat) {
        this.boat = boat;
    }

    public int getMissL() {
        return missL;
    }

    public void setMissL(int missL) {
        this.missL = missL;
    }

    public int getMissR() {
        return missR;
    }

    public void setMissR(int missR) {
        this.missR = missR;
    }

    public int getCannL() {
        return cannL;
    }

    public void setCannL(int cannL) {
        this.cannL = cannL;
    }

    public int getCannR() {
        return cannR;
    }

    public void setCannR(int cannR) {
        this.cannR = cannR;
    }
    //                     END OF   SETTERS & GETTERS                //
    ///////////////////////////////////////////////////////////////////
    @Override
    public String toString() {
        {
            return "State{" +
                    "missL=" + missL +
                    ", cannL=" + cannL +
                    ", boat=" + boat +
                    ", missR=" + missR +
                    ", cannR=" + cannR +

                    '}';
        }
    }




    public static void main(String[] args) {
        State s = new State(0, 3, 0, 3, boatPos.left);
        boolean x;
        x=s.goalState();
        System.out.print(x);
    }
}
