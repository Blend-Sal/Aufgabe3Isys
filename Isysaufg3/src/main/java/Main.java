public class Main {
    public static void main(String[] args) throws Exception {
        Learner test = new Learner();
        test.train(FileReader.readDataList("Isysaufg3/src/main/resources/train.txt"));
        System.out.println(test.predict(5));
    }
}
