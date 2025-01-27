package com.tpe.mockito1;

public class PaymentService {

//    Constructor injection
    private PaymentManager paymentManager;

    public PaymentService(PaymentManager paymentManager) {
        this.paymentManager = paymentManager;
    }

    public String checkPaymentStatus(int id) {
        String string = "STATUS: ";
        String status = paymentManager.getPaymentStatus(id);
        return string + status;
//        return "STATUS: " + paymentManager.getPaymentStatus(id);
    }
}
