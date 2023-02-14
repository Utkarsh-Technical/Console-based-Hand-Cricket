package handCricket;

import java.util.Random;

public class abc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0;
		while(i<10) {
		String chars = "HTHHTTHHT";
		Random rnd = new Random();
		char c = chars.charAt(rnd.nextInt(chars.length()));
		System.out.println(c);
		i++;
		}
	}

}
