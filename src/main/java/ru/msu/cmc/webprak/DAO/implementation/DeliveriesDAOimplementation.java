package ru.msu.cmc.webprak.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.msu.cmc.webprak.DAO.DeliveriesDAO;
import ru.msu.cmc.webprak.models.Deliveries;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DeliveriesDAOimplementation extends CommonDAOimplementation<Deliveries, Long> implements DeliveriesDAO {

    public DeliveriesDAOimplementation(){
        super(Deliveries.class);
    }

    @Override
    public List<Deliveries> getAllDeliveriesByName(String goodName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Deliveries> query = session.createQuery("FROM Deliveries WHERE name LIKE :gotName", Deliveries.class)
                    .setParameter("gotName", likeExpr(goodName));
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public Deliveries getSingleDeliveryByName(String goodName) {
        List<Deliveries> candidates = this.getAllDeliveriesByName(goodName);
        return candidates == null ? null :
                candidates.size() == 1 ? candidates.get(0) : null;
    }

    @Override
    public List<Deliveries> getByFilter(Filter filter) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Deliveries> criteriaQuery = builder.createQuery(Deliveries.class);
            Root<Deliveries> root = criteriaQuery.from(Deliveries.class);

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
