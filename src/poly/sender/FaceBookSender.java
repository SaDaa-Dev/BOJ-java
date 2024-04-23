package poly.sender;

public class FaceBookSender implements Sender{
    @Override
    public void sendMessage(String first) {
        System.out.println("FaceBook " + first);
    }
}
