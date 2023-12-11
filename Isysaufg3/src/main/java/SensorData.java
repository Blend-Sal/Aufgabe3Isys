public class SensorData {
    private String[] sequence;
    private String label;
    boolean favorable = false;

    SensorData(String label, String[] sequence) {
        if (label.equalsIgnoreCase("G")) {
            this.favorable = true;
        }
        this.sequence = sequence;
    }


    public static SensorData sensorData(String label, String[] sequence) {
        return new SensorData(label, sequence);
    }

    public boolean setSequence(String[] sequence) {
        this.sequence = sequence;
        return true;
    }

    public String[] getSequence() {
        return this.sequence;
    }


}