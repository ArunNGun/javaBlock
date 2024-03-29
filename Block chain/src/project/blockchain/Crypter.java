package project.blockchain;

import java.security.MessageDigest;

public class Crypter {
	
	//im using SHA256 algo
	
	public static String  applyCrypter(String s) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			
			byte[] hash = digest.digest(s.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();
			for(int i=0;i<hash.length;i++) {
				String hex=Integer.toHexString(0xff & hash[i]);
				if(hex.length()==1) hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
			
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
