package net.royal.framework.web.core;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UFile {

	private static final Log LOGGER = LogFactory.getLog(UFile.class);

	public static boolean carpetaBorrar(File folder) {
		if (folder.isDirectory()) {
			String[] children = folder.list();
			for (int i = 0; i < children.length; i++) {
				LOGGER.debug(">>> Iterando file " + i);
				boolean success = carpetaBorrar(new File(folder, children[i]));
				if (!success) {
					return false;
				}
			}
		}
		// La carpeta esta vacia. Ahora puede ser eliminada.
		LOGGER.debug("Carpeta borrada satisfactoriamente");
		return folder.delete();
	}

	/**
	 * incluye la ruta desde la raiz, web
	 * 
	 * @return
	 */
	public static String rutaWebCompleto(String rutaArchivo) {
		String ruta = null;
		ruta = UAplicacion.getRealPath();
		ruta = ruta + rutaArchivo;
		return ruta;
	}

	public static String getInputStreamToString(InputStream is) {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sb.toString();
	}

	public static void borrarArchivoTemporal(String archivo) throws IOException {
		File archivoTemp = new File(archivo);
		if (archivoTemp.exists())
			archivoTemp.delete();
	}

	public static String getSeparador() {
		return File.separator;
	}

	public static String archivoUnico() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd-HHmmssSSS");
		String nombreCarpetaSession = df.format(new Date());
		return nombreCarpetaSession;
	}

	public String cargarImagen(String foto) {

		String imagen = foto.substring(foto.lastIndexOf(UFile.getSeparador()) + 1, foto.length());

		LOGGER.debug("foto    :   " + foto);
		LOGGER.debug("Imagen  :   " + imagen);

		InputStream stream;
		String realPath = UAplicacion.getRealPath();

		try {

			File f = new File(foto);

			if (f.exists()) {
				stream = new FileInputStream(foto);

				File targetFolder = new File(realPath + UFile.getSeparador() + "upload");
				OutputStream out = new FileOutputStream(new File(targetFolder, imagen));
				int read = 0;
				byte[] bytes = new byte[1024];
				while ((read = stream.read(bytes)) != -1) {
					out.write(bytes, 0, read);
				}
				stream.close();
				out.flush();
				out.close();
			}

		} catch (Exception e) {
			LOGGER.error(e);
		}

		return UFile.getSeparador() + "upload" + UFile.getSeparador() + imagen;
	}

	public static String copiarArchivoGeneral(String archiv, byte[] archivo, String opcion, String extension,
			String ruta) {

		InputStream stream;

		try {

			byte[] bytes = new byte[1024];
			bytes = archivo;
			archiv = archiv + "." + extension;
			LOGGER.debug("archivo copiar::" + archiv);
			stream = new ByteArrayInputStream(bytes);

			File targetFolder = new File(ruta + UFile.getSeparador() + opcion);
			OutputStream out = new FileOutputStream(new File(targetFolder, archiv));

			int read = 0;

			while ((read = stream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			stream.close();
			out.flush();
			out.close();

		} catch (Exception e) {
			LOGGER.error(e);
		}
		return archiv;

	}

	public String copiarArchivoProceso(String foto, byte[] archivo, Integer idProceso, String extension) {

		LOGGER.debug("foto    :   " + foto);

		InputStream stream;
		String realPath = UAplicacion.getRealPath();

		String ruta = UFile.getSeparador() + "recursos" + UFile.getSeparador() + "flujos";

		try {

			byte[] bytes = new byte[1024];
			bytes = archivo;
			foto = "flujo" + idProceso + "." + extension;
			LOGGER.debug("FOTO::" + foto);

			stream = new ByteArrayInputStream(bytes);

			File targetFolder = new File(ruta);
			OutputStream out = new FileOutputStream(new File(targetFolder, foto));

			int read = 0;

			while ((read = stream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			stream.close();
			out.flush();
			out.close();

		} catch (Exception e) {
			LOGGER.error(e);
		}
		return foto;

	}

	public static String obtenerContenidoFile(String rutaArchivo) throws IOException {

		StringBuilder contenido = new StringBuilder("");

		File archivo = new File(rutaArchivo);

		if (archivo.exists()) {
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);

			String linea;
			while ((linea = br.readLine()) != null)
				contenido.append(linea);

			fr.close();
		}

		return contenido.toString();
	}

	public static void guardarContenidoFile(String rutaArchivo, String contenido) throws IOException {

		File archivo = new File(rutaArchivo);

		FileWriter fichero = new FileWriter(archivo);
		PrintWriter pw = new PrintWriter(fichero);

		pw.println(contenido);

		fichero.close();
	}

	public void cargarArchivoXByte(byte[] bytesArchivo, String nombreNombreUnico, String directorio) throws Exception {

		InputStream stream;
		String realPath = UAplicacion.getRealPath();

		LOGGER.debug("PATH:" + realPath + UFile.getSeparador() + directorio);

		byte[] bytes = new byte[1024];
		bytes = bytesArchivo;

		stream = new ByteArrayInputStream(bytes);

		File targetFolder = new File(realPath + UFile.getSeparador() + directorio);
		OutputStream out = new FileOutputStream(new File(targetFolder, nombreNombreUnico));
		int read = 0;

		while ((read = stream.read(bytes)) != -1) {
			out.write(bytes, 0, read);
		}
		stream.close();
		out.flush();
		out.close();

	}

	public String cargarArchivoXByteTemporal(byte[] bytesArchivo, String nombreNombreUnico, String directorio)
			throws Exception {

		InputStream stream;
		String realPath = UAplicacion.getRealPath();
		String ruta = "";

		LOGGER.debug("PATH:" + realPath + UFile.getSeparador() + directorio);

		byte[] bytes = new byte[1024];
		bytes = bytesArchivo;

		stream = new ByteArrayInputStream(bytes);

		File targetFolder = new File(realPath + UFile.getSeparador() + directorio);
		OutputStream out = new FileOutputStream(new File(targetFolder, nombreNombreUnico));
		int read = 0;

		while ((read = stream.read(bytes)) != -1) {
			out.write(bytes, 0, read);
		}
		stream.close();
		out.flush();
		out.close();

		ruta = realPath + UFile.getSeparador() + directorio + UFile.getSeparador() + nombreNombreUnico;
		LOGGER.debug(ruta);
		return ruta;

	}

	public static byte[] obtenerArregloByte(String ruta) {
		byte[] bytesrespaldo = null;
		File file = new File(ruta);

		try {
			LOGGER.debug("entro a try");
			FileInputStream fis = new FileInputStream(file);
			LOGGER.debug("file::" + file.getName());
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];

			for (int readNum; (readNum = fis.read(buf)) != -1;) {
				bos.write(buf, 0, readNum);
			}
			byte[] bytes = bos.toByteArray();
			LOGGER.debug("bytes::" + bytes);
			bytesrespaldo = bytes;
		} catch (Exception e) {
			LOGGER.error(e);
		}

		return bytesrespaldo;
	}

	public static Boolean existeFileEnServidor(String file, String ruta) throws IOException {

		Boolean existe = false;
		String realPath = UAplicacion.getRealPath();
		String fotoReal = null;
		if (UValidador.esNulo(file)) {
			return false;
		}

		File f = new File(realPath + File.separator + ruta + File.separator + file);

		if (f.exists()) {
			existe = true;
			// Se compara el nombre ingresado con el nombre del file porque este
			// no
			// diferencia mayusculas o minusculas
			fotoReal = f.getCanonicalPath();
			String extension = fotoReal.substring(fotoReal.lastIndexOf(".") + 1, fotoReal.length());
			fotoReal = fotoReal.replace(extension, extension.toLowerCase());
			fotoReal = fotoReal.substring(fotoReal.lastIndexOf(UFile.getSeparador()) + 1, fotoReal.length());
			fotoReal = fotoReal.replace(" ", "").trim();
			if (file.equals(fotoReal))
				existe = true;
			else {
				existe = false;
			}
			LOGGER.debug(fotoReal + " <-----> " + file);
		}

		return existe;
	}

	/**
	 * Crea un documento físico en la carpeta temporal de la aplicación.
	 * 
	 * @param ruta
	 *            directorio de carpeta
	 * @param nombre
	 *            nombre del documento
	 * @param archivo
	 *            bytes del documento
	 * @throws IOException
	 */
	public static void crearArchivoPorRutaTemporal(String ruta, String nombre, byte[] archivo) throws IOException {
		File uploadedFile = new File(ruta + nombre);
		if (uploadedFile.exists()) {
			uploadedFile.delete();
		}
		InputStream stream;

		try {

			byte[] bytes = new byte[1024];
			bytes = archivo;

			LOGGER.debug("archivo copiar::" + nombre);
			stream = new ByteArrayInputStream(bytes);

			OutputStream out = new FileOutputStream(uploadedFile);

			int read = 0;

			while ((read = stream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			stream.close();
			out.flush();
			out.close();

		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	public static String verArchivo(byte data[], String nombreArchivo, HttpServletResponse response) throws Exception {

		response.setHeader("Content-Disposition", "attachment;filename=" + nombreArchivo);
		ServletOutputStream ouputStream = response.getOutputStream();
		ouputStream.write(data);
		ouputStream.flush();
		ouputStream.close();

		return null;
	}

	public static void descargarArchivo(byte data[], String nombre) throws IOException {
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
				.getResponse();

		response.setHeader("Content-Disposition", "attachment;filename=" + nombre);
		response.setContentLength(data.length);
		ServletOutputStream out = null;
		try {

			out = response.getOutputStream();
			out.write(data);
			out.flush();
			FacesContext.getCurrentInstance().getResponseComplete();
		} catch (IOException err) {
			err.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException err) {
				err.printStackTrace();
			}
		}

	}

	public static void descargarArchivoFromFolder(String pathname) {
		try {
			File archivo = new File(pathname);
			byte[] fileContent = Files.readAllBytes(archivo.toPath());

			descargarArchivo(fileContent, archivo.getName());

		} catch (Exception e) {
			// handles IO exceptions
			e.printStackTrace();
		}
	}

	public static String remplazarTildes(String archivo) {
		String retorno = archivo;
		retorno = retorno.replaceAll("á", "a");
		retorno = retorno.replaceAll("é", "e");
		retorno = retorno.replaceAll("í", "i");
		retorno = retorno.replaceAll("ó", "o");
		retorno = retorno.replaceAll("ú", "u");
		retorno = retorno.replaceAll("Á", "A");
		retorno = retorno.replaceAll("É", "E");
		retorno = retorno.replaceAll("Í", "I");
		retorno = retorno.replaceAll("Ó", "O");
		retorno = retorno.replaceAll("Ú", "U");

		return retorno;
	}

	public static String remplazarCaracteresEspeciales(String archivo) {
		String retorno = archivo;
		retorno = retorno.replaceAll("á", "a");
		retorno = retorno.replaceAll("é", "e");
		retorno = retorno.replaceAll("í", "i");
		retorno = retorno.replaceAll("ó", "o");
		retorno = retorno.replaceAll("ú", "u");
		retorno = retorno.replaceAll("Á", "A");
		retorno = retorno.replaceAll("É", "E");
		retorno = retorno.replaceAll("Í", "I");
		retorno = retorno.replaceAll("Ó", "O");
		retorno = retorno.replaceAll("Ú", "U");
		retorno = retorno.replaceAll("°", "");
		retorno = retorno.replaceAll("|", "");

		return retorno;
	}
}
