package netsestonia.numberstorage.numbers.controller;

import netsestonia.numberstorage.numbers.dto.NumberRequestDto;
import netsestonia.numberstorage.numbers.service.NumberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/numbers")
public class NumberController {

    private final NumberService numberService;

    public NumberController(NumberService numberService) {
        this.numberService = numberService;
    }

    @GetMapping
    public ResponseEntity<List<Integer>> getNumbers() {
        List<Integer> numbers = numberService.getAllNumbers();
        return ResponseEntity.ok(numbers);
    }

    @PostMapping
    public ResponseEntity<String> addNumbers(@RequestBody NumberRequestDto request) {
        numberService.saveNumbers(request.getNumbers());
        return ResponseEntity.status(201).body("Numbers added successfully");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(500).body("An error occurred: " + e.getMessage());
    }
}
