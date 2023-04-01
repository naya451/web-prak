package ru.msu.cmc.webprak.DAO;

import ru.msu.cmc.webprak.models.Sellers;

import java.util.List;

public interface SellersDAO extends CommonDAO<Sellers, Long> {
    List<Sellers> getAllSellers(String Name, int AOD, int AOFD);
    List<Sellers> getAllSellersSortedByName(int asc, String Name, int AOD, int AOFD);
    List<Sellers> getAllSellersSortedByAOD(int asc, String Name, int AOD, int AOFD);
    List<Sellers> getAllSellersSortedByAODS(int asc, String Name, int AOD, int AOFD);
}