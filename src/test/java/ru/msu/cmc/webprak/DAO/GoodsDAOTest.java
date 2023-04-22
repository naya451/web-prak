package ru.msu.cmc.webprak.DAO;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import ru.msu.cmc.webprak.models.Goods;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestPropertySource(locations = "classpath:application.properties")
public class GoodsDAOTest {

    @Autowired
    private GoodsDAO goodsDAO;

    @Test
    void testSimpleManipulations() {
        List<Goods> list_of_goods = (List<Goods>) goodsDAO.getAll();
        assertEquals(3, list_of_goods.size());
        List<Goods> list_of_goods2 = (List<Goods>) goodsDAO.getAllGoods();
        assertEquals(3, list_of_goods2.size());
        List<Goods> all_goods_name = goodsDAO.getAllGoodsByName("jeans");
        assertEquals(2, all_goods_name.size());
        Goods goods_by_id = goodsDAO.getById(3L);
        assertEquals("chocolate", goods_by_id.getName());
        Goods unreal_goods = goodsDAO.getById(999L);
        assertNull(unreal_goods);
        Goods goods_equal = goodsDAO.getSingleGoodByName("chocolate");
        assertEquals(goods_by_id, goods_equal);
        Goods unreal_goods2 = goodsDAO.getSingleGoodByName("socks example");
        assertNull(unreal_goods2);
    }

    @Test
    void testSortings() {
        List<Goods> sortJeans = goodsDAO.getAllGoodsByNameSortedWithNameASC("jeans");
        assertEquals(2, sortJeans.size());
        assertEquals(2, sortJeans.get(0).getId());
        assertEquals(1, sortJeans.get(1).getId());
        sortJeans = goodsDAO.getAllGoodsByNameSortedWithNameDESC("jeans");
        assertEquals(2, sortJeans.size());
        assertEquals(1, sortJeans.get(0).getId());
        assertEquals(2, sortJeans.get(1).getId());
        List<Goods> sortJeansWithTimeOfKeeping = goodsDAO.getAllGoodsByNameSortedWithTimeOfKeepingASC("jeans");
        assertEquals(2, sortJeansWithTimeOfKeeping.size());
        sortJeansWithTimeOfKeeping = goodsDAO.getAllGoodsByNameSortedWithTimeOfKeepingDESC("jeans");
        assertEquals(2, sortJeansWithTimeOfKeeping.size());
        List<Goods> sortJeansWithAvailability = goodsDAO.getAllGoodsByNameSortedWithAvailabilityASC("jeans");
        assertEquals(2, sortJeansWithAvailability.size());
        assertEquals(1, sortJeansWithAvailability.get(0).getId());
        assertEquals(2, sortJeansWithAvailability.get(1).getId());
        sortJeansWithAvailability = goodsDAO.getAllGoodsByNameSortedWithAvailabilityDESC("jeans");
        assertEquals(2, sortJeansWithAvailability.size());
        assertEquals(2, sortJeansWithAvailability.get(0).getId());
        assertEquals(1, sortJeansWithAvailability.get(1).getId());
    }
}