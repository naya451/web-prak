package ru.msu.cmc.webprak.DAO.implementation;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.msu.cmc.webprak.DAO.SellersDAO;
import ru.msu.cmc.webprak.models.Sellers;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SellersDAOimplementation extends CommonDAOimplementation<Sellers, Long> implements SellersDAO {

    public SellersDAOimplementation(){
        super(Sellers.class);
    }



    private String likeExpr(String param) {
        return "%" + param + "%";
    }

    @Override
    public List<Sellers> getAllSellers(String Name, int AOD, int AOFD) {
        return null;
    }

    @Override
    public List<Sellers> getAllSellersSortedByName(int asc, String Name, int AOD, int AOFD) {
        return null;
    }

    @Override
    public List<Sellers> getAllSellersSortedByAOD(int asc, String Name, int AOD, int AOFD) {
        return null;
    }

    @Override
    public List<Sellers> getAllSellersSortedByAODS(int asc, String Name, int AOD, int AOFD) {
        return null;
    }
}