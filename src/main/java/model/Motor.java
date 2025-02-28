package model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "motores")
public class Motor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;

    @OneToMany(mappedBy = "motor", cascade = CascadeType.ALL)
    private List<Equipo> equipos;

    public Motor(String nombre, List<Equipo> equipos, int cv, int campeonatos) {
        this.nombre = nombre;
        this.equipos = equipos;
        this.cv = cv;
        this.campeonatos = campeonatos;
    }

    private int cv;
    private int campeonatos;
}