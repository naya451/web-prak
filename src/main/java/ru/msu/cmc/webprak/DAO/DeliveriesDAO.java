package ru.msu.cmc.webprak.DAO;

import ru.msu.cmc.webprak.models.Deliveries;

import java.util.List;

public interface DeliveriesDAO extends CommonDAO<Deliveries, Long> {
    List<Deliveries> getAllDeliveries();

    List<Deliveries> getAllDeliveriesByBuyer(Long id);

    List<Deliveries> getAllDeliveriesByPeriod(java.sql.Date start, java.sql.Date end);

    List<Deliveries> getAllDeliveriesByPeriodSortedWithDateASC(java.sql.Date start, java.sql.Date end);

    List<Deliveries> getAllDeliveriesByPeriodSortedWithDateDESC(java.sql.Date start, java.sql.Date end);

    List<Deliveries> getAllDeliveriesByPeriodSortedWithNumberOfGoodsASC(java.sql.Date start, java.sql.Date end);

    List<Deliveries> getAllDeliveriesByPeriodSortedWithNumberOfGoodsDESC(java.sql.Date start, java.sql.Date end);

    List<Deliveries> getAllDeliveriesByPeriodSortedWithBuyerNameASC(java.sql.Date start, java.sql.Date end);

    List<Deliveries> getAllDeliveriesByPeriodSortedWithBuyerNameDESC(java.sql.Date start, java.sql.Date end);
}