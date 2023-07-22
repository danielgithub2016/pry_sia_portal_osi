package net.royal.marcainterna.pcoefa.servicio;

import net.royal.framework.web.servicio.GenericoServicio;

public interface MapPcOefaServicio extends GenericoServicio {

	public Boolean existePcOefa(String nombre);

	public Boolean existePcFisicamenteOefa(String nombre);

//	public ValidaPcOefaDto generarTokenMarcaPcOefa(ValidaPcOefaDto dtPcOefaDto) throws ValidateException;

}
