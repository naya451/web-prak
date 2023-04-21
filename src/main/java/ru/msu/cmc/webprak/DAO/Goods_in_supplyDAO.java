package ru.msu.cmc.webprak.DAO;

import ru.msu.cmc.webprak.models.Goods_in_supply;

import java.util.List;

public interface Goods_in_supplyDAO extends CommonDAO<Goods_in_supply, Long> {
    List<Goods_in_supply> getAllGoods_in_supply(Long id);
}