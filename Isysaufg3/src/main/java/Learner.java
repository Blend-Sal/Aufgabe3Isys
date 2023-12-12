import weka.classifiers.bayes.NaiveBayes;
import weka.core.Attribute;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    public int[][] fileTable(int columns, int rows) {
        int[][] fileTable = new int[columns][3];

        int mm = 0;
        int mn = 0;
        int mh = 0;
        int nm = 0;
        int nn = 0;
        int nh = 0;
        int hm = 0;
        int hn = 0;
        int hh = 0;
        for (int i = 0; i < trainData.size(); i++) {


            for (int j = 0; j < trainData.get(i).getSequence().size() - 1; j++) {
                String current = trainData.get(i).getSequence().get(j);
                String next = trainData.get(i).getSequence().get(j + 1);
                if (current.equals("m")) {
                    switch (next) {
                        case "m" -> mm++;
                        case "n" -> mn++;
                        case "h" -> mh++;
                    }
                } else if (current.equals("n")) {
                    switch (next) {
                        case "m" -> nm++;
                        case "n" -> nn++;
                        case "h" -> nh++;
                    }
                } else if (current.equals("h")) {
                    switch (next) {
                        case "m" -> hm++;
                        case "n" -> hn++;
                        case "h" -> hh++;
                    }
                } else {
                    System.out.println("Problem");
                }

            }

        }
        fileTable[0][0] = mm;
        fileTable[0][1] = mn;
        fileTable[0][2] = mh;
        fileTable[1][0] = nm;
        fileTable[1][1] = nn;
        fileTable[1][2] = nh;
        fileTable[2][0] = hm;
        fileTable[2][1] = hn;
        fileTable[2][2] = hh;


        return fileTable;
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