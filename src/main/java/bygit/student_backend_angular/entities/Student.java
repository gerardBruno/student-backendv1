package bygit.student_backend_angular.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Student {
    @Id
    private String studentId;
    private String firstName;
    private String lastName;
    @Column(unique = true)//unicité en bdd
    private String code;
    private String photo;
    private String departId;
}
