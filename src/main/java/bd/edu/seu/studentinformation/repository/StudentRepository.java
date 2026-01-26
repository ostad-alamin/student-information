package bd.edu.seu.studentinformation.repository;

import bd.edu.seu.studentinformation.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

}
