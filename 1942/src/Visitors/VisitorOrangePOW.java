package Visitors;

import java.util.Timer;
import java.util.TimerTask;

import Entidades.Entidad;
import Entidades.Jugador;
import EstadosJugador.EstadoInmune;
import EstadosJugador.EstadoJugador;
import Logica.Juego;
import Premios.PremioTemporal;

public class VisitorOrangePOW extends VisitorPremioTemporal{

	public VisitorOrangePOW(PremioTemporal entidad) {
		super(entidad);
		this.duracion = entidad.getDuracion();
	}
	
	public void visit(Jugador jug) {
		//hacer algo temporalmente --> inmunidad es una buena opcion
		/*
		EstadoJugador estado_actual = jug.getEstadoJugador();
		jug.setEstadoJugador(new EstadoInmune(jug));
		PremioTemporal p=(PremioTemporal) entidad;
		entidad.eliminar();
		Timer timer = new Timer();
		TimerTask timer_task = new TimerTask() {

			@Override
			public void run() {
				jug.setEstadoJugador(estado_actual);
				this.cancel();
			};
		};
		timer.schedule(timer_task, this.duracion, 1);
		
	}
	*/
		
	}
}