import java.util.ArrayList;
import java.util.List;

public class Learner {
    private final List<SensorData> trainData;

    private Learner(List<SensorData> trainData) {
        this.trainData = trainData;
    }

    public static Learner learner(List<SensorData> trainData) {
        return new Learner(trainData);
    }

    public List<SensorData> getGData() {
        return this.trainData.stream().filter(SensorData::isFavorable).toList();
    }

    public List<SensorData> getUData() {
        List<SensorData> data = new ArrayList<>(this.trainData);
        data.removeAll(getGData());
        return data;
    }

    public static int[][] frequencyTable(List<SensorData> dataList) {
        int[][] frequencyTable = new int[3][3];

        /*
        mm  mn  mh
        nm  nn  nh
        hm  hn  hh
         */
        int mm = 0;
        int mn = 0;
        int mh = 0;
        int nm = 0;
        int nn = 0;
        int nh = 0;
        int hm = 0;
        int hn = 0;
        int hh = 0;
        for (int i = 0; i < dataList.size(); i++) {

            for (int j = 0; j < dataList.get(i).getSequence().size() - 1; j++) {
                String current = dataList.get(i).getSequence().get(j);
                String next = dataList.get(i).getSequence().get(j + 1);
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

            frequencyTable[0][0] = mm;
            frequencyTable[0][1] = mn;
            frequencyTable[0][2] = mh;
            frequencyTable[1][0] = nm;
            frequencyTable[1][1] = nn;
            frequencyTable[1][2] = nh;
            frequencyTable[2][0] = hm;
            frequencyTable[2][1] = hn;
            frequencyTable[2][2] = hh;
        }

        return frequencyTable;
    }

    public static double[][] probabilityTable(Learner learner, boolean favorable) {
        double[][] probabilityTable = new double[3][3];
        int[][] frequencyTable = favorable ? frequencyTable(learner.getGData()) : frequencyTable(learner.getUData());
        for (int i = 0; i < frequencyTable.length; i++) {
            int sum = frequencyTable[i][0] + frequencyTable[i][1] + frequencyTable[i][2];
            for (int j = 0; j < frequencyTable[i].length; j++) {
                probabilityTable[i][j] = (float) frequencyTable[i][j] / sum;
            }
        }


        return probabilityTable;
    }

    public static String print3DTable(double[][] arr) {

        return String.format("[%.8f, %.8f, %.8f]%n[%.8f, %.8f, %.8f]%n[%.8f, %.8f, %.8f]", (arr[0][0]),  (arr[0][1]),  (arr[0][2]),  (arr[1][0]),  (arr[1][1]),  (arr[1][2]),  (arr[2][0]),  (arr[2][1]), arr[2][2]);
    }

    public static String print3DTable(int[][] arr) {

        return String.format("[%d, %d, %d]%n[%d, %d, %d]%n[%d, %d, %d]", arr[0][0], arr[0][1], arr[0][2], arr[1][0], arr[1][1], arr[1][2], arr[2][0], arr[2][1], arr[2][2]);
    }


}