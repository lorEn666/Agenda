package agenda;

import java.util.Scanner;

public class Agenda {

	// Método para limpiar la consola

	public static void clean() {
		for (int i = 0; i < 26; i++) {
			System.out.println();
		}
	}

	// Método para mostrar agenda sin contactos guardados

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
			System.out.println("     *****                           *****");
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

			System.out.println("Escoja una opción. (1-5)");
			opc = leer.nextInt();

			if ((opc >= 1) && (opc <= 5)) {
				datoCorrecto = true;
			} else {
				clean();
				System.out.println("Dato introducido no es correcto.");
			}

		} while (!datoCorrecto);

		return opc;
	}

	// Método para listar la agenda (opción 1)

	public static void mostrarAgenda(String mAgenda[][]) {
		for (int i = 0; i < mAgenda.length; i++) {
			System.out.println(mAgenda[i][0] + "-->" + mAgenda[i][1]);
		}
	
	}

	// Método para guardar contactos (opción 2)

	public static void guardarContacto(String mGuardar[][]) {
		Scanner leer = new Scanner(System.in);
		for (int i = 0; i < mGuardar.length; i++) {
			if ((mGuardar[i][0].equalsIgnoreCase("Vacío")) && (mGuardar[i][1].equalsIgnoreCase("Vacío"))) {
				System.out.println("Introduce nombre del contacto:");
				mGuardar[i][0] = leer.nextLine();
				System.out.println("Introduce teléfono del contacto:");
				mGuardar[i][1] = leer.nextLine();
				break;
			}
		}
		
	}

	public static void main(String[] args) {
		String mContactos[][] = new String[10][2];
		int opcion = 0;

		agendaVacia(mContactos);

		
		do {
			
			switch (mostrarMenu()) {
			case 1:
				mostrarAgenda(mContactos);
				break;
			case 2:
				guardarContacto(mContactos);
				break;
			default:
				break;
			}
			
		}while(true);

	}

}
