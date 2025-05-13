
package Logica;

import java.util.Date;

public class Pedido {


private int id_pedido;
private int id_cliente; 
private Date fecha_pedido;

    public Pedido() {
    }

    public Pedido(int id_pedido, int id_cliente, Date fecha_pedido) {
        this.id_pedido = id_pedido;
        this.id_cliente = id_cliente;
        this.fecha_pedido = fecha_pedido;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Date getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(Date fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }





    
}
