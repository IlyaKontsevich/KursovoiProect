package laba1.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface IDao<TYPE> {
    TYPE add(TYPE object) throws Exception;
    TYPE getById(Integer id) throws Exception;
    Integer delete(Integer id) throws SQLException, Exception;
    TYPE update(TYPE object) throws SQLException;
    TYPE getByName(String param) throws Exception;
    List<TYPE> getAll() throws SQLException;
}
