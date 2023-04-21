package ru.msu.cmc.webprak.DAO;

import ru.msu.cmc.webprak.models.Goods;
import ru.msu.cmc.webprak.models.Deliveries;

import java.util.List;

public interface DeliveriesDAO extends CommonDAO<Deliveries, Long> {
    List<Deliveries> getAllDeliveries();

    List<Deliveries> getAllDeliveriesByBuyer(Long id);

    List<Goods> getGoodsInSupply(Long id);

    List<Deliveries> getAllDeliveriesByPeriod(Long start, Long end);

    List<Deliveries> getAllDeliveriesByPeriodSortedWithDateASC(Long start, Long end);

    List<Deliveries> getAllDeliveriesByPeriodSortedWithDateDESC(Long start, Long end);

    List<Deliveries> getAllDeliveriesByPeriodSortedWithNumberOfGoodsASC(Long start, Long end);

    List<Deliveries> getAllDeliveriesByPeriodSortedWithNumberOfGoodsDESC(Long start, Long end);

    List<Deliveries> getAllDeliveriesByPeriodSortedWithBuyerNameASC(Long start, Long end);

    List<Deliveries> getAllDeliveriesByPeriodSortedWithBuyerNameDESC(Long start, Long end);
}