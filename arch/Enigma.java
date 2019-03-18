import java.io.*;
import java.util.*;
/**
* <h1>Enigma</h1>
* Engima machine emulator
*
* @author MJ
*/
public class Enigma {
	static int rotor1 = 0;
	static int rotor1i = 0;
	static int rotor2 = 0;
	static int rotor2i = 0;
	static int rotor3 = 0;
	static int rotor3i = 0;
	static String message = "";
	static String messageNew = "";
	static String alpha = "abcdefghijklmnopqrstuvwxyz ";
	//Main
	public static void main(String[] args) {
		//rotorConversion(args[0], args[1], args[2]);
		readIn();
		message = message.toLowerCase();
		encrypt();
		display();
	}
	//Make rotor alpha's numbers
	public static void rotorConversion(String x, String y, String z) {
		for (int i = 0; i < alphabet.length; i++) {
				if (x.equals(alphabet[i])) {
					rotor1 = i;
				}
				if (y.equals(alphabet[i])) {
					rotor2 = i;
				}
				if (y.equals(alphabet[i])) {
					rotor3 = i;
				}
		}
	}
	//Read StdIn
	public static void readIn() {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		try {
			while(true) {
				String name = f.readLine();
				if (name == null) {break;}
				else {message += name;}
			}
		}catch (Exception e) {}
	}
	//Plugboard
	public static String plugboard(String ch) {
		int index = 0;
		for (int i = 0; i < alpha.length(); i++) {
			if (ch.equals(ch.charAt(i) + "")) {
				index = i;
				break;
			}
		}
		return plugboard[index];
	}
	//Rotor 1
	public static void rotors(String ch) {

	}
	//encrypt
	public static void encrypt() {
		for (int i = 0; i < message.length(); i++) {
			messageNew += plugboard(message.charAt(i) + "");
		}
	}
	//display
	public static void display() {
		System.out.println(messageNew);
	}
}
