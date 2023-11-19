package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDAO {
	private Connection conn;
	public String response = "Usuário já existente";

	public RegisterDAO() {
		this.conn = ConnectionManager.getInstance().getConnection();
	}

	public String verifyUser(String cpf, String name, String password, String birth, String email, String cel) {

		String sql = "SELECT * FROM USUARIO WHERE NR_CPF = ? AND DS_SENHA = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, cpf);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (!rs.next()) {
				ps.close();
				rs.close();
				signUpUser(cpf, name, password, birth, email, cel);
				return "";
			} else {
				return response;
			}
		} catch (SQLException e) {
			return e.getMessage();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String signUpUser(String cpf, String name, String password, String birth, String email, String cel) {

		String sql = "INSERT INTO USUARIO (NR_CPF, NM_USUARIO, DS_SENHA, DT_NASCIMENTO, DS_EMAIL, NR_TELEFONE) VALUES (?,?,?,?,?,?);";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, cpf);
			ps.setString(2, name);
			ps.setString(3, password);
			ps.setString(4, birth);
			ps.setString(5, email);
			ps.setString(6, cel);

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
