package bd.edu.seu.studentinformation.controller;

import bd.edu.seu.studentinformation.model.Student;
import bd.edu.seu.studentinformation.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String studentEntry() {
        return "student-entry";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student, Model model) {
        Student savedStudent = studentService.save(student);
        model.addAttribute("s", savedStudent);
        return "success";
    }
}
