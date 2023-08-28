
package microempresa;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author DUOC
 */
public class Solicitud {
    
    //atributos:
    private int numero;
    private Date fecha;
    private Cliente cliente;
    private int total;
    private String productos;
    
    //constructores:
    public Solicitud() {
    }

    public Solicitud(int numero, Date fecha, Cliente cliente, int total, String productos) throws Exception {
        setNumero(numero);
        setFecha(fecha);
        setCliente(cliente);
        setTotal(total);
        setProductos(productos);
    }
    
    //accesadores y mutadores:
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) throws Exception {
        Date hoy = new Date();
        if ( !fecha.after(hoy) ) {
            this.fecha = fecha;
        }else{
            throw new Exception("La fecha no puede ser después de hoy!");
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }
    
    //imprimir:
    public void imprimir(){
        System.out.println("Número: " + this.numero);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Fecha: " + sdf.format(this.fecha) );
        
        System.out.println( this.cliente );
        System.out.println("Total: " + this.total);
        System.out.println("Productos: " + this.productos);
    }
    
    //CUSTOMERS:
    public void agregar_producto(Producto p, int cantidad, String unidad_gramo){
        int total = 0;
        String texto = "";
        if ( unidad_gramo.equalsIgnoreCase("unidades")) {
            total = cantidad * p.getPrecio();
            texto = p.getDescripcion() + " $" + p.getPrecio() + " " + cantidad + " unidades";
        }else{
            total = p.getPrecio() * cantidad/1000;
            texto = p.getDescripcion() + " $" + p.getPrecio() + " " + cantidad/1000 + " kilos";
        }
        this.total = this.total + total;
        
        if (this.productos == null) {
            this.productos = texto;
        }else{
            this.productos = this.productos + "; " + texto;
        }
    }
    
    public void descuento(double porcentaje){
        //parseo: transformar a integer.
        int descuento = (int)(this.total * porcentaje);
        this.total = this.total - descuento;
    }
    
    
}
