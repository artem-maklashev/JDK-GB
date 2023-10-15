package jdk_server_lesson2.server;

import jdk_server_lesson2.client.Client;

import java.util.ArrayList;
import java.util.List;

public class Server {
    private final Repository repository;
    ServerView serverView;

    private final List<Client> clientList;
    private boolean work;

    public Server(Repository repository, ServerView serverView) {
        this.repository = repository;
        this.serverView = serverView;
        this.clientList = new ArrayList<>();
    }

    public void startServer(){
        work = true;
    }

    public void stopServer(){
        work = false;
        for (int i = clientList.size()-1; i >=0  ; i--) {
            disconnectUser(clientList.get(i));

        }
    }
    public boolean connectUser(Client client){
        if (!work) {
            return false;
        }
        this.clientList.add(client);
        appendLog(client.getName() + " подключился" );
        return true;
    }

    public void disconnectUser (Client client) {
        clientList.remove(client);
        if (client != null) {
            appendLog(client.getName() + " отключился");
            client.disconnect();

        }
    }
    public void sendMessage(String text) {
        if (!work) {
            return;
        }
        appendLog(text);
        answerAll(text);
        saveInLog(text);
    }

    private void saveInLog(String text) {
        repository.saveInLog(text);
    }

    private void answerAll(String text) {
        for (Client client: clientList){
            client.serverAnswer(text);
        }
    }

    private void appendLog(String text) {
        serverView.appendLog(text);
    }

    public String getHistory(){
        return repository.readLog();
    }

    public boolean serverStatus(){
        return work;
    }

}
