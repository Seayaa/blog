package blog;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalTime;
import java.util.Date;

public class Test3 {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		SecureRandom a = SecureRandom.getInstanceStrong();
		System.out.println(a.nextInt());
		
		Date date = new Date();
		System.out.println(date.toString());
		
		LocalTime time = LocalTime.now();
		System.out.println();
	}
}
