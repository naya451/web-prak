package ru.msu.cmc.webprak.DAO;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import ru.msu.cmc.webprak.models.Goods_in_supply;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestPropertySource(locations = "classpath:application.properties")
public class Goods_in_supplyDAOTest {

    @Autowired
    private Goods_in_supplyDAO Goods_in_supplyDAO;
    @Autowired
    private SuppliesDAO suppliesDAO;

    @Test
    void testSimpleManipulations() {
        List<Goods_in_supply> list_of_Goods_in_supply = (List<Goods_in_supply>) Goods_in_supplyDAO.getAll();
        assertEquals(4, list_of_Goods_in_supply.size());
        List<Goods_in_supply> list_of_Goods_in_supply2 = (List<Goods_in_supply>) Goods_in_supplyDAO.getAllGoods_in_supply(suppliesDAO.getById(7L));
        assertEquals(2, list_of_Goods_in_supply2.size());
    }
}