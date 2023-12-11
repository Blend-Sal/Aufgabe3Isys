import java.util.List;



public class Learner {
    private final List<SensorData> trainData;

    private Learner(List<SensorData> trainData) {
        this.trainData = trainData;
    }

    public static Learner learner(List<SensorData> trainData) {
        return new Learner(trainData);
    }



}