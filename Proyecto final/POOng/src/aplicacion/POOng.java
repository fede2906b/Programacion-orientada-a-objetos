package aplicacion;

import java.awt.geom.Rectangle2D.Double;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class POOng {
	private Personaje jugador1,jugador2;
	private Pelota pelota;
	private int puntosJuego;
	private boolean enJuego;
	private boolean enPausa;
	private boolean gameOver;
	private boolean hayObjetivos;
	private boolean haySorpresas;
	private boolean hayBloqueSuperior;
	private boolean hayBloqueInferior;
	private int puntaje1,puntaje2;
	private Objetivo objetivoSuperior,objetivoInferior;
	private Bloque bloqueArriba,bloqueAbajo;
	private Sorpresa sorpresa;
	private POOng juego=null;
	
	public POOng(String personaje1,String personaje2,String modoDeJuego,String pelota,int puntos) {
		System.out.println(puntos);
		this.jugador1=new Personaje1(personaje1);
		this.jugador2=new Personaje2(personaje2);
		this.elegirPelota(pelota);
		this.enJuego=false;
		this.enPausa=true;
		this.gameOver=false;
		this.hayObjetivos=false;
		this.haySorpresas=false;
		this.hayBloqueSuperior=false;
		this.hayBloqueInferior=false;
		this.puntaje1=0;
		this.puntaje2=0;
		this.puntosJuego=puntos;
	}
	
	public void elegirPelota(String pelota) {
		if(pelota=="lenta") {
			this.pelota=new Lenta();
		}else if(pelota=="rapida") {
			this.pelota=new Rapida();
		}else if(pelota=="incremental") {
			this.pelota=new Incremental();
		}
	}
	
	public boolean revisionPuntaje() {
		return (puntaje1<puntosJuego)&&(puntaje2<puntosJuego);
	}
	
	public void empezarJuego() {
		this.enJuego=true;
		this.enPausa=false;
	}
	
	public void reanudar() {
		this.enPausa=false;
	}
	
	public void setJuego(POOng juego) {
		this.juego=juego;
	}
	
	public POOng getJuego() {
		return this.juego;
	}
	
	public boolean getEnJuego() {
		return this.enJuego;
	}
	
	public boolean getEnPausa() {
		return this.enPausa;
	}
	
	public Pelota getPelota() {
		return pelota;
	}
	
	public void mover() {
		if(pelota.getSalioArriba() || pelota.getSalioAbajo() || 
				pelota.getTomoObjetivo1() || pelota.getTomoObjetivo2()) {
			verPunto();
			nuevoPunto();
			this.enPausa=true;
		}else {
			pelota.mover(colisionR1(), colisionR2(), colisionObjetivoSuperior(), 
					colisionObjetivoInferior(), colisionSorpresa());
		}
	}
	
	public void verPunto() {
		if(pelota.getSalioArriba()) {
			this.puntaje2++;
		}else if(pelota.getSalioAbajo()) {
			this.puntaje1++;
		}else if(pelota.getTomoObjetivo1()) {
			this.puntaje2=this.puntaje2+(int) Math.floor(Math.random()*((puntosJuego/2)-2+1)+2);
		}else if(pelota.getTomoObjetivo2()) {
			this.puntaje1=this.puntaje1+(int) Math.floor(Math.random()*((puntosJuego/2)-2+1)+2);
		}
	}
	
	public void nuevoPunto() {
		this.pelota.nuevaPelota();
		this.jugador1.reiniciar();
		this.jugador2.reiniciar();
	}
	
	public void moverJugador2(boolean rigth) {
		if(rigth) {
			jugador1.moverDerecha();
			if(colisionBloqueSuperior()) {
				jugador1.perderFortaleza();
				this.quitarBloqueSuperior();
			}
		}else {
			jugador1.moverIzquirda();
			if(colisionBloqueSuperior()) {
				jugador1.perderFortaleza();
				this.quitarBloqueSuperior();
			}
		}
	}
	
	public void moverJugador1(boolean rigth) {
		if(rigth) {
			jugador2.moverDerecha();
			if(colisionBloqueInferior()) {
				jugador2.perderFortaleza();
				this.quitarBloqueInferior();
			}
		}else {
			jugador2.moverIzquirda();
			if(colisionBloqueInferior()) {
				jugador2.perderFortaleza();
				this.quitarBloqueInferior();
			}
		}
	}
	
	public void setObjetivos() {
		this.hayObjetivos=true;
		this.objetivoSuperior=new Objetivo(75);
		this.objetivoInferior=new Objetivo(580);
	}
	
	public void quitarObjetivos() {
		this.hayObjetivos=false;
		this.objetivoSuperior=null;
		this.objetivoInferior=null;
	}
	
	public void setSorpresas() {
		this.haySorpresas=true;
		this.sorpresa=elegirSorpresa((int) Math.floor(Math.random()*(2-1+1)+1));
	}
	
	public void quitarSorpresas() {
		this.haySorpresas=false;
		this.sorpresa=null;
	}
	
	public void setBloqueSuperior() {
		this.hayBloqueSuperior=true;
		this.bloqueArriba=new Bloque(60);
	}
	
	public void setBloqueInferior() {
		this.hayBloqueInferior=true;
		this.bloqueAbajo=new Bloque(533);
	}
	
	public void quitarBloqueSuperior() {
		this.hayBloqueSuperior=false;
		this.bloqueArriba=null;
	}
	
	public void quitarBloqueInferior() {
		this.hayBloqueInferior=false;
		this.bloqueAbajo=null;
	}
	
	public Sorpresa elegirSorpresa(int sorpresa) {
		if(sorpresa==1) {
			Sorpresa s=new Turtle();
			return s;
		}else if(sorpresa==2) {
			Sorpresa s=new Energy();
			return s;
		}
		return new Energy();
	}
	
	public boolean getHayObjetivos() {
		return this.hayObjetivos;
	}
	
	public boolean getHaySorpresas() {
		return this.haySorpresas;
	}
	
	public boolean getHayBloqueSuperior() {
		return this.hayBloqueSuperior;
	}
	
	public boolean getHayBloqueInferior() {
		return this.hayBloqueInferior;
	}
	
	public int getJugador1X() {
		return this.jugador1.getX();
	}
	
	public int getJugador1Y() {
		return this.jugador1.getY();
	}
	
	public int getJugador2X() {
		return this.jugador2.getX();
	}
	
	public int getJugador2Y() {
		return this.jugador2.getY();
	}
	
	public int getPelotaX() {
		return pelota.getX();
	}
	
	public int getPelotaY() {
		return pelota.getY();
	}
	
	public int getPuntaje1() {
		return puntaje1;
	}
	
	public int getPuntaje2() {
		return puntaje2;
	}
	
	public int getFortaleza1() {
		return jugador1.getFortaleza();
	}
	
	public int getFortaleza2() {
		return jugador2.getFortaleza();
	}
	
	public int getXObjetivoSuperior() {
		return objetivoSuperior.getX();
	}
	
	public int getYObjetivoSuperior() {
		return objetivoSuperior.getY();
	}
	
	public int getXObjetivoInferior() {
		return objetivoInferior.getX();
	}
	
	public int getYObjetivoInferior() {
		return objetivoInferior.getY();
	}
	
	public int getXBloqueSuperior() {
		return bloqueArriba.getX();
	}
	
	public int getYBloqueSuperior() {
		return bloqueArriba.getY();
	}
	
	public int getXBloqueInferior() {
		return bloqueAbajo.getX();
	}
	
	public int getYBloqueInferior() {
		return bloqueAbajo.getY();
	}
	
	public int getXSorpresa() {
		return sorpresa.getX();
	}
	
	public int getYSorpresa() {
		return sorpresa.getY();
	}
	
	public boolean hayFortaleza() {
		return (jugador1.getFortaleza()>500 && jugador2.getFortaleza()>500);
	}
	
	public boolean colisionR1() {
		Double j=jugador1.cuadradoPersonaje();
		Double p=pelota.cuadradoPelota();
		return j.intersects(p);
	}
	
	public boolean colisionR2() {
		Double j=jugador2.cuadradoPersonaje();
		Double p=pelota.cuadradoPelota();
		return j.intersects(p);
	}
	
	public boolean colisionObjetivoSuperior() {
		if(hayObjetivos) {
			Double o=objetivoSuperior.cuadradoObjetivo();
			Double p=pelota.cuadradoPelota();
			return o.intersects(p);
		}else {
			return false;
		}
	}
	
	public boolean colisionObjetivoInferior() {
		if(hayObjetivos) {
			Double o=objetivoInferior.cuadradoObjetivo();
			Double p=pelota.cuadradoPelota();
			return o.intersects(p);
		}else {
			return false;
		}
	}
	
	public boolean colisionSorpresa() {
		if(haySorpresas) {
			Double s=sorpresa.cuadradoSorpresa();
			Double p=pelota.cuadradoPelota();
			return s.intersects(p);
		}else {
			return false;
		}
	}
	
	public boolean colisionBloqueSuperior() {
		if(this.hayBloqueSuperior) {
			Double s=bloqueArriba.cuadradoBloque();
			Double j=jugador1.cuadradoPersonaje();
			return s.intersects(j);
		}else {
			return false;
		}
	}
	
	public boolean colisionBloqueInferior() {
		if(this.hayBloqueInferior) {
			Double s=bloqueAbajo.cuadradoBloque();
			Double j=jugador2.cuadradoPersonaje();
			return s.intersects(j);
		}else {
			return false;
		}
	}
	
	public boolean gameOver() {
		return this.gameOver;
	}
	
	public void evaluarSorpresa() {
		if(this.haySorpresas) {
			if(this.colisionSorpresa()){
				if(pelota.getUltimoJugador()) {
					this.sorpresa.aplicarSorpresa(this.jugador1,this.jugador2,this.pelota);
					this.setBloqueInferior();
				}else{
					this.sorpresa.aplicarSorpresa(this.jugador2,this.jugador1,this.pelota);
					this.setBloqueSuperior();
				}
				this.quitarSorpresas();
			}
		}
	}
	
	public void salvar (File archivo) throws POOngException {
		if (enJuego==false) {
			throw new POOngException (POOngException.SIN_JUEGO);
		}
		try{
			ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream(archivo));
			out.writeObject(this);
			out.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void abra(File archivo) throws POOngException {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
			//setJuego((POONg)ois.readObject() );
		} catch (Exception e) {
			throw new POOngException (POOngException.ERROR_ABRIR);
		}
	}
}