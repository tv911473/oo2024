package ee.tlu.kontrolltoo2;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class River {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nimi;
    private double start_x;
    private double start_y;
    private double end_x;
    private double end_y;
    private double speed;

    @ManyToOne
    private Lake lake;
}