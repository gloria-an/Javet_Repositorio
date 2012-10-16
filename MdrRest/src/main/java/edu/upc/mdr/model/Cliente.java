package edu.upc.mdr.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cliente")
public class Cliente {
	
	int idCliente;
	String NombreCliente;
	String ApellidosCliente;
	String dni;
	String EstadoCivil;
	String TipoDocumento;
	String resultado;

	public Cliente() {
	}

	public Cliente(int idCliente, String NombreCliente,
			String ApellidosCliente, String dni, String estadoCivil,
			String tipoDocumento, String resultado) {
		super();
		this.idCliente = idCliente;
		this.NombreCliente = NombreCliente;
		this.ApellidosCliente = ApellidosCliente;
		this.dni = dni;
		this.EstadoCivil = estadoCivil;
		this.TipoDocumento = tipoDocumento;
		this.resultado = resultado;
	}


	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCliente() {
		return NombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		NombreCliente = nombreCliente;
	}

	public String getApellidosCliente() {
		return ApellidosCliente;
	}

	public void setApellidosCliente(String apellidosCliente) {
		ApellidosCliente = apellidosCliente;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEstadoCivil() {
		return EstadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		EstadoCivil = estadoCivil;
	}

	public String getTipoDocumento() {
		return TipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		TipoDocumento = tipoDocumento;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return String.format("{dni=%s,nombre=%s}", dni, NombreCliente + " " + ApellidosCliente);
	}
}