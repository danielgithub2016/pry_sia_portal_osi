package net.royal.framework.web.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class PropertiesUtil {

    private static final Logger logger = Logger.getLogger(PropertiesUtil.class.getPackage().getName());
    private static Properties props = null;
    private static String fileName = System.getenv("DOMAIN_HOME") + "/data/sia/portalweb/propiedadesAplicacionWeb.properties";
    //private static String fileName = System.getenv("DOMAIN_HOME") + "D:\\data\\properties\\cep\\configuracion.properties";
    //private static String fileName  = "D:\\data\\properties\\cep\\configuracion.properties";

    public PropertiesUtil(String aFileName) {
        super();
        if (!"".equals(aFileName) && aFileName != null) {
            this.fileName = aFileName;
        }
    }

    public static String getProp(String propName) {
  //      logger.log(Level.INFO, "Obteniendo propiedad {0}", propName);
        if (props == null) {
            props = new Properties();
            try {
                try (InputStream is = new FileInputStream(fileName)) {
          //          logger.log(Level.INFO, "Archivo de propiedades existe {0}: {1}", new Object[]{fileName, is != null});
                    props.load(is);
                }

            } catch (IOException ex) {
        //        logger.log(Level.SEVERE, null, ex);
                return "";
            }
        }

        if (props != null) {
//            logger.log(Level.INFO, "Valor de propiedad {0} = {1}", new String[]{propName, props.getProperty(propName)});
            return props.getProperty(propName);
        }

      //  logger.log(Level.INFO, "Valor de propiedad {0} no encontrada, devolviendo nulo", propName);
        return null;
    }

    public String getFileName() {
        return fileName;
    }

}
