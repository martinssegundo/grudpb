package br.com.grudpb.models;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import io.smallrye.mutiny.Uni;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_pasciente")
@SequenceGenerator(
        name = "personSequence",
        sequenceName = "person_seq",
        allocationSize = 1,
        initialValue = 1)
public class Paciente extends PanacheEntityBase {
    @Id

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personSequence")
    private Long id;
    @Column(name = "ds_nome")
    private String nome;
    @Column(name = "num_idade")
    private Long idade;
    @ElementCollection
    @CollectionTable(name = "tb_consulta", joinColumns = @JoinColumn(name = "paciente_id"))
    @Column(name = "cod_consulta")
    private List<Long> consultas;

    public Paciente(){}

    public Paciente(Long id, String nome, Long idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Long getIdade() {
        return idade;
    }

    public List<Long> getConsultas() {
        return consultas;
    }

    public Uni<Void> addConsulta(Long codConsulta, Paciente paciente) {
        paciente.getConsultas().add(codConsulta);
        return paciente.persistAndFlush().replaceWithVoid();
    }
}
