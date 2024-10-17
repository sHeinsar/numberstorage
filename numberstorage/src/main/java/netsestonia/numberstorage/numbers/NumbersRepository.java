package netsestonia.numberstorage.numbers;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NumbersRepository {

    private final JdbcClient jdbcClient;

    public NumbersRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<NumbersEntity> findAll() {
        return jdbcClient.sql("SELECT * FROM Numbers")
                .query(NumbersEntity.class)
                .list();
    }

    public void create(List<Integer> numbers) {
        for (Integer number : numbers) {
            jdbcClient.sql("INSERT INTO Numbers(numbers) values(?)")
                    .param(number)
                    .update();
        }
    }
}
