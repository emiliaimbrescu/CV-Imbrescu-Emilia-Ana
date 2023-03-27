package org.example.Repository;

import org.example.Domain.Excursie;
import org.example.Domain.Validator;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class DbRepository implements Repository0{
    private String url;
    private String username;
    private String password;

    private Validator<Excursie> validator;
    public DbRepository(String url, String username, String password, Validator<Excursie> validator) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.validator = validator;
    }

    public Excursie findOne(Long idCautat) {return null;}

    @Override
    public Iterable<Excursie> findAll() {
        Set<Excursie> entities = new HashSet<>();
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * from excursii");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String oras = resultSet.getString("oras");
                String atractie = resultSet.getString("atractie");
                String categorie = resultSet.getString("categorie");
                Double pret = resultSet.getDouble("pret");


                Excursie entitate = new Excursie(id, oras, atractie, categorie, pret);
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
    public Excursie save(Excursie entity) {
        String sql = "insert into entities (id, oras, atractie, categorie, pret) values (?,?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, entity.getId());
            ps.setString(2, entity.getOras());
            ps.setString(3, entity.getAtractie());
            ps.setString(4, entity.getCategorie());
            ps.setDouble(5, entity.getPret());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Excursie delete(Long id) {
        return null;
    }


}
