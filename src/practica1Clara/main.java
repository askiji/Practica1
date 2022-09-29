package practica1Clara;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class main {
	static File practica1 = new File(".");

	public static void main(String[] args) throws IOException , ClassNotFoundException {
		// TODO Auto-generated method stub
		//Estan los ejercicios en el main asique solo tienes que descomentarlos.
//		practica1.mkdir();
//		ejercicioUno();
//		ejercicioDos();
		boolean b = ejercicioTres(new File(practica1 , "datos.dat") , new File(practica1 , "datos.dat"));
//		System.out.println(b);
		File f = new File(practica1, "ejercicio4.txt");
//		ejercicioCuatro();
//		ejercicioCinco();
//		ejercicioCuatroB();
//		ejercicioCincoB();
//		ejercicioSeis(f);
//		ejercicioSiete();
//		ejercicoOcho();
		File f7 = new File(practica1, "ejercicio7Objeto.txt");
//		ejercicioSieteObjeto(f7);
		File f8 = new File(practica1, "ejercicio8Objeto.txt");
		ejercicioOchoObjeto(f8);

	}
	
	private static void ejercicioOchoObjeto(File f) throws IOException , ClassNotFoundException {
		FileOutputStream fs = new FileOutputStream(f);
		ObjectOutputStream os = new ObjectOutputStream(fs);
		Scanner sc = new Scanner(System.in);
		int nia =0;
		do {
			System.out.println("Introduzca NIA");
			nia = Integer.valueOf(sc.next());
			if (nia == 0)break;
			System.out.println("Introduzca nombre");
			String nombre = sc.next();
			System.out.println("Introdizca nota evaluacion 1");
			double nota1 = Double.valueOf(sc.next());
			System.out.println("Introdizca nota evaluacion 2");
			double nota2 = Double.valueOf(sc.next());
			System.out.println("Introdizca nota evaluacion 3");
			double nota3 = Double.valueOf(sc.next());
			Persona p = new Persona(nia, nombre, nota1, nota2, nota3);
			os.writeObject(p);
			
		} while (nia != 0);
		os.close();
		int opcion = 0;
		System.out.println("1.- Mostrar listado de estudiantes");
		System.out.println("2.- Mostrar listado de estudiantes con media superior a 7");
		FileInputStream fsI= new FileInputStream(f);
		ObjectInputStream osI=new ObjectInputStream(fsI);
		opcion = Integer.valueOf(sc.next());
		try {
			while (true) {
				Persona p = (Persona) osI.readObject();
				if (opcion == 1) {
					System.out.println("NIA : " + p.getNia());
					System.out.println("Nombre : " + p.getNombre());
					System.out.println("Media : " + (p.getNota1() + p.getNota2() + p.getNota3()) / 3);
				}
				if (opcion == 2) {
					if ((p.getNota1() + p.getNota2() + p.getNota3()) / 3 >= 7) {
						System.out.println("NIA : " + p.getNia());
						System.out.println("Nombre : " + p.getNombre());
						System.out.println("Media : " + (p.getNota1() + p.getNota2() + p.getNota3()) / 3);
					}
				}
			}
		} catch (EOFException ex) {
			os.close();
		}

	}

	private static void ejercicioSieteObjeto(File f) throws IOException, ClassNotFoundException {
		FileOutputStream fs = new FileOutputStream(f);
		ObjectOutputStream os = new ObjectOutputStream(fs);
		Scanner sc = new Scanner(System.in);
		String nombre ="";
		do {
			System.out.println("Introduzca Nombre");
			nombre = sc.next();
			if(nombre.equalsIgnoreCase("Exit")) break;
			System.out.println("Introduzca email");
			String email = sc.next();
			System.out.println("Introduzaca codigo de pedido");
			int codigo = Integer.valueOf(sc.next());
			System.out.println("Introuzca importe");
			double importe = Double.valueOf(sc.next());
			System.out.println("Introduzca estado");
			String estado = sc.next();
			os.writeObject(new Cliente(nombre, email, codigo, importe, estado));
		} while (nombre.equals("Exit"));
		
		FileInputStream fsI= new FileInputStream(f);
		ObjectInputStream osI=new ObjectInputStream(fsI);
		try {
			for (;;) {
				Cliente c = (Cliente) osI.readObject();
				String aux5 = c.getEstado();
				if (aux5.equalsIgnoreCase("Entregado")) {
					System.out.println("Nomrbe del cliete : " + c.getNombre());
					System.out.println("Email : " + c.getEmail());
					System.out.println("Codigo del pedido : " + c.getCodigo());
					System.out.println("Importe del pedido : " + c.getImporte());
					System.out.println("Estado del pedido : " + c.getEstado());
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch bloco
			osI.close();
		}

//		os.close();
//		
	}
	private static void ejercicoOcho() throws IOException {
		File f = new File(practica1, "ejercicio8.txt");
		FileOutputStream fO = new FileOutputStream(f, true);
		DataOutputStream dO = new DataOutputStream(fO);
		int nia = -1;
		;
		String nombre = "";
		double nota1 = 0;
		double nota2 = 0;
		double nota3 = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Introduzaca  NIA");
			nia = Integer.valueOf(sc.next());
			if (nia == 0)
				break;
			dO.writeInt(nia);
			System.out.println("Introduzca nombre");
			nombre = sc.next();
			dO.writeUTF(nombre);
			System.out.println("Introduzca Nota eva 1");
			nota1 = Double.valueOf(sc.next());
			dO.writeDouble(nota1);
			System.out.println("Introduzca Nota eva 2");
			nota2 = Double.valueOf(sc.next());
			dO.writeDouble(nota2);
			System.out.println("Introduzca Nota eva 3");
			nota3 = Double.valueOf(sc.next());
			dO.writeDouble(nota3);
		} while (nia != 0);
		dO.close();
		int opcion = 0;
		System.out.println("1.- Mostrar listado de estudiantes");
		System.out.println("2.- Mostrar listado de estudiantes con media superior a 7");
		FileInputStream fI = new FileInputStream(f);
		DataInputStream dI = new DataInputStream(fI);
		opcion = Integer.valueOf(sc.next());
		try {
			while (true) {
				nia = dI.readInt();
				nombre = dI.readUTF();
				nota1 = dI.readDouble();
				nota2 = dI.readDouble();
				nota3 = dI.readDouble();
				if (opcion == 1) {
					System.out.println("NIA : " + nia);
					System.out.println("Nombre : " + nombre);
					System.out.println("Media : " + (nota1 + nota2 + nota3) / 3);
				}
				if (opcion == 2) {
					if ((nota1 + nota2 + nota3) / 3 >= 7) {
						System.out.println("NIA : " + nia);
						System.out.println("Nombre : " + nombre);
						System.out.println("Media : " + (nota1 + nota2 + nota3) / 3);
					}
				}
			}
		} catch (EOFException ex) {
			dI.close();
		}

	}

	private static void ejercicioSiete() throws IOException {
		File f = new File(practica1, "ejercicio7.txt");
		crearFichero(f);
		mostrarEjercicioSiete(f);

	}

	private static void mostrarEjercicioSiete(File f) throws FileNotFoundException, IOException {
		FileInputStream fI = new FileInputStream(f);
		DataInputStream dI = new DataInputStream(fI);
		try {
			for (;;) {
				String aux1 = dI.readUTF();
				String aux2 = dI.readUTF();
				String aux3 = dI.readUTF();
				double aux4 = dI.readDouble();
				String aux5 = dI.readUTF();
				if (aux5.equalsIgnoreCase("Entregado")) {
					System.out.println("Nomrbe del cliete : " + aux1);
					System.out.println("Email : " + aux2);
					System.out.println("Codigo del pedido : " + aux3);
					System.out.println("Importe del pedido : " + aux4);
					System.out.println("Estado del pedido : " + aux5);
				}
			}
		} catch (EOFException e) {
			dI.close();
		}
	}

	private static void crearFichero(File f) throws FileNotFoundException, IOException {
		// True para que podamos ir metiendo mas pedidos
		FileOutputStream fO = new FileOutputStream(f, true);
		DataOutputStream dO = new DataOutputStream(fO);
		String nombre = "";
		String mail = "";
		String codigo = "";
		double importe = 0;
		String estado = "";
		Scanner sc = new Scanner(System.in);
		while (!nombre.equals("Exit")) {
			System.out.println("Introduzca nombre");
			nombre = sc.next();
			if (nombre.equals("Exit"))
				break;
			dO.writeUTF(nombre);
			System.out.println("Introduzca email");
			mail = sc.next();
			dO.writeUTF(mail);
			System.out.println("Introduzca codigo de pedido");
			codigo = sc.next();
			dO.writeUTF(codigo);
			System.out.println("Importe del pedido");
			importe = Double.valueOf(sc.next());
			dO.writeDouble(importe);
			System.out.println("Estado del pedido");
			estado = sc.next();
			dO.writeUTF(estado);
		}
		dO.flush();
		dO.close();
	}

	private static void ejercicioSeis(File f) throws IOException {

		FileInputStream fI = new FileInputStream(f);
		DataInputStream dI = new DataInputStream(fI);

		int aux = Integer.MIN_VALUE;
		try {
			while (true) {
				int aux1 = dI.readInt();
				if (aux1 > aux)
					aux = aux1;
				dI.readUTF();
				dI.readInt();
				dI.readUTF();
			}
		} catch (EOFException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("El maximo es :" + aux);
			dI.close();
		}

	}

	private static void ejercicioCuatroB() throws IOException {
		File f = new File(practica1, "ejercicio4.txt");
		FileOutputStream fO = new FileOutputStream(f);
		DataOutputStream dO = new DataOutputStream(fO);
		Scanner sc = new Scanner(System.in);
		int num1 = 1;
		while (num1 != 0) {
			System.out.println("Introduzca dos numeros");
			num1 = sc.nextInt();
			if (num1 == 0)
				break;
			dO.writeInt(num1);
			dO.writeUTF(" ");
			int num2 = sc.nextInt();
			dO.writeInt(num2);
			dO.writeUTF("\n");
		}
		dO.close();
		System.out.println("Ha finalizado la insercion");
	}

	private static void ejercicioCincoB() throws IOException {
		File f = new File(practica1, "ejercicio4.txt");
		FileInputStream fI = new FileInputStream(f);
		DataInputStream dI = new DataInputStream(fI);
		try {
			while (true) {
				int aux1 = dI.readInt();
				dI.readUTF();
				int aux2 = dI.readInt();
				dI.readUTF();
				System.out.println(aux1 + " + " + aux2 + " = " + (aux1 + aux2));
			}
		} catch (EOFException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			dI.close();
		}

	}

	private static void ejercicioCinco() throws IOException {
		File f = new File(practica1, "ejercicio4.txt");
		FileReader fr = new FileReader(f);
		String text = new String(Files.readAllBytes(Paths.get(f.getPath())));
		String[] splitLinea = text.split("\n");
		String[][] splitNumero = new String[splitLinea.length][2];
		int contador = 0;
		for (String line : splitLinea) {
			String[] aux = line.split(" ");
			System.out.println(aux[0]);
			System.out.println(aux[1]);
			splitNumero[contador][0] = aux[0];
			splitNumero[contador][1] = aux[1];
			contador++;
		}
		for (String[] strings : splitNumero) {
			System.out.println(
					strings[0] + "+" + strings[1] + "=" + (Integer.valueOf(strings[0]) + Integer.valueOf(strings[1])));
		}
	}

	private static void ejercicioCuatro() throws IOException {
		File f = new File(practica1, "ejercicio4.txt");
		FileWriter fw = new FileWriter(f);
		Scanner sc = new Scanner(System.in);
		int num1 = 1;
		while (num1 != 0) {
			System.out.println("Introduzca dos numeros");
			num1 = sc.nextInt();
			if (num1 == 0)
				break;
			int num2 = sc.nextInt();
			fw.write(num1 + " " + num2 + "\n");
		}
		fw.close();
		System.out.println("Ha finalizado la insercion");
	}

	private static boolean ejercicioTres(File f1, File f2) throws IOException {
		boolean result = false;
		FileInputStream fileIn1 = new FileInputStream(f1);
		FileInputStream fileIn2 = new FileInputStream(f2);
		int in = 0;
		if (Files.size(f1.toPath()) == Files.size(f2.toPath())) {
			while (fileIn1.read() != -1) {
				if (fileIn1.read() == fileIn2.read()) {
					in = fileIn1.read();
					result = true;
				} else {
					System.out.println("Distintas letras");
					result = false;
					break;
				}
			}
		} else {
			System.out.println("Distinto tamaño");
			result = false;

		}
		fileIn1.close();
		fileIn2.close();
		return result;
	}

	private static void ejercicioDos() throws IOException {
		File f = new File(practica1, "poblaciones.dat");
		FileOutputStream fileOut = new FileOutputStream(f, true);
		DataOutputStream dataOS = new DataOutputStream(fileOut);
		Scanner sc = new Scanner(System.in);
		int codigo;
		int aux = 2;
		String str;
		while (aux != 3) {
			aux++;
			System.out.println("Introduzca codigo postal");
			codigo = Integer.parseInt(sc.next());
			dataOS.writeInt(codigo);
			System.out.println("Introduzca nombre");
			dataOS.writeUTF(sc.next());
			System.out.println("Introduzca provincia");
			dataOS.writeUTF(sc.next());
		}
		dataOS.close();
		FileInputStream fileIn = new FileInputStream(f);
		DataInputStream dataIn = new DataInputStream(fileIn);
		try {
			while (true) {
				str = String.valueOf(dataIn.readInt());
				System.out.println("Codigo postal : " + str);
//				System.out.println(dataIn.readInt());
				System.out.print("Nombre : ");
				System.out.println(dataIn.readUTF());
				System.out.print("Provincia : ");
				System.out.println(dataIn.readUTF());
			}
		} catch (EOFException ex) {
			dataIn.close();
		}
	}

	protected static void ejercicioUno() throws IOException {
		File f = new File(practica1, "datos.dat");
		FileOutputStream fileOut = new FileOutputStream(f);
		DataOutputStream dataOS = new DataOutputStream(fileOut);
		String[] nombres = { "Juan", "María", "Jesús", "Aitor", "Andrés", "Ainhoa", "Laura" };
		int[] edades = { 15, 25, 40, 36, 5, 42, 10 };

		for (int i = 0; i < edades.length; i++) {
			dataOS.writeUTF("Nombre: " + nombres[i] + " edad: ");
			dataOS.writeInt(edades[i]);
		}
		dataOS.close();
		// leer fichero
		FileInputStream fileIn = new FileInputStream(f);
		DataInputStream dataIn = new DataInputStream(fileIn);
		try {
			while (true) {
//				System.out.print("Nombre: ");
				System.out.print(dataIn.readUTF());
//				System.out.print(" edad: ");
				System.out.println(dataIn.readInt());
				// porque sale el ultimo nombre
			}
		} catch (EOFException ex) {
			dataIn.close();
		}
	}

}
