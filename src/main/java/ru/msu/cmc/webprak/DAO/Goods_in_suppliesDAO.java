package ru.msu.cmc.webprak.DAO;

import ru.msu.cmc.webprak.models.Goods_in_supplies;

import java.util.List;

public interface Goods_in_suppliesDAO extends CommonDAO<Goods_in_supplies, Long> {

    List<Goods_in_supplies> getAllGoods_in_supplies();
}