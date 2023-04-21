package ru.msu.cmc.webprak.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.msu.cmc.webprak.DAO.SuppliesDAO;
import ru.msu.cmc.webprak.models.Supplies;

import java.sql.Date;
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
    public List<Supplies> getAllSuppliesBySeller(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Query<Supplies> query = session.createQuery("FROM Supplies " +
                            "WHERE seller = :id", Supplies.class)
                    .setParameter("id", id);
            return query.getResultList().size() == 0 ? null : query.getResultList();
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
}