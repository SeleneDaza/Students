package co.edu.uptc.actividadDos.service;

import co.edu.uptc.actividadDos.dto.StudentDTO;
import co.edu.uptc.actividadDos.model.Student;
import co.edu.uptc.actividadDos.persistence.StudentPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentPersistence persistence;
    
    public Student addStudent(StudentDTO dto) {

        Student student = new Student(dto.getName(), dto.getAge());

        persistence.save(student); // ahora guarda SOLO uno

        return student;
    }

    // ✅ SIEMPRE leer del NFS
    public List<Student> getStudents() {
        return persistence.load();
    }
}