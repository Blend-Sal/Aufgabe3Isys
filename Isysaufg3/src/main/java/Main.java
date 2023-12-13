public class Main {
    public static void main(String[] args) throws Exception {
        Learner test = Learner.learner(FileReader.readDataList("Isysaufg3/src/main/resources/train.txt"));


        System.out.println("Günstig:\n" + Learner.print3DTable(Learner.frequencyTable(test.getGData())));
        System.out.println("Ungünstig:\n" + Learner.print3DTable(Learner.frequencyTable(test.getUData())));
        System.out.println("Günstig:\n" + Learner.print3DTable(Learner.probabilityTable(test, true)));
        System.out.println("Ungünstig:\n" + Learner.print3DTable(Learner.probabilityTable(test, false)));

    }
}
