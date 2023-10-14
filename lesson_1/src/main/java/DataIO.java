import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class DataIO {
    private static final String fileName = "messages.txt";
    public static void writeMessages(List<String> lines) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        for (String line : lines) {
            writer.write(line + "\n");
        }
        writer.close();
    }

    public static List<String> readMessages() throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("File created!");
        } else {
            List<String> messages = new ArrayList<>();
            FileReader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String message;
            while ((message = bufferedReader.readLine()) != null) {
                messages.add(message);
            }
            bufferedReader.close();
            return messages;
        }
        return new ArrayList<>();
    }
}
