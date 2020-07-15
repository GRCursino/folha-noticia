package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "usuario")
public class Usuario{	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_user;
	@Column
	private String email;
	@Column
	private String senha;

    public Usuario(int id_user, String email, String senha) {
        this.id_user = id_user;
        this.email = email;
        this.senha = senha;
    }

    public Usuario() {
    }

	public int getId_user() {
		return this.id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}