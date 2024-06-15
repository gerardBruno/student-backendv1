package bygit.student_backend_angular.controllers;

import bygit.student_backend_angular.entities.Payment;
import bygit.student_backend_angular.entities.Student;
import bygit.student_backend_angular.repositories.PaymentRepository;
import bygit.student_backend_angular.repositories.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentController {

    private StudentRepository studentRepository;
    private PaymentRepository paymentRepository;

    public PaymentController(StudentRepository studentRepository, PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
        this.studentRepository = studentRepository;
    }

    @GetMapping(path = "/payments")
    public List<Payment> getAllPayments(){
       return paymentRepository.findAll();
    }

    @GetMapping(path = "/payments/{id}")
    public Payment getPaymentById(@PathVariable Long id){
        return paymentRepository.findById(id).get();
    }

    @GetMapping(path = "/students")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @GetMapping(path = "/students/{id}")
    public Student getStudentsById(@PathVariable String id){
        return studentRepository.findById(id).get();
    }

    public List<Student> getStudentByDepartId(String departId){
        return studentRepository.findByDepartId(departId);
    }
}
