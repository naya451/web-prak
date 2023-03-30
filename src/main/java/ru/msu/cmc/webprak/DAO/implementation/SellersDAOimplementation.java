package ru.msu.cmc.webprak.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.msu.cmc.webprak.DAO.SellersDAO;
import ru.msu.cmc.webprak.models.Sellers;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SellersDAOimplementation extends CommonDAOimplementation<Sellers, Long> implements SellersDAO {

    public SellersDAOimplementation(){
        super(Sellers.class);
    }

    @Override
    public List<Sellers> getAllSellersByName(String goodName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Sellers> query = session.createQuery("FROM Sellers WHERE name LIKE :gotName", Sellers.class)
                    .setParameter("gotName", likeExpr(goodName));
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public Sellers getSingleSellerByName(String goodName) {
        List<Sellers> candidates = this.getAllSellersByName(goodName);
        return candidates == null ? null :
                candidates.size() == 1 ? candidates.get(0) : null;
    }

    @Override
    public List<Sellers> getByFilter(Filter filter) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Sellers> criteriaQuery = builder.createQuery(Sellers.class);
            Root<Sellers> root = criteriaQuery.from(Sellers.class);

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