import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FileReader extends java.io.FileReader {

    public FileReader(String filename) throws IOException {
        super(filename);
    }

    public List<SensorData> readDataList(String filename) throws IOException {
        List<SensorData> dataList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Trennen Sie das Label und die Sequenz
                String[] parts = line.split(" ", 2);
                String label = parts[0];
                String[] sequence = parts[1].split(" +");

                // Erstellen Sie ein neues SensorData-Objekt und fügen Sie es zur Liste hinzu
                SensorData data = SensorData.sensorData(label, sequence);
                dataList.add(data);
            }
        }

        return dataList;
    }
}