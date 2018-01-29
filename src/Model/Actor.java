package Model;

public class Actor {

    private int actorID;
    private String actorName;

    public Actor(int actorID, String actorName) {
        this.actorID = actorID;
        this.actorName = actorName;
    }

    public int getActorID() {
        return actorID;
    }

    public void setActorID(int actorID) {
        this.actorID = actorID;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    @Override
    public String toString() {
        return  actorName;

    }










}
