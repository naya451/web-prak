package ru.msu.cmc.webprak.DAO;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import ru.msu.cmc.webprak.models.Warehouse_condition;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestPropertySource(locations = "classpath:application.properties")
public class Warehouse_conditionDAOTest {

    @Autowired
    private Warehouse_conditionDAO Warehouse_conditionDAO;
    @Autowired
    private GoodsDAO goodsDAO;

    @Test
    void testSimpleManipulations() {
        List<Warehouse_condition> PlacesByType = Warehouse_conditionDAO.getGetNotFreePositionsByType("smth");
        assertNull(PlacesByType);
        List<Warehouse_condition> PlacesForGood = (List<Warehouse_condition>) Warehouse_conditionDAO.getPlaces(goodsDAO.getById(2L));
        assertEquals(2, PlacesForGood.size());
    }
}