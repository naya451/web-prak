package ru.msu.cmc.webprak.DAO;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import ru.msu.cmc.webprak.models.Deliveries;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestPropertySource(locations="classpath:application.properties")
public class DeliveriesDAOTest {

    @Autowired
    private DeliveriesDAO deliveriesDAO;

    @Test
    void testSimpleManipulations() {
        List<Deliveries> list_of_deliveries = (List<Deliveries>) deliveriesDAO.getAll();
        assertEquals(11, list_of_deliveries.size());
        List<Deliveries> list_of_deliveries2 = (List<Deliveries>) deliveriesDAO.getAllDeliveries();
        assertEquals(11, list_of_deliveries2.size());
        List<Deliveries> all_buyers_deliveries= deliveriesDAO.getAllDeliveriesByBuyer("Mike Smith");
        assertEquals(5, all_buyers_deliveries.size());
        java.util.Date tmp1 = new java.util.Date(114, 00, 01);
        java.util.Date tmp2 = new java.util.Date(115, 00, 01);
        List<Deliveries> deliveriesin2014 = deliveriesDAO.getAllDeliveriesByPeriod(tmp1, tmp2);
        assertEquals(4, deliveriesin2014.size());
    }

    @Test
    void testSortings() {
        java.util.Date tmp1 = new java.util.Date(114, 00, 01);
        java.util.Date tmp2 = new java.util.Date(115, 00, 01);
        List<Deliveries> deliveriesin2014sorted = deliveriesDAO.getAllDeliveriesByPeriodSortedWithDateASC(tmp1, tmp2);
        assertEquals(4, deliveriesin2014sorted.size());
        assertEquals(7, deliveriesin2014sorted.get(0).getId());
        deliveriesin2014sorted = deliveriesDAO.getAllDeliveriesByPeriodSortedWithDateDESC(tmp1, tmp2);
        assertEquals(4, deliveriesin2014sorted.size());
        assertEquals(7, deliveriesin2014sorted.get(3).getId());
        deliveriesin2014sorted = deliveriesDAO.getAllDeliveriesByPeriodSortedWithNumberOfGoodsASC(tmp1, tmp2);
        assertEquals(4, deliveriesin2014sorted.size());
        assertEquals(7, deliveriesin2014sorted.get(3).getId());
        deliveriesin2014sorted = deliveriesDAO.getAllDeliveriesByPeriodSortedWithNumberOfGoodsDESC(tmp1, tmp2);
        assertEquals(4, deliveriesin2014sorted.size());
        assertEquals(7, deliveriesin2014sorted.get(0).getId());
        deliveriesin2014sorted = deliveriesDAO.getAllDeliveriesByPeriodSortedWithBuyerNameASC(tmp1, tmp2);
        assertEquals(4, deliveriesin2014sorted.size());
        assertEquals("Ally Mads", deliveriesin2014sorted.get(0).getBuyer_name());
        deliveriesin2014sorted = deliveriesDAO.getAllDeliveriesByPeriodSortedWithBuyerNameDESC(tmp1, tmp2);
        assertEquals(4, deliveriesin2014sorted.size());
        assertEquals("Ally Mads", deliveriesin2014sorted.get(3).getBuyer_name());
    }
}