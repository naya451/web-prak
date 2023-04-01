package ru.msu.cmc.webprak.DAO.implementation;

import org.springframework.stereotype.Repository;
import ru.msu.cmc.webprak.DAO.Warehouse_conditionDAO;
import ru.msu.cmc.webprak.models.Warehouse_condition;

import java.util.List;

@Repository
public class Warehouse_conditionDAOimplementation extends CommonDAOimplementation<Warehouse_condition, Long> implements Warehouse_conditionDAO {

    public Warehouse_conditionDAOimplementation(){
        super(Warehouse_condition.class);
    }

    private String likeExpr(String param) {
        return "%" + param + "%";
    }


    @Override
    public List<Warehouse_condition> getAllFreePlaces() {
        return null;
    }

    @Override
    public Warehouse_condition getPlacesByTypes(String type) {
        return null;
    }
}