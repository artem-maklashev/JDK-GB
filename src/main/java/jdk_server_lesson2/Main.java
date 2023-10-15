package jdk_server_lesson2;

import jdk_server_lesson2.client.ClientGUI;
import jdk_server_lesson2.client.ClientView;
import jdk_server_lesson2.server.*;


public class Main {
    public static void main(String[] args) {
        Repository repository = new Storage();
        ServerView serverView= new ServerWindow();
        Server server = new Server(repository, serverView);
        serverView.setServer(server);
        ClientView clientView = new ClientGUI(server);
        ClientView clientView1 = new ClientGUI(server);
    }
}
