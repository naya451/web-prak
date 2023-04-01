package ru.msu.cmc.webprak.DAO;

import ru.msu.cmc.webprak.models.Buyers;

import java.util.List;

public interface BuyersDAO extends CommonDAO<Buyers, Long> {
    List<Buyers> getAllBuyers(String Name, int AOS, int AOFS);
    List<Buyers> getAllBuyersSortedByName(int asc, String Name, int AOS, int AOFS);
    List<Buyers> getAllBuyersSortedByAOS(int asc, String Name, int AOS, int AOFS);
    List<Buyers> getAllBuyersSortedByAOFS(int asc, String Name, int AOS, int AOFS);

}