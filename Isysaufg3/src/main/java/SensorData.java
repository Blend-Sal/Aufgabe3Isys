import java.util.List;

public class SensorData {
    private List<String> sequence;
    private String label;
    boolean favorable = false;

    SensorData(String label, List<String> sequence) {
        this.label = label;
        if (this.label.equalsIgnoreCase("G")) {
            this.favorable = true;
        }
        this.sequence = sequence;
    }


    public static SensorData sensorData(String label, List<String> sequence) {
        return new SensorData(label, sequence);
    }

    public boolean setSequence(List<String> sequence) {
        this.sequence = sequence;
        return true;
    }

    public List<String> getSequence() {
        return this.sequence;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isFavorable() {
        return favorable;
    }

    public void setFavorable(boolean favorable) {
        this.favorable = favorable;
    }

    public String toString() {
        return String.format("(%s | %s)", this.label, this.sequence);
    }
}