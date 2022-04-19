package prj5;

public class State {
    private String stateName;
    private SinglyLinkedList<Race> races;

    public State(String name, SinglyLinkedList<Race> race) {
        stateName = name;
        races = race;
    }


    public SinglyLinkedList<Race> getRaces() {
        return races;
    }


    public String getStateName() {
        return stateName;
    }

}
