package ru.msu.cmc.webprak.DAO;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import ru.msu.cmc.webprak.models.Sellers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestPropertySource(locations = "classpath:application.properties")
public class SellersDAOTest {

    @Autowired
    private SellersDAO sellersDAO;

    @Test
    void testSimpleManipulations() {
        List<Sellers> list_of_sellers = (List<Sellers>) sellersDAO.getAll();
        assertEquals(3, list_of_sellers.size());
        List<Sellers> list_of_sellers2 = (List<Sellers>) sellersDAO.getAllSellers();
        assertEquals(3, list_of_sellers2.size());
        List<Sellers> all_sellers_name = sellersDAO.getAllSellersByName("H&M home");
        assertEquals(1, all_sellers_name.size());
        assertEquals("H&M home", all_sellers_name.get(0).getName());
        Sellers sellers_by_id = sellersDAO.getById(3L);
        assertEquals("CROPP", sellers_by_id.getName());
        Sellers unreal_sellers = sellersDAO.getById(999L);
        assertNull(unreal_sellers);
        Sellers sellers_equal = sellersDAO.getSingleSellerByName("CROPP");
        assertEquals(sellers_by_id, sellers_equal);
        Sellers unreal_sellers2 = sellersDAO.getSingleSellerByName("Penny Holland");
        assertNull(unreal_sellers2);
    }

    @Test
    void testSortings() {
        List<Sellers> sortHandM = sellersDAO.getAllSellersByNameSortedWithNameASC("H&M");
        assertEquals(2, sortHandM.size());
        assertEquals(1, sortHandM.get(0).getId());
        assertEquals(2, sortHandM.get(1).getId());
        sortHandM = sellersDAO.getAllSellersByNameSortedWithNameDESC("H&M");
        assertEquals(2, sortHandM.size());
        assertEquals(2, sortHandM.get(0).getId());
        assertEquals(1, sortHandM.get(1).getId());
        List<Sellers> sortHandMWithYearsSupplies = sellersDAO.getAllSellersByNameSortedWithYearsSuppliesASC("H&M");
        assertEquals(2, sortHandMWithYearsSupplies.size());
        assertEquals(1, sortHandMWithYearsSupplies.get(0).getId());
        assertEquals(2, sortHandMWithYearsSupplies.get(1).getId());
        sortHandMWithYearsSupplies = sellersDAO.getAllSellersByNameSortedWithYearsSuppliesDESC("H&M");
        assertEquals(2, sortHandMWithYearsSupplies.size());
        assertEquals(2, sortHandMWithYearsSupplies.get(0).getId());
        assertEquals(1, sortHandMWithYearsSupplies.get(1).getId());
        List<Sellers> sortHandMWithSupplies = sellersDAO.getAllSellersByNameSortedWithSuppliesASC("H&M");
        assertEquals(2, sortHandMWithSupplies.size());
        assertEquals(2, sortHandMWithSupplies.get(0).getId());
        assertEquals(1, sortHandMWithSupplies.get(1).getId());
        sortHandMWithSupplies = sellersDAO.getAllSellersByNameSortedWithSuppliesDESC("H&M");
        assertEquals(2, sortHandMWithSupplies.size());
        assertEquals(1, sortHandMWithSupplies.get(0).getId());
        assertEquals(2, sortHandMWithSupplies.get(1).getId());
    }
}