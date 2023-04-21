package ru.msu.cmc.webprak.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.msu.cmc.webprak.DAO.BuyersDAO;
import ru.msu.cmc.webprak.models.Buyers;

import java.util.List;

@Repository
public class BuyersDAO_Implementation extends CommonDAOImplementation<Buyers, Long> implements BuyersDAO {

    public BuyersDAO_Implementation() {
        super(Buyers.class);
    }

    @Override
    public List<Buyers> getAllBuyers() {
        try (Session session = sessionFactory.openSession()) {
            Query<Buyers> query = session.createQuery("FROM Buyers", Buyers.class);
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Buyers> getAllBuyersByName(String BuyersName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Buyers> query = session.createQuery("FROM Buyers WHERE name LIKE :gotName", Buyers.class)
                    .setParameter("gotName", likeExpr(BuyersName));
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Buyers> getAllBuyersByNameSortedWithNameASC(String BuyersName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Buyers> query = session.createQuery("FROM Buyers WHERE name LIKE :gotName " +
                            "ORDER BY name ASC", Buyers.class)
                    .setParameter("gotName", likeExpr(BuyersName));
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Buyers> getAllBuyersByNameSortedWithNameDESC(String BuyersName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Buyers> query = session.createQuery("FROM Buyers WHERE name LIKE :gotName " +
                            "ORDER BY name DESC", Buyers.class)
                    .setParameter("gotName", likeExpr(BuyersName));
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Buyers> getAllBuyersByNameSortedWithYearsDeliveriesASC(String BuyersName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Buyers> query = session.createQuery("FROM Buyers WHERE name LIKE :gotName " +
                            "ORDER BY getNumberYearsDeliveries(id) ASC", Buyers.class)
                    .setParameter("gotName", likeExpr(BuyersName));
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Buyers> getAllBuyersByNameSortedWithYearsDeliveriesDESC(String BuyersName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Buyers> query = session.createQuery("FROM Buyers WHERE name LIKE :gotName " +
                            "ORDER BY getNumberYearsDeliveries(id) DESC", Buyers.class)
                    .setParameter("gotName", likeExpr(BuyersName));
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Buyers> getAllBuyersByNameSortedWithDeliveriesASC(String BuyersName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Buyers> query = session.createQuery("FROM Buyers WHERE name LIKE :gotName " +
                            "ORDER BY getNumberDeliveries(id) ASC", Buyers.class)
                    .setParameter("gotName", likeExpr(BuyersName));
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Buyers> getAllBuyersByNameSortedWithDeliveriesDESC(String BuyersName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Buyers> query = session.createQuery("FROM Buyers WHERE name LIKE :gotName " +
                            "ORDER BY getNumberDeliveries(id) DESC", Buyers.class)
                    .setParameter("gotName", likeExpr(BuyersName));
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public Buyers getSingleBuyerByName(String BuyersName) {
        List<Buyers> candidates = this.getAllBuyersByName(BuyersName);
        return candidates == null ? null :
                candidates.size() == 1 ? candidates.get(0) : null;
    }

    private String likeExpr(String param) {
        return "%" + param + "%";
    }
}