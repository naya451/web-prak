package ru.msu.cmc.webprak.DAO.implementation;

import org.springframework.stereotype.Repository;
import ru.msu.cmc.webprak.DAO.BuyersDAO;
import ru.msu.cmc.webprak.models.Buyers;

import java.util.List;

@Repository
public class BuyersDAOimplementation extends CommonDAOimplementation<Buyers, Long> implements BuyersDAO {

    public BuyersDAOimplementation(){
        super(Buyers.class);
    }
    private String likeExpr(String param) {
        return "%" + param + "%";
    }

    @Override
    public List<Buyers> getAllBuyers(String Name, int AOS, int AOFS) {
        return null;
    }

    @Override
    public List<Buyers> getAllBuyersSortedByName(int asc, String Name, int AOS, int AOFS) {
        return null;
    }

    @Override
    public List<Buyers> getAllBuyersSortedByAOS(int asc, String Name, int AOS, int AOFS) {
        return null;
    }

    @Override
    public List<Buyers> getAllBuyersSortedByAOFS(int asc, String Name, int AOS, int AOFS) {
        return null;
    }
}
