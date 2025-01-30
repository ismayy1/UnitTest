package com.tpe.mockito1;

public class PaymentManager {

    public String getPaymentStatus(int paymentId) {
        if (paymentId == 123) {
            return "SSSSS";
        } else if (paymentId == 456) {
            return "FAILED";
        } else {
            return "UNKNOWN";
        }
    }
}
