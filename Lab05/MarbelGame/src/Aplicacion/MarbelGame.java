package Aplicacion;

import java.lang.Math;
import java.util.*;


import java.awt.*;

public class MarbelGame {
	private int tamano;
	private Object[][][] tablero;
	private int movimientos;
	private int canicas;
	private int barreras;
	
	public MarbelGame(int n,int m,int b) {
		tamano=n;
		canicas=m;
		barreras=b;
		movimientos=0;
		asignaciones(tamano,canicas,barreras);
	}
	
	public void asignaciones(int n,int m,int b) {
		tablero=null;
		tablero=new Object[n][n][3];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				Object[] e= {0,null,null};
				tablero[i][j]= e;
			}
		}
		poblar(m,b);
	}
	
	public void poblar(int canicas,int barreras) {
		for(int i=0;i<canicas;i++) {
			int r=(int) (Math.random() * 255),g=(int) (Math.random() * 255),b=(int) (Math.random() * 255);
			Color color=new Color(r,g,b);
			agregar(1,color);
			agregar(2,color);
		}
		
		for(int j=0;j<barreras;j++) {
			Color color=new Color(0,0,0);
			agregar(3,color);
		}
	}
	
	public void agregar(int elemento,Color color) {
		int f=(int) (Math.random() * tamano);
		int c=(int) (Math.random() * tamano);
		while(true) {
			if((int)tablero[f][c][0]==0) {
				tablero[f][c][0]=elemento;
				tablero[f][c][1]=color;
				break;
			}
			f=(int) (Math.random() * tamano);
			c=(int) (Math.random() * tamano);
		}
	}
	
	public void mostrar() {
		for(int i=0;i<tamano;i++) {
			String numes="";
			for(int j=0;j<tamano;j++) {
				numes+=tablero[i][j][0]+" ";
			}
			System.out.println(numes);
		}
	}
	
	public int getLongitud() {
		return tamano;
	}
	
	public int getNumero(int i,int j) {
		return (int)tablero[i][j][0];
	}
	
	public Color getColor(int i,int j) {
		return (Color)tablero[i][j][1];
	}
	
	public Color getColor2(int i,int j) {
		return  (Color)tablero[i][j][2];
	}
	
	public void norte() {
		for(int j=0;j<tamano;j++) {
			for(int i=tamano-2;i>-1;i--) {
				if((int)tablero[i][j][0]==1) {
					while(i<tamano-1) {
						if((int)tablero[i+1][j][0]==0 || (int)tablero[i+1][j][0]==2) { 
							if((int)tablero[i+1][j][0]==0) {
								norteSur(i,j,1,0);
							}else if((int)tablero[i+1][j][0]==2) {
								norteSur(i,j,1,2);
								break;
							}
							i++;
						}else {
							break;
						}
					}
				}
			}
		}
		movimientos=movimientos+1;
	}
	
	public void sur() {
		for(int j=0;j<tamano;j++) {
			for(int i=1;i<tamano;i++) {
				if((int)tablero[i][j][0]==1) {
					while(i>0) {
						if((int)tablero[i-1][j][0]==0 || (int)tablero[i-1][j][0]==2) { 
							if((int)tablero[i-1][j][0]==0) {
								norteSur(i,j,-1,0);
							}else if((int)tablero[i-1][j][0]==2) {
								norteSur(i,j,-1,2);
								break;
							}
							i--;
						}else {
							break;
						}
					}
				}
			}
		}
		movimientos=movimientos+1;
	}
	
	public void este(){
		for(int i=0;i<tamano;i++) {
			for(int j=1;j<tamano;j++) {
				if((int)tablero[i][j][0]==1) {
					while(j>0) {
						if((int)tablero[i][j-1][0]==0 || (int)tablero[i][j-1][0]==2) { 
							if((int)tablero[i][j-1][0]==0) {
								esteOeste(i,j,-1,0);
							}else if((int)tablero[i][j-1][0]==2) {
								esteOeste(i,j,-1,2);
								break;
							}
							j--;
						}else {
							break;
						}
					}
				}
			}
		}
		movimientos=movimientos+1;
	}
	
	public void oeste() {
		for(int i=0;i<tamano;i++) {
			for(int j=tamano-2;j>-1;j--) {
				if((int)tablero[i][j][0]==1) {
					while(j<tamano-1) {
						if((int)tablero[i][j+1][0]==0 || (int)tablero[i][j+1][0]==2) { 
							if((int)tablero[i][j+1][0]==0) {
								esteOeste(i,j,1,0);
							}else if((int)tablero[i][j+1][0]==2) {
								esteOeste(i,j,1,2);
								break;
							}
							j++;
						}else {
							break;
						}
					}
				}
			}
		}
		movimientos=movimientos+1;
	}
	
	public int[] consultar() {
		int malUbicadas=0;
		int bienUbicadas=0;
		for(int i=0;i<tamano;i++) {
			for(int j=0;j<tamano;j++) {
				if((int)tablero[i][j][0]==4) {
					if(this.getColor(i,j).equals(this.getColor2(i,j))) {
						bienUbicadas+=1;
					}else {
						malUbicadas+=1;
					}
				}
			}
		}
		int[] consulta= {movimientos,bienUbicadas,malUbicadas};
		return consulta;
	}
	
	public void modificar(int n,int m,int b) {
		tamano=n;
		canicas=m;
		barreras=b;
		movimientos=0;
		asignaciones(n,m,b);
	}

	public void norteSur(int i,int j,int num,int movimiento) {
		if(movimiento==0) {
			tablero[i+num][j][0]=tablero[i][j][0];
			tablero[i+num][j][1]=tablero[i][j][1];
			tablero[i+num][j][2]=tablero[i][j][2];
			tablero[i][j][0]=0;
			tablero[i][j][1]=null;
			tablero[i][j][2]=null;
		}else if(movimiento==2) {
			tablero[i+num][j][0]=4;
			tablero[i+num][j][1]=tablero[i+num][j][1];
			tablero[i+num][j][2]=tablero[i][j][1];
			tablero[i][j][0]=0;
			tablero[i][j][1]=null;
			tablero[i][j][2]=null;
		}
	}
	
	public void esteOeste(int i,int j,int num,int movimiento) {
		if(movimiento==0) {
			tablero[i][j+num][0]=tablero[i][j][0];
			tablero[i][j+num][1]=tablero[i][j][1];
			tablero[i][j+num][2]=tablero[i][j][2];
			tablero[i][j][0]=0;
			tablero[i][j][1]=null;
			tablero[i][j][2]=null;
		}else if(movimiento==2) {
			tablero[i][j+num][0]=4;
			tablero[i][j+num][1]=tablero[i][j+num][1];
			tablero[i][j+num][2]=tablero[i][j][1];
			tablero[i][j][0]=0;
			tablero[i][j][1]=null;
			tablero[i][j][2]=null;
		}
	}
}

