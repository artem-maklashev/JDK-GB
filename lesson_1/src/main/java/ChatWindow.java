import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class ChatWindow extends JFrame {
    private static final int WIDTH = 555;
    public static final int HEIGHT = 507;
    JButton btnSend, btnConnect;
    JTextField messageField, connectionPort, userName;
    JFormattedTextField connectionAdress;
    JPasswordField passwordField;
    JTextArea chatHistory;
    JPanel connectionPanel, bottomPanel;
    private final Messages messagesList = new Messages();
    private int messagesCount;

    ChatWindow() throws IOException {
        messagesCount = messagesList.getSize();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Chat Client");
        setResizable(true);
        setLayout(new BorderLayout());
        chatHistory = new JTextArea(messagesList.getMessages());
        chatHistory.setEditable(false);
        connectionPanel = connectionPanel();
        bottomPanel = bottomPanel();
        add(connectionPanel, BorderLayout.NORTH);
        add(chatHistory);
        add(bottomPanel, BorderLayout.SOUTH);
        setVisible(true);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    updateChatHistory();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        timer.setRepeats(true);
        timer.start();
    }

    public JPanel bottomPanel() {
        messageField = new JTextField();
        btnSend = new JButton("Send");
        JPanel panBottom = new JPanel(new BorderLayout());
        messageField.setPreferredSize(new Dimension(getWidth() - 80, 30));
        btnSend.setPreferredSize(new Dimension(80, 30));
        messageField.setEditable(false);
        ActionListener l = ae -> {
            if (!messageField.getText().isEmpty()){
                try {
                    messagesList.addMessage(userName.getText(), messageField.getText());
                    messageField.setText("");
                } catch (IOException ex) {
                    System.out.println("Ошибка добавления записи о сообщении");
                }
            }
        };
        messageField.addActionListener(l);
        btnSend.addActionListener(l);
        panBottom.add(messageField, BorderLayout.CENTER);
        panBottom.add(btnSend, BorderLayout.EAST);
        return panBottom;
    }

    public JPanel connectionPanel() {
        JPanel connectionPanel = new JPanel(new GridLayout(2, 3));
        connectionAdress = new JFormattedTextField(createIPAddressFormatter());
        connectionAdress.setValue("127.000.000.001");
        connectionPort = new JTextField("8123");
        connectionPanel.add(connectionAdress);
        connectionPanel.add(connectionPort);
        connectionPanel.add(new JLabel());

        btnConnect = new JButton("Connect");
        btnConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectionPanel.setVisible(false);
                messageField.setEditable(true);
                bottomPanel.repaint();
            }
        });
        userName = new JTextField("Username");
        passwordField = new JPasswordField(10);
        connectionPanel.add(userName);
        connectionPanel.add(passwordField);
        connectionPanel.add(btnConnect);

        return connectionPanel;
    }

    private MaskFormatter createIPAddressFormatter() {
        try {
            return new MaskFormatter("###.###.###.###");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateChatHistory() throws IOException {
        List<String> newMessages = DataIO.readMessages();
        if (newMessages.size() > messagesCount) {
            List<String> messagesToAdd = newMessages.subList(messagesCount, newMessages.size());
            for (String message : messagesToAdd) {
                chatHistory.append(message + "\n");
            }
            messagesCount = newMessages.size();
        }
    }
}
