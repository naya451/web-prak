package ru.msu.cmc.webprak.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.msu.cmc.webprak.DAO.SuppliesDAO;
import ru.msu.cmc.webprak.models.Supplies;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SuppliesDAOimplementation extends CommonDAOimplementation<Supplies, Long> implements SuppliesDAO {

    public SuppliesDAOimplementation(){
        super(Supplies.class);
    }

    @Override
    public List<Supplies> getAllSuppliesByName(String goodName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Supplies> query = session.createQuery("FROM Supplies WHERE name LIKE :gotName", Supplies.class)
                    .setParameter("gotName", likeExpr(goodName));
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public Supplies getSingleSupplieByName(String goodName) {
        List<Supplies> candidates = this.getAllSuppliesByName(goodName);
        return candidates == null ? null :
                candidates.size() == 1 ? candidates.get(0) : null;
    }

    @Override
    public List<Supplies> getByFilter(Filter filter) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Supplies> criteriaQuery = builder.createQuery(Supplies.class);
            Root<Supplies> root = criteriaQuery.from(Supplies.class);

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