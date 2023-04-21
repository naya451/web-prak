package ru.msu.cmc.webprak.DAO;

import ru.msu.cmc.webprak.models.Goods;
import ru.msu.cmc.webprak.models.Supplies;

import java.util.List;

public interface SuppliesDAO extends CommonDAO<Supplies, Long> {
    List<Supplies> getAllSupplies();

    List<Supplies> getAllSuppliesBySeller(Long id);

    List<Goods> getGoodsInSupply(Long id);

    List<Supplies> getAllSuppliesByPeriod(Long start, Long end);

    List<Supplies> getAllSuppliesByPeriodSortedWithDateASC(Long start, Long end);

    List<Supplies> getAllSuppliesByPeriodSortedWithDateDESC(Long start, Long end);

    List<Supplies> getAllSuppliesByPeriodSortedWithNumberOfGoodsASC(Long start, Long end);

    List<Supplies> getAllSuppliesByPeriodSortedWithNumberOfGoodsDESC(Long start, Long end);

    List<Supplies> getAllSuppliesByPeriodSortedWithSellerNameASC(Long start, Long end);

    List<Supplies> getAllSuppliesByPeriodSortedWithSellerNameDESC(Long start, Long end);
}