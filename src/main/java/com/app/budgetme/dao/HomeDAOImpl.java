package com.app.budgetme.dao;

import com.app.budgetme.utility.homeRes;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HomeDAOImpl implements HomeDAO{

    private EntityManager entityManager;

    public HomeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<homeRes>[] fetchHomeData(String month) {
        String queryStr = "SELECT p.category, SUM(t.spent) AS actual, p.planned, (p.planned-SUM(t.spent)) AS 'cat_balance', " +
                "p.month FROM budgetme.transaction t INNER JOIN budgetme.planning p ON t.category=p.category " +
                "WHERE t.month=?1 GROUP BY category, planned, month ORDER BY category";
        try {
            Query query = entityManager.createNativeQuery(queryStr);
            query.setParameter(1, month);

            List<Object[]> results = query.getResultList();
            ArrayList<homeRes> homeResList=new ArrayList<>();
            for (Object[] result: results) {
                homeRes ahomeRes = new homeRes((String) result[0], (Double) result[1], (Double) result[2], (Double) result[3], (String) result[4]);
                homeResList.add(ahomeRes);
            }

            return new ArrayList[]{homeResList};
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
