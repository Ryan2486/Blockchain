package com.example.block.Model;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlockChain {
  private int difficulty = 5;
  private Block genesisBlock;
  private List<Block> blockChain;

  public BlockChain(int difficulty) {
    try {
      this.difficulty = difficulty;
      this.blockChain = new ArrayList<>();
      this.genesisBlock = new Block("0", "0", new Date(), 0);
      this.blockChain.add(genesisBlock);
    } catch (Exception e) {
      // Handle exception
    }

  }

  public Block getLatestBlock() {
    return blockChain.get(blockChain.size() - 1);
  }

  public Block generateNextBlock(Object blockData) {
    Block previousBlock = getLatestBlock();
    System.out.println("Previous Block Hash: " + previousBlock.getHash());
    return new Block(previousBlock.getHash(), blockData,
        new Date(), 0);
  }

  public String HashBlock(Block block) {
    try {
      MessageDigest SHA256 = MessageDigest.getInstance("SHA-256");
      String blockData = block.getPreviousHash() + (block.getDateTime().toString())
          + Integer.toString(block.getNonce()) + block.getData();
      byte[] hash = SHA256.digest(blockData.getBytes("UTF-8"));
      return hash.toString();
    } catch (Exception e) {
      // Handle exception
      return null;
    }
  }

  public void addBlock(Block block) {
    blockChain.add(block);
  }

  public List<Block> getBlockChain() {
    return blockChain;
  }

  public void setBlockChain(List<Block> blockChain) {
    this.blockChain = blockChain;
  }

  public Block getGenesisBlock() {
    return genesisBlock;
  }

  public void setGenesisBlock(Block genesisBlock) {
    this.genesisBlock = genesisBlock;
  }

  public int getDifficulty() {
    return difficulty;
  }

  public void setDifficulty(int difficulty) {
    this.difficulty = difficulty;
  }

}
