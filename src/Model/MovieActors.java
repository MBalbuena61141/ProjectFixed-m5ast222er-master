package Model;

public class MovieActors {
    private int actorID;
    private int movieID;

    public MovieActors (int actorID, int movieID) {
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