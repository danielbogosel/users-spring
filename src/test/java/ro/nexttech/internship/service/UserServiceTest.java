package ro.nexttech.internship.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.nexttech.internship.model.User;
import ro.nexttech.internship.model.UserDto;
import ro.nexttech.internship.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @InjectMocks
    UserService classUnderTest;
    @Mock
    UserRepository userRepository;
    public static final int RANDOM_ID = 1234;

    @Test
    public void getAllUsersExpectSuccess() {
        List<User> mockUserList = getMockUserList();
        when(userRepository.findAll()).thenReturn(mockUserList);
        List<UserDto> response = classUnderTest.getAllUsers();
        assertEquals(response.get(0).getUsername(), mockUserList.get(0).getUsername());
    }

//    @Test
//    public void createUserExpectSuccess() {
//        UserDto mockUserDto = getMockUserDto();
//        User mockUser = getMockUser();
//        when(userRepository.save(mockUser)).thenReturn(mockUserDto);
//        UserDto response = classUnderTest.createUser(mockUserDto);
//        verify(userRepository, times(1)).save(mockUser);
//        assertEquals(response.getUsername(), mockUser.getUsername());
//    }

    @Test
    public void getUserByIdExpectSuccess() {
        Optional<User> mockUser = Optional.of(getMockUser());
        when(userRepository.findById(RANDOM_ID)).thenReturn(mockUser);
        Optional<UserDto> response = classUnderTest.getUserById(RANDOM_ID);
        assertEquals(response.get().getUsername(), mockUser.get().getUsername());
    }

    //@Test
//    public void getUserByIdExpectNull() {
//        int mockId = 123;
//        Optional<User> mockUser = Optional.of(getMockUser());
//        when(userRepository.findById(mockId)).thenReturn(null);
//        Optional<UserDto> response = classUnderTest.getUserById(mockId);
//        assertNull(response);
//    }

    @Test
    public void deleteUserExpectSuccess() {
        User mockUser = getMockUser();
        when(userRepository.findById(RANDOM_ID)).thenReturn(Optional.of(mockUser));
        UserDto response = classUnderTest.deleteUser(RANDOM_ID);
        verify(userRepository, times(1)).delete(mockUser);
        assertEquals(response.getUsername(), mockUser.getUsername());
    }

    private List<User> getMockUserList() {
        List<User> mockUser = new ArrayList<>();
        User user = new User();
        user.setId(1234);
        user.setUsername("randomUsername");
        user.setPassword("randomPassword");
        user.setEmail("randomEmail");
        user.setUserRole("randomRole");
        user.setCompanyId(1234);
        mockUser.add(user);
        return mockUser;
    }

    private User getMockUser() {
        User user = new User();
        user.setId(1234);
        user.setUsername("randomUsername");
        user.setPassword("randomPassword");
        user.setEmail("randomEmail");
        user.setUserRole("randomRole");
        user.setCompanyId(1234);
        return user;
    }

    private UserDto getMockUserDto() {
        UserDto userDto = new UserDto();
        userDto.setUsername("randomUsername");
        userDto.setPassword("randomPassword");
        userDto.setEmail("random");
        userDto.setUserRole("randomRole");
        return userDto;
    }
}