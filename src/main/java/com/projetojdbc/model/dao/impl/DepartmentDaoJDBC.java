package com.projetojdbc.model.dao.impl;

import com.projetojdbc.Conexao;
import com.projetojdbc.DbIntegrityException;
import com.projetojdbc.entities.Department;
import com.projetojdbc.entities.Seller;
import com.projetojdbc.model.dao.DepartmentDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {
    private Connection conn;

    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department obj) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
              "INSERT INTO department "
              + "(Name) VALUES (?)", Statement.RETURN_GENERATED_KEYS
            );

            st.setString(1, obj.getName());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
                Conexao.closeResultSet(rs);
            } else {
                throw new DbIntegrityException("Erro inesperado");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            Conexao.closeStatement(st);
        }
    }

    @Override
    public void update(Department obj) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                    "UPDATE department "
                    + "SET Name = ? "
                    + "WHERE Id = ?", Statement.RETURN_GENERATED_KEYS
            );

            st.setString(1, obj.getName());
            st.setInt(2, obj.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        } finally {
            Conexao.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                    "DELETE FROM department WHERE Id = ?"
            );

            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        } finally {
            Conexao.closeStatement(st);
        }
    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT * "
                    + "FROM department "
                    + "WHERE Id = ?"
            );

            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                Department dep = instantiateDepartment(rs);

                return dep;
            }

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar departamento", e);
        } finally {
            Conexao.closeStatement(st);
            Conexao.closeResultSet(rs);
        }
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT * FROM department"
            );

            rs = st.executeQuery();

            List<Department> list = new ArrayList<>();
            while (rs.next()) {
                Department dep = instantiateDepartment(rs);

                list.add(dep);
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar os departamentos", e);
        } finally {
            Conexao.closeStatement(st);
            Conexao.closeResultSet(rs);
        }
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department();
        dep.setId(rs.getInt("Id"));
        dep.setName(rs.getString("Name"));

        return dep;
    }
}
