package net.royal.firmadigital.vista.controladora;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.royal.framework.web.core.UValidador;

public class CargarDocumentos extends HttpServlet {

	private static final String ARCHIVO_NOMBRE = "archivo";
	private static final String ARCHIVO_FECHA_ACTUALIZACION = "fechaActualizacion";

	public CargarDocumentos() {
		super();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/* Se realiza la carga de los archivos */
		doPost(req, resp);
	}

	public void doPost1111(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String vcFileName = req.getHeader(ARCHIVO_NOMBRE);
		String vcDtLastMod = req.getHeader(ARCHIVO_FECHA_ACTUALIZACION);
		String procesosaacion = req.getParameter("procesoaccion");
		String proceso = "";
		String accion = "";

		// separamos elprocso y la accion
		if (!UValidador.estaVacio(procesosaacion)) {
			proceso = procesosaacion.substring(0, procesosaacion.indexOf("|"));
			accion = procesosaacion.substring(procesosaacion.indexOf("|") + 1, procesosaacion.length());
		}

		

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean overwrite = true;
		String vcFileName = req.getHeader(ARCHIVO_NOMBRE);
		String vcDtLastMod = req.getHeader(ARCHIVO_FECHA_ACTUALIZACION);

		String rutabase = req.getParameter("rutabase");

		// String vcRutaDocumentos = UAplicacion.getServletContext();
		String message = "OK, archivo cargado: " + vcFileName;

		int status = HttpServletResponse.SC_OK;
		System.out.println("Nombre de archivo que se carga: " + vcFileName + " mensaje:" + message);
		if (vcFileName == null) {
			message = "Archivo no encontrado";
			status = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
		} else {

			File uploadedFile = new File(rutabase + vcFileName.replace("_final", "_firmado"));
			if (uploadedFile.exists()) {
				if (overwrite) {
					uploadedFile.delete();
				}
			}
			// ensure the directory is writable - and a new file may be created.
			if (!uploadedFile.createNewFile()) {
				message = "ERROR: Error en acceso del servidor de destino, no se puede crear archivo.";
				status = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
			} else {
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				InputStream is = req.getInputStream();
				try {
					// create a buffer. 4K!
					byte[] buffer = new byte[4096];
					int byteCnt = 0;
					while (true) {
						int bytes = is.read(buffer);
						if (bytes < 0)
							break;
						byteCnt += bytes;
						fos.write(buffer, 0, bytes);
					}
					fos.flush();
					// En esta seccion se pueden realizar tareas adicionales
					// para la gestión del archivo

				} finally {
					is.close();
					fos.close();
					uploadedFile.setLastModified((new Long(vcDtLastMod)).longValue());
				}
			}
		}

		resp.setContentType("text/plain");
		resp.setStatus(status);
		if (status != HttpServletResponse.SC_OK) {
			getServletContext().log("ERROR: " + message);
		}
		PrintWriter out = resp.getWriter();
		out.println(message);
	}

}