package net.royal.marcainterna.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.royal.marcainterna.pcoefa.dominio.MvcPcOefaToken;
import net.royal.marcainterna.pcoefa.rest.json.ValidaPcOefaResponse;
import net.royal.marcainterna.pcoefa.servicio.MvcPcOefaTokenServicio;

//@Path("/pctokenoefa")
public class PcOefaTokenRest {

	// ModelMapper modelMapper;

	// @Autowired
	MvcPcOefaTokenServicio mvcPcOefaTokenServicio;

	@GET
	@Path("/generarToken/{pNombrePc}/{pUsuarioPc}")
	// @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String generarToken(@PathParam("pNombrePc") String pNombrePc, @PathParam("pUsuarioPc") String pUsuarioPc) {

		ValidaPcOefaResponse validaPcOefaResponse = new ValidaPcOefaResponse();

		ApplicationContext context = new ClassPathXmlApplicationContext("comun/ctxPortalWeb.xml");
		mvcPcOefaTokenServicio = (MvcPcOefaTokenServicio) context.getBean("BeanServicioMapPcOefaToken");

		MvcPcOefaToken mvcPcOefaToken = new MvcPcOefaToken();
		mvcPcOefaToken.setTx_pc(pNombrePc);
		mvcPcOefaToken.setTx_codigo_usuario_creacion(pUsuarioPc);

		try {
			mvcPcOefaToken = mvcPcOefaTokenServicio.generarToken(mvcPcOefaToken);

			validaPcOefaResponse.setCodigo("ok");
			validaPcOefaResponse.setMensaje(mvcPcOefaToken.getTx_token());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			validaPcOefaResponse.setCodigo("error");
			validaPcOefaResponse.setMensaje(e.getMessage());
		}

		return validaPcOefaResponse.getCodigo() + "|" + validaPcOefaResponse.getMensaje();
	}

	@GET
	@Path("/prueba/{pSaludo}")
	@Produces(MediaType.TEXT_PLAIN)
	public String prueba(@PathParam("pSaludo") String pSaludo) {

		return "hola " + pSaludo;
	}

}
