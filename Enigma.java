import java.io.*;
import java.util.*;
/**
* <h1>Enigma</h1>
* Engima machine emulator
*
* @author MJ
*/
public class Enigma {
	static String message = "";
	static String messageNew = "";
	static String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i",
	 														"j", "k","l", "m", "n", "o", "p", "q", "r",
															"s", "t", "u", "v", "w", "x", "y", "z", " "};
	static String[] plugboard = {"a", "b", "c", "d", "e", "f", "g", "h", "i",
														  "j", "k","l", "m", "n", "o", "p", "q", "r",
														  "s", "t", "u", "v", "w", "x", "y", "z", " "};
	//Main
	public static void main(String[] args) {
		readIn();
		message = message.toLowerCase();
		encrypt();
		display();
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
		for (int i = 0; i < alphabet.length; i++) {
			if (ch.equals(alphabet[i])) {
				index = i;
				break;
			}
		}
		return plugboard[index];
	}
	//Rotor 1
	public static rotor1() {
		
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
