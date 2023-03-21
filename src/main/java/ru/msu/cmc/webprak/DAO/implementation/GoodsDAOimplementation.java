package ru.msu.cmc.webprak.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.msu.cmc.webprak.DAO.GoodsDAO;
import ru.msu.cmc.webprak.models.Goods;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GoodsDAOimplementation extends CommonDAOimplementation<Goods, Long> implements GoodsDAO {

    public GoodsDAOimplementation(){
        super(Goods.class);
    }

    @Override
    public List<Goods> getAllGoodsByName(String goodName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Goods> query = session.createQuery("FROM Goods WHERE name LIKE :gotName", Goods.class)
                    .setParameter("gotName", likeExpr(goodName));
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public Goods getSingleGoodByName(String goodName) {
        List<Goods> candidates = this.getAllGoodsByName(goodName);
        return candidates == null ? null :
                candidates.size() == 1 ? candidates.get(0) : null;
    }

    @Override
    public List<Goods> getByFilter(Filter filter) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Goods> criteriaQuery = builder.createQuery(Goods.class);
            Root<Goods> root = criteriaQuery.from(Goods.class);

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