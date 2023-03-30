package ru.msu.cmc.webprak.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.msu.cmc.webprak.DAO.Goods_in_deliveryDAO;
import ru.msu.cmc.webprak.models.Goods_in_delivery;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class Goods_in_deliveryDAOimplementation extends CommonDAOimplementation<Goods_in_delivery, Long> implements Goods_in_deliveryDAO {

    public Goods_in_deliveryDAOimplementation(){
        super(Goods_in_delivery.class);
    }

    @Override
    public List<Goods_in_delivery> getAllGoods_in_deliveryByName(String goodName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Goods_in_delivery> query = session.createQuery("FROM Goods_in_delivery WHERE name LIKE :gotName", Goods_in_delivery.class)
                    .setParameter("gotName", likeExpr(goodName));
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public Goods_in_delivery getSingleGood_in_deliveryByName(String goodName) {
        List<Goods_in_delivery> candidates = this.getAllGoods_in_deliveryByName(goodName);
        return candidates == null ? null :
                candidates.size() == 1 ? candidates.get(0) : null;
    }

    @Override
    public List<Goods_in_delivery> getByFilter(Filter filter) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Goods_in_delivery> criteriaQuery = builder.createQuery(Goods_in_delivery.class);
            Root<Goods_in_delivery> root = criteriaQuery.from(Goods_in_delivery.class);

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
