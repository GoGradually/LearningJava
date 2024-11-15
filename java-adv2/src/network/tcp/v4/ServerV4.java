package network.tcp.v4;

import network.tcp.v3.SessionV3;

import java.io.IOException;
import java.net.ServerSocket;

import static util.MyLogger.log;

public class ServerV4 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("서버 시작");
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("서버 소켓 시작 - 리스닝 포트: " + PORT);

        while (true) {
            Thread thread = new Thread(new SessionV4(serverSocket.accept()));
            thread.start();
        }
    }
}
