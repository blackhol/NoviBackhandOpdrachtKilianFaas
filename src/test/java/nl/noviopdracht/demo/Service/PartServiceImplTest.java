package nl.noviopdracht.demo.Service;

import nl.noviopdracht.demo.Model.Part;
import nl.noviopdracht.demo.Repository.PartRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class PartServiceImplTest {

    @Mock
    PartRepository partRepository;

    @InjectMocks
    private PartServiceImpl partService;

    @Captor
    ArgumentCaptor<Part> partCaptor;

    @Test
    void savePart() {
        //Arrange
        Part part = new Part();
        part.setPrice(15);
        part.setPartname("test");
        partRepository.save(part);
        //Act
        verify(partRepository, times(1)).save(partCaptor.capture());
        var part1 = partCaptor.getValue();
        //Assert
        assertThat(part1.getPartname()).isEqualTo("test");
        assertThat(part1.getPrice()).isEqualTo(15);
    }

    @Test
    void getAllParts() {
        List<Part> testParts = new ArrayList<>();

        Part part1 = new Part();
        part1.setPrice(10);
        part1.setPartname("test1");

        Part part2 = new Part();
        part2.setPrice(12);
        part2.setPartname("test2");

        Part part3 = new Part();
        part3.setPrice(13);
        part3.setPartname("test3");

        Part part4 = new Part();
        part4.setPrice(14);
        part4.setPartname("test4");

        testParts.add(part1);
        testParts.add(part2);
        testParts.add(part3);
        testParts.add(part4);

        //Act
        when(partRepository.findAll()).thenReturn(testParts);

        partService.getAllParts();
        //Assert
        assertThat(testParts.get(0)).isEqualTo(part1);
        assertThat(testParts.get(1)).isEqualTo(part2);
        assertThat(testParts.get(2)).isEqualTo(part3);
        assertThat(testParts.get(3)).isEqualTo(part4);

    }
}