package mde.iot.ucm4iot.drivers;

public class Driver {

	/***
	 * main(..)
	 * --------
	 * Driver code that manually tests elements in the environment.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(toName(1));
		System.out.println("1b.1a".compareTo("1a.1b"));
	}
	
	public static int toNumber(String name) {
        int number = 0;
        for (int i = 0; i < name.length(); i++) {
            number = number * 26 + (name.charAt(i) - ('A' - 1));
        }
        return number;
    }

    public static String toName(int number) {
        StringBuilder sb = new StringBuilder();
        while (number-- > 0) {
            sb.append((char)('a' + (number % 26)));
            number /= 26;
        }
        return sb.reverse().toString();
    }
}
