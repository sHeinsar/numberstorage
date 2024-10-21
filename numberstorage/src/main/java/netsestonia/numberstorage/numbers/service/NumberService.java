package netsestonia.numberstorage.numbers.service;

import netsestonia.numberstorage.numbers.entity.NumberEntity;
import netsestonia.numberstorage.numbers.repository.NumberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class NumberService {

    private final NumberRepository numberRepository;

    public NumberService(NumberRepository numberRepository) {
        this.numberRepository = numberRepository;
    }

    @Transactional
    public void saveNumbers(List<Integer> numbers) {
        List<NumberEntity> numberEntities = numbers.stream()
                .filter(Objects::nonNull)
                .map(NumberEntity::new)
                .collect(Collectors.toList());

        if (numberEntities.isEmpty()) {
            throw new IllegalArgumentException("At least one valid number must be provided");
        }

        numberRepository.saveAll(numberEntities);
    }

    public List<Integer> getAllNumbers() {
        return numberRepository.findAll().stream()
                .map(NumberEntity::getNumber)
                .collect(Collectors.toList());
    }
}
