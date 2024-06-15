package bygit.student_backend_angular.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    private Double amount;
    private PaymentType type;
    private LocalDate date;
    private PaymentStatus status;
    private String payment;
    @ManyToOne
    private Student student;

}
