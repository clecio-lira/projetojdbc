package com.projetojdbc.model.dao;

import com.projetojdbc.Conexao;
import com.projetojdbc.model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
    public static SellerDao createSellerDao() {
        return new SellerDaoJDBC(Conexao.conectar());
    }
}
