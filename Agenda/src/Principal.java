import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        AgendaTelefonica agenda = new AgendaTelefonica();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Menú de la Agenda Telefónica ---");
            System.out.println("1. Enlistar Contactos");
            System.out.println("2. Crear Nuevo Contacto");
            System.out.println("3. Eliminar Contacto");
            System.out.println("4. Buscar Contacto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    agenda.listarContactos();
                    break;
                case "2":
                    agenda.crearContacto(scanner);
                    break;
                case "3":
                    agenda.eliminarContacto(scanner);
                    break;
                case "4":
                    agenda.buscarContacto(scanner);
                    break;
                case "5":
                    System.out.println("Saliendo de la aplicación.");
                    return;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }
}

