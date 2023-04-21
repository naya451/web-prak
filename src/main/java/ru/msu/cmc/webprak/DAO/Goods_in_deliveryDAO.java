package ru.msu.cmc.webprak.DAO;

import ru.msu.cmc.webprak.models.Goods;
import ru.msu.cmc.webprak.models.Goods_in_delivery;

import java.util.List;

public interface Goods_in_deliveryDAO extends CommonDAO<Goods_in_delivery, Long> {
    List<Goods> getAllGoods_in_delivery(Long id);
}