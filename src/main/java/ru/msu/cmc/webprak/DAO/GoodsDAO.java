package ru.msu.cmc.webprak.DAO;

import lombok.Builder;
import lombok.Getter;
import ru.msu.cmc.webprak.models.Goods;

import java.util.List;

public interface GoodsDAO extends CommonDAO<Goods, Long> {

    List<Goods> getAllGoodsByName(String goodName);
    Goods getSingleGoodByName(String goodName);
    List<Goods> getByFilter(Filter filter);

    @Builder
    @Getter
    class Filter {
        private String name;
        private String type;
        private Long availability;
    }

    static Filter.FilterBuilder getFilterBuilder() {
        return Filter.builder();
    }
}