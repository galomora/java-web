var wsocket;
  function connect() {
  	wsocket = new WebSocket("ws://localhost:8080/curso-inyeccion-cdi/notificacion");
  	wsocket.onmessage = onMessage;
  }
  function onMessage(evt) {
	  document.getElementById ("notificacion-form:notificacion-text").value = evt.data; 
  	PF ("notificacion").value = evt.data;
  }

  function enviarMensaje () {
	  window.alert ("va a enviar mensaje " + document.getElementById ("mensaje").value)
	  wsocket.send (document.getElementById ("mensaje").value);
  }
  
  window.addEventListener("load", connect, false);