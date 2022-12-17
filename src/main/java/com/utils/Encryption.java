package com.utils;

import java.security.NoSuchAlgorithmException;  
import java.security.MessageDigest;  
  
public class Encryption   
{  
    /* Driver Code */  
    @SuppressWarnings("finally")
	public static String encrypt(String password)   
    {  
        /* Plain-text password initialization. */
        String encryptedpassword = null;  
        try   
        {  
            /* MessageDigest instance for MD5. */  
            MessageDigest m = MessageDigest.getInstance("MD5");  
              
            /* Add plain-text password bytes to digest using MD5 update() method. */  
            m.update(password.getBytes());  
              
            /* Convert the hash value into bytes */   
            byte[] bytes = m.digest();  
              
            /* The bytes array has bytes in decimal form. Converting it into hexadecimal format. */  
            StringBuilder s = new StringBuilder();  
            for(int i=0; i< bytes.length ;i++)  
            {  
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
            }  
              
            /* Complete hashed password in hexadecimal format */  
            encryptedpassword = s.toString();  
        }   
        catch (NoSuchAlgorithmException e)   
        {  
            e.printStackTrace();  
        }  
        finally {
        	return encryptedpassword;
        }
    }  
    public static void main(String[] args) {
    	String password = "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";
    	System.out.println(encrypt(password));
    }
}  