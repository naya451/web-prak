package ru.msu.cmc.webprak.DAO;

import lombok.Builder;
import lombok.Getter;
import ru.msu.cmc.webprak.models.Deliveries;
import ru.msu.cmc.webprak.models.Supplies;

import java.util.List;

public interface SuppliesDAO extends CommonDAO<Supplies, Long> {

    List<Supplies> getAllSuppliesByDate(java.sql.Date supplyDate);

    List<Deliveries> getAllSuppliesByBuyer(String seller_name);
    List<Deliveries> getByFilter(Filter filter);

    @Builder
    @Getter
    class Filter {
        private java.sql.Date date;
        private Long amount;
        private String seller_name;
    }

    static Filter.FilterBuilder getFilterBuilder() {
        return Filter.builder();
    }
}