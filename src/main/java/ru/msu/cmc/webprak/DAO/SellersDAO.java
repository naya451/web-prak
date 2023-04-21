package ru.msu.cmc.webprak.DAO;

import ru.msu.cmc.webprak.models.Sellers;

import java.util.List;

public interface SellersDAO extends CommonDAO<Sellers, Long> {
    List<Sellers> getAllSellers();

    List<Sellers> getAllSellersByName(String SellersName);

    List<Sellers> getAllSellersByNameSortedWithNameASC(String SellersName);

    List<Sellers> getAllSellersByNameSortedWithNameDESC(String SellersName);

    List<Sellers> getAllSellersByNameSortedWithYearsSuppliesASC(String SellersName);

    List<Sellers> getAllSellersByNameSortedWithYearsSuppliesDESC(String SellersName);

    List<Sellers> getAllSellersByNameSortedWithSuppliesASC(String SellersName);

    List<Sellers> getAllSellersByNameSortedWithSuppliesDESC(String SellersName);

    Sellers getSingleSellerByName(String SellersName);
}