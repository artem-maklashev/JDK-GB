package jdk_server_lesson2.server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerWindow extends JFrame {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    private Repository repository;

    JButton btnStart, btnStop;
    JTextArea log;
    private final Server server;

    public ServerWindow(Repository repository){
        this.server  = new Server(repository);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setLocationRelativeTo(null);

        createPanel();

        setVisible(true);
    }
    private void appendLog(String text){
        log.append(text + "\n");
    }

    private void createPanel() {
        log = new JTextArea();
        add(log);
        add(createButtons(), BorderLayout.SOUTH);
    }

    private Component createButtons() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (server.serverStatus()){
                    appendLog("Сервер уже был запущен");
                } else {
                    server.startServer();
                    appendLog("Сервер запущен!");
                }
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!server.serverStatus()){
                    appendLog("Сервер уже был остановлен");
                } else {
                    server.stopServer();
                    //TODO поправить удаление
                    appendLog("Сервер остановлен!");
                }
            }
        });
        panel.add(btnStart);
        panel.add(btnStop);
        return panel;
    }
}
