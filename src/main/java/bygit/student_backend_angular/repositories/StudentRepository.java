package bygit.student_backend_angular.repositories;

import bygit.student_backend_angular.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
        List<Student> findByDepartId(String deptId);
}
