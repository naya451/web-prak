package ru.msu.cmc.webprak.DAO;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import ru.msu.cmc.webprak.models.Buyers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestPropertySource(locations = "classpath:application.properties")
public class BuyersDAOTest {

    @Autowired
    private BuyersDAO buyersDAO;

    @Test
    void testSimpleManipulations() {
        List<Buyers> list_of_buyers = (List<Buyers>) buyersDAO.getAll();
        assertEquals(3, list_of_buyers.size());
        List<Buyers> list_of_buyers2 = (List<Buyers>) buyersDAO.getAllBuyers();
        assertEquals(3, list_of_buyers2.size());
        List<Buyers> all_buyers_name = buyersDAO.getAllBuyersByName("Mike Smith");
        assertEquals(1, all_buyers_name.size());
        assertEquals("Mike Smith", all_buyers_name.get(0).getName());
        Buyers buyers_by_id = buyersDAO.getById(3L);
        assertEquals("Ally Mads", buyers_by_id.getName());
        Buyers unreal_buyers = buyersDAO.getById(999L);
        assertNull(unreal_buyers);
        Buyers buyers_equal = buyersDAO.getSingleBuyerByName("Ally Mads");
        assertEquals(buyers_by_id, buyers_equal);
        Buyers unreal_buyers2 = buyersDAO.getSingleBuyerByName("Penny Holland");
        assertNull(unreal_buyers2);
    }

    @Test
    void testSortings() {
        List<Buyers> sortSmiths = buyersDAO.getAllBuyersByNameSortedWithNameASC("Smith");
        assertEquals(2, sortSmiths.size());
        assertEquals(1, sortSmiths.get(0).getId());
        assertEquals(2, sortSmiths.get(1).getId());
        sortSmiths = buyersDAO.getAllBuyersByNameSortedWithNameDESC("Smith");
        assertEquals(2, sortSmiths.size());
        assertEquals(2, sortSmiths.get(0).getId());
        assertEquals(1, sortSmiths.get(1).getId());
        List<Buyers> sortSmithsWithYearsDeliveries = buyersDAO.getAllBuyersByNameSortedWithYearsDeliveriesASC("Smith");
        assertEquals(2, sortSmithsWithYearsDeliveries.size());
        assertEquals(1, sortSmithsWithYearsDeliveries.get(0).getId());
        assertEquals(2, sortSmithsWithYearsDeliveries.get(1).getId());
        sortSmithsWithYearsDeliveries = buyersDAO.getAllBuyersByNameSortedWithYearsDeliveriesDESC("Smith");
        assertEquals(2, sortSmithsWithYearsDeliveries.size());
        assertEquals(2, sortSmithsWithYearsDeliveries.get(0).getId());
        assertEquals(1, sortSmithsWithYearsDeliveries.get(1).getId());
        List<Buyers> sortSmithsWithDeliveries = buyersDAO.getAllBuyersByNameSortedWithDeliveriesASC("Smith");
        assertEquals(2, sortSmithsWithDeliveries.size());
        assertEquals(2, sortSmithsWithDeliveries.get(0).getId());
        assertEquals(1, sortSmithsWithDeliveries.get(1).getId());
        sortSmithsWithDeliveries = buyersDAO.getAllBuyersByNameSortedWithDeliveriesDESC("Smith");
        assertEquals(2, sortSmithsWithDeliveries.size());
        assertEquals(1, sortSmithsWithDeliveries.get(0).getId());
        assertEquals(2, sortSmithsWithDeliveries.get(1).getId());
    }
}