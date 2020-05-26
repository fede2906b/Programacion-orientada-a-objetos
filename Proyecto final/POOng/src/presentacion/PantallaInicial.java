package presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class PantallaInicial extends JPanel{
	private Image fondoActual;
	protected JButton jugadorCjugador,jugadorCmaquina,maquinaCmaquina;
	protected JButton aspecto1,aspecto2,pelota,volver,jugar=new JButton(),puntos;
	protected JButton ironMan,freddyKrueger,coraje,volver2;
	protected JButton lenta,rapida,incremental,volver3;
	public static final String pantallaDeInicio="rsc/fondo.png";
	public static final String pantalla2Jugadores="rsc/fondo2jugadores.png";
	public static final String pantallaSeleccionPersonaje="rsc/selecciondepersonaje.png";
	public static final String pantallaSeleccionPelota="rsc/selecciondepelota.png";
	protected static HashMap<String,String> personajesSeleccionados;
	protected static String pelotaSeleccionada;
	protected static String modoDeJuego;
	protected int puntaje=10;
	
	public PantallaInicial()  {
		super(null);
		personajesSeleccionados=new HashMap<String,String>();
		personajesSeleccionados.put("j1",null);
		personajesSeleccionados.put("j2",null);
		pelotaSeleccionada=null;
		prepareElementosInicio();
		prepareAccionesInicio();
	}
	
	public void paintBorder(Graphics g) {
		super.paintComponents(g);
		g.drawImage(fondoActual,0,0,getSize().width, getSize().height,null);
		paintComponents(g);
	}
	
	private void setFondo(String archivo) {
		try {
			fondoActual = new ImageIcon(archivo).getImage();
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	public void prepareElementosInicio(){
		removeAll();
		setFondo(pantallaDeInicio);	
		jugadorCjugador=new JButton();
		jugadorCjugador.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jugadorCjugador.setBounds(30, 500, 160, 60);
		ImageIcon icono=new ImageIcon("rsc/2jugadores.png");
		jugadorCjugador.setIcon(icono);
		jugadorCmaquina=new JButton();
		jugadorCmaquina.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jugadorCmaquina.setBounds(220, 500, 160, 60);
		icono=new ImageIcon("rsc/1jugador.png");
		jugadorCmaquina.setIcon(icono);
		maquinaCmaquina=new JButton();
		maquinaCmaquina.setCursor(new Cursor(Cursor.HAND_CURSOR));
		maquinaCmaquina.setBounds(410, 500, 160, 60);
		icono=new ImageIcon("rsc/cpuvscpu.png");
		maquinaCmaquina.setIcon(icono);
		add(jugadorCjugador);
		add(jugadorCmaquina);
		add(maquinaCmaquina);
		repaint();
	}
	
	public void prepareAccionesInicio() {
		jugadorCjugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				modoDeJuego="2Jugadores";
				prepareElementos2Jugadores();
				prepareAcciones2Jugadores();
				repaint();
			}
		});
		jugadorCmaquina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
			}
		});
		maquinaCmaquina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
			}
		});
	}
	
	public void prepareElementos2Jugadores() {
		removeAll();
		setFondo(pantalla2Jugadores);	
		aspecto1=new JButton();
		aspecto1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		aspecto1.setBounds(250, 240, 100, 100);
		imagenBoton(aspecto1,new ImageIcon("rsc/seleccionarpersonaje1.png"));
		aspecto2=new JButton();
		aspecto2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		aspecto2.setBounds(250, 390, 100, 100);
		imagenBoton(aspecto2,new ImageIcon("rsc/seleccionarpersonaje2.png"));
		pelota=new JButton();
		pelota.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pelota.setBounds(250, 540, 100, 100);
		imagenBoton(pelota,new ImageIcon("rsc/seleccionarpelota.png"));
		volver=new JButton();
		volver.setCursor(new Cursor(Cursor.HAND_CURSOR));
		volver.setBounds(0, 0, 50, 50);
		imagenBoton(volver,new ImageIcon("rsc/volver.png"));
		jugar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jugar.setBounds(475, 580, 100, 50);
		imagenBoton(jugar,new ImageIcon("rsc/botonjugar.png"));
		puntos=new JButton();
		puntos.setCursor(new Cursor(Cursor.HAND_CURSOR));
		puntos.setBounds(494, 0, 100, 50);
		imagenBoton(puntos,new ImageIcon("rsc/botonpuntos.png"));
		add(aspecto1);
		add(aspecto2);
		add(pelota);
		add(volver);
		add(jugar);
		add(puntos);
		repaint();
	}
	
	public void prepareAcciones2Jugadores() {
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				regresar();
			}
		});
		
		aspecto1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				prepareElementosSeleccionarPersonaje();
				prepareAccionesSeleccionarPersonaje1();
				repaint();
			}
		});
		
		aspecto2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				prepareElementosSeleccionarPersonaje();
				prepareAccionesSeleccionarPersonaje2();
				repaint();
			}
		});
		
		pelota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				prepareElementosSeleccionarPelota();
				prepareAccionesSeleccionarPelota();
				repaint();
			}
		});
		
		puntos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				puntaje=Integer.parseInt(JOptionPane.showInputDialog("¿A cuantos puntos desea jugar?"));
			}
		});
	}
	
	public void prepareElementosSeleccionarPersonaje() {
		removeAll();
		setFondo(pantallaSeleccionPersonaje);
		ironMan=new JButton();
		ironMan.setCursor(new Cursor(Cursor.HAND_CURSOR));
		ironMan.setBounds(310, 215, 250, 100);
		imagenBotonPersonaje(ironMan,"ironman");
		freddyKrueger=new JButton();
		freddyKrueger.setCursor(new Cursor(Cursor.HAND_CURSOR));
		freddyKrueger.setBounds(310, 362, 250, 100);
		imagenBotonPersonaje(freddyKrueger,"freddy");
		coraje=new JButton();
		coraje.setCursor(new Cursor(Cursor.HAND_CURSOR));
		coraje.setBounds(310, 510, 250, 100);
		imagenBotonPersonaje(coraje,"coraje");
		volver2=new JButton();
		volver2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		volver2.setBounds(0, 0, 50, 50);
		imagenBoton(volver2,new ImageIcon("rsc/volver.png"));
		add(ironMan);
		add(freddyKrueger);
		add(coraje);
		add(volver2);
		repaint();
	}
	
	public void prepareAccionesSeleccionarPersonaje1() {
		volver2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				prepareElementos2Jugadores();
				prepareAcciones2Jugadores();
				repaint();
			}
		});		
		ironMan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(personajesSeleccionados.get("j1")=="ironman" || personajesSeleccionados.get("j2")=="ironman") {
					JOptionPane.showMessageDialog(null, "Ya está seleccionado");
				}else {
					personajesSeleccionados.replace("j1","ironman");
					prepareElementos2Jugadores();
					prepareAcciones2Jugadores();
					repaint();
				}
			}
		});		
		freddyKrueger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(personajesSeleccionados.get("j1")=="freddy" || personajesSeleccionados.get("j2")=="freddy") {
					JOptionPane.showMessageDialog(null, "Ya está seleccionado");
				}else {
					personajesSeleccionados.replace("j1","freddy");
					prepareElementos2Jugadores();
					prepareAcciones2Jugadores();
					repaint();
				}
			}
		});	
		coraje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(personajesSeleccionados.get("j1")=="coraje" || personajesSeleccionados.get("j2")=="coraje") {
					JOptionPane.showMessageDialog(null, "Ya está seleccionado");
				}else {
					personajesSeleccionados.replace("j1","coraje");
					prepareElementos2Jugadores();
					prepareAcciones2Jugadores();
					repaint();
				}
			}
		});
	}
	
	public void prepareAccionesSeleccionarPersonaje2() {
		volver2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				prepareElementos2Jugadores();
				prepareAcciones2Jugadores();
				repaint();
			}
		});
		ironMan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(personajesSeleccionados.get("j1")=="ironman" || personajesSeleccionados.get("j2")=="ironman") {
					JOptionPane.showMessageDialog(null, "Ya está seleccionado");
				}else {
					personajesSeleccionados.replace("j2","ironman");
					prepareElementos2Jugadores();
					prepareAcciones2Jugadores();
					repaint();
				}
			}
		});
		freddyKrueger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(personajesSeleccionados.get("j1")=="freddy" || personajesSeleccionados.get("j2")=="freddy") {
					JOptionPane.showMessageDialog(null, "Ya está seleccionado");
				}else {
					personajesSeleccionados.replace("j2","freddy");
					prepareElementos2Jugadores();
					prepareAcciones2Jugadores();
					repaint();
				}
			}
		});
		coraje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(personajesSeleccionados.get("j1")=="coraje" || personajesSeleccionados.get("j2")=="coraje") {
					JOptionPane.showMessageDialog(null, "Ya está seleccionado");
				}else {
					personajesSeleccionados.replace("j2","coraje");
					prepareElementos2Jugadores();
					prepareAcciones2Jugadores();
					repaint();
				}
			}
		});
	}
	
	public void prepareElementosSeleccionarPelota() {
		removeAll();
		setFondo(pantallaSeleccionPelota);
		lenta=new JButton();
		lenta.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lenta.setBounds(400, 250, 100, 100);
		imagenBotonPelota(lenta,"lenta");
		rapida=new JButton();
		rapida.setCursor(new Cursor(Cursor.HAND_CURSOR));
		rapida.setBounds(400, 380, 100, 100);
		imagenBotonPelota(rapida,"rapida");
		incremental=new JButton();
		incremental.setCursor(new Cursor(Cursor.HAND_CURSOR));
		incremental.setBounds(400, 510, 100, 100);
		imagenBotonPelota(incremental,"incremental");
		volver3=new JButton();
		volver3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		volver3.setBounds(0, 0, 50, 50);
		imagenBoton(volver3,new ImageIcon("rsc/volver.png"));
		add(lenta);
		add(rapida);
		add(incremental);
		add(volver3);
		repaint();
	}
	
	public void prepareAccionesSeleccionarPelota() {
		volver3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				prepareElementos2Jugadores();
				prepareAcciones2Jugadores();
				repaint();
			}
		});
		
		lenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(pelotaSeleccionada=="lenta") {
					JOptionPane.showMessageDialog(null, "Ya está seleccionado");
				}else {
					pelotaSeleccionada="lenta";
					prepareElementos2Jugadores();
					prepareAcciones2Jugadores();
					repaint();
				}
			}
		});
		
		rapida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(pelotaSeleccionada=="rapida") {
					JOptionPane.showMessageDialog(null, "Ya está seleccionado");
				}else {
					pelotaSeleccionada="rapida";
					prepareElementos2Jugadores();
					prepareAcciones2Jugadores();
					repaint();
				}
			}
		});
		
		incremental.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(pelotaSeleccionada=="incremental") {
					JOptionPane.showMessageDialog(null, "Ya está seleccionado");
				}else {
					pelotaSeleccionada="incremental";
					prepareElementos2Jugadores();
					prepareAcciones2Jugadores();
					repaint();
				}
			}
		});
	}
	
	public void imagenBoton(JButton boton,ImageIcon icono) {
		boton.setIcon(icono);
	}
	
	public void imagenBotonPersonaje(JButton boton,String nombre) {
		if(personajesSeleccionados.get("j1")==nombre || personajesSeleccionados.get("j2")==nombre) {
			ImageIcon icono=new ImageIcon("rsc/boton"+nombre+"bn.png");
			boton.setIcon(icono);
		}else {
			ImageIcon icono=new ImageIcon("rsc/boton"+nombre+".png");
			boton.setIcon(icono);
		}
	}
	
	public void imagenBotonPelota(JButton boton,String nombre) {
		if(pelotaSeleccionada==nombre) {
			ImageIcon icono=new ImageIcon("rsc/pelota"+nombre+"bn.png");
			boton.setIcon(icono);
		}else {
			ImageIcon icono=new ImageIcon("rsc/pelota"+nombre+".png");
			boton.setIcon(icono);
		}
	}
	
	public void regresar() {
		int resp=JOptionPane.showConfirmDialog(this,"¿Estas seguro de que deseas volver?(Se perderá toda la configuración.)"
				,"Volver",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if(resp==JOptionPane.YES_OPTION){
			personajesSeleccionados.replace("j1",null);
			personajesSeleccionados.replace("j2",null);
			pelotaSeleccionada=null;
			prepareElementosInicio();
			prepareAccionesInicio();
			repaint();
		}
	}
	
	public String getPersonaje1() {
		return personajesSeleccionados.get("j1");
	}
	
	public String getPersonaje2() {
		return personajesSeleccionados.get("j2");
	}
	
	public String getPelota() {
		return pelotaSeleccionada;
	}
	
	public String getModoDeJuego() {
		return modoDeJuego;
	}
}