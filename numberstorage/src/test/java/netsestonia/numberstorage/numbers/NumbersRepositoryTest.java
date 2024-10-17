package netsestonia.numberstorage.numbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class NumbersRepositoryTest {

    NumbersRepository numbersRepository;

    List<Integer> list = Arrays.asList(1, 2);

    @BeforeEach
    public void setUp() {
        numbersRepository = Mockito.mock(NumbersRepository.class);
        numbersRepository.create(list);
    }

    @Test
    public void findAll() {
        List<NumbersEntity> expectedEntities = Collections.emptyList();
        when(numbersRepository.findAll()).thenReturn(expectedEntities);
        List<NumbersEntity> entities = numbersRepository.findAll();
        assertEquals(expectedEntities, entities);
    }

    @Test
    public void findAllNonEmptyList() {
        List<NumbersEntity> expectedEntities = Arrays.asList(new NumbersEntity(1), new NumbersEntity(2));
        when(numbersRepository.findAll()).thenReturn(expectedEntities);
        List<NumbersEntity> entities = numbersRepository.findAll();
        assertEquals(expectedEntities, entities);
    }

    @Test
    public void create() {
        numbersRepository.create(list);
        verify(numbersRepository, times(2)).create(list);
    }

    @Test
    public void createWithNewList() {
        List<Integer> newList = Arrays.asList(3, 4, 5);
        numbersRepository.create(newList);
        // Verify that the create method was called with the new list argument
        verify(numbersRepository, times(1)).create(newList);
    }
}