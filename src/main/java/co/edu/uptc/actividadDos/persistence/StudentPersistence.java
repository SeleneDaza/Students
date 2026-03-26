package co.edu.uptc.actividadDos.persistence;

import co.edu.uptc.actividadDos.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentPersistence {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(Student student) {
        String sql = "INSERT INTO estudiantes (nombre, edad) VALUES (?, ?)";
        jdbcTemplate.update(sql, student.getName(), student.getAge());
    }

    public List<Student> load() {
        String sql = "SELECT * FROM estudiantes";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Student(
                        rs.getString("nombre"),
                        rs.getInt("edad")
                )
        );
    }
}