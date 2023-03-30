package ru.msu.cmc.webprak.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.msu.cmc.webprak.DAO.Warehouse_conditionDAO;
import ru.msu.cmc.webprak.models.Warehouse_condition;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class Warehouse_conditionDAOimplementation extends CommonDAOimplementation<Warehouse_condition, Long> implements Warehouse_conditionDAO {

    public Warehouse_conditionDAOimplementation(){
        super(Warehouse_condition.class);
    }

    @Override
    public List<Warehouse_condition> getAllWarehouse_conditionByName(String goodName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Warehouse_condition> query = session.createQuery("FROM Warehouse_condition WHERE name LIKE :gotName", Warehouse_condition.class)
                    .setParameter("gotName", likeExpr(goodName));
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public Warehouse_condition getSingleGoodByName(String goodName) {
        List<Warehouse_condition> candidates = this.getAllWarehouse_conditionByName(goodName);
        return candidates == null ? null :
                candidates.size() == 1 ? candidates.get(0) : null;
    }

    @Override
    public List<Warehouse_condition> getByFilter(Filter filter) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Warehouse_condition> criteriaQuery = builder.createQuery(Warehouse_condition.class);
            Root<Warehouse_condition> root = criteriaQuery.from(Warehouse_condition.class);

            List<Predicate> predicates = new ArrayList<>();
            if (filter.getName() != null)
                predicates.add(builder.like(root.get("name"), likeExpr(filter.getName())));

            if (predicates.size() != 0)
                criteriaQuery.where(predicates.toArray(new Predicate[0]));

            return session.createQuery(criteriaQuery).getResultList();
        }
    }

    private String likeExpr(String param) {
        return "%" + param + "%";
    }
}