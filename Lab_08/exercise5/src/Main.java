interface PaymentMethod {
    void pay(double amount);
}

class PayPalPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paying: " + amount + " with paypal method");
    }
}

class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paying: " + amount + " with credit card method");
    }
}

class CashPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paying: " + amount + " with cash method");
    }
}

class CheckoutService {
    private final PaymentMethod paymentMethod;

    public CheckoutService(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void checkOut(double amount) {
        System.out.println("Processing checkout. . . ");
        paymentMethod.pay(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        double amount = 500000;

        CheckoutService service1 = new CheckoutService(new PayPalPayment());
        service1.checkOut(amount);

        CheckoutService service2 = new CheckoutService(new CashPayment());
        service2.checkOut(amount);

        CheckoutService service3 = new CheckoutService(new CreditCardPayment());
        service3.checkOut(amount);

    }
}
