package ru.msu.cmc.webprak.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.msu.cmc.webprak.DAO.Goods_in_deliveryDAO;
import ru.msu.cmc.webprak.models.Deliveries;
import ru.msu.cmc.webprak.models.Goods_in_delivery;

import java.util.List;

@Repository
public class Goods_in_deliveryDAO_Implementation extends CommonDAOImplementation<Goods_in_delivery, Long> implements Goods_in_deliveryDAO {

    public Goods_in_deliveryDAO_Implementation() {
        super(Goods_in_delivery.class);
    }

    @Override
    public List<Goods_in_delivery> getAllGoods_in_delivery(Deliveries id) {
        try (Session session = sessionFactory.openSession()) {
            Query<Goods_in_delivery> query = session.createQuery("FROM Goods_in_delivery WHERE delivery = :id", Goods_in_delivery.class)
                    .setParameter("id", id);
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }
}