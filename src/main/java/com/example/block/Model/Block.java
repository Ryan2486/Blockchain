package com.example.block.Model;

import java.security.MessageDigest;
import java.util.Date;

public class Block {
  private String hash;
  private String previousHash;
  private Object data;
  private Date DateTime;
  private int nonce;

  public Block(String previousHash, Object data, Date DateTime, int nonce) {
    this.previousHash = previousHash;
    this.data = data;
    this.DateTime = DateTime;
    this.nonce = nonce;
    this.hash = calculateHash().toString();
  }

  public String calculateHash() {
    try {
      MessageDigest SHA256 = MessageDigest.getInstance("SHA-256");
      String blockData = previousHash + (DateTime.toString()) + Integer.toString(nonce) + data;
      String hash = SHA256.digest(blockData.getBytes("UTF-8")).toString();
      return hash;
    } catch (Exception e) {
      // Handle exception
      return null;
    }
  }

  public String getHash() {
    return this.hash;
  }

  public String getPreviousHash() {
    return previousHash;
  }

  public void setPreviousHash(String previousHash) {
    this.previousHash = previousHash;
  }

  public Object getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public Date getDateTime() {
    return DateTime;
  }

  public void setDateTime(Date DateTime) {
    this.DateTime = DateTime;
  }

  public int getNonce() {
    return nonce;
  }

  public void setNonce(int nonce) {
    this.nonce = nonce;
  }

}
