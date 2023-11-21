package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

	public class HomeDAO {
		
	private Connection conn;
	public String response = "";

	public HomeDAO() {
		this.conn = ConnectionManager.getInstance().getConnection();
	}

	public String getValues(String cpf) {
		String sql = "SELECT NM_USUARIO, VL_SALDO, VL_FATURA, VL_CREDITO_LIMITE FROM USUARIO U, CONTA C WHERE U.NR_CPF = ? AND U.NR_CPF = C.NR_CPF";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, cpf);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				response = rs.getString("NM_USUARIO") + "-" + rs.getDouble("VL_SALDO") + "-" + rs.getDouble("VL_FATURA") + "-" + rs.getDouble("VL_CREDITO_LIMITE");
			}

			ps.close();
			rs.close();
			conn.close();

			return response;
		} catch (SQLException e) {
			return e.getMessage();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String verifyBalance(String cpf, double value) {
		String sql = "SELECT * FROM CONTA WHERE VL_SALDO >= ? AND NR_CPF = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setDouble(1, value);
			ps.setString(2, cpf);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return pixPay(cpf, value);
			}

			return response;
		} catch(Exception e) {
			return e.getMessage();
		}
	}

	public String pixPay(String cpf, double value) {
		String sql = "UPDATE CONTA SET VL_SALDO = VL_SALDO - ? WHERE NR_CPF = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setDouble(1, value);
			ps.setString(2, cpf);

			ps.execute();

			ps.close();
			conn.close();

			return response;
		} catch (SQLException e) {
			return e.getMessage();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String verifyLimit(String cpf, double value) {
		String sql = "SELECT * FROM CONTA WHERE VL_CREDITO_LIMITE >= ? AND NR_CPF = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setDouble(1, value);
			ps.setString(2, cpf);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return creditPay(cpf, value);
			}

			return response;
		} catch(Exception e) {
			return e.getMessage();
		}
	}

	public String creditPay(String cpf, double value) {
		String sql = "UPDATE CONTA SET VL_FATURA = VL_FATURA + ?, VL_CREDITO_LIMITE = VL_CREDITO_LIMITE - ? WHERE NR_CPF = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setDouble(1, value);
			ps.setDouble(2, value);
			ps.setString(3, cpf);

			ps.execute();

			ps.close();
			conn.close();

			return response;
		} catch (SQLException e) {
			return e.getMessage();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String deposit(String cpf, double value) {
		String sql = "UPDATE CONTA SET VL_SALDO = VL_SALDO + ? WHERE NR_CPF = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setDouble(1, value);
			ps.setString(2, cpf);

			ps.execute();

			ps.close();
			conn.close();

			return response;
		} catch (SQLException e) {
			return e.getMessage();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String payInvoice(String cpf, double value) {
		String sql = "UPDATE CONTA SET VL_FATURA = VL_FATURA - ?, VL_CREDITO_LIMITE = VL_CREDITO_LIMITE + ? WHERE NR_CPF = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setDouble(1, value);
			ps.setDouble(2, value);
			ps.setString(3, cpf);

			ps.execute();

			ps.close();
			conn.close();

			return response;
		} catch (SQLException e) {
			return e.getMessage();
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
