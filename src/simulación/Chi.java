package simulación;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
 
 
public class Chi extends JPanel {
	
	public Procesos pro;
	public JPanel panel;
	public JTextField chiTabla;
	public JTextField numAleatorios[];
	public JLabel hipotesis, conclusion, chiTablaLabel, numerosAleatorios, tablaLabel, pruebaUni;
	public JLabel vacio, lambda;
	public JButton botonCalcular, botonLimpiar;
	public GridBagLayout capa;
	public JTable tabla;
	public DefaultTableModel modelo;
	public JScrollPane barra;
	GridBagConstraints alineacion;
	public String nombresColumnas[] = {"Evento (i)", "fe", "fo", "fo - fe", "(fe - fo)^2", "((fe - fo)^2)/fe"};
	int[] enterosAleatorios;
	
    public Chi() {
    	//Configurar esquema
    	capa = new GridBagLayout();
    	this.setLayout(capa);
    	alineacion = new GridBagConstraints();
    	
    	//Crear componentes
    	numerosAleatorios = new JLabel("Numeros Aleatorios");
    	
    	numAleatorios = new JTextField[10];
    	for(int i=0; i<numAleatorios.length; i++) {
    		numAleatorios[i] = new JTextField(6);
    	}
    	
    	vacio = new JLabel("Emmanuel Hernandez Mendoza");
    	
    	tablaLabel = new JLabel("Tabla de Frecuencia");
    	modelo = new DefaultTableModel(nombresColumnas, 10);
    	tabla = new JTable(modelo);
 	   	barra = new JScrollPane(tabla);
		
		pro = new Procesos();
		botonCalcular = new JButton("Calcular");
		botonCalcular.addActionListener(pro);
		botonLimpiar = new JButton("Limpiar");
		botonLimpiar.addActionListener(pro);
		
		chiTablaLabel = new JLabel("Chi Cuadrada-Tabla");
		chiTabla = new JTextField(6);
		
		pruebaUni = new JLabel("PRUEBA DE LA UNIFORMIDAD");
		lambda = new JLabel("lambda^2 =");
		
		hipotesis = new JLabel("Prueba de Hipotesis");
		conclusion = new JLabel("CONCLUSION");
		
		//Agregar componenetes al Panel
		alineacion.fill = GridBagConstraints.HORIZONTAL;
		agregarComponentes(numerosAleatorios, 0, 0, 1, 1);
		
		alineacion.fill = GridBagConstraints.VERTICAL;
		for(int i=0; i<numAleatorios.length; i++) {
			agregarComponentes(numAleatorios[i], (i+1), 0, 2, 1);
		}
		agregarComponentes(vacio, 11, 0, 2, 1);
 
		alineacion.fill = GridBagConstraints.CENTER;
		agregarComponentes(tablaLabel, 0, 2, 3, 1);
		
		alineacion.fill = GridBagConstraints.BOTH;
		agregarComponentes(barra, 1, 2, 3, 11);
		
		alineacion.fill = GridBagConstraints.HORIZONTAL;
		agregarComponentes(botonCalcular, 2, 5, 2, 2);
		agregarComponentes(botonLimpiar, 8, 5, 2, 2);
		
		alineacion.fill = GridBagConstraints.HORIZONTAL;
		agregarComponentes(chiTablaLabel, 12, 0, 2, 1);
		agregarComponentes(chiTabla, 13, 0, 2, 2);
		
		alineacion.fill = GridBagConstraints.CENTER;
		agregarComponentes(hipotesis, 12, 5, 2, 1);
		agregarComponentes(conclusion, 13, 5, 2, 1);
		agregarComponentes(pruebaUni, 14, 3, 2, 1);
		
		alineacion.fill = GridBagConstraints.EAST;
		agregarComponentes(lambda, 12, 4, 1, 1);
		
    }
    
    public void agregarComponentes(Component componente, int fila, int columna, 
    	int anchura, int altura) {
    	//Columna y fila
    	alineacion.gridx = columna;
    	alineacion.gridy = fila;
    	
    	//Ancho y alto
    	alineacion.gridwidth = anchura; //num de columnas
    	alineacion.gridheight = altura; //num de filas
    	
    	//Establece esquema y agragarlo al Panel
    	capa.setConstraints(componente, alineacion);
    	this.add(componente, alineacion);
    }
        
    private class Procesos implements ActionListener {
    	
    	
    	public void actionPerformed(ActionEvent evento) {
    		
    		if (evento.getActionCommand() == "Limpiar") {
    				//Borra todos los datos de la tabla
    				limpiarDatos();
    			}
 
    		else {
    			//Rellenar Columna Evento (i) y Columna Fe
    			rellenarEventos();
    			ordenarDigitos();
    			calculosRestantes();
    		}
    	}
    
    //Metodo que rellena la Columna Evento y la Columna Fe
    	public void rellenarEventos() {
    		int fe=0;
    		int m=10;
    	
    		//formula fe=(4*m)/10
    		/*Como el Num. Total de la Secuencia es 10,
    		 no es necesario pedirlo*/
    		fe = (4*m)/10;
    	
    		for(int i=0; i<tabla.getRowCount(); i++) {
    			tabla.setValueAt(i, i, 0);
    			tabla.setValueAt(fe, i, 1);
    		}
		}
		
    //Metodo para Separar todos los digitos de los num Aleatorios
    	public void ordenarDigitos() {
    	
    		String stringAleatorios="";
    		char arregloCharAleatorios[];
    		Character arregloCharacterAleatorios[];
    		String arregloStringAleatorios[];
    		    	
    		//Obtener todos los Num Aleatorios y pasarlos a una cadena
    		for(int i=0; i<numAleatorios.length; i++) {
    			stringAleatorios = stringAleatorios + numAleatorios[i].getText();
    		}
   		
    		arregloCharAleatorios = stringAleatorios.toCharArray(); //Separar digito por digito
    	
    		//Pasar todos los char a un arreglo Character
    		arregloCharacterAleatorios = new Character[arregloCharAleatorios.length];
    		for(int i=0; i<arregloCharAleatorios.length; i++) {
    			arregloCharacterAleatorios[i] = arregloCharAleatorios[i];
    		}
    	
    		//Se convierte el Arreglo Character a String
    		arregloStringAleatorios = new String[arregloCharacterAleatorios.length];
    		for(int i=0; i<arregloCharacterAleatorios.length; i++) {
    			arregloStringAleatorios[i] = arregloCharacterAleatorios[i].toString();
    		}
    	
    		//Convertir Arreglo String a Entero
    		enterosAleatorios = new int[arregloStringAleatorios.length];
    		for(int i=0; i<arregloStringAleatorios.length; i++) { 
    			enterosAleatorios[i] = Integer.parseInt(arregloStringAleatorios[i]);
    		}
    	
    		//Ver cuantos 0's hay, cuantos 1's hay.... etc
    		for(int i=0; i<tabla.getRowCount(); i++) {
    			tabla.setValueAt(buscarDigito(i), i, 2);
    		}
    	}
    	
    	//Metodo que busca los digitos 0, 1, 2, 3....9 y cuenta cuantos son
    	public int buscarDigito(int digito) {
    		boolean bandera = true;
    		int contador=0;
    		
    		while(bandera) {
    			
    			for(int i=0; i<enterosAleatorios.length; i++) {
    				
    				if(enterosAleatorios[i] == digito){
					
						contador = contador +1;				
    					bandera = false;
    				}
    			}
    			bandera = false;
    		}
    		return contador;
    	}
    	
    	//Metodo para rellenar las Columnas faltantes
    	public void calculosRestantes() {
    		String valores1[] = new String[tabla.getRowCount()];
    		String valores2[] = new String[tabla.getRowCount()];
    		int[] val1= new int[valores1.length]; 
    		int[] val2= new int[valores2.length];
    		int resultado = 0;
    		    		
    		//Convertir los valores de la tabla en String y luego en Enteros
    		for(int i=0; i<tabla.getRowCount(); i++) {
    			valores1[i] = tabla.getValueAt(i, 2).toString();
    			valores2[i] = tabla.getValueAt(i, 1).toString();
    			
    			val1[i] = Integer.parseInt(valores1[i]);
    			val2[i] = Integer.parseInt(valores2[i]);
    		}
    		
    		//Calcula fo-fe
    		for(int i=0; i<tabla.getRowCount(); i++) {
    			
    			resultado = val1[i] - val2[i];
    			tabla.setValueAt(resultado, i, 3);
    		}
    		
    		//Calcula (fo-fe)^2
    		for(int i=0; i<tabla.getRowCount(); i++) {
    			val2[i] = Integer.parseInt(tabla.getValueAt(i, 3).toString());
    			resultado = val2[i] * val2[i];
    			tabla.setValueAt(resultado, i, 4);
    		}
    		
    		//calcula ((fo-fe)^2)/fe
    		double res=0;
    		double[] val3 = new double[tabla.getRowCount()];
    		for(int i=0; i<tabla.getRowCount(); i++) {
    			val3[i] = Double.parseDouble(tabla.getValueAt(i, 4).toString());
    			res = val3[i] / 4;
    			tabla.setValueAt(res, i, 5);
    		}
    		
    		//Calcula lambda^2
			double suma=0;
    		for(int i=0; i<tabla.getRowCount(); i++) {
    			val3[i] = Double.parseDouble(tabla.getValueAt(i, 5).toString());
    			suma = suma + val3[i];
    			lambda.setText("lambda^2 = "+suma);
    		}
    		
    		//Conclusion, Prueba de Hipotesis
    		double chi=0;
    		chi = Double.parseDouble(chiTabla.getText());
    		if(suma <= chi) {
    			conclusion.setText("Los Numeros SON Aleatorios");
    		}
    		else {
    			conclusion.setText("Los Numeros NO son Aleatorios");
    		}
    	}
    	
    	public void limpiarDatos() {
    		
    		//Borra los campos de Num Aleatorios
    		for(int i=0; i<numAleatorios.length; i++) {
    			numAleatorios[i].setText("");
    		}
    		//Borra los valores de la tabla
    		for(int i=0; i<tabla.getRowCount(); i++) {
    			
    			for(int a=0; a<tabla.getColumnCount(); a++) {
    				tabla.setValueAt("", i, a);
    			}
    		}
    		
    		//Borra el campo de chi-cuadrada-tabla, lambda^2 y la hipotesis
    		chiTabla.setText("");
    		lambda.setText("lambda^2 =");
    		conclusion.setText("");
    	}
    }
}