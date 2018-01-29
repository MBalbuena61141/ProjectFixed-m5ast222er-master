package Model;

public class Cast {
    private int actorID;
    private int movieID;

    public Cast(int actorID, int movieID) {
        this.actorID = actorID;
        this.movieID = movieID;
    }


    public int getActorID() {
        return actorID;
    }

    public void setActorID(int actorID) {
        this.actorID = actorID;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }


    @Override
    public String toString() {
        return "The movie cats its"+ actorID;
    }
}
