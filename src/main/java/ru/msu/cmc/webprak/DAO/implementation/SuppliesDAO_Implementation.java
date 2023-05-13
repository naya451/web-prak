package ru.msu.cmc.webprak.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.msu.cmc.webprak.DAO.SuppliesDAO;
import ru.msu.cmc.webprak.models.Supplies;

import java.util.Date;
import java.util.List;

@Repository
public class SuppliesDAO_Implementation extends CommonDAOImplementation<Supplies, Long> implements SuppliesDAO {

    public SuppliesDAO_Implementation() {
        super(Supplies.class);
    }

    @Override
    public List<Supplies> getAllSupplies() {
        try (Session session = sessionFactory.openSession()) {
            Query<Supplies> query = session.createQuery("FROM Supplies", Supplies.class);
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Supplies> getAllSuppliesBySeller(String name) {
        try (Session session = sessionFactory.openSession()) {
            Query<Supplies> query = session.createQuery("FROM Supplies " +
                            "WHERE seller_name LIKE :name", Supplies.class)
                    .setParameter("name", name);
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }


    @Override
    public List<Supplies> getIndexSupplies() {
        try (Session session = sessionFactory.openSession()) {
            Query<Supplies> query = session.createQuery("FROM Supplies order by date_time", Supplies.class);
            return query.getResultList().size() == 0 ? null : query.getResultList().subList(0, 5);
        }
    }

    @Override
    public List<Supplies> getAllSuppliesBySellerLimit5(String seller) {
        try (Session session = sessionFactory.openSession()) {
            Query<Supplies> query = session.createQuery("FROM Supplies " +
                            "WHERE seller_name LIKE :name ORDER BY date_time desc", Supplies.class)
                    .setParameter("name", likeExpr(seller));
            return query.getResultList().size() == 0 ? null : ((query.getResultList().size() < 5) ? query.getResultList() : query.getResultList().subList(0, 5));
        }
    }
    @Override
    public List<Supplies> getAllSuppliesByPeriod(Date start, Date end) {
        try (Session session = sessionFactory.openSession()) {
            Query<Supplies> query = session.createQuery("FROM Supplies " +
                            "WHERE date_time <= :end AND date_time >= :start", Supplies.class)
                    .setParameter("end", end).setParameter("start", start);
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Supplies> getAllSuppliesByPeriodSortedWithDateASC(Date start, Date end) {
        try (Session session = sessionFactory.openSession()) {
            Query<Supplies> query = session.createQuery("FROM Supplies " +
                            "WHERE date_time <= :end AND date_time >= :start ORDER BY date_time ASC", Supplies.class)
                    .setParameter("end", end).setParameter("start", start);
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Supplies> getAllSuppliesByPeriodSortedWithDateDESC(Date start, Date end) {
        try (Session session = sessionFactory.openSession()) {
            Query<Supplies> query = session.createQuery("FROM Supplies " +
                            "WHERE date_time <= :end AND date_time >= :start ORDER BY date_time DESC", Supplies.class)
                    .setParameter("end", end).setParameter("start", start);
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Supplies> getAllSuppliesByPeriodSortedWithNumberOfGoodsASC(Date start, Date end) {
        try (Session session = sessionFactory.openSession()) {
            Query<Supplies> query = session.createQuery("FROM Supplies " +
                            "WHERE date_time <= :end AND date_time >= :start ORDER BY getNumberOfGoodsInSupply(id) ASC", Supplies.class)
                    .setParameter("end", end).setParameter("start", start);
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Supplies> getAllSuppliesByPeriodSortedWithNumberOfGoodsDESC(Date start, Date end) {
        try (Session session = sessionFactory.openSession()) {
            Query<Supplies> query = session.createQuery("FROM Supplies " +
                            "WHERE date_time <= :end AND date_time >= :start ORDER BY getNumberOfGoodsInSupply(id) DESC", Supplies.class)
                    .setParameter("end", end).setParameter("start", start);
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Supplies> getAllSuppliesByPeriodSortedWithSellerNameASC(Date start, Date end) {
        try (Session session = sessionFactory.openSession()) {
            Query<Supplies> query = session.createQuery("FROM Supplies " +
                            "WHERE date_time <= :end AND date_time >= :start ORDER BY seller_name ASC", Supplies.class)
                    .setParameter("end", end).setParameter("start", start);
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Supplies> getAllSuppliesByPeriodSortedWithSellerNameDESC(Date start, Date end) {
        try (Session session = sessionFactory.openSession()) {
            Query<Supplies> query = session.createQuery("FROM Supplies " +
                            "WHERE date_time <= :end AND date_time >= :start ORDER BY seller_name DESC", Supplies.class)
                    .setParameter("end", end).setParameter("start", start);
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }
    private String likeExpr(String param) {
        return "%" + param + "%";
    }
}