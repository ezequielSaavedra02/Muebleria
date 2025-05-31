package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Skmp implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_kmp;

    @ManyToOne
    @JoinColumn(name = "id_mp")
    private MateriaPrima materiaPrima;

    @Temporal(TemporalType.DATE)
    private Date fecha_mov;

    private String tipo_mov;
    private int cantidad;

    public Skmp() {
    }

    public Skmp(int id_kmp, MateriaPrima materiaPrima, Date fecha_mov, String tipo_mov, int cantidad) {
        this.id_kmp = id_kmp;
        this.materiaPrima = materiaPrima;
        this.fecha_mov = fecha_mov;
        this.tipo_mov = tipo_mov;
        this.cantidad = cantidad;
    }

    public int getId_kmp() {
        return id_kmp;
    }

    public void setId_kmp(int id_kmp) {
        this.id_kmp = id_kmp;
    }

    public MateriaPrima getMateriaPrima() {
        return materiaPrima;
    }

    public void setMateriaPrima(MateriaPrima materiaPrima) {
        this.materiaPrima = materiaPrima;
    }

    public Date getFecha_mov() {
        return fecha_mov;
    }

    public void setFecha_mov(Date fecha_mov) {
        this.fecha_mov = fecha_mov;
    }

    public String getTipo_mov() {
        return tipo_mov;
    }

    public void setTipo_mov(String tipo_mov) {
        this.tipo_mov = tipo_mov;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    


}
