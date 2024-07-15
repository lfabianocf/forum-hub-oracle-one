package forum.hub.api.domain.cursos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cursos")
@Entity(name = "curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private Boolean ativo;


    public Curso(DadosCadastroCurso dados) {
        this.nome = dados.nome();
        this.categoria = dados.categoria();
        this.ativo = true;
    }

    public void atualizarDados(DadosAtualizarCurso dados) {

        if (dados.nome() != null) {
            this.nome = dados.nome();
        }

        if (dados.categoria() != null) {
            this.categoria = dados.categoria();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
