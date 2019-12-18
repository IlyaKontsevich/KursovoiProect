package laba1.dao.implementations;

import laba1.dao.interfaces.IDao;
import laba1.model.Doctor;
import laba1.model.Employee;
import org.postgresql.Driver;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static laba1.dao.utils.UtilsForDao.*;

public class EmployeeDao implements IDao<Employee> {
    public EmployeeDao() {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Employee add(Employee employee) throws Exception {
        PreparedStatement statement = getCreateStatement("INSERT INTO employees(name, position, mobile_phone) " +
                "VALUES (?,?,?)","id");
        statement.setString(1, employee.getName());
        statement.setString(2, employee.getPosition());
        statement.setString(3, employee.getMobilePhone());

        return (Employee) saveAndExistsCheck(statement, employee);
    }

    public Integer delete(Integer id) throws Exception {
        return genericDelete(id, "DELETE FROM employees WHERE id = ?");
    }

    @Override
    public Employee update(Employee employee) throws SQLException {
        PreparedStatement statement = getCreateStatement
                ("UPDATE employees SET name = ?,position = ?, mobile_phone = ? where id = ?","id");
        statement.setString(1, employee.getName());
        statement.setString(2, employee.getPosition());
        statement.setString(3, employee.getMobilePhone());
        statement.setInt(4, employee.getId());

        return (Employee) saveAndExistsCheck(statement, employee);
    }

    public Employee getById(Integer id) throws Exception {
        PreparedStatement statement = createStatement("SELECT * FROM employees WHERE id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        if (!resultSet.next()) //if there not user in DB
            return null;

        return new Employee(resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("mobile_phone"),
                resultSet.getString("position"));
    }

    public Employee getByName(String name) throws Exception {
        PreparedStatement statement = createStatement("SELECT * FROM employees WHERE name = ?");
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();

        if (!resultSet.next())
            return null;

        return new Employee(resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("mobile_phone"),
                resultSet.getString("position"));
    }

    @Override
    public List<Employee> getAll() throws SQLException {
        PreparedStatement statement = createStatement("SELECT * FROM employees");
        ResultSet resultSet = statement.executeQuery();

        List<Employee> employees = new ArrayList<>();

        while (resultSet.next()) {
            employees.add(new Employee(resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("mobile_phone"),
                resultSet.getString("position")));
        }
        return employees;
    }
}

