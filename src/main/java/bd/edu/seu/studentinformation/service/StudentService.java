package bd.edu.seu.studentinformation.service;

import bd.edu.seu.studentinformation.dto.StudentDto;
import bd.edu.seu.studentinformation.model.Student;
import bd.edu.seu.studentinformation.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student create(StudentDto dto) {
        Student student = new Student();
        applyDto(student, dto);
        return studentRepository.save(student);
    }

    public Student getStudentById(Integer id) {
        return studentRepository.findById(id).get();
    }

    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Integer id, StudentDto dto) {
        Student existing = getStudentById(id);
        applyDto(existing, dto);
        return studentRepository.save(existing);
    }

    private void applyDto(Student student, StudentDto dto) {
        student.setName(dto.getName());
        student.setProgram(dto.getProgram());
        student.setBatch(dto.getBatch());
        student.setCgpa(dto.getCgpa());
    }
}
