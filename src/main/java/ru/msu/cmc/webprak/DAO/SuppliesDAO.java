package ru.msu.cmc.webprak.DAO;

import ru.msu.cmc.webprak.models.Supplies;

import java.util.List;

public interface SuppliesDAO extends CommonDAO<Supplies, Long> {
    List<Supplies> getAllSupplies(java.sql.Date supplyDate, String supply_name, int amount);
    List<Supplies> getAllSuppliesSortedByDate(int asc, java.sql.Date supplyDate, String seller_name, int amount);
    List<Supplies> getAllSuppliesSortedBySName(int asc, java.sql.Date supplyDate, String seller_name, int amount);
    List<Supplies> getAllSuppliesSortedByAmount(int asc, java.sql.Date supplyDate, String seller_name, int amount);
}