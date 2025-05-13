package Logica;

import java.util.Date;

public class Skmp {


private int id_kmp;
private int id_mp;
private Date fecha_mov;
private String tipo_mov;
private int cantidad;

    public Skmp() {
    }

    public Skmp(int id_kmp, int id_mp, Date fecha_mov, String tipo_mov, int cantidad) {
        this.id_kmp = id_kmp;
        this.id_mp = id_mp;
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

    public int getId_mp() {
        return id_mp;
    }

    public void setId_mp(int id_mp) {
        this.id_mp = id_mp;
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
