package laba1.dao.implementations;

import laba1.dao.interfaces.IDao;
import laba1.model.Room;
import org.postgresql.Driver;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static laba1.dao.utils.UtilsForDao.*;

public class RoomDao implements IDao<Room> {
    public RoomDao() {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Room add(Room room) throws Exception {
        PreparedStatement statement = getCreateStatement("INSERT INTO rooms(name, size, free_places) VALUES (?,?,?)", "id");
        statement.setString(1, room.getName());
        statement.setInt(2, room.getSize());
        statement.setInt(3, room.getFreePlaces());

        return (Room) saveAndExistsCheck(statement, room);
    }

    public Integer delete(Integer id) throws Exception {
        return genericDelete(id, "DELETE FROM rooms WHERE id = ?");
    }

    @Override
    public Room update(Room room) throws SQLException {
        PreparedStatement statement = getCreateStatement("UPDATE rooms SET name = ?, size = ?, free_places = ?", "id");
        statement.setString(1, room.getName());
        statement.setInt(2, room.getSize());
        statement.setInt(3, room.getFreePlaces());

        return (Room) saveAndExistsCheck(statement, room);
    }

    public Room getById(Integer id) throws Exception {
        PreparedStatement statement = createStatement("SELECT * FROM rooms WHERE id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (!resultSet.next())
            return null;

        return new Room(resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getInt("size"),
                resultSet.getInt("free_places"));
    }

    public Room getByName(String name) throws Exception {
        PreparedStatement statement = createStatement("SELECT * FROM rooms WHERE name = ?");
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();
        if (!resultSet.next())
            return null;

        return new Room(resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getInt("size"),
                resultSet.getInt("free_places"));
    }

    @Override
    public List<Room> getAll() throws SQLException {
        PreparedStatement statement = createStatement("SELECT * FROM rooms");
        ResultSet resultSet = statement.executeQuery();

        List<Room> rooms = new ArrayList<>();

        while (resultSet.next()) {
            rooms.add(new Room(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("size"),
                    resultSet.getInt("free_places")));
        }
        return rooms;
    }
}
