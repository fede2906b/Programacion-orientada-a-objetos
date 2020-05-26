package presentacion;

import aplicacion.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class wimbledonGUI extends JFrame implements Runnable,KeyListener{
	private JMenuBar barraDeMenu;
	private JMenu menu;
	private JMenuItem nuevo,abrir,guardar,guardarComo,salir;
	private PantallaInicial inicio;
	private Tablero tablero;
	private POOng juego;
	private Hilo hilo;
	
	public wimbledonGUI() {
		super("Wimbledon");		
		prepareElementos();
		prepareAcciones();
	}
	
	public void prepareElementos() {
		prepareElementosFrame();	
		prepareElementosMenu();
		prepareElementosJuego();
		
	}
	
	public void prepareAcciones() {
		prepareAccionesFrame();
		prepareAccionesMenu();	
		prepareAccionesJuego();
	}
	
	public void prepareElementosFrame() {
		ImageIcon icono = new ImageIcon("rsc/logo.png");
		Image icon = icono.getImage();
		setIconImage(icon);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(this);
		setResizable(false);
		setFocusable(true);
		setSize(new Dimension(600, 700));
		setLocationRelativeTo(null);	
	}
	
	public void prepareAccionesFrame() {
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				salir();
			}
		});
	}
	
	public void prepareElementosMenu() {
		barraDeMenu=new JMenuBar();
		menu=new JMenu("Menú");
		nuevo=new JMenuItem("Nuevo");
		abrir=new JMenuItem("Abrir");
		guardar=new JMenuItem("Guardar");
		guardarComo=new JMenuItem("Guardar Como");
		salir=new JMenuItem("Salir");	
		menu.add(nuevo);
		menu.add(abrir);
		menu.add(guardar);
		menu.add(guardarComo);
		menu.add(salir);
		barraDeMenu.add(menu);
		setJMenuBar(barraDeMenu);
	}
	
	public void prepareAccionesMenu(){
		salir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				salir();
			}
		});
	}
	
	public void prepareElementosJuego() {
		inicio=new PantallaInicial();
		tablero=new Tablero();
		add(inicio);
		inicio.repaint();
	}
	
	
	public void prepareAccionesJuego() {
		inicio.jugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empezarJuego();
			}
		});
	}
	
	public void empezarJuego() {
		if(inicio.getPersonaje1()==null || inicio.getPersonaje2()==null || inicio.getPelota()==null) {	
			JOptionPane.showMessageDialog(null, "Aún no ha seleccionado todas las configuraciones.");
		}else {
			inicio.setVisible(false);
			remove(inicio);
			juego=new POOng(inicio.getPersonaje1(),inicio.getPersonaje2(),inicio.getModoDeJuego(),inicio.getPelota(),inicio.puntaje);
			movimiento();
			//tablero.setPosicionPelota(juego.getPelotaX(), juego.getPelotaY());
			tablero.setPersonajes(inicio.getPersonaje1(),inicio.getPersonaje2());
			add(tablero);
		}
	}
	
	public void salir(){
		int resp=JOptionPane.showConfirmDialog(this,"¿Esta seguro de que quiere cerrar la aplicacion?"
							,"Cerrar",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if(resp==JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}
	
	public void movimiento() {
		tablero.setPosicionP1(juego.getJugador1X(), juego.getJugador1Y());
		tablero.setPosicionP2(juego.getJugador2X(), juego.getJugador2Y());
	}
	
	public void reanudar() {
		if(juego.getEnPausa()) {
			juego.reanudar();
		}
	}
	
	public static void main(String[] args) {
		wimbledonGUI prueba=new wimbledonGUI();
		prueba.setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		if(juego!=null) {
			if(keyCode==KeyEvent.VK_RIGHT) {
				if(juego.getEnJuego()) {
					this.reanudar();
					juego.moverJugador2(true);
				}else {
					hilo=new Hilo(tablero,juego);
					hilo.start();
					juego.empezarJuego();
				}
			}
			if(keyCode==KeyEvent.VK_LEFT) {
				if(juego.getEnJuego()) {
					this.reanudar();
					juego.moverJugador2(false);
				}else {
					hilo=new Hilo(tablero,juego);
					hilo.start();
					juego.empezarJuego();
				}
			}
			if(keyCode==KeyEvent.VK_D) {
				if(juego.getEnJuego()) {
					this.reanudar();
					juego.moverJugador1(true);
				}else {
					hilo=new Hilo(tablero,juego);
					hilo.start();
					juego.empezarJuego();
				}
			}
			if(keyCode==KeyEvent.VK_A) {
				if(juego.getEnJuego()) {
					this.reanudar();
					juego.moverJugador1(false);
				}else {
					hilo=new Hilo(tablero,juego);
					hilo.start();
					juego.empezarJuego();
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	}
}
