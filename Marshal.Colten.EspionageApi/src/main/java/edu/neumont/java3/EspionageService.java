package edu.neumont.java3;

import java.math.BigInteger;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface EspionageService {
	@WebMethod
	String crack(@WebParam BigInteger code, @WebParam BigInteger e);
}