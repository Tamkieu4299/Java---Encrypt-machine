package encryptMachine;
import java.util.*;

public class EncryptionProgram_ {
	
		
	// Variables
	private Scanner scanner;
	private Random random;
	private ArrayList<Character> list;
	private ArrayList<Character> shuffledList;
	private char character;
	private String line;
	private char[] letters;
	private char[] secretLetters;
	
	EncryptionProgram_() {
		scanner = new Scanner(System.in);
		random = new Random();
		list = new ArrayList();
		shuffledList = new ArrayList();
		character = ' ';
		
		newKey();
		askQuestion();
	}
	
	// Ask user the input
	private void askQuestion() {
		while(true) {
			
			System.out.println("\nWHAT DO YOU WANT TO DO?");
			System.out.println("(N)ewKey,(G)etKey,(E)ncrypt,(D)ecrypt,(Q)uit");
			char response = Character.toUpperCase(scanner.nextLine().charAt(0));
			
			switch(response) {
			case 'N':
				newKey();
				break;
			case 'G':
				getKey();
				break;
			case 'E':
				encrypt();
				break;
			case 'D':
				decrypt();
				break;
			case 'Q':
				quit();
				break;
			default:
				System.out.println("Invalid input");
			}
		}
	}
	
	// Get the new key
	private void newKey() {
		
		// Get rid of the old key
		character =' ';
		list.clear();
		shuffledList.clear();
		
		for(int i=32; i <127; i++) {
			list.add(Character.valueOf(character));
			character++;
		}
		
		// Permutate the list
		shuffledList = new ArrayList(list);
		Collections.shuffle(shuffledList);
		System.out.println("New key has been generated");
	}
	
	// Retrieve the key
	private void getKey() {
		
		System.out.println("Key: ");
		for(Character x : list) {
			System.out.print(x);
		}
		System.out.println();
		for(Character x : shuffledList) {
			System.out.print(x);
		}
	}
	
	// Encrypt method
	private void encrypt() {
		
		System.out.println("\nEnter a message: ");
		String message = scanner.nextLine();
		
		letters = message.toCharArray();
		
		for(int i=0; i<letters.length; i++) {
			
			for(int j=0; j<list.size(); j++) {
				if(letters[i]==list.get(j)){
					letters[i]=shuffledList.get(j);
					break;
					}
				}
			}
		System.out.println("\nEncrypted: ");
		for(char x: letters) {
			System.out.print(x);
		}
		System.out.println();
	}

	// Decrypt method
	private void decrypt() {
		System.out.println("\nEnter an encrypted message: ");
		String message = scanner.nextLine();
		
		letters = message.toCharArray();
		
		for(int i=0; i<letters.length; i++) {
			
			for(int j=0; j<list.size(); j++) {
				if(letters[i]==shuffledList.get(j)){
					letters[i]=list.get(j);
					break;
					}
				}
			}
		System.out.println("\nDecrypted: ");
		for(char x: letters) {
			System.out.print(x);
		}
		System.out.println();
	}
	
	// Quit
	private void quit() {
		System.out.println("Goodbye");
		System.exit(0);
	}
			
}


