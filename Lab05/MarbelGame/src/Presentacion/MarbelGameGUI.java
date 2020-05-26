package Presentacion;
import Aplicacion.*;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MarbelGameGUI extends JFrame{
	private JMenuBar barraDeMenu;
	private JMenu menu;
	private JMenuItem nuevo,abrir,guardar,guardarComo,salir,color1,color2;
	private JFileChooser elegirArchivo;
	private File archivoGuardado;
	private Marbel tablero;
	private JPanel controles;
	private JPanel ajustes;
	private JButton norte,sur,este,oeste;
	private JButton consultar,modificar;
	private JMenu colorMenu;
	private MarbelGame juego;
	
	public MarbelGameGUI(MarbelGame mg) {
		super("Marbel Game");
		elegirArchivo=new JFileChooser();
		juego=mg;
	}

	private void prepareElementos(){
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla = pantalla.getScreenSize();
		int alto=(int)tamanoPantalla.getHeight()/2;
		int ancho=(int)tamanoPantalla.getWidth()/2;
		setSize(ancho,alto);
		setLocation(ancho/2,alto/2);
		prepareElementosMenu();
		prepareElementosTablero();
		prepareElementosControles();
		prepareElementosAjustes();
    }

	private void prepareAcciones(){
		prepareAccionesMenu();
		prepareAccionesControles();
		prepareAccionesAjustes();
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				salir();
			}
		});
	}
	
	public void prepareElementosTablero() {
		refresque();
	}
	
	public void prepareElementosControles() {
		controles=new JPanel();
		controles.setBackground(Color.RED);
		norte=new JButton("Norte");
		controles.add(norte);
		sur=new JButton("Sur");
		controles.add(sur);	
		este=new JButton("Este");
		controles.add(este);
		oeste=new JButton("Oeste");
		controles.add(oeste);
		add(controles,BorderLayout.NORTH);
	}
	
	public void prepareElementosAjustes() {
		ajustes=new JPanel();
		ajustes.setBackground(Color.RED);
		consultar=new JButton("Consultar");
		ajustes.add(consultar);
		modificar=new JButton("Modificar");
		ajustes.add(modificar);	
		add(ajustes,BorderLayout.SOUTH);
	}
	
	public void prepareElementosMenu(){
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
		colorMenu=new JMenu("Color");
		color1=new JMenuItem("Color de fondo");
		color2=new JMenuItem("Color de celdas");
		colorMenu.add(color1);
		colorMenu.add(color2);
		barraDeMenu.add(colorMenu);
		setJMenuBar(barraDeMenu);
	}

	public void prepareAccionesControles() {
		norte.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				botonNorteAccion();
			}
		});
		sur.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				botonSurAccion();
			}
		});
		este.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				botonEsteAccion();
			}
		});
		oeste.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				botonOesteAccion();
			}
		});
	}
	
	public void botonNorteAccion() {
		juego.norte();
		tablero.repaint();
	}
	
	public void botonSurAccion() {
		juego.sur();
		tablero.repaint();
	}
	
	public void botonEsteAccion() {
		juego.este();
		tablero.repaint();
	}
	
	public void botonOesteAccion() {
		juego.oeste();
		tablero.repaint();
	}
	
	public void prepareAccionesAjustes() {
		consultar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				consultar();
			}
		});
		modificar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				modificar();
			}
		});
	}
	
	public void prepareAccionesMenu(){
		salir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				salir();
			}
		});
		guardar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		
		abrir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				abrir();
			}
		});
		
		color1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambioDeColor(true);
			}
		});
		
		color2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambioDeColor(false);
			}
		});
	}
	
	public void cambioDeColor(boolean celdaOFondo) {
		if(celdaOFondo) {
			Color temp=JColorChooser.showDialog(null,"Seleccione un color de fondo", Color.WHITE);
			tablero.setColor(temp);
		}else {
			Color temp=JColorChooser.showDialog(null,"Seleccione un color para las celdas", Color.WHITE);
			tablero.setColorCeldas(temp);
			tablero.repaint();
		}
	}
	
	public void modificar() {
		int tamano=Integer.parseInt(JOptionPane.showInputDialog("Escriba el nuevo tamaño"));
		int canicas=Integer.parseInt(JOptionPane.showInputDialog("Escriba el nuevo numero de canicas"));
		int barreras=Integer.parseInt(JOptionPane.showInputDialog("Escriba el nuevo numero de barreras"));
		juego.modificar(tamano,canicas,barreras);
		tablero.repaint();
	}
	
	public void consultar() {
		int[] temp=juego.consultar();
		JOptionPane.showMessageDialog(null,"Numero de movimientos: "+temp[0]+"\nCanicas bien ubicadas: "+temp[1]+"\nCanicas mal ubicadas: "+temp[2]);
	}
	
	public void salir(){
		int resp=JOptionPane.showConfirmDialog(this,"¿Esta seguro de que quiere cerrar la aplicacion?"
							,"Cerrar",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if(resp==JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}
	
	public void guardar() {
		elegirArchivo.showSaveDialog(this);
		archivoGuardado=elegirArchivo.getSelectedFile();
		JOptionPane.showMessageDialog(null,"Funcionalidad en construccion (Guardar).\nRuta del archivo: \n"+archivoGuardado.toString()+"\n"+
				"Nombre del archivo: \n"+elegirArchivo.getName(archivoGuardado));
	}
	
	public void abrir() {
		elegirArchivo.showOpenDialog(this);
		archivoGuardado=elegirArchivo.getSelectedFile();
		JOptionPane.showMessageDialog(null,"Funcionalidad en construccion (Abrir).\nRuta del archivo: \n"+archivoGuardado.toString()+"\n"+
				"Nombre del archivo: \n"+elegirArchivo.getName(archivoGuardado));
	}

	public void refresque() {
		tablero=new Marbel(juego);
		getContentPane().add(tablero,BorderLayout.CENTER);
		tablero.repaint();
	}
	
	public static void main(String[] args) {
		MarbelGame juego=new MarbelGame(4,3,1);
        MarbelGameGUI prueba=new MarbelGameGUI(juego);
		prueba.prepareElementos();
		prueba.prepareAcciones();
        prueba.setVisible(true);
    }
}

class Marbel extends JPanel{
    public static int TAMANO=40;
    private MarbelGame marbelGame;
    private Color colorCeldas;
    
    public Marbel(MarbelGame ac) {
        setBackground(Color.WHITE);
        colorCeldas=Color.BLACK;
        marbelGame=ac;
        setPreferredSize(new Dimension(384,683));   
    }
    
    public void setColor(Color color) {
    	setBackground(color);
    }
    
    public void setColorCeldas(Color color) {
    	colorCeldas=color;
    }
    
    public void setJuego(MarbelGame juego){
        this.marbelGame=juego;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(colorCeldas);
        for (int i=0;i<=marbelGame.getLongitud();i++){
            g.drawLine(i*TAMANO,0,i*TAMANO,marbelGame.getLongitud()*TAMANO);
            g.drawLine(0,i*TAMANO,marbelGame.getLongitud()*TAMANO,i*TAMANO);
        }	
        for (int i=0;i<marbelGame.getLongitud();i++){
            for(int j=0;j<marbelGame.getLongitud();j++){
            	if (marbelGame.getNumero(i,j)!=0 && marbelGame.getNumero(i,j)!=4){
            		g.setColor(marbelGame.getColor(i,j));
            		if (marbelGame.getNumero(i,j)==1){
            			g.fillOval(TAMANO*j+5,TAMANO*i+5,30,30);
            		}else if (marbelGame.getNumero(i,j)==2){
            			g.drawOval(TAMANO*j+5,TAMANO*i+5,30,30);
            		}else if (marbelGame.getNumero(i,j)==3) {
            			g.fillRect(TAMANO*j,TAMANO*i,TAMANO,TAMANO);
            		}
            	}else if (marbelGame.getNumero(i,j)==4) {
            		g.setColor(marbelGame.getColor(i,j));
            		g.drawOval(TAMANO*j+5,TAMANO*i+5,30,30);
            		g.setColor(marbelGame.getColor2(i,j));
            		g.fillOval(TAMANO*j+7,TAMANO*i+7,25,25);
            	}
            }
        }
        /*
        HACE EL TABLERO INICIAL PARA refresque()
        for (int i=0;i<=marbelGame.getLongitud();i++){
            g.drawLine(i*TAMANO,0,i*TAMANO,marbelGame.getLongitud()*TAMANO);
            g.drawLine(0,i*TAMANO,marbelGame.getLongitud()*TAMANO,i*TAMANO);
        }
        g.setColor(Color.ORANGE);
        g.fillOval(TAMANO*1+5,TAMANO*0+5,30,30);
        g.setColor(Color.BLUE);
        g.fillOval(TAMANO*0+5,TAMANO*1+5,30,30);
        g.setColor(Color.GREEN);
        g.fillOval(TAMANO*2+5,TAMANO*1+5,30,30);
        g.setColor(Color.ORANGE);
        g.drawOval(TAMANO*3+5,TAMANO*2+5,30,30);
        g.setColor(Color.BLUE);
        g.drawOval(TAMANO*0+5,TAMANO*2+5,30,30);
        g.setColor(Color.GREEN);
        g.drawOval(TAMANO*1+5,TAMANO*3+5,30,30);
        g.setColor(Color.BLACK);
        g.fillRect(TAMANO*1,TAMANO*1,TAMANO,TAMANO);*/
    }
}
