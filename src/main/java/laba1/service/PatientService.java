package laba1.service;

import laba1.dao.implementations.PatientDao;
import laba1.dao.interfaces.IDao;
import laba1.model.Patient;
import laba1.model.Room;

public class PatientService extends GenericService<Patient> {
    private IService<Room> roomService = new RoomService();

    public PatientService() {
        super(new PatientDao());
    }

    @Override
    public Patient add(Patient patient) throws Exception {
        Room room = roomService.getById(patient.getRoomId());
        if(room.getFreePlaces() > 0){
            room.setFreePlaces(room.getFreePlaces()-1);
            roomService.update(room);
        }else {
            return null;
        }
        return super.add(patient);
    }

}
