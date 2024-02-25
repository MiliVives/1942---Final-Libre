package Entidades;

import EntidadesGraficas.EntidadGrafica;

public abstract class Proyectil extends Entidad {
	protected int damage;

	public Proyectil(EntidadGrafica entidad_graf) {
		super(entidad_graf);
	}

	public int getDamage() {
		return this.damage;
	}
}