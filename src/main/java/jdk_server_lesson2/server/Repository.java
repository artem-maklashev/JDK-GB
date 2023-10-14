package jdk_server_lesson2.server;

public interface Repository {
     String readLog();
     void saveInLog(String text);

}
