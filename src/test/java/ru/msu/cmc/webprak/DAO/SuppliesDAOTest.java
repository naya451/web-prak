package ru.msu.cmc.webprak.DAO;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import ru.msu.cmc.webprak.models.Supplies;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestPropertySource(locations="classpath:application.properties")
public class SuppliesDAOTest {

    @Autowired
    private SuppliesDAO suppliesDAO;

    @Test
    void testSimpleManipulations() {
        List<Supplies> list_of_supplies = (List<Supplies>) suppliesDAO.getAll();
        assertEquals(11, list_of_supplies.size());
        List<Supplies> list_of_supplies2 = (List<Supplies>) suppliesDAO.getAllSupplies();
        assertEquals(11, list_of_supplies2.size());
        List<Supplies> all_sellers_supplies= suppliesDAO.getAllSuppliesBySeller("H&M");
        assertEquals(5, all_sellers_supplies.size());
        java.util.Date tmp1 = new java.util.Date(114, 00, 01);
        java.util.Date tmp2 = new java.util.Date(115, 00, 01);
        List<Supplies> suppliesin2014 = suppliesDAO.getAllSuppliesByPeriod(tmp1, tmp2);
        assertEquals(4, suppliesin2014.size());
    }

    @Test
    void testSortings() {
        java.util.Date tmp1 = new java.util.Date(114, 00, 01);
        java.util.Date tmp2 = new java.util.Date(115, 00, 01);
        List<Supplies> suppliesin2014sorted = suppliesDAO.getAllSuppliesByPeriodSortedWithDateASC(tmp1, tmp2);
        assertEquals(4, suppliesin2014sorted.size());
        assertEquals(7, suppliesin2014sorted.get(0).getId());
        suppliesin2014sorted = suppliesDAO.getAllSuppliesByPeriodSortedWithDateDESC(tmp1, tmp2);
        assertEquals(4, suppliesin2014sorted.size());
        assertEquals(7, suppliesin2014sorted.get(3).getId());
        suppliesin2014sorted = suppliesDAO.getAllSuppliesByPeriodSortedWithNumberOfGoodsASC(tmp1, tmp2);
        assertEquals(4, suppliesin2014sorted.size());
        assertEquals(7, suppliesin2014sorted.get(3).getId());
        suppliesin2014sorted = suppliesDAO.getAllSuppliesByPeriodSortedWithNumberOfGoodsDESC(tmp1, tmp2);
        assertEquals(4, suppliesin2014sorted.size());
        assertEquals(7, suppliesin2014sorted.get(0).getId());
        suppliesin2014sorted = suppliesDAO.getAllSuppliesByPeriodSortedWithSellerNameASC(tmp1, tmp2);
        assertEquals(4, suppliesin2014sorted.size());
        assertEquals("CROPP", suppliesin2014sorted.get(0).getSeller_name());
        suppliesin2014sorted = suppliesDAO.getAllSuppliesByPeriodSortedWithSellerNameDESC(tmp1, tmp2);
        assertEquals(4, suppliesin2014sorted.size());
        assertEquals("CROPP", suppliesin2014sorted.get(3).getSeller_name());
    }
}