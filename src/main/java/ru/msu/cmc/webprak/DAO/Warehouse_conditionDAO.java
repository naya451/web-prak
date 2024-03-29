package ru.msu.cmc.webprak.DAO;

import ru.msu.cmc.webprak.models.Goods;
import ru.msu.cmc.webprak.models.Warehouse_condition;

import java.util.List;

public interface Warehouse_conditionDAO extends CommonDAO<Warehouse_condition, Long> {
    List<Warehouse_condition> getGetNotFreePositionsByType(String type);
    public List<Warehouse_condition> getPlaces(Goods id);
}