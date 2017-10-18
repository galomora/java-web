package ec.casabaca.asynchronous.ejb;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;

@Stateful
@LocalBean
public class AsincronicoBean {
	@Resource SessionContext sessionContext;
	@Asynchronous
	public Future<String> ejecucionAsincronica () throws InterruptedException {
		TimeUnit.SECONDS.sleep(30);
		if (sessionContext.wasCancelCalled()) {
			System.out.println("ejecucion cancelada");
			return new AsyncResult<String>("ejecucion cancelada");
		}
		return new AsyncResult<String>("ejecucion Exitosa");
	}
}
