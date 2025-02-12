package iesthiar.modelo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import lombok.Data;


@Entity
public class Coche {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
@Column(unique = true)
    private String matricula;
    private String marca;
    private String modelo;
@Temporal(TemporalType.DATE)
    private Date fecha;
    // @ManyToOne(cascade ={ CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE})
    // private Cliente propietario;
    
    
    
    
    
    public Coche(String matricula, String marca, String modelo, Date fecha) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.fecha = fecha;

    }
    

    public Coche(String string, String string2, String string3, java.sql.Date date, String string4) {
        //TODO Auto-generated constructor stub
    }
    public Coche(){}
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getMarca() {
        return marca;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
        result = prime * result + ((marca == null) ? 0 : marca.hashCode());
        result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
        result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
       
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coche other = (Coche) obj;
        if (id != other.id)
            return false;
        if (matricula == null) {
            if (other.matricula != null)
                return false;
        } else if (!matricula.equals(other.matricula))
            return false;
        if (marca == null) {
            if (other.marca != null)
                return false;
        } else if (!marca.equals(other.marca))
            return false;
        if (modelo == null) {
            if (other.modelo != null)
                return false;
        } else if (!modelo.equals(other.modelo))
            return false;
        if (fecha == null) {
            if (other.fecha != null)
                return false;
        } else if (!fecha.equals(other.fecha))
            return false;
       
        return true;
    }

    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    @Override
    public String toString() {
        return "Coche [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", fecha=" + fecha
                + "]";
    }
    
}
