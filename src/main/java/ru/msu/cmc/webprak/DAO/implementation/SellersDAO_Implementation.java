package ru.msu.cmc.webprak.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.msu.cmc.webprak.DAO.SellersDAO;
import ru.msu.cmc.webprak.models.Sellers;

import java.util.List;

@Repository
public class SellersDAO_Implementation extends CommonDAOImplementation<Sellers, Long> implements SellersDAO {

    public SellersDAO_Implementation() {
        super(Sellers.class);
    }

    @Override
    public List<Sellers> getAllSellers() {
        try (Session session = sessionFactory.openSession()) {
            Query<Sellers> query = session.createQuery("FROM Sellers", Sellers.class);
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Sellers> getAllSellersByName(String SellersName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Sellers> query = session.createQuery("FROM Sellers WHERE name LIKE :gotName", Sellers.class)
                    .setParameter("gotName", likeExpr(SellersName));
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Sellers> getAllSellersByNameSortedWithNameASC(String SellersName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Sellers> query = session.createQuery("FROM Sellers WHERE name LIKE :gotName " +
                            "ORDER BY name ASC", Sellers.class)
                    .setParameter("gotName", likeExpr(SellersName));
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Sellers> getAllSellersByNameSortedWithNameDESC(String SellersName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Sellers> query = session.createQuery("FROM Sellers WHERE name LIKE :gotName " +
                            "ORDER BY name DESC", Sellers.class)
                    .setParameter("gotName", likeExpr(SellersName));
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Sellers> getAllSellersByNameSortedWithYearsSuppliesASC(String SellersName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Sellers> query = session.createQuery("FROM Sellers WHERE name LIKE :gotName " +
                            "ORDER BY getnumberyearssupplies(id) ASC", Sellers.class)
                    .setParameter("gotName", likeExpr(SellersName));
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Sellers> getAllSellersByNameSortedWithYearsSuppliesDESC(String SellersName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Sellers> query = session.createQuery("FROM Sellers WHERE name LIKE :gotName " +
                            "ORDER BY getnumberyearssupplies(id) DESC", Sellers.class)
                    .setParameter("gotName", likeExpr(SellersName));
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Sellers> getAllSellersByNameSortedWithSuppliesASC(String SellersName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Sellers> query = session.createQuery("FROM Sellers WHERE name LIKE :gotName " +
                            "ORDER BY getnumbersupplies(id) ASC", Sellers.class)
                    .setParameter("gotName", likeExpr(SellersName));
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Sellers> getAllSellersByNameSortedWithSuppliesDESC(String SellersName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Sellers> query = session.createQuery("FROM Sellers WHERE name LIKE :gotName " +
                            "ORDER BY getnumbersupplies(id) DESC", Sellers.class)
                    .setParameter("gotName", likeExpr(SellersName));
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public Sellers getSingleSellerByName(String SellersName) {
        List<Sellers> candidates = this.getAllSellersByName(SellersName);
        return candidates == null ? null :
                candidates.size() == 1 ? candidates.get(0) : null;
    }

    private String likeExpr(String param) {
        return "%" + param + "%";
    }
}