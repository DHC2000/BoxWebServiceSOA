package com.hdz.carrillo.api3.services;
import com.hdz.carrillo.api3.models.Titulo;
import com.hdz.carrillo.api3.repositories.IRepository;
import com.hdz.carrillo.api3.repositories.TituloRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TituloService implements IService<Titulo>{

    private IRepository<Titulo> peleadorRepo;
    private Connection con;

    public TituloService(Connection conn){
        peleadorRepo = new TituloRepository(conn);
    }
    @Override
    public List<Titulo> listar() {
        try{
            return  peleadorRepo.listar();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Optional<Titulo> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public void guardar(Titulo titulo) {

    }

    @Override
    public void eliminar(Long id) {

    }
}
