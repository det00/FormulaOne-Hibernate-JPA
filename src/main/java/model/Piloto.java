package model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"equipo", "carreras"})
@Entity
@Table(name = "pilotos")
public class Piloto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellidos;
    private int edad;
    private int campeonatos;
    private String pais;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    @ManyToMany
    @JoinTable(
            name = "pilotos_carreras",
            joinColumns = @JoinColumn(name = "piloto_id"),
            inverseJoinColumns = @JoinColumn(name = "carrera_id")
    )
    private List<Carrera> carreras;
}