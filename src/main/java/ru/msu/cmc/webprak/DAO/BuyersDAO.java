package ru.msu.cmc.webprak.DAO;

import lombok.Builder;
import lombok.Getter;
import ru.msu.cmc.webprak.models.Buyers;

import java.util.List;

public interface BuyersDAO extends CommonDAO<Buyers, Long> {

    List<Buyers> getAllBuyersByName(String buyerName);
    Buyers getSingleBuyerByName(String buyerName);
    List<Buyers> getByFilter(Filter filter);

    @Builder
    @Getter
    class Filter {
        private String name;
    }

    static Filter.FilterBuilder getFilterBuilder() {
        return Filter.builder();
    }
}