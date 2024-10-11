package middleclass1.exception.ex4.exception;

public class ConnectExceptionV4 extends NetworkClientExceptionV4 {
    private String address;

    public ConnectExceptionV4(String message, String address) {
        super(message);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
