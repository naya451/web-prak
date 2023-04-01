package ru.msu.cmc.webprak.DAO;

import ru.msu.cmc.webprak.models.Deliveries;

import java.util.List;

public interface DeliveriesDAO extends CommonDAO<Deliveries, Long> {
    List<Deliveries> getAllDeliveries(java.sql.Date deliveryDate, String buyer_name, int amount);
    List<Deliveries> getAllDeliveriesSortedByDate(int asc, java.sql.Date deliveryDate, String buyer_name, int amount);
    List<Deliveries> getAllDeliveriesSortedByBName(int asc, java.sql.Date deliveryDate, String buyer_name, int amount);
    List<Deliveries> getAllDeliveriesSortedByAmount(int asc, java.sql.Date deliveryDate, String buyer_name, int amount);
}