package br.gov.sp.fatec.springboot3app2025.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cor_correcao")
public class CorCorrecao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cor_id")
    private Long id;

    @Column(name = "cor_feedback", nullable = false, length = 100)
    private String feedback;

    @Column(name = "cor_nota", nullable = false)
    private Float nota;

    @Column(name = "cor_data", nullable = false)
    private LocalDate data;

    @Column(name = "cor_sequencial")
    private Integer sequencial;

    @ManyToOne
    @JoinColumn(name = "cor_anotacao", nullable = false)
    private Anotacao anotacao;

    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }

    public Float getNota() { return nota; }
    public void setNota(Float nota) { this.nota = nota; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public Integer getSequencial() { return sequencial; }
    public void setSequencial(Integer sequencial) { this.sequencial = sequencial; }

    public Anotacao getAnotacao() { return anotacao; }
    public void setAnotacao(Anotacao anotacao) { this.anotacao = anotacao; }
}
