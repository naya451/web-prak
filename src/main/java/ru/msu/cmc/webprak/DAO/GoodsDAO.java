package ru.msu.cmc.webprak.DAO;

import ru.msu.cmc.webprak.models.Goods;
import ru.msu.cmc.webprak.models.Sellers;
import ru.msu.cmc.webprak.models.Warehouse_condition;

import java.util.List;

public interface GoodsDAO extends CommonDAO<Goods, Long> {
    List<Goods> getAllGoods();

    List<Goods> getAllGoodsByName(String GoodsName);

    List<Warehouse_condition> getPlaces(Long id);

    List<Sellers> getSellers(Long id);

    Long getAvailability(Long id);

    List<Goods> getAllGoodsByNameSortedWithNameASC(String GoodsName);

    List<Goods> getAllGoodsByNameSortedWithNameDESC(String GoodsName);

    List<Goods> getAllGoodsByNameSortedWithTimeOfKeepingASC(String GoodsName);

    List<Goods> getAllGoodsByNameSortedWithTimeOfKeepingDESC(String GoodsName);

    List<Goods> getAllGoodsByNameSortedWithAvailabilityASC(String GoodsName);

    List<Goods> getAllGoodsByNameSortedWithAvailabilityDESC(String GoodsName);

    Goods getSingleGoodByName(String GoodsName);
}