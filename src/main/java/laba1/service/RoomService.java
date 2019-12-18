package laba1.service;

import laba1.dao.implementations.RoomDao;
import laba1.model.Room;

import java.sql.SQLException;
import java.util.List;

public class RoomService extends GenericService<Room> {
    public RoomService() {
        super(new RoomDao());
    }

    public List<Room> getFreeRooms() throws SQLException {
        List<Room> rooms = dao.getAll();
        for(Room room : rooms){
            if(room.getFreePlaces() == 0){
                rooms.remove(room);
            };
        }
        return rooms;
    }
}
