package model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString(exclude = "equipo")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jefes_equipo")
public class JefeEquipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellido;
    private String pais;
    private int edad;

    @OneToOne(mappedBy = "jefeEquipo", cascade = CascadeType.ALL)
    private Equipo equipo;
}
