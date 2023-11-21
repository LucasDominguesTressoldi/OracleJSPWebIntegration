package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class RegisterDAO {
	private Connection conn;
	public String response = "Usuário já existente";

	public RegisterDAO() {
		this.conn = ConnectionManager.getInstance().getConnection();
	}

	public String verifyUser(String cpf, String name, String password, LocalDate birth, String email, String cel) {

		String sql = "SELECT * FROM USUARIO WHERE NR_CPF = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, cpf);

			ResultSet rs = ps.executeQuery();

			if (!rs.next()) {
				ps.close();
				rs.close();
				return signUpUser(cpf, name, password, birth, email, cel);
			} else {
				return response;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return e.getMessage();
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	public String signUpUser(String cpf, String name, String password, LocalDate birth, String email, String cel) {

		String sql = "INSERT INTO USUARIO (NR_CPF, NM_USUARIO, DS_SENHA, DT_NASCIMENTO, DS_EMAIL, NR_TELEFONE) VALUES (?,?,?,?,?,?)";

		try {
			Date birthDate = Date.valueOf(birth);

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, cpf);
			ps.setString(2, name);
			ps.setString(3, password);
			ps.setDate(4, birthDate);
			ps.setString(5, email);
			ps.setString(6, cel);

			ps.execute();

			ps.close();
			conn.close();

			return "";
		} catch (SQLException e) {
			return e.getMessage();
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
