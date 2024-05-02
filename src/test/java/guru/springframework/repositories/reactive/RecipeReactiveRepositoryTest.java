package guru.springframework.repositories.reactive;

import guru.springframework.domain.Recipe;
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
public class RecipeReactiveRepositoryTest {

    private final RecipeReactiveRepository recipeReactiveRepository;

    @Autowired
    public RecipeReactiveRepositoryTest(RecipeReactiveRepository recipeReactiveRepository) {
        this.recipeReactiveRepository = recipeReactiveRepository;
    }

    @BeforeEach
    public void setUp() {
        recipeReactiveRepository.deleteAll().block();
    }

    @Test
    public void testRecipeSave() {
        Recipe recipe = new Recipe();
        recipe.setDescription("Yummy");

        recipeReactiveRepository.save(recipe).block();

        Long count = recipeReactiveRepository.count().block();

        assertEquals(Long.valueOf(1L), count);
    }
}
