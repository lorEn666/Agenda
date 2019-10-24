package agenda;

import java.util.Scanner;

public class Agenda {

	// Método para limpiar la consola

	public static void clean() {
		for (int i = 0; i < 31; i++) {
			System.out.println();
		}
	}

	// Método que no dejará seguir hasta pulsar "Enter"

	public static void enterParaContinuar() {
		String seguir = "";
		Scanner leer = new Scanner(System.in);

		System.out.println("Pulse Enter para continuar...");
		try {
			seguir = leer.nextLine();
		} catch (Exception e) {
		}
	}

	// Método para rellenar matriz con contactos vacíos

	public static void agendaVacia(String mVacio[][]) {
		for (int i = 0; i < mVacio.length; i++) {
			mVacio[i][0] = "Vacío";
			mVacio[i][1] = "Vacío";
		}
	}

	// Método devuelve opción escogida y pinta menú

	public static int mostrarMenu() {
		Scanner leer = new Scanner(System.in);
		int opc = 0;
		boolean datoCorrecto = false;

		do {

			System.out.println("      *********************************** ");
			System.out.println("     ** ººººº ****************************");
			System.out.println("     ** ººººº *****<<<NOKIA>>>************");
			System.out.println("     ** ººººº ****************************");
			System.out.println("     *************************************");
			System.out.println("     *****                           *****");
			System.out.println("     *****     1.Agenda              *****");
			System.out.println("     *****     2.Guardar contacto    *****");
			System.out.println("     *****     3.Borrar contacto     *****");
			System.out.println("     *****     4.Editar contacto     *****");
			System.out.println("     *****     5.Buscar contacto     *****");
			System.out.println("     *****                           *****");
			System.out.println("     *****     0.Apagar              *****");
			System.out.println("     *****                           *****");
			System.out.println("     *****                           *****");
			System.out.println("     *************************************");
			System.out.println("     ******** 1 ****** 2 ****** 3 ********");
			System.out.println("     *************************************");
			System.out.println("      ******* 4 ****** 5 ****** 6 ******* ");
			System.out.println("       *********************************  ");
			System.out.println("        ***** 7 ****** 8 ****** 9 *****   ");
			System.out.println("         *****************************    ");
			System.out.println("            ********** 0 **********       ");
			System.out.println("             *********************        ");

			System.out.println("Escoja una opción. (0-5)");
			opc = leer.nextInt();

			if ((opc >= 0) && (opc <= 5)) {
				datoCorrecto = true;
			} else {
				clean();
				System.err.println("Dato introducido no es correcto.");
				enterParaContinuar();
			}

		} while (!datoCorrecto);

		return opc;
	}

	// Método para listar la agenda (opción 1)

	public static void mostrarAgenda(String mAgenda[][]) {
		clean();

		for (int i = 0; i < mAgenda.length; i++) {
			System.out.println(i + ")" + mAgenda[i][0] + "-->" + mAgenda[i][1]);
		}
	}

	// Método para guardar contactos y búsqueda de posición libre, con posibilidad
	// de guardar tantos contactos como queramos (opción 2)

	public static void guardarContacto(String mGuardar[][]) {
		Scanner leer = new Scanner(System.in);
		String guardarOtro = "";

		clean();

		for (int i = 0; i < mGuardar.length; i++) {
			if ((mGuardar[i][0].equalsIgnoreCase("Vacío")) && (mGuardar[i][1].equalsIgnoreCase("Vacío"))) {
				System.out.println("Introduce nombre del contacto:");
				mGuardar[i][0] = leer.nextLine();
				System.out.println("Introduce teléfono del contacto:");
				mGuardar[i][1] = leer.nextLine();
				clean();
				System.out.println("¡Contacto guardado con éxito!");
				enterParaContinuar();
				break;
			}
		}
		do {
			clean();
			System.out.println("¿Quiere guardar otro contacto? (S/N)");
			guardarOtro = leer.nextLine();
			guardarOtro.toUpperCase();

			if (guardarOtro.equalsIgnoreCase("S")) {
				guardarContacto(mGuardar);
			}
			if ((!guardarOtro.equalsIgnoreCase("S") && (!guardarOtro.equalsIgnoreCase("N")))) {
				System.err.println("El dato introducido no es correcto. Introduzca S o N");
			}
			if (guardarOtro.equalsIgnoreCase("N")) {
				break;
			}
		} while ((!guardarOtro.equalsIgnoreCase("S") || (!guardarOtro.equalsIgnoreCase("N"))));
	}

	// Método para borrar contactos, listando primero agenda para comodidad del
	// usuario (opción 3)

	public static void borrarContacto(String mBorrar[][]) {
		Scanner leer = new Scanner(System.in);
		int contactoBorrado = 0;

		do {
			clean();
			mostrarAgenda(mBorrar);
			System.out.println("¿Qué contacto desea eliminar? (0-9)");
			contactoBorrado = leer.nextInt();
			if ((contactoBorrado < 0) || (contactoBorrado > 9)) {
				System.err.println(
						"El dato introducido no es correcto. Debe introducir una posición de memoria comprendida entre 0 y 9");
				enterParaContinuar();
			} else {
				mBorrar[contactoBorrado][0] = "Vacío";
				mBorrar[contactoBorrado][1] = "Vacío";
				clean();
				System.out.println("¡Contacto borrado con éxito!");
				enterParaContinuar();
			}
		} while ((contactoBorrado < 0) || (contactoBorrado > 9));
	}

	// Método que posibilita la edición de un contacto (opción 4)

	public static void editarContacto(String mEditar[][]) {
		Scanner leer = new Scanner(System.in);
		Scanner edicion = new Scanner(System.in);
		int contactoEditado = 0;

		do {
			clean();
			mostrarAgenda(mEditar);
			System.out.println("¿Qué contacto desea editar? (0-9)");
			contactoEditado = leer.nextInt();
			if ((contactoEditado < 0) || (contactoEditado > 9)) {
				System.err.println(
						"El dato introducido no es correcto. Debe introducir una posición de memoria comprendida entre 0 y 9");
				enterParaContinuar();
			} else {
				clean();
				System.out.println("Introduzca el nuevo nombre del contacto:");
				mEditar[contactoEditado][0] = edicion.nextLine();
				System.out.println("Introduzca el nuevo número de teléfono del contacto:");
				mEditar[contactoEditado][1] = edicion.nextLine();
				clean();
				System.out.println("¡Contacto editado con éxito!");
				enterParaContinuar();
			}
		} while ((contactoEditado < 0) || (contactoEditado > 9));
	}

	// Método para poder realizar búsquedas, bien por posición en memoria o bien
	// listando todos los contactos que compartan la misma inicial (opcion 5)

	public static void buscarContacto(String mBuscar[][]) {
		Scanner leer = new Scanner(System.in);
		String opcionBusqueda = "", inicialBusqueda = "";
		int posicionMemoria = 0;

		clean();

		do {
			System.out.println("¿Quiere buscar por posición en memoria o listar los contactos según la inicial? (M/I)");
			opcionBusqueda = leer.nextLine();
			opcionBusqueda.toUpperCase();

			if (opcionBusqueda.equalsIgnoreCase("M")) {
				do {
					clean();
					System.out.println("Introduzca la posición en la que desea realizar la búsqueda: (0-9)");
					posicionMemoria = leer.nextInt();
					if ((posicionMemoria >= 0) && (posicionMemoria <= 9)) {
						clean();
						System.out.println(mBuscar[posicionMemoria][0] + "-->" + mBuscar[posicionMemoria][1]);
						enterParaContinuar();
					} else {
						clean();
						System.err.println("El dato introducido no es correcto. Introduzca una posición válida.");
						enterParaContinuar();
					}
				} while ((posicionMemoria < 0) || (posicionMemoria > 9));
			}
			if (opcionBusqueda.equalsIgnoreCase("I")) {
				clean();
				System.out.println("Introduzca la inicial para realizar la búsqueda: (A-Z)");
				inicialBusqueda = leer.nextLine();
				clean();
				for (int i = 0; i < mBuscar.length; i++) {
					if (mBuscar[i][0].substring(0, 1).equalsIgnoreCase(inicialBusqueda)) {
						System.out.println(mBuscar[i][0] + "-->" + mBuscar[i][1]);
					}
				}
				enterParaContinuar();
			}
		} while ((!opcionBusqueda.equalsIgnoreCase("M")) && (!opcionBusqueda.equalsIgnoreCase("I")));
	}

	// Método que fuerza el cierre de la aplicación (opción 0)

	public static void apagar() {
		clean();
		System.err.println("Teléfono apagado");
		System.exit(0);
	}

	public static void main(String[] args) {
		String mContactos[][] = new String[10][2];

		agendaVacia(mContactos);

		do {
			clean();

			switch (mostrarMenu()) {
			case 1:
				mostrarAgenda(mContactos);
				enterParaContinuar();
				break;
			case 2:
				guardarContacto(mContactos);
				break;
			case 3:
				borrarContacto(mContactos);
				break;
			case 4:
				editarContacto(mContactos);
				break;
			case 5:
				buscarContacto(mContactos);
				break;
			case 0:
				apagar();
			default:
				System.err.println("Inserte un dato válido.");
			}
		} while (true);
	}
}
