package ua.ithillel.dao.employeePart;

import ua.ithillel.dbconnect.DBConnectionFactory;
import ua.ithillel.exception.DaoException;
import ua.ithillel.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static ua.ithillel.util.AppConstant.*;

public class EmployeeDatabaseDao implements EmployeeDao {

    private static final String INSERT = "INSERT INTO employee (name, salary, department_id, chief_id) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE employee SET name = ?, salary = ?, department_id = ?, chief_id = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM employee WHERE id = ?";
    private static final String SELECT_ONE = "SELECT * FROM employee WHERE id = ?";
    private static final String SELECT = "SELECT * FROM employee";

    @Override
    public Long addEmployee(Employee employee) throws DaoException {
        Long employeeID = null;
        try (
                Connection con = DBConnectionFactory.build().getConnection();
                PreparedStatement pstm = con.prepareStatement(INSERT)
        ) {

            pstm.setString(1, employee.getName());
            pstm.setInt(2, employee.getSalary());
            pstm.setLong(3, employee.getDepartmentId());
            if (Objects.isNull(employee.getChiefId())) {
                pstm.setNull(4, Types.NULL);
            } else {
                pstm.setLong(4, employee.getChiefId());
            }
            int i = pstm.executeUpdate();
            ResultSet gk = pstm.getGeneratedKeys();
            if (gk.next()) {
                employeeID = gk.getLong("id");
            }
            return employeeID;
        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public void updateEmployee(Employee employee) throws DaoException {
        Employee oldEmployee = getEmployee(employee.getId());
        if (Objects.nonNull(oldEmployee)) {
            try (
                    Connection con = DBConnectionFactory.build().getConnection();
                    PreparedStatement pstm = con.prepareStatement(UPDATE)
            ) {
                pstm.setString(1, employee.getName());
                pstm.setInt(2, employee.getSalary());
                pstm.setLong(3, employee.getDepartmentId());
                if (Objects.isNull(employee.getChiefId())) {
                    pstm.setNull(4, Types.NULL);
                } else {
                    pstm.setLong(4, employee.getChiefId());
                }
                pstm.setLong(5, employee.getId());
                pstm.executeUpdate();

            } catch (SQLException e) {
                throw new DaoException(e);
            }
        }
    }

    @Override
    public void deleteEmployee(Long id) throws DaoException {

        try (
                Connection con = DBConnectionFactory.build().getConnection();
                PreparedStatement pstm = con.prepareStatement(DELETE)
        ) {
            pstm.setLong(1, id);
            pstm.executeUpdate();

            //    con.close();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Employee getEmployee(Long id) throws DaoException {
        try (
                Connection con = DBConnectionFactory.build().getConnection();
                PreparedStatement stmt = con.prepareStatement(SELECT_ONE)
        ) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Long chiefId = rs.getLong(CHIEF_ID);
                if (rs.wasNull()) {
                    chiefId = null;
                }
                return new Employee(
                        rs.getLong(ID),
                        rs.getLong(DEPARTMENT_ID),
                        chiefId,
                        rs.getString(NAME),
                        rs.getInt(SALARY)
                );
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return null;
    }


    @Override
    public List<Employee> findEmployees() throws DaoException {

        List<Employee> employeeList = new ArrayList<>();
        try (
                Connection con = DBConnectionFactory.build().getConnection();
                Statement stmt = con.createStatement()
        ) {
            ResultSet rs = stmt.executeQuery(SELECT);
            while (rs.next()) {
                Long chief_id = rs.getLong(CHIEF_ID);
                if (rs.wasNull()) {
                    chief_id = null;
                }
                Employee employee = new Employee(
                        rs.getLong(ID),
                        rs.getLong(DEPARTMENT_ID),
                        chief_id,
                        rs.getString(NAME),
                        rs.getInt(SALARY)
                );
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return employeeList;
    }
}

