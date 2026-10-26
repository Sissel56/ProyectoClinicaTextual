package clases.sesion;

public abstract class Usuario {
	protected String nUsuario;
	protected String password;
	protected String nPersona;
	protected String perfil;
	
	
	
	
	public Usuario() {
		super();
	}

	public Usuario(String nUsuario, String password, String nPersona, String perfil) {
		super();
		this.nUsuario = nUsuario;
		this.password = password;
		this.nPersona = nPersona;
		this.perfil = perfil;
	}



	public String getnUsuario() {
		return nUsuario;
	}

	public void setnUsuario(String nUsuario) {
		this.nUsuario = nUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getnPersona() {
		return nPersona;
	}

	public void setnPersona(String nPersona) {
		this.nPersona = nPersona;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
}
