package bygit.student_backend_angular.repositories;

import bygit.student_backend_angular.entities.Payment;
import bygit.student_backend_angular.entities.PaymentStatus;
import bygit.student_backend_angular.entities.PaymentType;
import bygit.student_backend_angular.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository  extends JpaRepository<Payment, Long> {
    List<Student> findByStudentCode(String Code);
    List<Student> findByStatus(PaymentStatus status);
    List<Student> findByType(PaymentType paymentType);

}
