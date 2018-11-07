import java.util.Scanner;

public class Password {
	
	private String pass1, pass2;
	private int repeatedCharLimit = 3;
	Scanner scan;

	Password(){
		scan = new Scanner(System.in);
		getPasswordEntry();
	}
	
	private void getPasswordEntry() {
		setPass1(scan.nextLine());
		checkForPassConditions(getPass1());
	}
	
	private void checkForPassConditions(String pass1) {
		if(!getPass1().contains(" ") 
				&& !getPass1().startsWith("!")
				&& !getPass1().startsWith("?")
				&& checkRepeatingElements(getPass1())) {
			
		}
	}

	/*
	 * DEBUG: Line skip 
	 * */

	public boolean checkRepeatingElements(String pass1) {
		for(int i=0;i<pass1.length();i++) {
			char[] passChars = new char[pass1.length()];
			passChars = pass1.toCharArray();
			for(int j = 0;j < passChars.length-1;j++) {
				if(passChars[i] == (passChars[j]))
				{
					int repeatedChars = 0;
					repeatedChars++;
					if(repeatedChars == repeatedCharLimit) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public String getPass1() {
		return pass1;
	}

	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}

	public String getPass2() {
		return pass2;
	}

	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}
}
