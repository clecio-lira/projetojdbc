package com.projetojdbc;

import com.projetojdbc.entities.Department;
import com.projetojdbc.entities.Seller;
import com.projetojdbc.model.dao.DaoFactory;
import com.projetojdbc.model.dao.DepartmentDao;
import com.projetojdbc.model.dao.SellerDao;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//
//        SellerDao sellerDao = DaoFactory.createSellerDao();
//
//        System.out.println("=== TEST 1: seller findById ===");
//        Seller seller = sellerDao.findById(3);
//        System.out.println(seller);
//
//        System.out.println("\n=== TEST 2: seller findByDerpartment ===");
//        Department department = new Department(2, null);
//        List<Seller> list = sellerDao.findByDepartment(department);
//        for (Seller obj: list) {
//            System.out.println(obj);
//        }
//
//        System.out.println("\n=== TEST 3: seller findAll ===");
//        list = sellerDao.findAll();
//        for (Seller obj: list) {
//            System.out.println(obj);
//        }
//
//        System.out.println("\n=== TEST 4: seller insert ===");
//        Seller newSeller = new Seller(null, "greg", "greg@email.com", new Date(), 4000.00, department);
//        sellerDao.insert(newSeller);
//        System.out.println("Inserido: " + newSeller.getId());
//
//        System.out.println("\n=== TEST 5: seller update ===");
//        seller = sellerDao.findById(1);
//        seller.setName("Marta Waine");
//        sellerDao.update(seller);
//        System.out.println("Atualizacao completa");
//
//        System.out.println("\n=== TEST 6: seller delete ===");
//        System.out.println("Digite o id para ser deletado: ");
//        int id = sc.nextInt();
//        sellerDao.deleteById(id);
//        System.out.println("Deletado");
//

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: department findById ===");
        Department department = departmentDao.findById(1);
        System.out.println(department);

        System.out.println("\n=== TEST 2: department findAll ===");
        List<Department> list = departmentDao.findAll();
        for (Department obj: list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 3: department insert ===");
        Department newDepartment = new Department(null, "greg");
        departmentDao.insert(newDepartment);
        System.out.println("Inserido: " + newDepartment.getId());

        System.out.println("\n=== TEST 4: department update ===");
        department = departmentDao.findById(1);
        department.setName("Marta Waine");
        departmentDao.update(department);
        System.out.println("Atualizacao completa");

        System.out.println("\n=== TEST 5: department delete ===");
        System.out.println("Digite o id para ser deletado: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Deletado");

        sc.close();
    }


}
