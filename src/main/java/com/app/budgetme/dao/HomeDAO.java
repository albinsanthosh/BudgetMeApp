package com.app.budgetme.dao;

import com.app.budgetme.utility.homeRes;

import java.util.List;

public interface HomeDAO {

    List<homeRes>[] fetchHomeData(String month);
}
