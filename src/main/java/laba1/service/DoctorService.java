package laba1.service;

import laba1.dao.implementations.DoctorDao;
import laba1.dao.interfaces.IDao;
import laba1.model.Doctor;

public class DoctorService extends GenericService<Doctor> {
    public DoctorService() {
        super(new DoctorDao());
    }
}
