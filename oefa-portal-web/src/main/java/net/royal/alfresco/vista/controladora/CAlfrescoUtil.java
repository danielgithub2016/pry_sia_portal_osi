package net.royal.alfresco.vista.controladora;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class CAlfrescoUtil {

	protected static Logger LOGGER = Logger.getLogger(CAlfrescoUtil.class);

	public static String view(byte data[], String nombreArchivo) throws Exception {

		FacesContext facesContext = FacesContext.getCurrentInstance();

		HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();

		response.reset();
		response.setHeader("Content-Type", "application/octet-stream");
		response.setHeader("Content-Disposition", String.format("attachment;filename=%s", nombreArchivo));

		OutputStream responseOutputStream = response.getOutputStream();

		InputStream fileInputStream = new ByteArrayInputStream(data);

		try {
			byte[] bytesBuffer = new byte[2048];
			int bytesRead;
			while ((bytesRead = fileInputStream.read(bytesBuffer)) > 0)
				responseOutputStream.write(bytesBuffer, 0, bytesRead);

			responseOutputStream.flush();
			responseOutputStream.close();

		} catch (IOException e) {
			LOGGER.info(e.getMessage());
		} finally {
			fileInputStream.close();
			facesContext.responseComplete();
		}

		return null;
	}
}
