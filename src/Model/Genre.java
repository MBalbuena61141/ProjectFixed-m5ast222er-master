package Model;

public class Genre {
    private int genreID;
    private String genreType;

    public Genre(int genreID, String genreType) {
        this.genreID = genreID;
        this.genreType = genreType;
    }

    public int getGenreID() {
        return genreID;
    }

    public void setGenreID(int genreID) {
        this.genreID = genreID;
    }

    public String getGenreType() {
        return genreType;
    }

    public void setGenreType(String genreType) {
        this.genreType = genreType;

}

    @Override
    public String toString() {
        return genreType;
}
}