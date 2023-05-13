package ru.msu.cmc.webprak.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.msu.cmc.webprak.DAO.Warehouse_conditionDAO;
import ru.msu.cmc.webprak.models.Goods;
import ru.msu.cmc.webprak.models.Warehouse_condition;

import java.util.List;

@Repository
public class Warehouse_conditionDAO_Implementation extends CommonDAOImplementation<Warehouse_condition, Long> implements Warehouse_conditionDAO {

    public Warehouse_conditionDAO_Implementation() {
        super(Warehouse_condition.class);
    }

    @Override
    public List<Warehouse_condition> getGetNotFreePositionsByType(String gtype) {
        try (Session session = sessionFactory.openSession()) {
            Query<Warehouse_condition> query = session.createQuery("FROM Warehouse_condition " +
                            " WHERE ((availability = false) and (gtype Like :gtype))", Warehouse_condition.class)
                                    .setParameter("gtype", likeExpr(gtype));
            return query.getResultList();
        }
    }
    @Override
    public List<Warehouse_condition> getPlaces(Goods id) {
        try (Session session = sessionFactory.openSession()) {
            Query<Warehouse_condition> query = session.createQuery("FROM Warehouse_condition " +
                            "WHERE good = :id", Warehouse_condition.class)
                    .setParameter("id", id);
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }
    private String likeExpr(String param) {
        return "%" + param + "%";
    }
}