
package microempresa;

/**
 *
 * @author DUOC
 */
public class Cliente {
    
    //atributos:
    private int run;
    private char dv;
    private String nombre;
    private String mail;
    private String direccion;
    private int telefono;
    
    //constructores
    public Cliente() {
    }

    public Cliente(int run, char dv, String nombre, String mail, String direccion, int telefono) throws Exception {
        setRun(run);
        setDv(dv);
        setNombre(nombre);
        setMail(mail);
        setDireccion(direccion);
        setTelefono(telefono);
    }
    
    //accesadores y mutadores
    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        this.run = run;
    }

    public char getDv() {
        return dv;
    }

    public void setDv(char dv) {
        this.dv = dv;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Exception {
        if(nombre.trim().length() >= 3){
            this.nombre = nombre;
        }else{
            throw new Exception("El nombre debe tener al menos 3 caracteres!");
        }
        
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) throws Exception {
        if ( mail.trim().length() >= 6 ) {
            
            String regex = "[a-z0-9._%+\\-]+@[a-z0-9.\\-]+\\.[a-z]{2,}$";
            if ( mail.matches(regex) ) {
                this.mail = mail;
            }            
            
        }else{
            throw new Exception("El mail debe tener al menos 6 caracteres!");
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) throws Exception {
        if ( String.valueOf(telefono).length() == 8 ) {
            this.telefono = telefono;
        }else{
            throw new Exception("El teléfono debe tener 8 dígitos");
        }
    }
    
    //imprimir:
    public void imprimir(){
        System.out.println("Run: " + this.run + "-" + this.dv);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Mail: " + this.mail);
        System.out.println("Dirección: " + this.direccion);
        System.out.println("Teléfono: " + this.telefono);
    }

    @Override
    public String toString() {
        return "Cliente{" + "run=" + run + ", dv=" + dv + ", nombre=" + nombre + ", mail=" + mail + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }
    
    public boolean validar_rut(){
        boolean validacion = false;
        try {
            //rut =  rut.toUpperCase();
            //rut = rut.replace(".", "");
            //rut = rut.replace("-", "");
            //int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));
            int rutAux = this.run;

            //char dv = rut.charAt(rut.length() - 1);
            char dv = this.dv;

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }
    
    
}
