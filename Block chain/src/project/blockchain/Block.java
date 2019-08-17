package project.blockchain;

import java.util.Date;

public class Block {
	
	
	
	public String hash;
	public String previousHash;
	private String data;
	private long timeStamp;
	private int nonce;
	
//constructor	
	public Block(String data,String previousHash) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.hash=calHash();
	}
	
	public String calHash() {
		String getHash=Crypter.applyCrypter(
						previousHash +
						Long.toString(timeStamp) +
						data);
		return getHash;
	}
	
	public void mining(int difficulty) {
		String s=new String(new char[difficulty]).replace('\0','0');
		while(!hash.substring(0,difficulty).equals(s)) {
			nonce++;
			hash=calHash();
		}
		System.out.println("Block mined.... :"+ hash);
	}
	
}