package jdk_server_lesson2.server;

import jdk_server_lesson2.client.Client;

import java.util.List;

public class Server {
    private ServerView serverView;
    private Repository repository;

    private List<Client> clientList;
    private boolean work;

    public Server(Repository repository) {
        this.repository = repository;
        this.serverView =
    }

    public void startServer(){
        work = true;
    }

    public void stopServer(){
        work = false;
        for (Client clientGUI: clientList){
            disconnectUser(clientGUI);
        }
    }
    public boolean connectUser(Client client){
        if (!work) {
            return false;
        }
        this.clientList.add(client);
        return true;
    }

    public void disconnectUser (Client client) {
        clientList.remove(client);
        if (client != null) {
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
    }

    public String getHistory(){
        String log = repository.readLog();
        return log;
    }
    public List<Client> getClientList() {
        return clientList;
    }

    public boolean serverStatus(){
        return work;
    }
}
