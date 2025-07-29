package com.java.interviewPrep.solid.o;

// Bad: If you add more payment types, you must modify this class
 class PaymentService {
    public void pay(String mode) {
        if ("CREDIT".equals(mode)) {
            // Credit card logic
        } else if ("PAYPAL".equals(mode)) {
            // PayPal logic
        }
    }
}

// Good: Use polymorphism to extend without modifying
 interface Payment {
    void pay();
}

 class CreditCardPayment implements Payment {
    public void pay() {
        System.out.println("Paid with credit card");
    }
}

 class PayPalPayment implements Payment {
    public void pay() {
        System.out.println("Paid with PayPal");
    }
}

 class PaymentProcessor {
    public void process(Payment payment) {
        payment.pay();
    }
}
