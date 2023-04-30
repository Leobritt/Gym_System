package model;

public class GymMember {
	private Integer id;
	
	private String nome;
	
	private String sexo;
	
	private String peso;
	
	public GymMember() {
		super();
	}

	public GymMember(Integer id, String nome, String sexo, String peso) {
		super();
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.peso = peso;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}
	
}
