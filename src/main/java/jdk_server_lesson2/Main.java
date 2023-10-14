package jdk_server_lesson2;

import jdk_server_lesson2.client.ClientGUI;
import server.server.*;

public class Main {
    public static void main(String[] args) {
        Repository repository = new Storage();
        ServerView serverView= new ServerWindow();
        Server server = new Server(repository);
        ServerWindow serverWindow = new ServerWindow(new Storage());
        new ClientGUI(serverWindow);
        new ClientGUI(serverWindow);
    }
}
