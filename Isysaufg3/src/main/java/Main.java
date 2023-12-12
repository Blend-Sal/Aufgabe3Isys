import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        Learner test = Learner.learner(FileReader.readDataList("Isysaufg3/src/main/resources/train.txt"));

       int[][] fT = test.fileTable(3, 3);
        System.out.printf("%d, %d, %d\n%d, %d, %d\n%d, %d, %d", fT[0][0], fT[0][1], fT[0][2], fT[1][0], fT[1][1], fT[1][2], fT[2][0], fT[2][1], fT[2][2]);
    }
}
