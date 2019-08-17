package project.blockchain;


import java.util.ArrayList;
import java.util.List;

import com.google.gson.GsonBuilder;



public class BlockChain {
	
	
	public static int difficulty = 0;
	public static List<Block> blockchain = new ArrayList<Block>();
	
	
	public static void main(String... args) {
		
		
		
		
		blockchain.add(new Block("hello this is the genesis block","0"));
		
		/*mining block*/ System.out.println("Trying to mine block 1...");
		blockchain.get(0).mining(difficulty);
		
		
		blockchain.add(new Block("hello this is the second block",blockchain.get(blockchain.size()-1).hash));
		//blockchain.get(1).mining(difficulty);
		
		blockchain.add(new Block("block 3",blockchain.get(blockchain.size()-1).hash));
		//blockchain.get(2).mining(difficulty);
		
		System.out.println("is chain valid ? :"+ isValid());
		
		String blockchainJson =new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
		
		System.out.println(blockchainJson);
		
	}
	
	public static Boolean isValid() {
		Block currentBlock;
		Block previousBlock;
		
		for(int i=1;i<blockchain.size();i++) {
			currentBlock=blockchain.get(i);
			previousBlock=blockchain.get(i-1);
			
			if(!currentBlock.hash.equals(currentBlock.calHash())) {
				System.out.println("Invalid chain: current hash is not equal");
				return false;
			}
			
			if(!previousBlock.hash.contentEquals(currentBlock.previousHash)) {
				System.out.println("invalid chain : previous hash not equal");
				return false;
			}
		}
		return true;
	}
	
	
	
}
