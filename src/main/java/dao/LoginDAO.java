package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

	private Connection conn;
	public String response = "Dados Inválidos!";

	public LoginDAO() {
		this.conn = ConnectionManager.getInstance().getConnection();
	}

	public String loginUser(String cpf, String password) {

		String sql = "SELECT * FROM USUARIO WHERE NR_CPF = ? AND DS_SENHA = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, cpf);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				response = "";
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
}
