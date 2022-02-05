package ua.ithillel.dao.departmentPart;

import ua.ithillel.dbconnect.DBConnectionFactory;
import ua.ithillel.exception.DaoException;
import ua.ithillel.model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static ua.ithillel.util.AppConstant.ID;
import static ua.ithillel.util.AppConstant.NAME;

public class DepartmentDatabaseDao implements DepartmentDao {
    private static final String INSERT = "INSERT INTO department(name) VALUES(?)";
    private static final String UPDATE = "UPDATE department SET name=? WHERE id=?";
    private static final String DELETE = "DELETE FROM department WHERE id=?";
    private static final String SELECT_ONE = "SELECT * FROM department WHERE id=";
    private static final String SELECT = "SELECT * FROM department";

    @Override
    public Long addDepartment(Department department) throws DaoException {
        Long departmentID = null;
        try (
                Connection con = DBConnectionFactory.build().getConnection();
                PreparedStatement pstm = con.prepareStatement(INSERT)
        ) {
            pstm.setString(1, department.getName());
            int i = pstm.executeUpdate();

            ResultSet gk = pstm.getGeneratedKeys();
            if (gk.next()) {
                departmentID = gk.getLong(ID);
            }
            return departmentID;
        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public void updateDepartment(Department department) throws DaoException {
        Department oldDepartment = getDepartment(department.getId());
        if (Objects.nonNull(oldDepartment)) {
            try (
                    Connection con = DBConnectionFactory.build().getConnection();
                    PreparedStatement pstm = con.prepareStatement(UPDATE)
            ) {
                pstm.setString(1, department.getName());
                pstm.setLong(2, department.getId());


                pstm.executeUpdate();
            } catch (SQLException e) {
                throw new DaoException(e);
            }
        }
    }

    @Override
    public void deleteDepartment(Long id) throws DaoException {

        try (
                Connection con = DBConnectionFactory.build().getConnection();
                PreparedStatement pstm = con.prepareStatement(DELETE)
        ) {

            pstm.setLong(1, id);
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public Department getDepartment(Long id) throws DaoException {
        try (
                Connection con = DBConnectionFactory.build().getConnection();
                PreparedStatement stmt = con.prepareStatement(SELECT_ONE + id)
        ) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Department(
                        rs.getLong(ID),
                        rs.getString(NAME)
                );
            }


        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return null;
    }

    @Override
    public List<Department> findDepartments() throws DaoException {

        List<Department> list = new ArrayList<>();

        try (
                Connection con = DBConnectionFactory.build().getConnection();
                Statement stmt = con.createStatement()
        ) {
            ResultSet rs = stmt.executeQuery(SELECT);
            while (rs.next()) {
                list.add(new Department(rs.getLong(ID), rs.getString(NAME)));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return list;
    }
}
