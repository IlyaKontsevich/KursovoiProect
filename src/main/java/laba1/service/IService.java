package laba1.service;

import java.sql.SQLException;
import java.util.List;

public interface IService<ENTITY> {
    ENTITY add(ENTITY entity) throws Exception;
    ENTITY getByName(String name) throws Exception;
    ENTITY update(ENTITY entity) throws SQLException;
    ENTITY getById(Integer id) throws Exception;
    Integer delete(Integer id) throws Exception;
    List<ENTITY> getAll() throws SQLException;
}
