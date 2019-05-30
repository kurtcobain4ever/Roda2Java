package com.fan.demo.util;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;


/**
 * DES加密工具
 * 1.desEncript加密
 * 2.desDecript解密
 * 3.getKey将原始秘钥转化为加工秘钥
 */
public class DESUtil {
    private static final String originKey ="ppteng";
    /**
     * 采用默认原始密文加密
     * @param clearText 输入明文
     * @return cipherText 密文
     * @throws Exception
     */
    public static String desEncript(String clearText) throws NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeyException, BadPaddingException,
            IllegalBlockSizeException, InvalidKeySpecException {
        //1.获取加密算法工具类
        Cipher cipher=Cipher.getInstance("DES");
        //2.将初始秘钥转化为加密秘钥
        SecretKey secretKey = DESUtil.getKey();
        //3.初始化加密工具类
        cipher.init(Cipher.ENCRYPT_MODE,secretKey);
        //4.加密执行，调用doFinal
        byte[] doFinal=cipher.doFinal(clearText.getBytes());
        //5.使用Base64进行解码得到密文
        String cipherText= Base64.encodeBase64String(doFinal);
        return cipherText;
    }

    /**
     * @param clearText 加密明文
     * @param customOriginKey 自定义原始秘钥
     * @return
     * @throws Exception
     */
    public static String desEncript(String clearText,String customOriginKey)throws Exception{
        Cipher cipher=Cipher.getInstance("DES");
        SecretKey secretKey = DESUtil.getKey(customOriginKey);
        cipher.init(Cipher.ENCRYPT_MODE,secretKey);
        byte[] doFinal=cipher.doFinal(clearText.getBytes());
        String cipherText= Base64.encodeBase64String(doFinal);
        return cipherText;
    }

    /**
     * @param cipherText 输入密文
     * @return clearText 明文
     * @throws Exception
     */
    public static String desDecript(String cipherText)throws Exception{
        Cipher cipher=Cipher.getInstance("DES");
        SecretKey secretKey =DESUtil.getKey();
        cipher.init(Cipher.DECRYPT_MODE,secretKey);
        byte[] decode=Base64.decodeBase64(cipherText);
        byte[] doFinal=cipher.doFinal(decode);
        String clearText= new String(doFinal);
        return clearText;
    }

    /**
     * @param cipherText 输入密文
     * @param customOriginKey 自定义原始秘钥
     * @return
     * @throws Exception
     */
    public static String desDecript(String cipherText,String customOriginKey)throws Exception{
        Cipher cipher=Cipher.getInstance("DES");
        SecretKey secretKey =DESUtil.getKey(customOriginKey);
        cipher.init(Cipher.DECRYPT_MODE,secretKey);
        byte[] decode=Base64.decodeBase64(cipherText);
        byte[] doFinal=cipher.doFinal(decode);
        String clearText= new String(doFinal);
        return clearText;
    }

    /**
     * 默认原始秘钥
     * @return 加密秘钥
     */
    public static SecretKey getKey() throws NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException {
        SecretKeyFactory keyFactory=SecretKeyFactory.getInstance("DES");
        byte[] keyBytes=new byte[8];
        byte[] originBytes=originKey.getBytes();
        for(int i=0;i<8 && i<originBytes.length;i++){
            keyBytes[i]=originBytes[i];
        }
        DESKeySpec desKeySpec=new DESKeySpec(keyBytes);
        SecretKey secretKey=keyFactory.generateSecret(desKeySpec);
        return secretKey;
    }

    /**
     * @param customOriginKey 自定义原始秘钥
     * @return SecretKey 加密秘钥
     * @throws Exception
     */
    public static SecretKey getKey(String customOriginKey) throws Exception {
        SecretKeyFactory keyFactory=SecretKeyFactory.getInstance("DES");
        byte[] originBytes=customOriginKey.getBytes();
        byte[] keyBytes=new byte[8];
        for(int i=0;i<8 && i<originBytes.length;i++){
            keyBytes[i]=originBytes[i];
        }
        DESKeySpec desKeySpec=new DESKeySpec(keyBytes);
        SecretKey secretKey=keyFactory.generateSecret(desKeySpec);
        return secretKey;
    }
}
