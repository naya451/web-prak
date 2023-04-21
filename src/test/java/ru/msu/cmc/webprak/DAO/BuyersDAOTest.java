package ru.msu.cmc.webprak.DAO;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import ru.msu.cmc.webprak.models.Buyers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestPropertySource(locations="classpath:application.properties")
public class BuyersDAOTest {

    @Autowired
    private BuyersDAO buyersDAO;
    @Autowired
    private EntityManagerFactory entityManagerFactory;
    
    @Test
    void testSimpleManipulations() {
        List<Buyers> list_of_buyers = (List<Buyers>) buyersDAO.getAll();
        assertEquals(5, list_of_buyers.size());
        List<Buyers> all_buyers_name= buyersDAO.getAllBuyersByName("Mike Smith");
        assertEquals(1, all_buyers_name.size());
        assertEquals("Mike Smith", all_buyers_name.get(0).getName());
        Buyers buyers_by_id = buyersDAO.getById(3L);
        assertEquals("Ally Gordon", buyers_by_id.getName());
        Buyers unreal_buyers= buyersDAO.getById(999L);
        assertNull(unreal_buyers);
        Buyers buyers_equal = buyersDAO.getSingleBuyerByName("Ally Gordon");
        assertEquals(buyers_by_id, buyers_equal);
        Buyers unreal_buyers2 = buyersDAO.getSingleBuyerByName("Penny Holland");
        assertNull(unreal_buyers2);
    }

    @BeforeEach
    void beforeEach() {
        List<Buyers> buyersList = new ArrayList<>();
        buyersList.add(new Buyers(1L, "Mike Smith", null, null, null, "just a buyer"));
        buyersList.add(new Buyers(2L, "Lavrenty", null, null, null, "MSU student"));
        buyersList.add(new Buyers(3L, "Ally Gordon", null, null, null, "another buyer"));
        buyersList.add(new Buyers(4L, "Serkan Bolat", null, null, null, "Architector"));
        buyersList.add(new Buyers(5L, "Tom Holland", null, null, null, "Umbrella fan"));
        buyersDAO.saveCollection(buyersList);
    }

    @BeforeAll
    @AfterEach
    void annihilation() {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.createNativeQuery("TRUNCATE buyers RESTART IDENTITY CASCADE;").executeUpdate();
            //entityManager.createNativeQuery("ALTER SEQUENCE buyer_buyer_id_seq RESTART WITH 1;").executeUpdate();
            entityManager.getTransaction().commit();
        }
    }
}