package presentacion;

import aplicacion.POOng;

public class Hilo extends Thread {
	private Tablero tablero;
	private POOng juego;
	private int timerObjetivos=0;
	private int tiempoSorpresas=(int) Math.floor(Math.random()*(300-150+1)+150);
	private int timerSorpresas=0;
	
	public Hilo(Tablero tablero,POOng juego) {
		this.tablero=tablero;
		this.juego=juego;
	}
	
	@Override
	public void run() {
		while(juego.getEnJuego() && juego.hayFortaleza() && juego.revisionPuntaje()) {
			try {
				sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!juego.getEnPausa()) {
				juego.mover();
				this.actualizarPuntaje();
				this.actualizarPelota();
				this.actualizarJugadores();
				this.actualizarFortaleza();
				this.actualizarColisiones();
				this.actualizarObjetivos();
				this.actualizarSorpresa();
				this.actualizarBloques();
				this.tiempoSorpresas();
				tablero.repaint();
				timerObjetivos++;
				timerSorpresas++;
			}
		}
	}
	
	public void actualizarObjetivos() {
		if(timerObjetivos==200){
			if(juego.getHayObjetivos()) {
				juego.quitarObjetivos();
				tablero.setObjetivos(false);
				timerObjetivos=0;
			}else {
				juego.setObjetivos();
				tablero.setObjetivos(true);
				tablero.setPosicionObjetivoSuperior(juego.getXObjetivoSuperior(), juego.getYObjetivoSuperior());
				tablero.setPosicionObjetivoInferior(juego.getXObjetivoInferior(), juego.getYObjetivoInferior());
				timerObjetivos=0;
			}	
		}
	}
	
	public void tiempoSorpresas() {
		if(timerSorpresas==tiempoSorpresas) {
			if(juego.getHaySorpresas()) {
				juego.quitarSorpresas();
				tablero.setSorpresas(false);
				timerSorpresas=0;
				tiempoSorpresas=(int) Math.floor(Math.random()*(300-150+1)+150);
			}else {
				juego.setSorpresas();
				tablero.setSorpresas(true);
				tablero.setPosicionSorpresa(juego.getXSorpresa(),juego.getYSorpresa());
				timerSorpresas=0;
			}
		}
	}
	
	public void actualizarSorpresa() {
		if(juego.getHaySorpresas()) {
			juego.evaluarSorpresa();
		}else {
			tablero.setSorpresas(false);
		}
	}
	
	public void actualizarBloques() {
		if(juego.getHayBloqueSuperior()) {
			tablero.setBloqueSuperior(true);
			tablero.setPosicionBloqueSuperior(juego.getXBloqueSuperior(), juego.getYBloqueSuperior());
		}else {
			tablero.setBloqueSuperior(false);
		}
		if(juego.getHayBloqueInferior()){
			tablero.setBloqueInferior(true);
			tablero.setPosicionBloqueInferior(juego.getXBloqueInferior(), juego.getYBloqueInferior());
		}else {
			tablero.setBloqueInferior(false);
		}
		
	}
	
	public void actualizarJugadores() {
		tablero.setPosicionP1(juego.getJugador1X(), juego.getJugador1Y());
		tablero.setPosicionP2(juego.getJugador2X(), juego.getJugador2Y());
	}
	
	public void actualizarPelota() {
		tablero.setPosicionPelota(juego.getPelotaX(), juego.getPelotaY());
	}
	
	public void actualizarPuntaje() {
		tablero.setPuntaje(juego.getPuntaje1(), juego.getPuntaje2());
	}
	
	public void actualizarFortaleza() {
		tablero.setFortaleza(juego.getFortaleza1(), juego.getFortaleza2());
	}
	
	public void actualizarColisiones() {
		tablero.setColisiones(juego.colisionR1(), juego.colisionR2());
	}
}