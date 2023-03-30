package ru.msu.cmc.webprak.DAO;

import lombok.Builder;
import lombok.Getter;
import ru.msu.cmc.webprak.models.Supplies;

import java.util.List;

public interface SuppliesDAO extends CommonDAO<Supplies, Long> {

    List<Supplies> getAllSuppliesByName(String supplyName);
    Supplies getSingleSupplieByName(String supplyName);
    List<Supplies> getByFilter(Filter filter);

    @Builder
    @Getter
    class Filter {
        private String name;
    }

    static Filter.FilterBuilder getFilterBuilder() {
        return Filter.builder();
    }
}