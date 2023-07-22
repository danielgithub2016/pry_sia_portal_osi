package net.royal.framework.web.dominio;

public class ParametroPersistenciaGenerico implements java.io.Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -1252253872796404022L;

	private String field;
	private Class clazz;
	private Object value;

	public ParametroPersistenciaGenerico(String pfield, Class pclazz,
			Object pvalue) {
		this.field = pfield;
		this.clazz = pclazz;
		this.value = pvalue;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
