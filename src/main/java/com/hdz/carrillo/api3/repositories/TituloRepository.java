package com.hdz.carrillo.api3.repositories;
import com.hdz.carrillo.api3.models.Titulo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TituloRepository implements IRepository<Titulo>{

    private Connection conn;
    private IRepository<Titulo> peleadorRepo;

    public TituloRepository(Connection conn){
        this.conn = conn;
    }
    @Override
    public List<Titulo> listar() throws SQLException {
        List<Titulo> peleador = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM titulos");
            while (rs.next()) {
                Titulo a = this.getTitulo(rs);
                peleador.add(a);
            }
            return peleador;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Titulo getById(Long id) throws SQLException {
        return null;
    }

    @Override
    public void guardar(Titulo r) throws SQLException {

    }

    @Override
    public void eliminar(Long id) throws SQLException {

    }

    private Titulo getTitulo(ResultSet rs) throws SQLException{
        Titulo a = new Titulo();
        a.setId(rs.getLong("id_titulo"));
        a.setNombre(rs.getString("nombre"));
        return a;
    };
}
