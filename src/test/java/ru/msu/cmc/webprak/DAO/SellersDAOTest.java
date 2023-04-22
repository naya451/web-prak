package ru.msu.cmc.webprak.DAO;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import ru.msu.cmc.webprak.models.Sellers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestPropertySource(locations="classpath:application.properties")
public class SellersDAOTest {

    @Autowired
    private SellersDAO sellersDAO;
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Test
    void testSimpleManipulations() {
        List<Sellers> list_of_sellers = (List<Sellers>) sellersDAO.getAll();
        assertEquals(5, list_of_sellers.size());
        List<Sellers> all_sellers_name= sellersDAO.getAllSellersByName("Mike Smith");
        assertEquals(1, all_sellers_name.size());
        assertEquals("Mike Smith", all_sellers_name.get(0).getName());
        Sellers sellers_by_id = sellersDAO.getById(3L);
        assertEquals("Ally Gordon", sellers_by_id.getName());
        Sellers unreal_sellers= sellersDAO.getById(999L);
        assertNull(unreal_sellers);
        Sellers sellers_equal = sellersDAO.getSingleSellerByName("Ally Gordon");
        assertEquals(sellers_by_id, sellers_equal);
        Sellers unreal_sellers2 = sellersDAO.getSingleSellerByName("Penny Holland");
        assertNull(unreal_sellers2);
    }

    @Test
    void testSortings() {
        List<Sellers> sortSmiths = sellersDAO.getAllSellersByNameSortedWithNameASC("Smith");
        assertEquals(2, sortSmiths.size());
        assertEquals(1, sortSmiths.get(0).getId());
        assertEquals(5, sortSmiths.get(1).getId());
        sortSmiths = sellersDAO.getAllSellersByNameSortedWithNameDESC("Smith");
        assertEquals(2, sortSmiths.size());
        assertEquals(5, sortSmiths.get(0).getId());
        assertEquals(1, sortSmiths.get(1).getId());
    }


    @BeforeEach
    void beforeEach() {
        List<Sellers> sellersList = new ArrayList<>();
        sellersList.add(new Sellers(1L, "Mike Smith", null, null, null, "just a seller"));
        sellersList.add(new Sellers(2L, "Lavrenty", null, null, null, "MSU student"));
        sellersList.add(new Sellers(3L, "Ally Gordon", null, null, null, "another seller"));
        sellersList.add(new Sellers(4L, "Serkan Bolat", null, null, null, "Architector"));
        sellersList.add(new Sellers(5L, "Tom Smith", null, null, null, "Umbrella fan"));
        sellersDAO.saveCollection(sellersList);
        //List<Deliveries> deliveriesList = new ArrayList<>();
        //java.sql.Date tmp = new java.sql.Date(2022, 11, 5);
        //Deliveries t1 = new Deliveries(1L, tmp, sellersDAO.getSingleSellerByName("Mike Smith"), null, "Mike Smith");
        //deliveriesList.add(t1);
        //deliveriesList.add(new Deliveries(2L, new java.sql.Date(2021, 4, 5), sellersDAO.getSingleSellerByName("Mike Smith"), null, "Mike Smith"));
        //deliveriesList.add(new Deliveries(3L, new java.sql.Date(2022, 12, 5), sellersDAO.getSingleSellerByName("Mike Smith"), null, "Mike Smith"));
        //deliveriesList.add(new Deliveries(4L, new java.sql.Date(2022, 12, 10), sellersDAO.getSingleSellerByName("Ally Gordon"), null, "Ally Gordon"));
        //deliveriesList.add(new Deliveries(5L, new java.sql.Date(2020, 12, 10), sellersDAO.getSingleSellerByName("Ally Gordon"), null, "Ally Gordon"));
        //deliveriesDAO.saveCollection(deliveriesList);
    }

    @BeforeAll
    @AfterEach
    void annihilation() {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            //entityManager.createNativeQuery("TRUNCATE deliveries RESTART IDENTITY CASCADE;").executeUpdate();
            //entityManager.createNativeQuery("ALTER SEQUENCE deliveries_delivery_id_seq RESTART WITH 1;").executeUpdate();
            entityManager.createNativeQuery("TRUNCATE sellers RESTART IDENTITY CASCADE;").executeUpdate();
            entityManager.createNativeQuery("ALTER SEQUENCE sellers_seller_id_seq RESTART WITH 1;").executeUpdate();
            entityManager.getTransaction().commit();
        }
    }
}