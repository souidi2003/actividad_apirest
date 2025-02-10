package iesthiar.curso;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Curso {
    private int codigo;
    private String nombre;
}
