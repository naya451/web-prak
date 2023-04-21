package ru.msu.cmc.webprak.DAO;

import ru.msu.cmc.webprak.models.Supplies;

import java.util.List;

public interface SuppliesDAO extends CommonDAO<Supplies, Long> {
    List<Supplies> getAllSupplies();

    List<Supplies> getAllSuppliesBySeller(Long id);

    List<Supplies> getAllSuppliesByPeriod(java.sql.Date start, java.sql.Date end);

    List<Supplies> getAllSuppliesByPeriodSortedWithDateASC(java.sql.Date start, java.sql.Date end);

    List<Supplies> getAllSuppliesByPeriodSortedWithDateDESC(java.sql.Date start, java.sql.Date end);

    List<Supplies> getAllSuppliesByPeriodSortedWithNumberOfGoodsASC(java.sql.Date start, java.sql.Date end);

    List<Supplies> getAllSuppliesByPeriodSortedWithNumberOfGoodsDESC(java.sql.Date start, java.sql.Date end);

    List<Supplies> getAllSuppliesByPeriodSortedWithSellerNameASC(java.sql.Date start, java.sql.Date end);

    List<Supplies> getAllSuppliesByPeriodSortedWithSellerNameDESC(java.sql.Date start, java.sql.Date end);
}