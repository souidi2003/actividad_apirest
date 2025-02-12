package iesthiar.modelo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 * Representa un coche en la base de datos.
 */
@Entity
public class Coche {

    /** Identificador único del coche. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /** Matrícula del coche (única). */
    @Column(unique = true)
    private String matricula;

    /** Marca del coche. */
    private String marca;

    /** Modelo del coche. */
    private String modelo;

    /** Fecha de fabricación del coche. Se almacena en formato yyyy-MM-dd. */
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fecha;

    /**
     * Constructor de la clase Coche.
     *
     * @param matricula Matrícula del coche.
     * @param marca     Marca del coche.
     * @param modelo    Modelo del coche.
     * @param fecha     Fecha de fabricación del coche.
     */
    public Coche(String matricula, String marca, String modelo, Date fecha) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.fecha = fecha;
    }

    /**
     * Constructor vacío requerido por JPA.
     */
    public Coche() {}

    /**
     * Obtiene la matrícula del coche.
     *
     * @return La matrícula del coche.
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Establece la matrícula del coche.
     *
     * @param matricula La matrícula a asignar.
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Obtiene la marca del coche.
     *
     * @return La marca del coche.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca del coche.
     *
     * @param marca La marca a asignar.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obtiene el modelo del coche.
     *
     * @return El modelo del coche.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establece el modelo del coche.
     *
     * @param modelo El modelo a asignar.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Obtiene el identificador único del coche.
     *
     * @return El ID del coche.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del coche.
     *
     * @param id El ID a asignar.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha de fabricación del coche.
     *
     * @return La fecha del coche.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de fabricación del coche.
     *
     * @param fecha La fecha a asignar.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Genera un código hash basado en los atributos del coche.
     *
     * @return Código hash del coche.
     */
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

    /**
     * Compara este objeto con otro para determinar si son iguales.
     *
     * @param obj Objeto a comparar.
     * @return true si los objetos son iguales, false en caso contrario.
     */
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

    /**
     * Representación en cadena del objeto Coche.
     *
     * @return Una cadena con los atributos del coche.
     */
    @Override
    public String toString() {
        return "Coche [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", fecha=" + fecha + "]";
    }
}
