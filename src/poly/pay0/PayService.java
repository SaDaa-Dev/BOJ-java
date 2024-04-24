package poly.pay0;

public class PayService {
    Pay pay;
    String payOption;
    int amount;

    public PayService(String payOption, int amount) {
        this.payOption = payOption;
        this.amount = amount;

        switch (payOption) {
            case "kakao":
                this.pay = new KakaoPay();
                break;
            case "naver":
                this.pay = new NaverPay();
                break;
            case "bad":
                this.pay = new BadPay();
                break;
            default:
                this.pay = null;
                break;
        }
    }

    public void pay() {
        pay.processPay(payOption, amount);
    }
}
