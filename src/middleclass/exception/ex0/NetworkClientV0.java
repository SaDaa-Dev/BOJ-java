package middleclass.exception.ex0;

public class NetworkClientV0 {
    private final String address;

    public NetworkClientV0(String address) {
        this.address = address;
    }

    public String connect() {
        System.out.println(address + " 서버 연결 성공");
        return "success";
    }

    public String send(String data) {
        System.out.println(address + " 서버에 연결 성공 " + data);
        return "success";
    }

    public void disconnect() {
        System.out.println("연결 해제");
    }
}
