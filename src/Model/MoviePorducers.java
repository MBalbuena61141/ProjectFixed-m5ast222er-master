package Model;

public class MoviePorducers {

    private int movieID;
    private int producerID;

    public MoviePorducers(int movieID, int producerID) {
        this.movieID = movieID;
        this.producerID = producerID;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public int getProducerID() {
        return producerID;
    }

    public void setProducerID(int producerID) {
        this.producerID = producerID;
    }


}
