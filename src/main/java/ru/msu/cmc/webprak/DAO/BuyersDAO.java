package ru.msu.cmc.webprak.DAO;

import ru.msu.cmc.webprak.models.Buyers;
import ru.msu.cmc.webprak.models.Deliveries;

import java.util.List;

public interface BuyersDAO extends CommonDAO<Buyers, Long> {
    List<Buyers> getAllBuyers();

    List<Buyers> getAllBuyersByName(String BuyersName);

    Long getNumberYearsDeliveries(Long id);

    Long getNumberDeliveries(Long id);

    List<Deliveries> getRecentDeliveries(Long id);

    List<Buyers> getAllBuyersByNameSortedWithNameASC(String BuyersName);

    List<Buyers> getAllBuyersByNameSortedWithNameDESC(String BuyersName);

    List<Buyers> getAllBuyersByNameSortedWithYearsDeliveriesASC(String BuyersName);

    List<Buyers> getAllBuyersByNameSortedWithYearsDeliveriesDESC(String BuyersName);

    List<Buyers> getAllBuyersByNameSortedWithDeliveriesASC(String BuyersName);

    List<Buyers> getAllBuyersByNameSortedWithDeliveriesDESC(String BuyersName);

    Buyers getSingleBuyerByName(String BuyersName);
}