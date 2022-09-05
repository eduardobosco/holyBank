package br.com.holy.bank.usuario;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class ConverterSenha {

	public static String converterSenha(String senha) throws NoSuchAlgorithmException {

		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(senha.getBytes(StandardCharsets.UTF_8));
		String encoded = Base64.getEncoder().encodeToString(hash);
		
		return encoded;
	}
}
