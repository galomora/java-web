package ec.casabaca.interceptor;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@LoggingInterceptorBinding
@Interceptor
public class LoggingInterceptor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@AroundInvoke
	public Object log(InvocationContext context) throws Exception {
		System.out.println("Se esta ejecutando " + context.getMethod().getName());
		return context.proceed();
	}

}
