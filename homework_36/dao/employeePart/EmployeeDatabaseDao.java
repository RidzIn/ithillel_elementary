package ua.ithillel.dao.employeePart;

import ua.ithillel.dbconnect.DatabaseConnectionSingleton;
import ua.ithillel.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmployeeDatabaseDao implements EmployeeDao {
    @Override
    public Long addEmployee(Employee employee) {
        Connection con = DatabaseConnectionSingleton.getInstance().getConnection();
        Long employeeID = null;
        try {
            String sql = "INSERT INTO employee (name, salary, department_id, chief_id) VALUES (?, ?, ?, ?)";
            PreparedStatement pstm = con.prepareStatement(sql);
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
            //  con.close();
            return employeeID;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateEmployee(Employee employee) {
        Employee oldEmployee = getEmployee(employee.getId());
        if (Objects.nonNull(oldEmployee)) {
            Connection con = DatabaseConnectionSingleton.getInstance().getConnection();
            try {
                String sql = "UPDATE Employee " +
                        "SET name = ?,salary = ?, department_id = ?, chief_id = ?" +
                        "WHERE id=?";

                PreparedStatement pstm = con.prepareStatement(sql);
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
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        Connection con = DatabaseConnectionSingleton.getInstance().getConnection();
        try {

            String sql = "DELETE FROM employee WHERE id=?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setLong(1, id);
            pstm.executeUpdate();

            //    con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee getEmployee(Long id) {
        Connection con = DatabaseConnectionSingleton.getInstance().getConnection();
        try (Statement stmt = con.createStatement()) {

            String sql = "SELECT * FROM employee WHERE ID=" + id;
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                Long chief_id = rs.getLong("chief_id");
                if (rs.wasNull()) {
                    chief_id = null;
                }
                return new Employee(
                        rs.getLong("id"),
                        rs.getLong("department_id"),
                        chief_id,
                        rs.getString("name"),
                        rs.getInt("salary")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Employee> findEmployees() {
        Connection con = DatabaseConnectionSingleton.getInstance().getConnection();
        List<Employee> employeeList = new ArrayList<>();
        try (Statement stmt = con.createStatement()) {

            String sql = "SELECT * FROM employee";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Long chief_id = rs.getLong("chief_id");
                if (rs.wasNull()) {
                    chief_id = null;
                }
                Employee employee = new Employee(
                        rs.getLong("id"),
                        rs.getLong("department_id"),
                        chief_id,
                        rs.getString("name"),
                        rs.getInt("salary")
                );
                employeeList.add(employee);
            }
            //    con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}

