package laba1.dao.implementations;

import laba1.dao.interfaces.IDao;
import laba1.model.Employee;
import laba1.model.Patient;
import org.postgresql.Driver;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static laba1.dao.utils.UtilsForDao.*;

public class PatientDao implements IDao<Patient> {
    public PatientDao() {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Patient add(Patient patient) throws Exception {
        PreparedStatement statement = getCreateStatement("INSERT INTO patients(name, diagnosis, room_id, doctor_id) " +
                "VALUES (?,?,?,?)", "id");
        statement.setString(1, patient.getName());
        statement.setString(2, patient.getDiagnosis());
        statement.setInt(3, patient.getRoomId());
        statement.setInt(4, patient.getDoctorId());

        return (Patient) saveAndExistsCheck(statement, patient);
    }

    public Integer delete(Integer id) throws Exception {
        return genericDelete(id, "DELETE FROM patients WHERE id = ?");
    }

    @Override
    public Patient update(Patient patient) throws SQLException {
        PreparedStatement statement = getCreateStatement("UPDATE patients SET name = ?, diagnosis = ?, room_id = ?, doctor_id = ?",
                "id");
        statement.setString(1, patient.getName());
        statement.setString(2, patient.getDiagnosis());
        statement.setInt(3, patient.getRoomId());
        statement.setInt(4, patient.getDoctorId());

        return (Patient) saveAndExistsCheck(statement, patient);
    }

    public Patient getById(Integer id) throws Exception {
        PreparedStatement statement = createStatement("SELECT * FROM patients WHERE id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        if (!resultSet.next())
            return null;

        return new Patient(resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getInt("room_id"),
                resultSet.getInt("doctor_id"),
                resultSet.getString("diagnosis"));
    }

    public Patient getByName(String name) throws Exception {
        PreparedStatement statement = createStatement("SELECT * FROM patients WHERE name = ?");
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();

        if (!resultSet.next())
            return null;

        return new Patient(resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getInt("room_id"),
                resultSet.getInt("doctor_id"),
                resultSet.getString("diagnosis"));
    }

    @Override
    public List<Patient> getAll() throws SQLException {
        PreparedStatement statement = createStatement("SELECT * FROM patients");
        ResultSet resultSet = statement.executeQuery();

        List<Patient> patients = new ArrayList<>();

        while (resultSet.next()) {
            patients.add(new Patient(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("room_id"),
                    resultSet.getInt("doctor_id"),
                    resultSet.getString("diagnosis")));
        }
        return patients;
    }
}
