import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FileReader extends java.io.FileReader {

    public FileReader(String filename) throws IOException {
        super(filename);
    }

    public static List<SensorData> readDataList(String filename) throws IOException {
        List<SensorData> dataList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Trennen von Label und Sequenz

                String[] parts = line.split(" +", 2);
                String label = parts[0];
                List<String> sequence = Arrays.asList(parts[1].split(" +"));

                // neues SensorData-Objekt erstellen und zur Liste hinzufügen
                SensorData data = SensorData.sensorData(label, sequence);
                dataList.add(data);
            }
        }

        return dataList;
    }
}