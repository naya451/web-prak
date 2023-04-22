package ru.msu.cmc.webprak.DAO;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import ru.msu.cmc.webprak.models.Goods_in_delivery;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestPropertySource(locations = "classpath:application.properties")
public class Goods_in_deliveryDAOTest {

    @Autowired
    private Goods_in_deliveryDAO Goods_in_deliveryDAO;
    @Autowired
    private DeliveriesDAO deliveriesDAO;

    @Test
    void testSimpleManipulations() {
        List<Goods_in_delivery> list_of_Goods_in_delivery = (List<Goods_in_delivery>) Goods_in_deliveryDAO.getAll();
        assertEquals(4, list_of_Goods_in_delivery.size());
        List<Goods_in_delivery> list_of_Goods_in_delivery2 = (List<Goods_in_delivery>) Goods_in_deliveryDAO.getAllGoods_in_delivery(deliveriesDAO.getById(7L));
        assertEquals(2, list_of_Goods_in_delivery2.size());
    }
}