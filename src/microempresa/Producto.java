
package microempresa;

/**
 *
 * @author DUOC
 */
public class Producto {
    
    //atributos:
    private int codigo;
    private String subcategoria, descripcion;
    private int precio;
    private int unidad_gramo;
    
    //constructores:
    public Producto() {
    }

    public Producto(int codigo, String subcategoria, String descripcion, int precio, int unidad_gramo) throws Exception {
        setCodigo(codigo);
        setSubcategoria(subcategoria);
        setDescripcion(descripcion);
        setPrecio(precio);
        setUnidad_gramo(unidad_gramo);
    }
    
    //accesadores y mutadores
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) throws Exception {
        if ( String.valueOf(codigo).length() == 4) {
            this.codigo = codigo;
        }else{
            throw new Exception("El código debe tener 4 dígitos!");
        }
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(String subcategoria) throws Exception {
        if ( subcategoria.equalsIgnoreCase("fruta") ||
                subcategoria.equalsIgnoreCase("verdura") ) {
            this.subcategoria = subcategoria;
        }else{
            throw new Exception("La subcategoría debe ser fruta o verdura!");
        }
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) throws Exception {
        if (precio > 0) {
            this.precio = precio;
        }else{
            throw new Exception("El precio debe ser mayor a cero");
        }
    }

    public int getUnidad_gramo() {
        return unidad_gramo;
    }

    public void setUnidad_gramo(int unidad_gramo) {
        this.unidad_gramo = unidad_gramo;
    }
    
    //imprimir:
    public void imprimir(){
        System.out.println("Código: " + this.codigo);
        System.out.println("Subcategoria: " + this.subcategoria);
        System.out.println("Descripción: " + this.descripcion);
        System.out.println("Precio: " + this.precio);
        System.out.println("Unidad/Gramo: " + this.unidad_gramo);
    }
    
}
