package netsestonia.numberstorage.numbers.dto;

import lombok.Data;

import java.util.List;

@Data
public class NumberRequestDto {
    private List<Integer> numbers;
}
