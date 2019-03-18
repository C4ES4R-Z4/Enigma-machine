import java.io.*;
import java.util.*;
/**
* <h1>Enigma</h1>
* Engima machine emulator
*
* @author MJ
*/
public class Enigma {
	static int r1 = 0;
	static int r2 = 0;
	static int r3 = 0;
	static String message = "";
	static String messageNew = "";
	static String alphabetS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static String plugboardS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static String rotor1S = "DMTWSILRUYQNKFEJCAZBPGXOHV";
	static String rotor2S = "HQZGPJTMOBLNCIFDYAWVEUSRKX";
	static String rotor3S = "UQNTLSZFMREHDPXKIBVYGJCWOA";
	static String reflectorS = "YRUHQSLDPXNGOKMIEBFZCWVJAT";
	static String[] alphabet = new String[26];
	static String[] plugboard = new String[26];
	static String[] rotor1 = new String[26];
	static String[] rotor2 = new String[26];
	static String[] rotor3 = new String[26];
	static String[] reflector = new String[26];
	//Main
	public static void main(String[] args) {
		readIn();
		toArray();
		encrypt();
		display();
	}
	//To toArray
	public static void toArray() {
		for (int i = 0; i < 27; i++) {
			alphabet[i] = alphabetS.substring(i, i+1);
			plugboard[i] = plugboardS.substring(i, i+1);
			rotor1[i] = rotor1S.substring(i, i+1);
			rotor2[i] = rotor2S.substring(i, i+1);
			rotor3[i] = rotor3S.substring(i, i+1);
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
			message = message.toUpperCase();
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
	public static String rotors(String ch) {
		//Rotor 1
		int index = index(ch);
		int indexer = r1;
		if (r1 + index > 26) {indexer = r1 - (26 - index)}
		ch = rotor1[index + indexer];
		r1++;
		//rotor2
		index = index(ch);
		int indexer = r2;
		if (r2 + index > 26) {indexer = r2 - (26 - index)}
		ch = rotor2[index + indexer];
		if (r1 == 26) {
			r1 = 0;
			r2++;
		}
		//rotor3S
		index = index(ch);
		int indexer = r2;
		if (r3 + index > 26) {indexer = r3 - (26 - index)}
		ch = rotor3[index + indexer];
		if (r2 == 26) {
			r2 = 0;
			r3++;
		}
		return ch;
	}
	//reverse rotor1
	public static String reverseRotor() {
		//Rotor 1
		int index = index(ch);
		int indexer = r3;
		if (r3 > index) {}
		ch = rotor1[index + indexer];
		r1++;
		//rotor2
		index = index(ch);
		int indexer = r2;
		if (r2 + index > 26) {indexer = r2 - (26 - index)}
		ch = rotor2[index + indexer];
		if (r1 == 26) {
			r1 = 0;
			r2++;
		}
		//rotor3S
		index = index(ch);
		int indexer = r2;
		if (r3 + index > 26) {indexer = r3 - (26 - index)}
		ch = rotor3[index + indexer];
		if (r2 == 26) {
			r2 = 0;
			r3++;
		}
		return ch;
	}
	//encrypt
	public static void encrypt() {
		String ch = "";
		for (int i = 0; i < message.length(); i++) {
			ch = plugboard(message.charAt(i) + "");
			ch = rotors(ch);
			ch = reflector(ch);
		}
	}
	//reflectorS
	public static String reflector(String ch) {
		int index = index(ch);
		ch = reflector[index];
		return ch;
	}
	//find alpha index
	public static int index(String ch) {
		for (int i = 0; i < 27; i++) {
			if (ch.equals(alphabet[i])) {
				return i;
			}
		}
		return 99;
	}
	//display
	public static void display() {
		System.out.println(messageNew);
	}
}
