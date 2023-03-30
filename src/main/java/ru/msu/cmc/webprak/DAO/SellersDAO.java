package ru.msu.cmc.webprak.DAO;

import lombok.Builder;
import lombok.Getter;
import ru.msu.cmc.webprak.models.Sellers;

import java.util.List;

public interface SellersDAO extends CommonDAO<Sellers, Long> {

    List<Sellers> getAllSellersByName(String sellerName);
    Sellers getSingleSellerByName(String sellerName);
    List<Sellers> getByFilter(Filter filter);

    @Builder
    @Getter
    class Filter {
        private String name;
    }

    static Filter.FilterBuilder getFilterBuilder() {
        return Filter.builder();
    }
}