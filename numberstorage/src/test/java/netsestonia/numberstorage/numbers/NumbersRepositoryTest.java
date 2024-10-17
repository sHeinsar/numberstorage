package netsestonia.numberstorage.numbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.mockito.Mockito.*;

class NumbersRepositoryTest {

    NumbersRepository numbersRepository;

    List<Integer> list = Arrays.asList(1, 2, 3);

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
        assert entities.equals(expectedEntities);
    }

    @Test
    public void create() {
        numbersRepository.create(list);
        verify(numbersRepository, times(2)).create(list);
    }
}