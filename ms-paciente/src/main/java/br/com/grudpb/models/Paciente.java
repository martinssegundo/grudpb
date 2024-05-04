package br.com.grudpb.models;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import io.smallrye.mutiny.Uni;
import jakarta.persistence.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.List;
import java.util.Vector;

@Entity
@Table(name = "tb_pasciente")
@Schema(name = "paciente")
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
    @CollectionTable(name = "tb_paciente_consulta", joinColumns = @JoinColumn(name = "paciente_id"))
    @Column(name = "cod_consulta")
    private List<Long> consultas;

    public Paciente(){}

    public Paciente(Long id, String nome, Long idade, Long codConsulta) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.addConsulta(codConsulta, this);
    }

    public Paciente(String nome, Long codConsulta) {
        this.nome = nome;
        this.addConsulta(codConsulta, this);
    }

    public Paciente(Long id, String nome, Long codConsulta) {
        this.id = id;
        this.nome = nome;
        this.addConsulta(codConsulta, this);
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(Long idade) {
        this.idade = idade;
    }

    public Uni<Void> addConsulta(Long codConsulta, Paciente paciente) {
        if(consultas == null)
            consultas = new Vector<>();
        paciente.getConsultas().add(codConsulta);
        return paciente.persistAndFlush().replaceWithVoid();
    }
}
