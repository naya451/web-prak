package ru.msu.cmc.webprak.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.msu.cmc.webprak.DAO.GoodsDAO;
import ru.msu.cmc.webprak.models.Goods;

import java.util.List;

@Repository
public class GoodsDAO_Implementation extends CommonDAOImplementation<Goods, Long> implements GoodsDAO {

    public GoodsDAO_Implementation() {
        super(Goods.class);
    }

    private String likeExpr(String param) {
        return "%" + param + "%";
    }

    @Override
    public List<Goods> getAllGoods() {
        try (Session session = sessionFactory.openSession()) {
            Query<Goods> query = session.createQuery("FROM Goods", Goods.class);
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Goods> getAllGoodsByName(String GoodsName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Goods> query = session.createQuery("FROM Goods WHERE name LIKE :gotName", Goods.class)
                    .setParameter("gotName", likeExpr(GoodsName));
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Goods> getAllGoodsByNameSortedWithNameASC(String GoodsName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Goods> query = session.createQuery("FROM Goods " +
                            "WHERE name LIKE :gotName ORDER BY name ASC", Goods.class)
                    .setParameter("gotName", likeExpr(GoodsName));
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Goods> getAllGoodsByNameSortedWithNameDESC(String GoodsName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Goods> query = session.createQuery("FROM Goods " +
                            "WHERE name LIKE :gotName ORDER BY name DESC", Goods.class)
                    .setParameter("gotName", likeExpr(GoodsName));
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Goods> getAllGoodsByNameSortedWithTimeOfKeepingASC(String GoodsName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Goods> query = session.createQuery("FROM Goods " +
                            "WHERE name LIKE :gotName ORDER BY time_of_keeping ASC", Goods.class)
                    .setParameter("gotName", likeExpr(GoodsName));
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Goods> getAllGoodsByNameSortedWithTimeOfKeepingDESC(String GoodsName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Goods> query = session.createQuery("FROM Goods " +
                            "WHERE name LIKE :gotName ORDER BY time_of_keeping DESC", Goods.class)
                    .setParameter("gotName", likeExpr(GoodsName));
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Goods> getAllGoodsByNameSortedWithAvailabilityASC(String GoodsName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Goods> query = session.createQuery("FROM Goods " +
                            "WHERE name LIKE :gotName ORDER BY getAvailability(id) ASC", Goods.class)
                    .setParameter("gotName", likeExpr(GoodsName));
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Goods> getAllGoodsByNameSortedWithAvailabilityDESC(String GoodsName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Goods> query = session.createQuery("FROM Goods " +
                            "WHERE name LIKE :gotName ORDER BY getAvailability(id) DESC", Goods.class)
                    .setParameter("gotName", likeExpr(GoodsName));
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public Goods getSingleGoodByName(String GoodsName) {
        List<Goods> candidates = this.getAllGoodsByName(GoodsName);
        return candidates == null ? null :
                candidates.size() == 1 ? candidates.get(0) : null;
    }
}