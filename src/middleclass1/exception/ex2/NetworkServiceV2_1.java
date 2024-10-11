package middleclass1.exception.ex2;

public class NetworkServiceV2_1 {
    public void sendMessage(String data) throws NetworkClientExceptionV2 {
        String address = "http://exaple.com";
        NetworkClientV2 client = new NetworkClientV2(address);
        client.initError(data);

        client.connect();
        client.send(data);
        client.disconnect();
    }
}
