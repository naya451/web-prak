package ru.msu.cmc.webprak.DAO.implementation;

import org.springframework.stereotype.Repository;
import ru.msu.cmc.webprak.DAO.SuppliesDAO;
import ru.msu.cmc.webprak.models.Supplies;

import java.sql.Date;
import java.util.List;

@Repository
public class SuppliesDAOimplementation extends CommonDAOimplementation<Supplies, Long> implements SuppliesDAO {

    public SuppliesDAOimplementation(){
        super(Supplies.class);
    }

    private String likeExpr(String param) {
        return "%" + param + "%";
    }


    @Override
    public List<Supplies> getAllSupplies(Date supplyDate, String supply_name, int amount) {
        return null;
    }

    @Override
    public List<Supplies> getAllSuppliesSortedByDate(int asc, Date supplyDate, String seller_name, int amount) {
        return null;
    }

    @Override
    public List<Supplies> getAllSuppliesSortedBySName(int asc, Date supplyDate, String seller_name, int amount) {
        return null;
    }

    @Override
    public List<Supplies> getAllSuppliesSortedByAmount(int asc, Date supplyDate, String seller_name, int amount) {
        return null;
    }
}