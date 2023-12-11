import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import weka.classifiers.bayes.NaiveBayes;
import weka.core.Attribute;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

//TODO WekaPackageManager.loadPackages(false);

public class Learner {
    private final List<SensorData> trainData;
    private DataSource trainingDataSource;
    private NaiveBayes naiveBayes;
    private Instances instances;


    private Learner(List<SensorData> trainData) {
        this.trainData = trainData;
    }

    public Learner() {
        this.trainData = new LinkedList<>();
    }

    public static Learner learner(List<SensorData> trainData) {
        return new Learner(trainData);
    }

    public void train(List<SensorData> trainData) throws Exception {
        ArrayList<Attribute> attributes = new ArrayList<>();
        for (SensorData dataRow : trainData) {
            attributes.add(new Attribute("favorability", dataRow.getLabel()));
            attributes.add(new Attribute("sequence", dataRow.getSequence()));
        }
        this.instances = new Instances("Agent", attributes, 0);
        this.instances.setClassIndex(0);

        this.naiveBayes = new NaiveBayes();
        this.naiveBayes.buildClassifier(this.instances);
    }

    public double predict(int position) throws Exception {

        return this.naiveBayes.classifyInstance(this.instances.get(position));
    }

}