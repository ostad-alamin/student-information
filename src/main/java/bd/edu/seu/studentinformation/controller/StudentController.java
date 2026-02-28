package bd.edu.seu.studentinformation.controller;

import bd.edu.seu.studentinformation.dto.StudentDto;
import bd.edu.seu.studentinformation.model.Student;
import bd.edu.seu.studentinformation.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/get/all")
    public List<Student> getAll(){
        return studentService.getAll();
    }

    @PostMapping("/save")
    public ResponseEntity<Student> create(@RequestBody StudentDto dto) {
        Student created = studentService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/get/{id}")
    public Student getById(@PathVariable Integer id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        studentService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> update(@PathVariable Integer id, @RequestBody StudentDto studentDto) {
        Student s = studentService.updateStudent(id, studentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(s);
    }
}
