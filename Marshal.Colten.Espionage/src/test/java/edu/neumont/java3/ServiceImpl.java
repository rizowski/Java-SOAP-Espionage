package edu.neumont.java3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.jws.WebMethod;
import javax.jws.WebParam;

import org.apache.geronimo.mail.util.Base64;

public class ServiceImpl implements EspionageService{

	@WebMethod(action="/crack")
	public String crack(@WebParam Long number) {
		String output = "";
		String hash = Encode("abc123", "password");
		try {
			
			URL url = new URL("http://localhost:8080/InYourPrime/factor?number=" + number);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			
			conn.setRequestProperty("Accept", "application/xml");
			conn.setRequestProperty("Authorization", "Basic "+hash);
			if (conn.getResponseCode() != 200) {
				System.out.println(conn.getResponseCode() +" " +conn.getResponseMessage() + " woops " + conn.getRequestProperties());
				return "ERROR";
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String current;
			while((current = br.readLine())!= null) {
				output += current;
			}
		} catch (MalformedURLException me) {
			System.out.println(me.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return output;
	}
	public String Encode(String username, String password) {
		String concated = username + ":" + password;
		String encode = new String(Base64.encode(concated.getBytes()));
		return encode;
	}
}

