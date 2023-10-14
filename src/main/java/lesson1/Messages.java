package lesson1;

import java.io.IOException;
import java.util.List;

public class Messages {
    private List<String> messages;

    public  Messages() throws IOException {
        this.messages = DataIO.readMessages();
    }

    public void addMessage(String user, String message) throws IOException {

        StringBuilder sb = new StringBuilder();
        sb.append(user).append(": ").append(message);
        messages.add(sb.toString());
        DataIO.writeMessages(messages);
    }

    public String getMessages() {
        StringBuilder sb = new StringBuilder();
        for (String message:
                messages) {
            sb.append(message + "\n");
        }
        return sb.toString();
    }

    public int getSize() {
        return messages.size();
    }

    public List<String> getList(int startIndex){
        return messages.subList(startIndex, messages.size() -1);
    }
}
