package modelo;

import java.security.MessageDigest;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.picketbox.commons.cipher.Base64;

public class GestionCifrado {
	String CADENA = "RnCD(*ewS^a?pwx";
	
	public SecretKeySpec CrearClave(String key) {
		try {
			byte[] claveEnBytes = key.getBytes("UTF-8");
			MessageDigest mensaje = MessageDigest.getInstance("SHA-1");
			claveEnBytes = mensaje.digest(claveEnBytes);
			claveEnBytes = Arrays.copyOf(claveEnBytes, 16);
			
			SecretKeySpec secretKey = new SecretKeySpec(claveEnBytes, "AES");
			return secretKey;
			
		} catch (Exception e) {
			return null;
		}
	}
	
    public String encriptar(String clave) {
     
        try {
        SecretKeySpec secretKeySpec = CrearClave(CADENA);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            
            byte [] claveEnBytes = clave.getBytes("UTF-8");
            byte [] claveEncriptada = cipher.doFinal(claveEnBytes);
            String claveEncriptadaCodificada = Base64.encodeBytes(claveEncriptada);
            return claveEncriptadaCodificada;
            
            
            
        } catch (Exception e) {
            return "";
        }
    }

     public String desencriptar(String clave) {
     
        try {
            SecretKeySpec secretKeySpec = CrearClave(CADENA);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            
            byte [] claveEnBytes = Base64.decode(clave);
            byte [] claveDesencriptada = cipher.doFinal(claveEnBytes);
            String claveDesencriptadaCadena = new String(claveDesencriptada);
            return claveDesencriptadaCadena;
            
        } catch (Exception e) {
            return "";
        }
    }
}
