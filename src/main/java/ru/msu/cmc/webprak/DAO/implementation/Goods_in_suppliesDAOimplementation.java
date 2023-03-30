package ru.msu.cmc.webprak.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.msu.cmc.webprak.DAO.Goods_in_suppliesDAO;
import ru.msu.cmc.webprak.models.Goods_in_supplies;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class Goods_in_suppliesDAOimplementation extends CommonDAOimplementation<Goods_in_supplies, Long> implements Goods_in_suppliesDAO {

    public Goods_in_suppliesDAOimplementation(){
        super(Goods_in_supplies.class);
    }

    @Override
    public List<Goods_in_supplies> getAllGoods_in_suppliesByName(String goodName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Goods_in_supplies> query = session.createQuery("FROM Goods_in_supplies WHERE name LIKE :gotName", Goods_in_supplies.class)
                    .setParameter("gotName", likeExpr(goodName));
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public Goods_in_supplies getSingleGoodByName(String goodName) {
        List<Goods_in_supplies> candidates = this.getAllGoods_in_suppliesByName(goodName);
        return candidates == null ? null :
                candidates.size() == 1 ? candidates.get(0) : null;
    }

    @Override
    public List<Goods_in_supplies> getByFilter(Filter filter) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Goods_in_supplies> criteriaQuery = builder.createQuery(Goods_in_supplies.class);
            Root<Goods_in_supplies> root = criteriaQuery.from(Goods_in_supplies.class);

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

