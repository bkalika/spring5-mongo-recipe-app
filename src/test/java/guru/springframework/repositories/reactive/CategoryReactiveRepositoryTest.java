package guru.springframework.repositories.reactive;

import guru.springframework.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by bogdan.kalika@gmail.com
 * Date: 4/24/2024
 */
@ExtendWith(SpringExtension.class)
@DataMongoTest
public class CategoryReactiveRepositoryTest {

    private final CategoryReactiveRepository categoryReactiveRepository;

    @Autowired
    public CategoryReactiveRepositoryTest(CategoryReactiveRepository categoryReactiveRepository) {
        this.categoryReactiveRepository = categoryReactiveRepository;
    }

    @BeforeEach
    public void setUp() {
        categoryReactiveRepository.deleteAll().block();
    }

    @Test
    public void testSave() {
        Category category = new Category();
        category.setDescription("Foo");

        categoryReactiveRepository.save(category).block();

        Long count = categoryReactiveRepository.count().block();

        assertEquals(Long.valueOf(1L), count);
    }

    @Test
    public void testFindByDescription() {
        Category category = new Category();
        category.setDescription("Foo");

        categoryReactiveRepository.save(category).then().block();

        Category fetchedCategory = categoryReactiveRepository.findByDescription("Foo").block();

        assertNotNull(fetchedCategory.getId());
    }
}
