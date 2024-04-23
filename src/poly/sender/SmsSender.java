package poly.sender;

public class SmsSender implements Sender{
    @Override
    public void sendMessage(String first) {
        System.out.println("sms " + first);
    }
}
