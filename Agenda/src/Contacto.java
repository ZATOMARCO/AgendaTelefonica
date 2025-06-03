public class Contacto {
    private String numero;
    private String nombre;

    public Contacto(String numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return numero + " : " + nombre;
    }
}
