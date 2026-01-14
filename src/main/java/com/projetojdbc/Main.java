package com.projetojdbc;

import com.projetojdbc.entities.Department;
import com.projetojdbc.entities.Seller;
import com.projetojdbc.model.dao.DaoFactory;
import com.projetojdbc.model.dao.SellerDao;

import java.util.Date;
import java.util.List;

public class Main {
    static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: seller findByDerpartment ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj: list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 3: seller findAll ===");
        list = sellerDao.findAll();
        for (Seller obj: list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 4: seller insert ===");
        Seller newSeller = new Seller(null, "greg", "greg@email.com", new Date(), 4000.00, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserido: " + newSeller.getId());

        System.out.println("\n=== TEST 5: seller update ===");
        seller = sellerDao.findById(1);
        seller.setName("Marta Waine");
        sellerDao.update(seller);
        System.out.println("Atualizacao completa");
    }
}
