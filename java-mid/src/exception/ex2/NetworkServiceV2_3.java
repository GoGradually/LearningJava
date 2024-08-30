package exception.ex2;

public class NetworkServiceV2_3 {
    public void sendMessage(String data) throws NetworkClientExceptionV2 {
        String address = "http://example.com";

        NetworkClientV2 clientV2 = new NetworkClientV2(address);
        clientV2.initError(data);

        try {
            clientV2.connect();
            clientV2.send(data);
        } catch (NetworkClientExceptionV2 e) {
            System.out.println("[오류] 코드: " + e.getErrorCode() + ", 메시지: " + e.getMessage());
        } finally {
            clientV2.disconnect();
        }
    }
}
