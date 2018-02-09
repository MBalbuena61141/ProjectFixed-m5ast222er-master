package Model;

public class Genre {
    private int genreID;
    private String genreTitle;

    public Genre(int genreID, String genreType) {
        this.genreID = genreID;
        this.genreTitle = genreType;
    }

    public int getGenreID() {
        return genreID;
    }

    public void setGenreID(int genreID) {
        this.genreID = genreID;
    }

    public String getGenreTitle() {
        return genreTitle;
    }

    public void setGenreTitle(String genreTitle) {
        this.genreTitle = genreTitle;

}

    @Override
    public String toString() {
        return genreTitle;
}
}