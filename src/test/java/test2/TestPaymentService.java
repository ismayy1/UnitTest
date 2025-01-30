package test2;

import com.tpe.mockito1.PaymentManager;
import com.tpe.mockito1.PaymentService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TestPaymentService {

    @Test
    void testCheckPaymentStatus() {
        PaymentManager paymentManager = mock(PaymentManager.class);
        when(paymentManager.getPaymentStatus(123)).thenReturn("SUCCESS");
        when(paymentManager.getPaymentStatus(456)).thenReturn("FAILED");
        PaymentService paymentService = new PaymentService(paymentManager);

        String actualVal = paymentService.checkPaymentStatus(123);

        assertEquals("STATUS: SUCCESS", actualVal);

//        verify(paymentManager).getPaymentStatus(123);
        verify(paymentManager, times(1)).getPaymentStatus(123);
    }
}
