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
    private int cv;
    private int campeonatos;
}