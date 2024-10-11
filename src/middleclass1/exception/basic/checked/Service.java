package middleclass1.exception.basic.checked;

public class Service {
    Client client = new Client();
    /*
    * 예외를 잡아서 처리하는 코드
    * */
    public void callCatch() {
        try {
            client.call();
        } catch (MyCheckedException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }

        System.out.println("정상 흐름");
    }

    /*
    * 체크 예외를 밖으로 던지는 코드
    * */
    public void catchThrow() throws MyCheckedException{
        client.call();
    }
}
