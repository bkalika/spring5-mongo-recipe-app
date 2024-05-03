package guru.springframework.controllers;

import guru.springframework.config.WebConfig;
import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.server.RouterFunction;
import reactor.core.publisher.Flux;

import static reactor.core.publisher.Mono.when;

/**
 * Created by bogdan.kalika@gmail.com
 * Date: 5/3/2024
 */
@SpringBootTest
@AutoConfigureWebTestClient
public class RouterFunctionTest {

    WebTestClient webTestClient;

    RecipeService recipeService;

    @Autowired
    WebConfig webConfig;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

//        webTestClient = WebTestClient
//                .bindToRouterFunction(webConfig.router(recipeService))
//                .build();
    }

    @Test
    public void testGetRecipes() {
        when(recipeService.getRecipes()).thenReturn(Flux.just());

        webTestClient.get().uri("/api/recipes")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void testGetRecipesWithData() {
        when(recipeService.getRecipes()).thenReturn(Flux.just(new Recipe(), new Recipe()));

        webTestClient.get().uri("/api/recipes")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Recipe.class);
    }
}
