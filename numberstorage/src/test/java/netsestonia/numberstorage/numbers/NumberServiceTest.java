package netsestonia.numberstorage.numbers;

import netsestonia.numberstorage.numbers.entity.NumberEntity;
import netsestonia.numberstorage.numbers.repository.NumberRepository;
import netsestonia.numberstorage.numbers.service.NumberService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class NumberServiceTest {

    @Mock
    private NumberRepository numberRepository;

    @InjectMocks
    private NumberService numberService;

    public NumberServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveNumbers_Success() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        numberService.saveNumbers(numbers);

        verify(numberRepository).saveAll(argThat(entities -> {
            List<NumberEntity> entityList = (List<NumberEntity>) entities;
            return entityList.size() == 3 &&
                    entityList.get(0).getNumber() == 1 &&
                    entityList.get(1).getNumber() == 2 &&
                    entityList.get(2).getNumber() == 3;
        }));
    }


    @Test
    void testGetAllNumbers() {
        NumberEntity numberEntity1 = new NumberEntity(1);
        numberEntity1.setNumber(1);
        NumberEntity numberEntity2 = new NumberEntity(2);
        numberEntity2.setNumber(2);

        when(numberRepository.findAll()).thenReturn(Arrays.asList(numberEntity1, numberEntity2));

        var result = numberService.getAllNumbers();

        assertEquals(Arrays.asList(1, 2), result);
    }
}
