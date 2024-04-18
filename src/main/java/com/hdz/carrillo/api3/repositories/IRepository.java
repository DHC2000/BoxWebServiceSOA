package com.hdz.carrillo.api3.repositories;
import java.sql.SQLException;
import java.util.List;

public interface IRepository<T>{

    List<T> listar() throws SQLException;
    T getById(Long id) throws SQLException;
    void guardar(T r) throws SQLException;
    void eliminar(Long id) throws SQLException;
}