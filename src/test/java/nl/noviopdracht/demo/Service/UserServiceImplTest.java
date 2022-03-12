package nl.noviopdracht.demo.Service;

import nl.noviopdracht.demo.Model.User;
import nl.noviopdracht.demo.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Captor
    ArgumentCaptor<User> userCaptor;

    @Test
    void gettAllUsers() {
        //Arrange
        List<User> userList = new ArrayList<>();

        User user1 = new User();
        user1.setId(1L);
        user1.setName("test1");

        User user2 = new User();
        user2.setId(2L);
        user2.setName("test2");

        User user3 = new User();
        user3.setId(3L);
        user3.setName("test3");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        //Act
        when(userRepository.findAll()).thenReturn(userList);

        userService.gettAllUsers();
        //Assert
        assertThat(userList.get(0)).isEqualTo(user1);
        assertThat(userList.get(1)).isEqualTo(user2);
        assertThat(userList.get(2)).isEqualTo(user3);


    }

    @Test
    void saveUser() {
        //Arrange
        User user = new User();
        user.setName("test");
        user.setId(1L);
        userRepository.save(user);
        //Act
        verify(userRepository, times(1)).save(userCaptor.capture());
        var user1 = userCaptor.getValue();
        //Assert
        assertThat(user1.getName()).isEqualTo("test");
        assertThat(user1.getId()).isEqualTo(1L);

    }
}