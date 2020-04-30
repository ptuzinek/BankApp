package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CSV {
    // Read data from CSV file and return as a list
    public static List<String[]> read(String file) throws IOException {
        List<String[]> data = new LinkedList<String[]>();
        String dataRow;
        BufferedReader br = new BufferedReader(new FileReader(file));

        while ((dataRow = br.readLine()) != null) {
            String[] dataRecords = dataRow.split(",");
            data.add(dataRecords);
        }
        return data;
    }
}
