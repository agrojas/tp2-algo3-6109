package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import avion.AvionSimple;

import pista.Pista;
import pista.PistaSimple;
import pista.PosicionesEntradaSobrantesException;
import pista.PosicionesEntradaVaciaException;

import copControl.Mapa;
import copControl.Posicion;



import fiuba.algo3.titiritero.dibujables.Circulo;
import fiuba.algo3.titiritero.dibujables.Cuadrado;
import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

public class VentanaPrincipal {

	private JFrame frame;
	private GameLoop gameLoop;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		try {
			initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setForeground(new Color(0, 0, 0));
		//tamaño ventana
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Proyecto Base para uso del Titiritero");
		
		JButton btnIniciar = this.addBotonIniciar();
		
		JButton btnDetener = this.addBotonDetener();
		
		JPanel panel = this.addSuperficiePanel();
		
		this.gameLoop = new GameLoop((SuperficieDeDibujo) panel);
		
		this.inicializarModelo();
		
		this.addMouseListener(panel);
		//por ahora no lo usamos
		//this.addKeyListener();

		this.setComponentsFocus(btnIniciar, btnDetener);

	}

		//Aca poner la logica de inicializacion
	private void inicializarModelo() {
		Mapa mapa = new Mapa();
		
		List<Posicion> entradasPistaSimple = new LinkedList<Posicion>();
		entradasPistaSimple.add(mapa.getPosicionAleatoria());
		
		Pista pistaSimple = null;
		try {
			pistaSimple = new PistaSimple(entradasPistaSimple);
		} catch (PosicionesEntradaVaciaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PosicionesEntradaSobrantesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Pista> pistas = new LinkedList<Pista>();
		pistas.add(pistaSimple);
		
		
		mapa.setPistas(pistas);
		Posicion posIni = mapa.generarPosicionExtremoAlAzar();
		Posicion posFin =pistaSimple.getPosicionesEntrada().get(0);
		AvionSimple avionSimple = new AvionSimple(posIni,posFin, mapa);
		
		
		this.gameLoop.agregar(avionSimple);
		Circulo circulo = new VistaAvionSimple(avionSimple);
		Cuadrado cuadrado = new VistaPistaSimple(pistaSimple);
		this.gameLoop.agregar(circulo);
		this.gameLoop.agregar(cuadrado);
		
	}

	private void setComponentsFocus(JButton btnIniciar, JButton btnDetener) {
		frame.setFocusable(true);
		btnDetener.setFocusable(false);
		btnIniciar.setFocusable(false);
	}

	private void addKeyListener() {
		frame.addKeyListener(new KeyListener(
				) {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				System.out.println("Key pressed");
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				System.out.println("Ping");
			}  
			 	
		});
	}

	private void addMouseListener(JPanel panel) {
		panel.addMouseListener(new MouseAdapter() {
					
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
			}});
	}

	private JPanel addSuperficiePanel() {
		JPanel panel = new SuperficiePanel();
		panel.setBackground(new Color(0, 0, 0));
		//tamaño fondo
		panel.setBounds(42, 53, 500, 500);
		frame.getContentPane().add(panel);
		return panel;
	}

	private JButton addBotonDetener() {
		JButton btnDetener = new JButton("Detener");
		btnDetener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameLoop.detenerEjecucion();
			}
		});
		btnDetener.setBounds(325, 16, 92, 25);
		frame.getContentPane().add(btnDetener);
		return btnDetener;
	}

	private JButton addBotonIniciar() {
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameLoop.iniciarEjecucion();
			}
		});
		btnIniciar.setBounds(42, 16, 77, 25);
		frame.getContentPane().add(btnIniciar);
		return btnIniciar;
	}
}