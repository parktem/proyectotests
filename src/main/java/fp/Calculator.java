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
		if (n == 0) {
			return "Cero";
		}
		if (n > 9) {
			if (n % 10 == 0) {
				if (n % 10 == 0) {
					numero += "Diez";
				}
				if (n % 20 == 0) {
					numero += "Veinte";
				}
				if (n % 30 == 0) {
					numero += "Treinta";
				}
				if (n % 40 == 0) {
					numero += "Cuarenta";
				}
				if (n % 50 == 0) {
					numero += "Cincuenta";
				}
				if (n % 60 == 0) {
					numero += "Sesenta";
				}
				if (n % 70 == 0) {
					numero += "Setenta";
				}
				if (n % 80 == 0) {
					numero += "Ochenta";
				}
				if (n % 90 == 0) {
					numero += "Noventa";
				}
			}
		}
		n /= 10;

		if (n / 10 == 1) {
			numero += " y uno";
		}

		if (n / 10 == 1) {
			numero += " y dos";
		}
		if (n / 10 == 1) {
			numero += " y tres";
		}
		if (n / 10 == 1) {
			numero += " y cuatro";
		}
		if (n / 10 == 1) {
			numero += " y cinco";
		}
		if (n / 10 == 1) {
			numero += " y seis";
		}
		if (n / 10 == 1) {
			numero += " y siete";
		}
		if (n / 10 == 1) {
			numero += " y ocho";
		}
		if (n / 10 == 1) {
			numero += " y nueve";
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
