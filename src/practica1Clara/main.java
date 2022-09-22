package practica1Clara;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class main {
	static File practica1 = new File(".");

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		practica1.mkdir();
//		ejercicioUno();
//		ejercicioDos();
		boolean b = ejercicioTres(new File(practica1 , "datos.dat") , new File(practica1 , "datos.dat"));
		System.out.println(b);
//		ejercicioCuatro();
//		ejercicioCinco();
		ejercicioCuatroB();
		ejercicioCincoB();
		
	}
	
	private static void ejercicioCuatroB() throws IOException{
		File f = new File(practica1 , "ejercicio4.txt");
		FileOutputStream fO = new FileOutputStream(f);
		DataOutputStream dO = new DataOutputStream(fO);
		Scanner sc = new Scanner(System.in);
		int num1=1;
		while(num1!=0) {
			System.out.println("Introduzca dos numeros");
			num1 = sc.nextInt();
			if(num1==0)break;
			dO.writeInt(num1);
			dO.writeUTF(" ");
			int num2 = sc.nextInt();
			dO.writeInt(num2);
		}
		dO.close();
		System.out.println("Ha finalizado la insercion");
	}
	private static void ejercicioCincoB() throws IOException{
		File f = new File(practica1 , "ejercicio4.txt");
		FileInputStream fI = new FileInputStream(f);
		DataInputStream dI = new DataInputStream(fI);
		
	}
	private static void ejercicioCinco() throws IOException {
		File f = new File(practica1 , "ejercicio4.txt");
		FileReader fr = new FileReader(f);
		String text = new String(Files.readAllBytes(Paths.get(f.getPath())));
		String[] splitLinea = text.split("\n");
		String[][] splitNumero = new String[splitLinea.length][2];
		int contador =0;
		for (String line : splitLinea) {
			String [] aux = line.split(" ");
			System.out.println(aux[0]);
			System.out.println(aux[1]);
			splitNumero[contador][0]= aux[0];
			splitNumero[contador][1]= aux[1];
			contador++;
		}
		for (String[] strings : splitNumero) {
			System.out.println(strings[0]+"+"+strings[1]+"="+(Integer.valueOf(strings[0])+Integer.valueOf(strings[1])));
		}
	}
	
	private static void ejercicioCuatro() throws IOException {
		File f = new File(practica1 , "ejercicio4.txt");
		FileWriter fw = new FileWriter(f);
		Scanner sc = new Scanner(System.in);
		int num1=1;
		while(num1!=0) {
			System.out.println("Introduzca dos numeros");
			num1 = sc.nextInt();
			if(num1==0)break;
			int num2 = sc.nextInt();
			fw.write(num1 + " " + num2 + "\n");
		}
		fw.close();
		System.out.println("Ha finalizado la insercion");
	}
	
	private static boolean ejercicioTres(File f1 , File f2) throws IOException {
		boolean result = false;
		FileInputStream fileIn1 = new FileInputStream(f1);
		FileInputStream fileIn2 = new FileInputStream(f2);
		int in = 0;
		if(Files.size(f1.toPath()) == Files.size(f2.toPath())) {
			while(fileIn1.read() != -1) {
				if(fileIn1.read() == fileIn2.read()) {
					in =fileIn1.read(); 
					result = true;
				}
				else {
					System.out.println("Distintas letras");
					result = false;
					break;
				}
			}
		}
		else {
			System.out.println("Distinto tamaño");
			result = false;
		
		}
		fileIn1.close();
		fileIn2.close();
		return result;
	}
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
