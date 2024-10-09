package middleclass.exception.basic.unchecked;

public class Service {

    Client client = new Client();

    public void callCatch() {
        try {
            client.call();
        } catch (MyUncheckedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("정상 로직");
    }

    public void callThrow() {
        client.call();
    }
}
