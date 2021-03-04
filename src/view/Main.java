package view;

import java.util.Scanner;

import org.basex.core.*;
import org.basex.core.cmd.*;
import org.basex.io.serial.*;
import org.basex.query.*;
import org.basex.query.iter.*;
import org.basex.query.value.*;
import org.basex.query.value.item.*;


public class Main {

	static Context context = new Context();
	
	public static void main(String[] args) throws BaseXException, QueryException {
		Scanner input = new Scanner(System.in);
		String code = "";
		int menuOptions = 0;
		int foodOption = 0;
		String queryData[];
		
		System.out.println("=== FOODA su aplicación automática de comida ===");
		System.out.println("Indique el código del restaurante");
		code = input.nextLine();
		
		String query = "for $x in doc('src/database/restaurantes.xml')/restaurantes/restaurante"
				+ "[@id=\""+ code +"\"]"
				+ "return concat($x/nombre, ',' , "
				+ "$x/tematica, ',' , "
				+ "$x/menu/entradas/entrada/nombre, ',',  "
				+ "$x/menu/platillos/platillo/nombre, ',',"
				+ "$x/menu/reposteria/postre/nombre)";

		
		queryData = query(query).split(",");
		
		System.out.println("_________________________________________________");
		System.out.println("|                                                |");
		System.out.println("|Bienvenido al restaurante "+ queryData[0] + "|");
		System.out.println("|Su temática es: " + queryData[1] + "            |");
		System.out.println("|________________________________________________|");
		System.out.println("| ¿Qué desea ordenar?                             |");
		System.out.println("| Pulse el número correspondiente para pedir      |");
		System.out.println("| (1) para pedir entradas                         |");
		System.out.println("| (2) para pedir platillos                        |");
		System.out.println("| (3) para pedir respostería                      |");
		System.out.println("| (4) para salir del programa                     |");
		System.out.println("___________________________________________________");
		menuOptions = input.nextInt();
		
		while (menuOptions < 4) 
		{	
			
			
			System.out.println("Estas son tus opciones, selecciona la que prefieras");
			
			switch (menuOptions) {
			case 1:
				System.out.println("---------------------------------------");
				System.out.println("|Opciones de Entradas                  |");
				System.out.println("----------------------------------------");
				System.out.println("  (1) " + queryData[2]);
				System.out.println("----------------------------------------");
				break;
				
			case 2:
				System.out.println("---------------------------------------");
				System.out.println("|Opciones de Platillos                 |");
				System.out.println("----------------------------------------");
				System.out.println("  (1) " + queryData[3]);
				System.out.println("----------------------------------------");
				break;

			case 3:
				System.out.println("---------------------------------------");
				System.out.println("|Opciones de Repostería                 |");
				System.out.println("----------------------------------------");
				System.out.println("  (1) " + queryData[4]);
				System.out.println("----------------------------------------");
				break;
			default:
				break;
				
			}
			foodOption = input.nextInt();
			System.out.println("Orden anotada");
			
			System.out.println("___________________________________________________");
			System.out.println("| ¿Desea ordenar algo más?                        |");
			System.out.println("| Pulse el número correspondiente para pedir      |");
			System.out.println("| (1) para pedir entradas                         |");
			System.out.println("| (2) para pedir platillos                        |");
			System.out.println("| (3) para pedir respostería                      |");
			System.out.println("| (4) para salir del programa                     |");
			System.out.println("___________________________________________________");
			menuOptions = input.nextInt();
		}
		System.out.println("Ten un excelente día");
	}
	
	static String query(final String query) throws BaseXException {
	    XQuery data = new XQuery(query);
	    
	    return data.execute(context);
	 
	}
	
	

}
