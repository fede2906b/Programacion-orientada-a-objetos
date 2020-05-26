package presentacion;

import aplicacion.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class Tablero extends JPanel {
	private Image fondoActual;
	private Image personaje1A,personaje1B;
	private Image personaje2A,personaje2B;
	private Image pelotaJuego;
	private Image icono1,icono2;
	private Image target=new ImageIcon("rsc/target.png").getImage();
	public static final String pelota="rsc/pelotaJuego.png";
	public static final String fondo="rsc/cancha.png";
	private int xPelota,yPelota;
	private int xP1,yP1;
	private int xP2,yP2;
	private int puntaje1,puntaje2;
	private int fortaleza1,fortaleza2;
	private boolean colision1,colision2;
	private int xOSuperior,yOSuperior;
	private int xOInferior,yOInferior;
	private int xSorpresa,ySorpresa;
	private int xBSuperior,yBSuperior;
	private int xBInferior,yBInferior;
	private boolean hayObjetivos=false;
	private boolean haySorpresa=false;
	private boolean hayBloqueSuperior=false;
	private boolean hayBloqueInferior=false;
	
	public Tablero() {
		setFondo(fondo);
		setPelota(pelota);
	}
	
	private void setFondo(String archivo) {
		try {
			fondoActual = new ImageIcon(archivo).getImage();
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	private void setPelota(String archivo) {
		try {
			pelotaJuego = new ImageIcon(archivo).getImage();
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	public void setPersonajes(String p1,String p2) {
		try {
			setIconos(p1,p2);
			personaje1A = new ImageIcon("rsc/"+p1+"1.png").getImage();
			personaje2A = new ImageIcon("rsc/"+p2+"1espalda.png").getImage();
			personaje1B = new ImageIcon("rsc/"+p1+"2.png").getImage();
			personaje2B = new ImageIcon("rsc/"+p2+"2espalda.png").getImage();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void setIconos(String p1,String p2) {
		try {
			icono1 = new ImageIcon("rsc/"+p1+"1.png").getImage();
			icono2 = new ImageIcon("rsc/"+p2+"1.png").getImage();
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	public void setPosicionP1(int x,int y){
		this.xP1=x;
		this.yP1=y;
	}
	
	public void setPosicionP2(int x,int y){
		this.xP2=x;
		this.yP2=y;
	}

	public void setPosicionPelota(int x,int y) {
		this.xPelota=x;
		this.yPelota=y;
	}
	
	public void setPuntaje(int p1,int p2) {
		this.puntaje1=p1;
		this.puntaje2=p2;
	}
	
	public void setFortaleza(int f1,int f2) {
		this.fortaleza1=f1;
		this.fortaleza2=f2;
	}
	
	public void setColisiones(boolean c1,boolean c2) {
		this.colision1=c1;
		this.colision2=c2;
	}
	
	public void setPosicionObjetivoSuperior(int x,int y) {
		this.xOSuperior=x;
		this.yOSuperior=y;
	}
	
	public void setPosicionObjetivoInferior(int x,int y) {
		this.xOInferior=x;
		this.yOInferior=y;
	}
	
	public void setPosicionBloqueSuperior(int x,int y) {
		this.xBSuperior=x;
		this.yBSuperior=y;
	}
	
	public void setPosicionBloqueInferior(int x,int y) {
		this.xBInferior=x;
		this.yBInferior=y;
	}
	
	public void setPosicionSorpresa(int x,int y) {
		this.xSorpresa=x;
		this.ySorpresa=y;
	}

	public void setBloqueSuperior(boolean b) {
		this.hayBloqueSuperior=b;
	}
	
	public void setBloqueInferior(boolean b) {
		this.hayBloqueInferior=b;
	}
	
	public void setObjetivos(boolean o) {
		this.hayObjetivos=o;
	}
	
	public void setSorpresas(boolean s) {
		this.haySorpresa=s;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2=(Graphics2D)g;
		g2.drawImage(fondoActual,0,0,getSize().width, getSize().height,null);
		dibujarObjetivos(g2);
		dibujarSorpresa(g2);
		dibujarPersonaje1(g2);
		dibujarBloques(g2);
		g2.drawImage(pelotaJuego,xPelota,yPelota,20,20,null);	
		dibujarPersonaje2(g2);
		dibujarPuntaje(g2);
		dibujarFortaleza1(g2);
		dibujarFortaleza2(g2);
	}
	
	public void dibujarPelota(Graphics2D g) {
		g.drawImage(pelotaJuego,xPelota,yPelota,20,20,null);
	}
	
	public void dibujarPuntaje(Graphics2D g) {
		g.drawImage(icono1,5,5,25,25,null);
		g.drawImage(icono2,564,5,25,25,null);
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Verdana", Font.BOLD, 30));
		g.drawString(String.valueOf(puntaje1), 35, 30);
		g.drawString(String.valueOf(puntaje2), 539, 30);
	}
	
	public void dibujarFortaleza1(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fill3DRect(5,40,100,10,true);
		if(fortaleza1>750) {
			g.setColor(Color.GREEN);
			g.fill3DRect(5,40,(int)fortaleza1/10,10,true);
		}else if(fortaleza1<750 && fortaleza1>500) {
			g.setColor(Color.ORANGE);
			g.fill3DRect(5,40,(int)fortaleza1/10,10,true);
		}else {
			g.setColor(Color.RED);
			g.fill3DRect(5,40,(int)fortaleza1/10,10,true);
		}
	}
	
	public void dibujarFortaleza2(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fill3DRect(489,40,100,10,true);
		if(fortaleza2>750) {
			g.setColor(Color.GREEN);
			g.fill3DRect(489+100-(int)fortaleza2/10,40,(int)fortaleza2/10,10,true);
		}else if(fortaleza2<750 && fortaleza2>500) {
			g.setColor(Color.ORANGE);
			g.fill3DRect(489+100-(int)fortaleza2/10,40,(int)fortaleza2/10,10,true);
		}else {
			g.setColor(Color.RED);
			g.fill3DRect(489+100-(int)fortaleza2/10,40,(int)fortaleza2/10,10,true);
		}
	}
	
	public void dibujarPersonaje1(Graphics2D g) {
		if(colision1) {
			g.drawImage(personaje1B,xP1,yP1,70,70,null);
		}else {
			g.drawImage(personaje1A,xP1,yP1,70,70,null);
		}
	}
	
	public void dibujarPersonaje2(Graphics2D g) {
		if(colision2) {
			g.drawImage(personaje2B,xP2,yP2,70,70,null);
		}else {
			g.drawImage(personaje2A,xP2,yP2,70,70,null);
		}
	}
	
	public void dibujarObjetivos(Graphics2D g) {
		if(this.hayObjetivos) {
			g.drawImage(target,xOSuperior,yOSuperior,30,30,null);
			g.drawImage(target,xOInferior,yOInferior,30,30,null);
		}
	}
	
	public void dibujarSorpresa(Graphics2D g) {
		if(this.haySorpresa) {
			g.drawImage(new ImageIcon("rsc/sorpresa.png").getImage(),xSorpresa,ySorpresa,30,30,null);
		}
	}
	
	public void dibujarBloques(Graphics2D g) {
		if(this.hayBloqueSuperior) {
			g.drawImage(new ImageIcon("rsc/muro.png").getImage(),xBSuperior,yBSuperior,70,70,null);
		}
		if(this.hayBloqueInferior) {
			g.drawImage(new ImageIcon("rsc/muro.png").getImage(),xBInferior,yBInferior,70,70,null);
		}
	}
}








