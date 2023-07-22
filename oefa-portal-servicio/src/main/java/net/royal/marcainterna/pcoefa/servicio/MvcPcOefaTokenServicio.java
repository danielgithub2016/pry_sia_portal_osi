package net.royal.marcainterna.pcoefa.servicio;

import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.marcainterna.pcoefa.dominio.MvcPcOefaToken;

public interface MvcPcOefaTokenServicio extends GenericoServicio {

	public MvcPcOefaToken obtenerPorToken(String token);

	public MvcPcOefaToken obtenerPorEstado(String estado);

	public MvcPcOefaToken generarToken(MvcPcOefaToken mvcPcOefaToken);

}
