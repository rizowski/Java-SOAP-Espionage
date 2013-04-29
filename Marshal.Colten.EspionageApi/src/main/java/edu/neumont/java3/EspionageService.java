package edu.neumont.java3;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface EspionageService {
	@WebMethod
	String crack(@WebParam Long code);
}