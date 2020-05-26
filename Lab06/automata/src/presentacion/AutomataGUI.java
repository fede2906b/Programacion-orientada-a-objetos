package presentacion;
import aplicacion.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AutomataGUI extends JFrame{	
    private JButton botonReloj;
    private JLabel lFila;
    private JLabel lColumna;
    private JTextField tFila;
    private JTextField tColumna;
    private JPanel panelControl;
    private JPanel panelNueva;
    private JPanel panelBNueva;
    private JButton botonViva;
    private JButton botonLatente;
    private JMenuBar barraDeMenu;
	private JMenu menu;
	private JMenuItem reiniciar,abrir,salvar,importar,exportar,salir;

    private FotoAutomata foto;
    private AutomataCelular automata=null;

    public AutomataGUI(AutomataCelular ac) {
        super("Automata celular");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        automata=ac;
        foto=new FotoAutomata(automata);
        setSize(new Dimension(802,870)); 
        prepareElementos();
        prepareAcciones();

    }

    private void prepareElementos() {
        setResizable(false);
        setFocusable(true);
        botonReloj=new JButton("Tic-tac");
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(foto,BorderLayout.NORTH);
        getContentPane().add(botonReloj,BorderLayout.SOUTH);
        prepareElementosMenu();
        foto.repaint();
    }

    private void prepareAcciones(){
    	prepareAccionesMenu();
        botonReloj.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    botonRelojAccion();
                }
            });

    }
    
    public void prepareElementosMenu() {
		barraDeMenu=new JMenuBar();
		menu=new JMenu("Menú");
		reiniciar=new JMenuItem("Reiniciar");
		abrir=new JMenuItem("Abrir");
		salvar=new JMenuItem("Salvar");
		importar=new JMenuItem("Importar");
		exportar=new JMenuItem("Exportar");
		salir=new JMenuItem("Salir");	
		menu.add(reiniciar);
		menu.add(abrir);
		menu.add(salvar);
		menu.add(importar);
		menu.add(exportar);
		menu.add(salir);
		barraDeMenu.add(menu);
		setJMenuBar(barraDeMenu);
	}
	
	public void prepareAccionesMenu(){
		salir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		abrir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				opcionAbrir();
			}
		});
		salvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				opcionSalvar();
			}
		});
		importar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				opcionImportar();
			}
		});
		exportar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				opcionExportar();
			}
		});
	}

	public void opcionSalvar() {
		try {
			automata.salve();
		} catch (AutomataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void opcionAbrir() {
		try {
			automata.abra();
		} catch (AutomataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void opcionExportar() {
		try {
			automata.exporte();
		} catch (AutomataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void opcionImportar() {
		try {
			automata.salve();
		} catch (AutomataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    private void botonRelojAccion() {
        automata.ticTac();
        foto.repaint();
    }

    public static void main(String[] args) {
        AutomataCelular ac=new AutomataCelular();
        AutomataGUI ca=new AutomataGUI(ac);
        ca.setVisible(true);

    }  
}

class FotoAutomata extends JPanel{
    public static int TAMANO=40;
    private AutomataCelular automata;

    public FotoAutomata(AutomataCelular ac) {
        setBackground(Color.white);
        automata=ac;
        setPreferredSize(new Dimension(800,800)); 		

    }

    public void setAutomata(AutomataCelular automata){
        this.automata=automata;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        for (int f=0;f<=automata.getLongitud();f++){
            g.drawLine(f*TAMANO,0,f*TAMANO,automata.getLongitud()*TAMANO);
        }
        for (int c=0;c<=automata.getLongitud();c++){
            g.drawLine(0,c*TAMANO,automata.getLongitud()*TAMANO,c*TAMANO);
        }		
        for (int f=0;f<automata.getLongitud();f++){
            for(int c=0;c<automata.getLongitud();c++){
                if (automata.getElemento(f,c)!=null){
                    g.setColor(automata.getElemento(f,c).getColor());
                    if (automata.getElemento(f,c).getForma()==Elemento.CUADRADA){                  
                        if (automata.getElemento(f,c).isVivo()){
                            g.drawRoundRect(TAMANO*c+3,TAMANO*f+3,35,35,5,5);
                        }else{
                            g.fillRoundRect(TAMANO*c+3,TAMANO*f+3,35,35,5,5);    

                        }
                    }else {
                        if (automata.getElemento(f,c).isVivo()){
                            g.fillOval(TAMANO*c+10,TAMANO*f+10,20,20);
                        } else {
                            g.drawOval(TAMANO*c+10,TAMANO*f+10,20,20);
                        }
                    }
                }
            }
        }
    }
}