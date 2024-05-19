package poly.pay0;

public class PayService {
    String option;
    int amount;

    public PayService(String option, int amount) {
        this.option = option;
        this.amount = amount;
    }

    public void processPay() {
        boolean result = false;

        System.out.println("결제를 시작합니다: option=" + option + " , amount=" + amount);

        Pay pay = PayStore.findPay(option);
        result = pay.pay(amount);
    }
}
