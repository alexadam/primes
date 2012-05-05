import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

public class Primes {

	static List<Integer> primes = new LinkedList<Integer>() {{ add(2); }};
	static final int SIZE = 300;

	public static void main(String[] args) {
		
		BufferedImage theImage = new BufferedImage(SIZE, SIZE, BufferedImage.TYPE_INT_RGB);
		for(int y = 0; y < SIZE; y++){
		    for(int x = 0; x < SIZE; x++)
		        theImage.setRGB(x, y, checkPrime(y * SIZE + x) ? 0 : Integer.MAX_VALUE * 2 - 1);
		}
		
		try {
			ImageIO.write(theImage, "png", new File("primes.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean checkPrime(int number) {
		if (number == 0)
			return false;

		if (number == 1 || number == 2)
			return true;

		boolean isPrime = true;
		int stoppingPoint = (int) Math.pow(number, 0.5) + 1;

		for (Integer p : primes) {
			if (number % p == 0) {
				isPrime = false;
				break;
			}

			if (p > stoppingPoint)
				break;
		}

		if (isPrime)
			primes.add(number);

		return isPrime;
	}
	
}
