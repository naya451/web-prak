package ru.msu.cmc.webprak.DAO;

import ru.msu.cmc.webprak.models.Supplies;

import java.util.List;

public interface SuppliesDAO extends CommonDAO<Supplies, Long> {
    List<Supplies> getAllSupplies();

    List<Supplies> getAllSuppliesBySeller(String name);

    List<Supplies> getAllSuppliesByPeriod(java.util.Date start, java.util.Date end);

    List<Supplies> getAllSuppliesByPeriodSortedWithDateASC(java.util.Date start, java.util.Date end);

    List<Supplies> getAllSuppliesByPeriodSortedWithDateDESC(java.util.Date start, java.util.Date end);

    List<Supplies> getAllSuppliesByPeriodSortedWithNumberOfGoodsASC(java.util.Date start, java.util.Date end);

    List<Supplies> getAllSuppliesByPeriodSortedWithNumberOfGoodsDESC(java.util.Date start, java.util.Date end);

    List<Supplies> getAllSuppliesByPeriodSortedWithSellerNameASC(java.util.Date start, java.util.Date end);

    List<Supplies> getAllSuppliesByPeriodSortedWithSellerNameDESC(java.util.Date start, java.util.Date end);

    public List<Supplies> getIndexSupplies();

    public List<Supplies> getAllSuppliesBySellerLimit5(String seller);
}