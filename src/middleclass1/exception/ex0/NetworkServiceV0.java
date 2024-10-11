package middleclass1.exception.ex0;

public class NetworkServiceV0 {
    public void sendMessage(String data) {
        String address = "http://exaple.com";
        NetworkClientV0 client = new NetworkClientV0(address);

        client.connect();
        client.send(data);
        client.disconnect();
    }
}
