
package microempresa;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author DUOC
 */
public class Microempresa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //1. SIEMPRE DENTRO DE MAIN. TRY/CATCH:
        try {
            //3. DESARROLLO:
            //3.1 CREAMOS CLIENTES:
            Cliente c1 = new Cliente(10306914, '9', "Elba Lazo", 
                    "elba.lazo@gmail.com", "Las Caletas #123", 12345678);
            Cliente c2 = new Cliente(17555444, '8', "Pavel Morales", 
                    "pavel.morales@gmail.com", "Concha y toro 1340", 87654321);
            c1.imprimir();
            c2.imprimir();
            
            //3.2 CREAMOS PRODUCTOS:
            Producto pro1 = new Producto(1111, "fruta", "naranja", 1200, 1000);
            Producto pro2 = new Producto(2222, "verdura", "lechuga", 950, 1);
            pro1.imprimir();
            pro2.imprimir();
            
            //3.3 CREAR SOLICITUDES:
            Solicitud s1 = new Solicitud();
            s1.setNumero(1);
            
            String fecha_texto = "24/03/2023";
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha_date = sdf.parse(fecha_texto);
            s1.setFecha(fecha_date);
            
            s1.setCliente(c1);
            
            s1.agregar_producto(pro1, 3000, "gramos");
            s1.agregar_producto(pro2, 4, "unidades");
            s1.descuento(0.3);
            s1.imprimir();
            
            
        } catch (Exception e) {
            //2. MENSAJE DE ERROR:
            System.out.println("ERROR: " + e.getMessage() );
        }
        
    }
    
}
