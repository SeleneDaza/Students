package co.edu.uptc.actividadDos.controller;

import co.edu.uptc.actividadDos.dto.ApiResponse;
import co.edu.uptc.actividadDos.dto.StudentDTO;
import co.edu.uptc.actividadDos.model.Student;
import co.edu.uptc.actividadDos.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @Value("${app.id}")
    private String appId;

    @Value("${service.id}")
    private String serviceId;

    @PostMapping
    public ApiResponse<Student> addStudent(@RequestBody StudentDTO dto) {
        Student student = service.addStudent(dto);
        return new ApiResponse<>(appId, serviceId, student);
    }

    @GetMapping
    public ApiResponse<List<Student>> getStudents() {
        return new ApiResponse<>(appId, serviceId, service.getStudents());
    }
}