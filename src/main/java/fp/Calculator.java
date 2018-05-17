package fp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Calculator {

	/*
	 * este metodo devuelve el Class del object que le pasamos
	 */
	public static Class classTypeOf(Object x) {
		return x.getClass();
	}

	/*
	 * devuelve una lista con los n números de la serie de fibonacci.
	 */
	public static List<Integer> fibonacci(int n) {
		int a = 0, b = 1;
		List<Integer> lista = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			lista.add(a + b);
			b = a;
			a = lista.get(i);
		}
		return lista;
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		List<Integer> lnumbers = new ArrayList<Integer>();
		while (number > 0 && number > step) {
			number -= step;
			lnumbers.add(number);
		}
		int[] numbers = new int[lnumbers.size()];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = lnumbers.get(i);
		}
		return numbers;
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		int divisores[] = null;
		List<Integer> numeros = new ArrayList<Integer>();

		if (n != 0) {
			for (int i = n; i > 0; i--)
				if (n % i == 0)
					numeros.add(i);
			divisores = new int[numeros.size()];
			for (int i = 0; i < divisores.length; i++)
				divisores[i] = numeros.get(i);
		}
		return divisores;
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena
	 * resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		char[] caracteres = { ' ', '?', '¿', '·', ':', 'á', 'é', 'í', 'ó', 'ú', 'à', 'è', 'ì', 'ò', 'ù', 'ª' };
		boolean verify = false;
		cadena.toLowerCase();
		for (int i = 0; i < cadena.length(); i++) {
			for (int j = 0; j < caracteres.length; j++) {
				if (cadena.charAt(i) == caracteres[j]) {
					cadena = cadena.replace(cadena.charAt(i), ' ');
				}
			}
		}
		for (int i = 0; i < cadena.length(); i++) {
			if (cadena.charAt(i) == cadena.charAt(cadena.length() - i - 1)) {
				verify = true;
			} else {
				verify = false;
			}
		}
		if (verify) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56 mostrar:
	 * cincuenta y seis
	 */
	public static String speakToMe(int n) {
		String numero = "";
		String[] unidades = { "Cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "Diez",
				"Once", "Doce", "Trece", "Catorce", "Quince", "Diecesies", "Diecisiete", "Dicieocho", "Dicienueve" };
		String[] decenas = { "Cero", "Diez", "Veinte", "Treinta", "Cuarenta", "Cincuenta", "Sesenta", "Setenta",
				"Ochenta", "Noventa" };
		if (n < 100) {
			if (n >= 20) {
				numero = decimalCompleto(n, numero, unidades, decenas);
			} else {
				numero += unidades[n];
			}
			System.out.println(numero);
		}
		return numero;
	}

	private static String decimalCompleto(int n, String numero, String[] unidades, String[] decenas) {
		if ((n % 10) != 0) {
			numero += decenas[(n / 10)];
			numero += " y ";
			numero += unidades[(n % 10)];

		} else {
			numero += decenas[(n / 10)];
		}
		return numero;
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		int index = 0;
		String year = "";
		for (int i = 0; i < fecha.length(); i++) {
			if (fecha.charAt(i) == '-') {
				index = i;
			}
		}
		for (int i = index; i < fecha.length(); i++) {
			year += fecha.charAt(i);
		}
		if (Integer.parseInt(year) % 4 == 0
				&& (Integer.parseInt(year) % 100 != 0 || Integer.parseInt(year) % 400 != 0)) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		boolean validate = false;
		String aux = "";
		aux += date.charAt(0) + date.charAt(1);
		if (date != "" && date.charAt(1) != '0' && Integer.valueOf(aux) < 32) {
			try {
				SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
				formatoFecha.parse(date);
				validate = true;
			} catch (ParseException e) {
				validate = false;
			}

		}

		return validate;
	}
}
