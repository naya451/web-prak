package ru.msu.cmc.webprak.DAO;

import ru.msu.cmc.webprak.models.Deliveries;

import java.util.List;

public interface DeliveriesDAO extends CommonDAO<Deliveries, Long> {
    List<Deliveries> getAllDeliveries();
    List<Deliveries> getIndexDeliveries();

    List<Deliveries> getAllDeliveriesByBuyer(String id);

    List<Deliveries> getAllDeliveriesByBuyerLimit5(String id);

    List<Deliveries> getAllDeliveriesByPeriod(java.util.Date start, java.util.Date end);

    List<Deliveries> getAllDeliveriesByPeriodSortedWithDateASC(java.util.Date start, java.util.Date end);

    List<Deliveries> getAllDeliveriesByPeriodSortedWithDateDESC(java.util.Date start, java.util.Date end);

    List<Deliveries> getAllDeliveriesByPeriodSortedWithNumberOfGoodsASC(java.util.Date start, java.util.Date end);

    List<Deliveries> getAllDeliveriesByPeriodSortedWithNumberOfGoodsDESC(java.util.Date start, java.util.Date end);

    List<Deliveries> getAllDeliveriesByPeriodSortedWithBuyerNameASC(java.util.Date start, java.util.Date end);

    List<Deliveries> getAllDeliveriesByPeriodSortedWithBuyerNameDESC(java.util.Date start, java.util.Date end);
}