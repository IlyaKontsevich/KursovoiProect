package laba1.service;

import laba1.dao.interfaces.IDao;

import java.sql.SQLException;
import java.util.List;

public class GenericService<ENTITY> implements IService<ENTITY> {
    IDao<ENTITY> dao ;

    public GenericService(IDao<ENTITY> dao) {
        this.dao = dao;
    }

    @Override
    public ENTITY add(ENTITY entity) throws Exception {
        return dao.add(entity);
    }

    @Override
    public ENTITY getByName(String name) throws Exception {
        return dao.getByName(name);
    }

    @Override
    public ENTITY update(ENTITY entity) throws SQLException {
        return dao.update(entity);
    }

    @Override
    public ENTITY getById(Integer id) throws Exception {
        return dao.getById(id);
    }

    @Override
    public Integer delete(Integer id) throws Exception {
        return dao.delete(id);
    }

    @Override
    public List<ENTITY> getAll() throws SQLException {
        return dao.getAll();
    }
}
