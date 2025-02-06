package iesthiar.modelo;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode 
public class Coche { 
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id; 
    private String matricula; 
    private String marca; 
    private String modelo; 
    private LocalDate fecha; 
    // @ManyToOne(cascade = CascadeType.ALL) 
    // @ToString.Exclude 
    // @EqualsAndHashCode.Exclude
    // @JsonIgnore 
    // private Cliente propietario; 
}