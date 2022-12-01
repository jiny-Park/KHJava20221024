package day26Practice;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressPT {

	public static void main(String[] args) {
		InetAddress ia = null;
		
		try {
			ia = InetAddress.getByName("localhost");
			System.out.println(ia);
			ia = InetAddress.getByName("www.naver.com");
			System.out.println(ia);
			
			InetAddress [] ias = InetAddress.getAllByName("www.google.com");
			for(InetAddress tmpAddress : ias) {
				System.out.println(tmpAddress);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		

	}

}
