package ru.msu.cmc.webprak.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.msu.cmc.webprak.DAO.Goods_in_supplyDAO;
import ru.msu.cmc.webprak.models.Supplies;
import ru.msu.cmc.webprak.models.Goods_in_supply;

import java.util.List;

@Repository
public class Goods_in_supplyDAO_Implementation extends CommonDAOImplementation<Goods_in_supply, Long> implements Goods_in_supplyDAO {

    public Goods_in_supplyDAO_Implementation() {
        super(Goods_in_supply.class);
    }

    @Override
    public List<Goods_in_supply> getAllGoods_in_supply(Supplies id) {
        try (Session session = sessionFactory.openSession()) {
            Query<Goods_in_supply> query = session.createQuery("FROM Goods_in_supply WHERE supply = :id", Goods_in_supply.class)
                    .setParameter("id", id);
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }
}