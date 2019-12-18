package laba1.dao.implementations;

import laba1.dao.interfaces.IDao;
import laba1.model.Doctor;
import org.postgresql.Driver;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static laba1.dao.utils.UtilsForDao.*;

public class DoctorDao implements IDao<Doctor> {
    public DoctorDao() {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Doctor add(Doctor doctor) throws Exception {

        PreparedStatement statement = getCreateStatement("INSERT INTO doctors(name) VALUES (?)", "id");
        statement.setString(1, doctor.getName());

        return (Doctor) saveAndExistsCheck(statement, doctor);
    }

    public Integer delete(Integer id) throws Exception {
        return genericDelete(id, "DELETE FROM doctors WHERE id = ?");
    }

    @Override
    public Doctor update(Doctor doctor) throws SQLException {
        PreparedStatement statement = getCreateStatement("UPDATE doctors SET name = ?", "id");
        statement.setString(1, doctor.getName());

        return (Doctor) saveAndExistsCheck(statement, doctor);
    }

    public Doctor getById(Integer id) throws Exception {
        PreparedStatement statement = createStatement("SELECT * FROM doctors WHERE room_id = ?");

        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (!resultSet.next())
            return null;

        return new Doctor(
                resultSet.getString("name"),
                resultSet.getInt("id"));
    }

    public Doctor getByName(String name) throws Exception {
        PreparedStatement statement = createStatement("SELECT * FROM doctors WHERE name = ?");
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();

        if (!resultSet.next())
            return null;

        return new Doctor(
                resultSet.getString("name"),
                resultSet.getInt("id"));
    }

    @Override
    public List<Doctor> getAll() throws SQLException {
        PreparedStatement statement = createStatement("SELECT * FROM doctors");
        ResultSet resultSet = statement.executeQuery();

        List<Doctor> doctors = new ArrayList<>();

        while (resultSet.next()) {
            doctors.add(new Doctor(
                    resultSet.getString("name"),
                    resultSet.getInt("id")));
        }
        return doctors;
    }
}

