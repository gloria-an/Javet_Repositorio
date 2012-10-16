package edu.upc.mdr.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import edu.upc.mdr.model.Cliente;
import edu.upc.mdr.service.ClienteService;
import edu.upc.mdr.vo.ClienteCollection;

public class ClienteServiceImpl implements ClienteService {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	private static Map<String, Cliente> clientes = new HashMap<String, Cliente>();

	public ClienteServiceImpl() {
	}

	@Override
	public ClienteCollection getUsers(String dni) {
		Connection conn = null;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=MdgArquitectos;user=sa;Password=sql");
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException exx) {
			exx.printStackTrace();
		}

		if (conn != null) {
			String SQL = "SELECT * FROM CLIENTES WHERE NRODOCUMENTO = '" + dni
					+ "'";
			// DESCOMENTAR ESTO PARA PROBAR REST
			// String SQL =
			// "SELECT * FROM CLIENTES WHERE NRODOCUMENTO = '12345678'";
			try {
				PreparedStatement statement = conn.prepareStatement(SQL);
				ResultSet result = statement.executeQuery();

				while (result.next()) {
					clientes.put(
							result.getString("NroDocumento"),
							new Cliente(result.getInt("IdCliente"), result
									.getString("NombreCliente"), result
									.getString("ApellidosCliente"), result
									.getString("NroDocumento"), result
									.getString("EstadoCivil"), result
									.getString("idTipoDocumento"), result
									.getString("Resultado")));

				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return new ClienteCollection(clientes.values());
	}

	@Override
	public Cliente getUser(String dni) {
		Connection conn = null;
		Cliente cl = new Cliente();

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=MdgArquitectos;user=sa;Password=sql");
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException exx) {
			exx.printStackTrace();
		}

		if (conn != null) {
			String SQL = "SELECT * FROM CLIENTES WHERE NRODOCUMENTO = '" + dni
					+ "'";

			// DESCOMENTAR ESTO PARA PROBAR REST
			// String SQL =
			// "SELECT * FROM CLIENTES WHERE NRODOCUMENTO = '12345678'";
			try {
				PreparedStatement statement = conn.prepareStatement(SQL);
				ResultSet result = statement.executeQuery();

				while (result.next()) {
					cl.setDni(result.getString("NroDocumento"));
					cl.setIdCliente(result.getInt("IdCliente"));
					cl.setNombreCliente(result.getString("NombreCliente"));
					cl.setApellidosCliente(result.getString("ApellidosCliente"));
					cl.setDni(result.getString("NroDocumento"));
					cl.setEstadoCivil(result.getString("EstadoCivil"));
					cl.setTipoDocumento(result.getString("idTipoDocumento"));
					cl.setResultado(result.getString("Resultado"));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cl;
	}

	@Override
	public Response getBadRequest() {
		return Response.status(Status.BAD_REQUEST).build();
	}

	@Override
	public Cliente getUserCli(String dni) {
		Connection conn = null;
		Cliente cl = new Cliente();

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=MdgArquitectos;user=sa;Password=sql");
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException exx) {
			exx.printStackTrace();
		}

		if (conn != null) {
			String SQL = "SELECT * FROM CLIENTES WHERE NRODOCUMENTO = '" + dni
					+ "'";

			// DESCOMENTAR ESTO PARA PROBAR REST
			// String SQL =
			// "SELECT * FROM CLIENTES WHERE NRODOCUMENTO = '12345678'";
			try {
				PreparedStatement statement = conn.prepareStatement(SQL);
				ResultSet result = statement.executeQuery();

				while (result.next()) {
					cl.setDni(result.getString("NroDocumento"));
					cl.setIdCliente(result.getInt("IdCliente"));
					cl.setNombreCliente(result.getString("NombreCliente"));
					cl.setApellidosCliente(result.getString("ApellidosCliente"));
					cl.setDni(result.getString("NroDocumento"));
					cl.setEstadoCivil(result.getString("EstadoCivil"));
					cl.setTipoDocumento(result.getString("idTipoDocumento"));
					cl.setResultado(result.getString("Resultado"));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cl;
	}

}