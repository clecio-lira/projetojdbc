package com.projetojdbc;

import com.projetojdbc.entities.Department;
import com.projetojdbc.entities.Seller;
import com.projetojdbc.model.dao.DaoFactory;
import com.projetojdbc.model.dao.SellerDao;

import java.util.Date;

public class Main {
    static void main(String[] args) {
        Department obj = new Department(1, "Books");
        System.out.println(obj);

        Seller obj1 = new Seller(1, "clecio", "clecio@email.com", new Date(), 3000.00, obj);
        System.out.println(obj1);

        SellerDao sellerDao = DaoFactory.createSellerDao();
    }
}
