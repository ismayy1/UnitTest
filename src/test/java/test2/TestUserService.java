package test2;

import com.tpe.mockito2.UserRepository;
import com.tpe.mockito2.UserService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class TestUserService {

//    Test getUser
//    1- id=1 -> "Dear bobSmith"
//    2- call getUserName only once
//    3- id=99 -> RuntimeException

    @Test
    void testGetUser() {

        UserRepository userRepository = mock(UserRepository.class);

        when(userRepository.getUserName(1)).thenReturn("bobSmith");
        when(userRepository.getUserName(99)).thenReturn(null);

        UserService userService = new UserService(userRepository);

        String userName = userService.getUser(1);

        assertEquals("Dear bobSmith", userName);
//        verify(userRepository).getUserName(1);

        assertThrows(RuntimeException.class, () -> userService.getUser(99));
        verify(userRepository).getUserName(99);
    }
}
