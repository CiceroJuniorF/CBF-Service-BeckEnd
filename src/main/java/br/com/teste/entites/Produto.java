package br.com.teste.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.Gson;

@XmlRootElement
@Entity
public class Produto {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;

	/**
	 * @deprecated frameworks only
	 */
	public Produto() {
	}

	public Produto(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Product [id= " + id + " name= " + name + "]";
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

	public void setName(String name) {
		this.name = name;
	}

	public String toJson() {
		return new Gson().toJson(this);
	}

}
