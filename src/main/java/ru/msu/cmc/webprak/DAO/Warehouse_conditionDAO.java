package ru.msu.cmc.webprak.DAO;

import lombok.Builder;
import lombok.Getter;
import ru.msu.cmc.webprak.models.Warehouse_condition;

import java.util.List;

public interface Warehouse_conditionDAO extends CommonDAO<Warehouse_condition, Long> {

    List<Warehouse_condition> getAllWarehouse_conditionByName(String goodName);
    Warehouse_condition getSingleGoodByName(String goodName);
    List<Warehouse_condition> getByFilter(Filter filter);

    @Builder
    @Getter
    class Filter {
        private String name;
    }

    static Filter.FilterBuilder getFilterBuilder() {
        return Filter.builder();
    }
}