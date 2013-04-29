package edu.neumont.java3;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.springframework.stereotype.Service;

@Service("EspionageCallbackHandler")
public class ServerCallbackHandler implements CallbackHandler{
	public void handle(Callback[] callbacks) throws IOException,
	UnsupportedCallbackException {
// TODO Auto-generated method stub

}
}
