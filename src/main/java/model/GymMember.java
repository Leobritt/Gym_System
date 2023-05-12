package model;

public class GymMember {
	private Integer id;
	
	private String name;
	
	private String sex;
	
	private String weight
;
	
	public GymMember() {
		super();
	}

	public GymMember(Integer id, String name, String sex, String weight) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.weight = weight;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String nome) {
		this.name = nome;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}
	
}
