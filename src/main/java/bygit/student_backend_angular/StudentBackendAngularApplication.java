package bygit.student_backend_angular;

import bygit.student_backend_angular.entities.Payment;
import bygit.student_backend_angular.entities.PaymentStatus;
import bygit.student_backend_angular.entities.PaymentType;
import bygit.student_backend_angular.entities.Student;
import bygit.student_backend_angular.repositories.PaymentRepository;
import bygit.student_backend_angular.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class StudentBackendAngularApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private PaymentRepository paymentRepository;

	public static void main(String[] args) {
		SpringApplication.run(StudentBackendAngularApplication.class, args);

		//Creation d'un pour insérer les données

	}

	@Override
	public void run(String... args) throws Exception {

		studentRepository.save(Student.builder().studentId(UUID.randomUUID().toString()).firstName("Gery")
				.lastName("gery")
				.departId("ING1").build());
		studentRepository.save(Student.builder().studentId(UUID.randomUUID().toString()).firstName("Arthur")
				.lastName("Arthur")
				.departId("ING1").build());
		studentRepository.save(Student.builder().studentId(UUID.randomUUID().toString()).firstName("Ilmane")
				.lastName("Ilmane")
				.departId("ING1").build());
		studentRepository.save(Student.builder().studentId(UUID.randomUUID().toString()).firstName("Arouna")
				.lastName("Arouane")
				.departId("ING1").build());

		studentRepository.save(Student.builder().studentId(UUID.randomUUID().toString()).firstName("Laeti")
				.lastName("Gerne")
				.departId("ING1").build());

		Random random = new Random();
		PaymentType[] paymentTypes = PaymentType.values();
		studentRepository.findAll().forEach(student -> {
			int index = random.nextInt(paymentTypes.length);
			for (int i = 0; i <10; i++){
				Payment payment = Payment.builder()
						.amount(1000 + (Double)(Math.random() +2000))
						.type(paymentTypes[index])
						.status(PaymentStatus.CREATED)
						.date(LocalDate.now())
						.student(student)
						.build();
				paymentRepository.save(payment);
			}

		});
	}
}
