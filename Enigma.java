import java.io.*;
import java.util.*;
/*****************************************************************************
* CLASS ENIGMA
*****************************************************************************/
public class Enigma {
  //Instance variables
  static int r1 = 0, r2 = 0, r3 = 0;
  static String message = "";
  static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  static String plugboard = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  static String reflection = "YRUHQSLDPXNGOKMIEBFZCWVJAT";
  static String rotorI = "JGDQOXUSCAMIFRVTPNEWKBLZYH";
  static String rotorII = "NTZPSFBOKMWRCJDIVLAEYUXHGQ";
  static String rotorIII = "JVIUBHTCDYAKEQZPOSGXNRMWFL";
  //Main
  public static void main(String[] args) {
    checkErrors();
    getMessage();
    encrypt();
    display();
  }
  //First checks
  public static void checkErrors() {
    if (plugboard.length() != 26) {System.err.println("Plugboard format incorrect."); System.exit(1);}
    if (rotorI.length() != 26) {System.err.println("Rotor I format incorrect."); System.exit(1);}
    if (rotorII.length() != 26) {System.err.println("Rotor II format incorrect."); System.exit(1);}
    if (rotorIII.length() != 26) {System.err.println("Rotor III format incorrect."); System.exit(1);}
    if (reflection.length() != 26) {System.err.println("Reflection board format incorrect."); System.exit(1);}
  }
  //Get char at index
  public static String get(String n, int index) {
    String rt = "";
    if ((index + 1) >= n.length()) {
      rt = n.substring(index);
    }else {
      rt = n.substring(index, index+1);
    }
    return rt;
  }
  //Get rotor position
  public static int getRotorIndex(int index, int rotation) {
    return Math.abs(26 - (index + rotation));
  }
  //Get Reverse rotor position
  public static int getReverseRotorIndex(int index, int rotation) {
    index = index - rotation;
    if (index < 0) {index = 26 + index;}
    return index;
  }
  //Make rotation
  public static void rotate() {
    r1++;
    if (r1 > 25) {r1 = 0; r2++;}
    if (r2 > 25) {r2 = 0; r3++;}
    if (r3 > 25) {r3 = 0;}
  }
  /*****************************************************************************
  * GET AND DISPLAY MESSAGE
  *****************************************************************************/
  //getMessage
  public static void getMessage() {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    try {
      String name;
      while(true) {
        name = in.readLine();
        if (name == null) {
          break;
        }else {
          message += name;
        }
      }
      message = message.toUpperCase();
    }catch(Exception e) {}
  }
  //Display
  public static void display() {
    System.out.println(message);
  }
  /*****************************************************************************
  * DO SCRAMBLING
  *****************************************************************************/
  //Do encryption
  public static void encrypt() {
    String newM = "";
    String ch = "";
    for (int i = 0; i < message.length(); i++) {
      System.out.println("Starting first sequence...\n");
      ch = plugboard(get(message, i));
      System.out.print("Rotor 1 changed " + ch + " to ");
      ch = rotors(ch, rotorI, r1);
      System.out.println(ch);
      System.out.print("Rotor 2 changed " + ch + " to ");
      ch = rotors(ch, rotorII, r2);
      System.out.println(ch);
      System.out.print("Rotor 3 changed " + ch + " to ");
      ch = rotors(ch, rotorIII, r3);
      System.out.print(ch + "\nEnding first sequence...\n\nStarting reverse");
      //ch = reflection(ch);
      System.out.print("Rotor 1 reverse changed " + ch + " to ");
      ch = reverseRotors(ch, rotorIII, r3);
      System.out.println(ch);
      System.out.print("Rotor 2 reverse changed " + ch + " to ");
      ch = reverseRotors(ch, rotorII, r2);
      System.out.println(ch);
      System.out.print("Rotor 3 reverse changed " + ch + " to ");
      ch = reverseRotors(ch, rotorI, r1);
      System.out.println(ch);
      //Todo reverse
      //System.out.println(ch);
      newM += ch;
    }
    message = newM;
  }
  //Plugboard scramble
  public static String plugboard(String ch) {
    for (int i = 0; i < 26; i++) {
      if (get(alphabet, i).equals(ch)) {
        return get(plugboard, i);
      }
    }
    return ch;
  }
  //Rotors
  public static String rotors(String ch, String rot, int r) {
    for (int i = 0; i < 26; i++) {
      if (get(alphabet, i).equals(ch)) {
        rotate();
        return get(rot, getRotorIndex(i, r - 1));
      }
    }
    return ch;
  }
  //Reverse Rotors
  public static String reverseRotors(String ch, String rot, int r) {
    for (int i = 0; i < 26; i++) {
      if (get(rot, i).equals(ch)) {
        return get(alphabet, getReverseRotorIndex(i, r - 1));
      }
    }
    return ch;
  }
  //reflection
  public static String reflection(String ch) {
    for (int i = 0; i < 26; i++) {
      if (get(alphabet, i).equals(ch)) {
        return get(reflection, i);
      }
    }
    return ch;
  }

}
