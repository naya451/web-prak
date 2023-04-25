package ru.msu.cmc.webprak.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.msu.cmc.webprak.DAO.DeliveriesDAO;
import ru.msu.cmc.webprak.models.Deliveries;

import java.sql.Date;
import java.util.List;

@Repository
public class DeliveriesDAO_Implementation extends CommonDAOImplementation<Deliveries, Long> implements DeliveriesDAO {

    public DeliveriesDAO_Implementation() {
        super(Deliveries.class);
    }

    @Override
    public List<Deliveries> getAllDeliveries() {
        try (Session session = sessionFactory.openSession()) {
            Query<Deliveries> query = session.createQuery("FROM Deliveries", Deliveries.class);
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Deliveries> getAllDeliveriesByBuyer(String buyer) {
        try (Session session = sessionFactory.openSession()) {
            Query<Deliveries> query = session.createQuery("FROM Deliveries " +
                            "WHERE buyer_name LIKE :name", Deliveries.class)
                    .setParameter("name", buyer);
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }
    @Override
    public List<Deliveries> getAllDeliveriesByBuyerLimit5(String buyer) {
        try (Session session = sessionFactory.openSession()) {
            Query<Deliveries> query = session.createQuery("FROM Deliveries " +
                            "WHERE buyer_name LIKE :name LIMIT 5", Deliveries.class)
                    .setParameter("name", buyer);
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Deliveries> getAllDeliveriesByPeriod(Date start, Date end) {
        try (Session session = sessionFactory.openSession()) {
            Query<Deliveries> query = session.createQuery("FROM Deliveries " +
                            "WHERE date_time between :start and :end ", Deliveries.class)
                    .setParameter("start", start).setParameter("end", end);
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Deliveries> getAllDeliveriesByPeriodSortedWithDateASC(Date start, Date end) {
        try (Session session = sessionFactory.openSession()) {
            Query<Deliveries> query = session.createQuery("FROM Deliveries " +
                            "WHERE date_time <= :end AND date_time >= :start ORDER BY date_time ASC", Deliveries.class)
                    .setParameter("end", end).setParameter("start", start);
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Deliveries> getAllDeliveriesByPeriodSortedWithDateDESC(Date start, Date end) {
        try (Session session = sessionFactory.openSession()) {
            Query<Deliveries> query = session.createQuery("FROM Deliveries " +
                            "WHERE date_time <= :end AND date_time >= :start ORDER BY date_time DESC", Deliveries.class)
                    .setParameter("end", end).setParameter("start", start);
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Deliveries> getAllDeliveriesByPeriodSortedWithNumberOfGoodsASC(Date start, Date end) {
        try (Session session = sessionFactory.openSession()) {
            Query<Deliveries> query = session.createQuery("FROM Deliveries " +
                            "WHERE date_time <= :end AND date_time >= :start ORDER BY getNumberOfGoodsInDelivery(id) ASC", Deliveries.class)
                    .setParameter("end", end).setParameter("start", start);
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Deliveries> getAllDeliveriesByPeriodSortedWithNumberOfGoodsDESC(Date start, Date end) {
        try (Session session = sessionFactory.openSession()) {
            Query<Deliveries> query = session.createQuery("FROM Deliveries " +
                            "WHERE date_time <= :end AND date_time >= :start ORDER BY getNumberOfGoodsInDelivery(id) DESC", Deliveries.class)
                    .setParameter("end", end).setParameter("start", start);
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Deliveries> getAllDeliveriesByPeriodSortedWithBuyerNameASC(Date start, Date end) {
        try (Session session = sessionFactory.openSession()) {
            Query<Deliveries> query = session.createQuery("FROM Deliveries " +
                            "WHERE date_time <= :end AND date_time >= :start ORDER BY buyer_name ASC", Deliveries.class)
                    .setParameter("end", end).setParameter("start", start);
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Deliveries> getAllDeliveriesByPeriodSortedWithBuyerNameDESC(Date start, Date end) {
        try (Session session = sessionFactory.openSession()) {
            Query<Deliveries> query = session.createQuery("FROM Deliveries " +
                            "WHERE date_time <= :end AND date_time >= :start ORDER BY buyer_name DESC", Deliveries.class)
                    .setParameter("end", end).setParameter("start", start);
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }
}