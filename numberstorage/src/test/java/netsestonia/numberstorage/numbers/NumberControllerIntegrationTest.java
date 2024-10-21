package netsestonia.numberstorage.numbers;

import netsestonia.numberstorage.numbers.dto.NumberRequestDto;
import netsestonia.numberstorage.numbers.entity.NumberEntity;
import netsestonia.numberstorage.numbers.repository.NumberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class NumberControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private NumberRepository numberRepository;

    @BeforeEach
    void setUp() {
        numberRepository.deleteAll();
    }

    @Test
    void testAddNumbers() throws Exception {
        NumberRequestDto requestDto = new NumberRequestDto();
        requestDto.setNumbers(List.of(1, 2, 3));

        mockMvc.perform(post("/numbers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"numbers\":[1,2,3]}"))
                .andExpect(status().isCreated())
                .andExpect(content().string("Numbers added successfully"));

        List<NumberEntity> savedNumbers = numberRepository.findAll();
        assertEquals(3, savedNumbers.size());
    }

    @Test
    void testGetNumbers() throws Exception {
        numberRepository.save(new NumberEntity(1));
        numberRepository.save(new NumberEntity(2));
        numberRepository.save(new NumberEntity(3));

        mockMvc.perform(get("/numbers"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0]").value(1))
                .andExpect(jsonPath("$[1]").value(2))
                .andExpect(jsonPath("$[2]").value(3));
    }
}
