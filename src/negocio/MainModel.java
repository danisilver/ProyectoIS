package negocio;

import presentacion.Event;

public class MainModel implements Model {
	
	private String titulo = "pantalla principal";
	
	public Event changeTitleEvent = new Event();

	public String getTitle() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
		changeTitleEvent.notifyAllObservers();
	}

	@Override
	public boolean isValid() {
		return true;
	}
}
