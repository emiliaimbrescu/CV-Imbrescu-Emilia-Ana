package org.example.Repository;

import org.example.Domain.Produs;
import org.example.Domain.Validator;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class DbRepository implements Repository0{
    private String url;
    private String username;
    private String password;

    private Validator<Produs> validator;
    public DbRepository(String url, String username, String password, Validator<Produs> validator) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.validator = validator;
    }

    public Produs findOne(Long idCautat) {return null;}

    @Override
    public Iterable<Produs> findAll() {
        Set<Produs> entities = new HashSet<>();
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * from produse");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String nume = resultSet.getString("nume");
                String categorie = resultSet.getString("categorie");
                String descriere = resultSet.getString("descriere");
                Double pret = resultSet.getDouble("pret");

                Produs entitate = new Produs(id, nume, categorie, descriere, pret);
                entitate.setId(id);
                entities.add(entitate);

            }
            return entities;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities;
    }

    @Override
    public Produs save(Produs entity) {
        String sql = "insert into entities (id, nume, categorie, descriere, pret) values (?,?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, entity.getId());
            ps.setString(2, entity.getNume());
            ps.setString(3, entity.getCategorie());
            ps.setString(4, entity.getDescriere());
            ps.setDouble(5, entity.getPret());
            /*
            ps.setString(1, entity.getTitlu());
            ps.setString(2, entity.getAutor());
            ps.setString(3, entity.getGen());
            ps.setDouble(4, entity.getPret());*/

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Produs delete(Long id) {
        return null;
    }


}
