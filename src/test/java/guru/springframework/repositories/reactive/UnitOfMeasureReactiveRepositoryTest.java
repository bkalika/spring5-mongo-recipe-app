package guru.springframework.repositories.reactive;

import guru.springframework.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by bogdan.kalika@gmail.com
 * Date: 4/24/2024
 */
@ExtendWith(SpringExtension.class)
@DataMongoTest
public class UnitOfMeasureReactiveRepositoryTest {

    private static final String EACH = "Each";

    private final UnitOfMeasureReactiveRepository unitOfMeasureReactiveRepository;

    @Autowired
    public UnitOfMeasureReactiveRepositoryTest(UnitOfMeasureReactiveRepository unitOfMeasureReactiveRepository) {
        this.unitOfMeasureReactiveRepository = unitOfMeasureReactiveRepository;
    }

    @BeforeEach
    public void setUp() {
        unitOfMeasureReactiveRepository.deleteAll().block();
    }

    @Test
    public void testSaveUom() {
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setDescription(EACH);

        unitOfMeasureReactiveRepository.save(uom).block();

        Long count = unitOfMeasureReactiveRepository.count().block();

        assertEquals(Long.valueOf(1L), count);
    }

    @Test
    public void testFindByDescription() {
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setDescription(EACH);

        unitOfMeasureReactiveRepository.save(uom).block();

        UnitOfMeasure fetchedUOM = unitOfMeasureReactiveRepository.findByDescription("Each").block();

        assertEquals(EACH, fetchedUOM.getDescription());
    }
}
