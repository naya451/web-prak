package ru.msu.cmc.webprak.DAO;

import lombok.Builder;
import lombok.Getter;
import ru.msu.cmc.webprak.models.Deliveries;

import java.util.List;

public interface DeliveriesDAO extends CommonDAO<Deliveries, Long> {

    List<Deliveries> getAllDeliveriesByDate(java.sql.Date deliveryDate);

    List<Deliveries> getAllDeliveriesByBuyer(String buyer_name);
    List<Deliveries> getByFilter(Filter filter);

    @Builder
    @Getter
    class Filter {
        private java.sql.Date date;
        private Long amount;
        private String buyer_name;
    }

    static Filter.FilterBuilder getFilterBuilder() {
        return Filter.builder();
    }
}