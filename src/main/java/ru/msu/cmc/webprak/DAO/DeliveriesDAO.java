package ru.msu.cmc.webprak.DAO;

import lombok.Builder;
import lombok.Getter;
import ru.msu.cmc.webprak.models.Deliveries;

import java.util.List;

public interface DeliveriesDAO extends CommonDAO<Deliveries, Long> {

    List<Deliveries> getAllDeliveriesByName(String deliveryName);
    Deliveries getSingleDeliveryByName(String deliveryName);
    List<Deliveries> getByFilter(Filter filter);

    @Builder
    @Getter
    class Filter {
        private String name;
    }

    static Filter.FilterBuilder getFilterBuilder() {
        return Filter.builder();
    }
}