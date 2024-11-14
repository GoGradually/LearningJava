package network.tcp.v2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static util.MyLogger.log;

public class ServerV2 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("서버 시작");
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("서버 소켓 시작 - 리스닝 포트: " + PORT);

        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try (Socket socket = serverSocket.accept();
                         DataInputStream input = new DataInputStream(socket.getInputStream());
                         DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                    ) {
                        log("소켓 연결: " + socket);


                        while (true) {
                            // 클라이언트로부터 문자 받기
                            String received = input.readUTF();
                            log("client -> server: " + received);

                            if (received.equals("exit")) {
                                break;
                            }

                            // 클라이언트에게 문자 보내기
                            String toSend = received + " World!";
                            output.writeUTF(toSend);
                            log("client <- server: " + toSend);

                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            thread.start();
        }
    }
}
