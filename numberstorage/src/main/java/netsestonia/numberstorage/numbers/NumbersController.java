package netsestonia.numberstorage.numbers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/numbers")
public class NumbersController {
    private final NumbersRepository numbersRepository;

    public NumbersController(NumbersRepository numbersRepository) {
        this.numbersRepository = numbersRepository;
    }

    @GetMapping("")
    public List<NumbersEntity> findAll() {
        return numbersRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody List<Integer> numbersEntity) {
        numbersRepository.create(numbersEntity);
    }

}
