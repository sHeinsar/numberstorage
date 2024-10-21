package netsestonia.numberstorage.numbers;

import netsestonia.numberstorage.numbers.controller.NumberController;
import netsestonia.numberstorage.numbers.dto.NumberRequestDto;
import netsestonia.numberstorage.numbers.service.NumberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class NumberControllerTest {

    @Mock
    private NumberService numberService;

    @InjectMocks
    private NumberController numberController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetNumbers() {
        when(numberService.getAllNumbers()).thenReturn(Arrays.asList(1, 2, 3));

        ResponseEntity<List<Integer>> response = numberController.getNumbers();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(Arrays.asList(1, 2, 3), response.getBody());
    }

    @Test
    void testAddNumbers() {
        NumberRequestDto requestDto = new NumberRequestDto();
        requestDto.setNumbers(Arrays.asList(1, 2, 3));

        ResponseEntity<String> response = numberController.addNumbers(requestDto);

        verify(numberService).saveNumbers(requestDto.getNumbers());
        assertEquals(201, response.getStatusCodeValue());
        assertEquals("Numbers added successfully", response.getBody());
    }

    @Test
    void testHandleException() {
        Exception e = new Exception("Some error occurred");

        ResponseEntity<String> response = numberController.handleException(e);

        assertEquals(500, response.getStatusCodeValue());
        assertEquals("An error occurred: Some error occurred", response.getBody());
    }
}
