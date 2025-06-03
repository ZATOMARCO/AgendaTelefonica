import java.io.*;
import java.util.*;

public class AgendaTelefonica {
    private final String archivo = "agenda.txt";
    private Map<String, String> contactos = new HashMap<>();

    public AgendaTelefonica() {
        cargar();
    }

    private void cargar() {
        File file = new File(archivo);
        if (file.exists()) {
            try (BufferedReader lector = new BufferedReader(new FileReader(file))) {
                String linea;
                while ((linea = lector.readLine()) != null) {
                    linea = linea.trim();
                    if (!linea.isEmpty()) {
                        String[] partes = linea.split(":", 2);
                        if (partes.length == 2) {
                            contactos.put(partes[0].trim(), partes[1].trim());
                        } else {
                            System.out.println("Línea inválida ignorada: " + linea);
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
        }
    }

    private void guardar() {
        try (PrintWriter escritor = new PrintWriter(new FileWriter(archivo))) {
            for (Map.Entry<String, String> entrada : contactos.entrySet()) {
                escritor.println(entrada.getKey() + " : " + entrada.getValue());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    public void listarContactos() {
        System.out.println("Contactos:");
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.");
        } else {
            for (Map.Entry<String, String> entrada : contactos.entrySet()) {
                System.out.println(entrada.getKey() + " : " + entrada.getValue());
            }
        }
    }

    public void crearContacto(Scanner scanner) {
        System.out.print("Ingrese el número telefónico: ");
        String numero = scanner.nextLine();
        System.out.print("Ingrese el nombre del contacto: ");
        String nombre = scanner.nextLine();
        contactos.put(numero, nombre);
        System.out.println("Contacto '" + nombre + "' con número '" + numero + "' agregado.");
        guardar();
    }

    public void eliminarContacto(Scanner scanner) {
        System.out.print("Ingrese el número telefónico a eliminar: ");
        String numero = scanner.nextLine();
        if (contactos.containsKey(numero)) {
            contactos.remove(numero);
            System.out.println("Contacto con número '" + numero + "' eliminado.");
            guardar();
        } else {
            System.out.println("No se encontró un contacto con el número '" + numero + "'.");
        }
    }

    public void buscarContacto(Scanner scanner) {
        System.out.print("Ingrese el número o nombre a buscar: ");
        String termino = scanner.nextLine().toLowerCase();
        boolean encontrado = false;

        for (Map.Entry<String, String> entrada : contactos.entrySet()) {
            if (entrada.getKey().toLowerCase().contains(termino) || entrada.getValue().toLowerCase().contains(termino)) {
                System.out.println(entrada.getKey() + " : " + entrada.getValue());
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron coincidencias.");
        }
    }
}