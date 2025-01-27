package test2;

import com.tpe.mockito1.PaymentManager;
import com.tpe.mockito1.PaymentService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestPaymentService {

    @Test
    void testCheckPaymentStatus() {
        PaymentManager paymentManager = mock(PaymentManager.class);
        when(paymentManager.getPaymentStatus(123)).thenReturn("SUCCESS");
        PaymentService paymentService = new PaymentService(paymentManager);
    }
}
