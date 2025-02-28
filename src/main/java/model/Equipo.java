package model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"motor", "pilotos", "jefeEquipo"})
@Entity
@Table(name = "equipos")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;

    public Equipo(String nombre, Motor motor, List<Piloto> pilotos, JefeEquipo jefeEquipo, String pais, int yearFundado, int campeonatosDeEquipos, int campeonatosDePilotos) {
        this.nombre = nombre;
        this.motor = motor;
        this.pilotos = pilotos;
        this.jefeEquipo = jefeEquipo;
        this.pais = pais;
        this.yearFundado = yearFundado;
        this.campeonatosDeEquipos = campeonatosDeEquipos;
        this.campeonatosDePilotos = campeonatosDePilotos;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "motor_id")
    private Motor motor;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
    private List<Piloto> pilotos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "jefe_equipo_id")
    private JefeEquipo jefeEquipo;

    private String pais;
    private int yearFundado;
    private int campeonatosDeEquipos;
    private int campeonatosDePilotos;
}