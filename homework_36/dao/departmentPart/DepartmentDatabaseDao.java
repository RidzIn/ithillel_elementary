package ua.ithillel.dao.departmentPart;

import ua.ithillel.dbconnect.DatabaseConnectionSingleton;
import ua.ithillel.model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDatabaseDao implements DepartmentDao {
    @Override
    public Long addDepartment(Department department) {
        Connection con = DatabaseConnectionSingleton.getInstance().getConnection();
        String sql = "INSERT INTO department(name) VALUES(?)";
        Long departmentID = null;
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, department.getName());
           int i =  pstm.executeUpdate();

            ResultSet gk = pstm.getGeneratedKeys();
            if(gk.next()){
                departmentID = gk.getLong("id");
            }
            return departmentID;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateDepartment(Department department) {
        Connection con = DatabaseConnectionSingleton.getInstance().getConnection();
        String sql = "UPDATE department " +
                "SET name=? " +
                "WHERE id=?";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, department.getName());
            pstm.setLong(2,department.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteDepartment(Long id) {
        Connection con = DatabaseConnectionSingleton.getInstance().getConnection();
        String sql = "DELETE FROM department WHERE id=?";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setLong(1, id);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Department getDepartment(Long id) {
        Connection con = DatabaseConnectionSingleton.getInstance().getConnection();
        String sql = "SELECT * FROM department WHERE id="+id;
        try (Statement stmt = con.createStatement()){
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                return new Department(
                        rs.getLong("id"),
                        rs.getString("name")
                );
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Department> findDepartments() {
        Connection con = DatabaseConnectionSingleton.getInstance().getConnection();
        List<Department> list = new ArrayList<>();
        String sql = "SELECT * FROM department";
        try(Statement stmt = con.createStatement()){
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                list.add(new Department(rs.getLong("id"),rs.getString("name")));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
       return list;
    }
}
