package poly.sender;

public class EmailSender implements Sender{
    @Override
    public void sendMessage(String first) {
        System.out.println("email " + first);
    }
}
