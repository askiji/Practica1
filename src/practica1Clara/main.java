package practica1Clara;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class main {
	static File practica1 = new File(".");

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		practica1.mkdir();
//		ejercicioUno();
//		ejercicioDos();
		boolean b = ejercicioTres(new File(practica1 , "poblaciones.dat") , new File(practica1 , "poblaciones.dat"));
		System.out.println(true);
		
	}
	private static boolean ejercicioTres(File f1 , File f2) throws IOException {
		boolean result;
		FileInputStream fileIn1 = new FileInputStream(f1);
		DataInputStream dataIn1 = new DataInputStream(fileIn1);
		FileInputStream fileIn2 = new FileInputStream(f2);
		DataInputStream dataIn2 = new DataInputStream(fileIn2);
		System.out.println(Files.size(f1.toPath()));
		if(Files.size(f1.toPath()) == Files.size(f2.toPath())) {
				for (int i = 0; i < Files.size(f1.toPath()); i++) {
					if(dataIn1.equals(dataIn2)) {
						result = true;
					}
					else {

						result = false; 
					}
				}
		}
		else {
			System.out.println("Distinto tamaño");
			result = false;
		
		}
		dataIn1.close();
		dataIn2.close();
		return result;
	}
	@SuppressWarnings("unlikely-arg-type")
	private static void ejercicioDos() throws IOException {
		File f = new File(practica1 , "poblaciones.dat");
		FileOutputStream fileOut=new FileOutputStream(f , true);
		DataOutputStream dataOS=new DataOutputStream(fileOut);
		Scanner sc = new Scanner(System.in);
		int codigo;
		int aux =2;
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
		}
		catch (EOFException ex) {
		dataIn.close();
		}
	}
	
	
	protected static void ejercicioUno() throws IOException  {
		File f = new File(practica1 , "datos.dat");
		FileOutputStream fileOut=new FileOutputStream(f);
		DataOutputStream dataOS=new DataOutputStream(fileOut);
		String[] nombres= {"Juan","María","Jesús","Aitor","Andrés","Ainhoa","Laura"};
		int[] edades= {15,25,40,36,5,42,10};
		
		for (int i = 0; i < edades.length; i++) {
			dataOS.writeUTF("Nombre: " + nombres[i]+ " edad: ");
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
				//porque sale el ultimo nombre
				}
		}
		catch (EOFException ex) {
		dataIn.close();
		}
	}
	
}
