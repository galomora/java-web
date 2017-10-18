package ec.casabaca.contador.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.AccessTimeout;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.DependsOn;
import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
@DependsOn (value = "PrinterObserver")
@LocalBean
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@AccessTimeout(value=120000)
public class ContadorBean {
	private int cuenta;
	private String estado;
	
	@PostConstruct 
	public void inicializarContador () {
		cuenta = 0;
		estado = "ON";
	}

	@Lock (LockType.WRITE)
    public int getHits() {
    	cuenta++;
        return cuenta;
    }

	@Lock (LockType.READ)
	public String getEstado() {
		return estado;
	}

	@Lock (LockType.WRITE)
	public void cambiarEstado() {
		if ("ON".equals(estado)) {
			estado = "OFF";
		} else {
			estado = "ON";
		}
		
	}
	
}
