package model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "pilotos")
@Entity
@Table(name = "carreras")
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private LocalDate fecha;
    private String pais;

    @ManyToMany(mappedBy = "carreras")
    private List<Piloto> pilotos;

    public Carrera(String nombre, LocalDate fecha, String pais, List<Piloto> pilotos) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.pais = pais;
        this.pilotos = pilotos;
    }
}