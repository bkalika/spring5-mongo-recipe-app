//package guru.springframework.repositories;
//
//import guru.springframework.domain.UnitOfMeasure;
//import guru.springframework.repositories.reactive.UnitOfMeasureReactiveRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
///**
// * Created by jt on 6/17/17.
// */
//@Disabled
//@ExtendWith(SpringExtension.class)
//@DataMongoTest
//public class UnitOfMeasureRepositoryIT {
//
//    @Autowired
//    UnitOfMeasureReactiveRepository unitOfMeasureReactiveRepository;
//
//    @BeforeEach
//    public void setUp() throws Exception {
//    }
//
//    @Test
//    public void findByDescription() {
//
//        UnitOfMeasure uom = unitOfMeasureReactiveRepository.findByDescription("Teaspoon").block();
//
//        assertEquals("Teaspoon", uom.getDescription());
//    }
//
//    @Test
//    public void findByDescriptionCup() {
//
//        UnitOfMeasure uom = unitOfMeasureReactiveRepository.findByDescription("Cup").block();
//
//        assertEquals("Cup", uom.getDescription());
//    }
//}