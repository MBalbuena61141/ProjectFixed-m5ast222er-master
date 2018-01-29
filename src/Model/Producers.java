package Model;

public class Producers {

    private int producerID;
    private String producerName;

    public Producers(int producerID, String producerName) {
        this.producerID = producerID;
        this.producerName = producerName;
    }

    public int getProducerID() {
        return producerID;
    }

    public void setProducerID(int producerID) {
        this.producerID = producerID;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    @Override
    public String toString() {
        return "Producers{" +
                "producerName='" + producerName + '\'' +
                '}';
    }
}
