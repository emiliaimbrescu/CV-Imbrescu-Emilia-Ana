package org.example.Repository;

import org.example.Domain.Student;
import org.example.Domain.Validator;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class DbRepository implements Repository0{
    private String url;
    private String username;
    private String password;

    private Validator<Student> validator;
    public DbRepository(String url, String username, String password, Validator<Student> validator) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.validator = validator;
    }

    public Student findOne(Long idCautat) {return null;}

    @Override
    public Iterable<Student> findAll() {
        Set<Student> entities = new HashSet<>();
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * from studenti");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String nume = resultSet.getString("nume");
                String prenume = resultSet.getString("prenume");
                String grupa = resultSet.getString("grupa");
                Double media = resultSet.getDouble("media");

                Student entitate = new Student(id, nume, prenume, grupa, media);
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
    public Student save(Student entity) {
        String sql = "insert into entities (id, nume, prenume, grupa, media) values (?,?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, entity.getId());
            ps.setString(2, entity.getNume());
            ps.setString(3, entity.getPrenume());
            ps.setString(4, entity.getGrupa());
            ps.setDouble(5, entity.getMedia());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Student delete(Long id) {
        return null;
    }


}
