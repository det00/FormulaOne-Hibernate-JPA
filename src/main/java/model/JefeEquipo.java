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

    public JefeEquipo(String nombre, String apellido, String pais, int edad, Equipo equipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.pais = pais;
        this.edad = edad;
        this.equipo = equipo;
    }

    private int edad;

    @OneToOne(mappedBy = "jefeEquipo")
    private Equipo equipo;
}
