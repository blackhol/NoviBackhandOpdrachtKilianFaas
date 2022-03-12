package nl.noviopdracht.demo.Service;

import nl.noviopdracht.demo.Model.Action;
import nl.noviopdracht.demo.Repository.ActionRepository;
import nl.noviopdracht.demo.Service.ActionServiceImpl;
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
public class ActionServiceImplTest {

    @Mock
    ActionRepository actionRepository;

    @InjectMocks
    private ActionServiceImpl actionService;

    @Captor
    ArgumentCaptor<Action> actionCaptor;

    @Test
    public void getActionTest(){
        // Arrange
        List<Action> testActions = new ArrayList<>();

        Action action1 = new Action();
        action1.setActionInt(1L);
        action1.setName("test");

        Action action2 = new Action();
        action2.setActionInt(2L);
        action2.setName("test2");

        Action action3 = new Action();
        action3.setActionInt(3L);
        action3.setName("test3");

        testActions.add(action1);
        testActions.add(action2);
        testActions.add(action3);

        // Act
        when(actionRepository.findAll()).thenReturn(testActions);

        actionService.getAllActions();
        // Assert
        assertThat(testActions.get(0)).isEqualTo(action1);
        assertThat(testActions.get(1)).isEqualTo(action2);
        assertThat(testActions.get(2)).isEqualTo(action3);
    }
    @Test
    public void actionSaveTest(){
        //Arrange
        Action action = new Action();
        action.setName("test");
        action.setActionInt(1L);
        actionRepository.save(action);
        //Act
        verify(actionRepository, times(1)).save(actionCaptor.capture());
        var action1 = actionCaptor.getValue();
        //Assert
        assertThat(action1.getName()).isEqualTo("test");
        assertThat(action1.getActionInt()).isEqualTo(1);
    }
}