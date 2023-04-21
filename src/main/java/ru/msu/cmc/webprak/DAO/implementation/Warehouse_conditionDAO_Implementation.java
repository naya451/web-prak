package ru.msu.cmc.webprak.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.msu.cmc.webprak.DAO.Warehouse_conditionDAO;
import ru.msu.cmc.webprak.models.Warehouse_condition;

import java.util.List;

@Repository
public class Warehouse_conditionDAO_Implementation extends CommonDAOImplementation<Warehouse_condition, Long> implements Warehouse_conditionDAO {

    public Warehouse_conditionDAO_Implementation() {
        super(Warehouse_condition.class);
    }

    private String likeExpr(String param) {
        return "%" + param + "%";
    }

    @Override
    public List<Warehouse_condition> getGetFreePositionsByType(String type) {
        try (Session session = sessionFactory.openSession()) {
            Query<Warehouse_condition> query = session.createQuery("FROM Warehouse_condition " +
                            "WHERE type = :type AND availability = true", Warehouse_condition.class)
                    .setParameter("type", type);
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Warehouse_condition> getPlaces(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Query<Warehouse_condition> query = session.createQuery("FROM Warehouse_condition " +
                            "WHERE good = :id", Warehouse_condition.class)
                    .setParameter("id", id);
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }
}