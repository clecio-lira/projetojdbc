package com.projetojdbc;

import com.projetojdbc.entities.Department;
import com.projetojdbc.entities.Seller;
import com.projetojdbc.model.dao.DaoFactory;
import com.projetojdbc.model.dao.SellerDao;

import java.util.Date;

public class Main {
    static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDao.findById(3);

        System.out.println(seller);
    }
}
