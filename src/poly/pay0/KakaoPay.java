package poly.pay0;

public class KakaoPay implements Pay{
    @Override
    public void processPay(String payOption, int amount) {
        System.out.println("카카오 결제 시작");
        System.out.println("결제를 시작합니다: option=" + payOption + ", amount=" + amount);
    }
}
