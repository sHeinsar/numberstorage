package netsestonia.numberstorage.numbers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import netsestonia.numberstorage.numbers.entity.NumberEntity;

@Repository
public interface NumberRepository extends JpaRepository<NumberEntity, Long> {
}
