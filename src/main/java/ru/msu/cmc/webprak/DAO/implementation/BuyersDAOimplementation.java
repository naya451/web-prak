package ru.msu.cmc.webprak.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.msu.cmc.webprak.DAO.BuyersDAO;
import ru.msu.cmc.webprak.models.Buyers;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BuyersDAOimplementation extends CommonDAOimplementation<Buyers, Long> implements BuyersDAO {

    public BuyersDAOimplementation(){
        super(Buyers.class);
    }

    @Override
    public List<Buyers> getAllBuyersByName(String goodName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Buyers> query = session.createQuery("FROM Buyers WHERE name LIKE :gotName", Buyers.class)
                    .setParameter("gotName", likeExpr(goodName));
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public Buyers getSingleBuyerByName(String goodName) {
        List<Buyers> candidates = this.getAllBuyersByName(goodName);
        return candidates == null ? null :
                candidates.size() == 1 ? candidates.get(0) : null;
    }

    @Override
    public List<Buyers> getByFilter(Filter filter) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Buyers> criteriaQuery = builder.createQuery(Buyers.class);
            Root<Buyers> root = criteriaQuery.from(Buyers.class);

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
