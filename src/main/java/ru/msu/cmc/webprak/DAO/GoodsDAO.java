package ru.msu.cmc.webprak.DAO;

import ru.msu.cmc.webprak.models.Goods;

import java.util.List;

public interface GoodsDAO extends CommonDAO<Goods, Long> {
    List<Goods> getAllGoods(String name, String type, int amount, java.sql.Date GoodToDate);
    List<Goods> getAllGoodsSortedByName(int asc, String name, String type, int amount, java.sql.Date GoodToDate);
    List<Goods> getAllGoodsSortedByAmount(int asc, String name, String type, int amount, java.sql.Date GoodToDate);
    List<Goods> getAllGoodsSortedByGTDate(int asc, String name, String type, int amount, java.sql.Date GoodToDate);
}