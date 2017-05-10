package com.xuzz.study.util;
/**
 * 加密工具类
 *
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtil {

  public static Log log = LogFactory.getLog(EncryptUtil.class);


  public static String decrypt(String message) {
    String result = "";
    try {
      byte[] bytesrc = stringToBytes(message);
      Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      DESKeySpec desKeySpec = new DESKeySpec("@#$%^6a7".getBytes("UTF-8"));
      SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
      SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
      IvParameterSpec iv = new IvParameterSpec("@#$%^6a7".getBytes("UTF-8"));
      cipher.init(2, secretKey, iv);
      byte[] retByte = cipher.doFinal(bytesrc);
      result = new String(retByte, "UTF-8");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

  public static String encrypt(String message) throws Exception {
    Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
    DESKeySpec desKeySpec = new DESKeySpec("@#$%^6a7".getBytes("UTF-8"));
    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
    SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
    IvParameterSpec iv = new IvParameterSpec("@#$%^6a7".getBytes("UTF-8"));
    cipher.init(1, secretKey, iv);
    String str = bytesToString(cipher.doFinal(message.getBytes("UTF-8")));
    return str;
  }

  private static byte[] stringToBytes(String temp) {
    byte[] digest = new byte[temp.length() / 2];
    for (int i = 0; i < digest.length; ++i) {
      String byteString = temp.substring(2 * i, 2 * i + 2);
      int byteValue = Integer.parseInt(byteString, 16);
      digest[i] = (byte) byteValue;
    }

    return digest;
  }

  private static String bytesToString(byte[] b) {
    StringBuffer hexString = new StringBuffer();
    for (int i = 0; i < b.length; ++i) {
      String plainText = Integer.toHexString(0xFF & b[i]);
      if (plainText.length() < 2)
        plainText = "0" + plainText;
      hexString.append(plainText);
    }

    return hexString.toString();
  }


  /**
   * BASE64加密
   * 
   * @param s String
   * @return String
   */
  public static String Bey64Ecnode(String s) {
    String str = null;
    if (s == null) {
      return null;
    }
    BASE64Encoder en = new BASE64Encoder();
    try {
      str = en.encode(s.getBytes("GBK"));
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return str;
  }


  /**
   * BASE64解密
   * 
   * @param s
   * @return
   * @throws Exception
   */
  public static String Bey64Decoder(String s) {
    if (s == null) {
      return null;
    }
    BASE64Decoder de = new BASE64Decoder();
    String res = "";
    try {
      byte[] bt = de.decodeBuffer(s);
      res = new String(bt, "GBK");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return res;
  }

  /**
   * MD5加密
   * 
   * @param origin
   * @return
   */
  public static String MD5Encode(String origin) {
    String resultString = null;

    try {
      resultString = new String(origin);
      MessageDigest md = MessageDigest.getInstance("MD5");
      resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return resultString;
  }

  public static String byteArrayToHexString(byte[] b) {
    StringBuffer resultSb = new StringBuffer();
    for (int i = 0; i < b.length; i++) {
      resultSb.append(byteToHexString(b[i]));
    }
    return resultSb.toString();
  }

  private static String byteToHexString(byte b) {
    int n = b;
    if (n < 0) {
      n = 256 + n;
    }
    int d1 = n / 16;
    int d2 = n % 16;
    return hexDigits[d1] + hexDigits[d2];
  }

  private final static String[] hexDigits =
      {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};


  private static String byte2HexStr(byte[] b) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < b.length; i++) {
      String s = Integer.toHexString(b[i] & 0xFF);
      if (s.length() == 1) {
        sb.append("0");
      }
      sb.append(s.toUpperCase());
    }
    return sb.toString();
  }

  /**
   * MD5数字签名 大写
   * 
   * @param src
   * @return
   * @throws Exception
   */
  public static String md5Digest(String src) {
    // 定义数字签名方法, 可用：MD5, SHA-1
    String s = "";
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      byte[] b = md.digest(src.getBytes("UTF-8"));
      s = byte2HexStr(b);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return s;
  }
}
