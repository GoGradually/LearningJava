package exception.ex2;

public class NetworkServiceV2_1 {
    public void sendMessage(String data) throws NetworkClientExceptionV2 {
        String address = "http://example.com";

        NetworkClientV2 clientV2 = new NetworkClientV2(address);
        clientV2.initError(data);

        clientV2.connect();
        clientV2.send(data);
        clientV2.disconnect();
    }
}
