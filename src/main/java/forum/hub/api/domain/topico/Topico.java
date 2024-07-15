package forum.hub.api.domain.topico;

import forum.hub.api.domain.cursos.Curso;
import forum.hub.api.domain.cursos.CursoRepository;
import forum.hub.api.domain.usuario.Usuario;
import forum.hub.api.domain.usuario.UsuarioRepository;
import forum.hub.api.infra.validacao.ValidacaoEXception;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensagem;

    private LocalDateTime data;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
     private Usuario usuario;

    private Boolean ativo;

    public Topico(Long id, String titulo, String mensagem, LocalDateTime data, Status status, Curso curso, Usuario usuario) {
        this.id = id;
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.data = data;
        this.status = status;
        this.curso = curso;
        this.usuario = usuario;

    }

    public void atualizarDados(DadosAtualizarTopico dados) {

        System.out.println("Cacete");


        if (dados.titulo() != null){
            this.titulo = dados.titulo();
        }
                if (dados.mensagem() != null) {
           this.mensagem = dados.mensagem();
        }

        if (dados.status() != null) {
            this.status = dados.status();
        }

    }

    public void excluir() {
        this.ativo = false;
    }
}
