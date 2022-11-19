package com.example.ropa.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("pants")
public class Pantalones {

	@Id
	private Long id;
	private String nombre;
	private String talla;
	private Float precio;
	private String color;
	private Long categoriaId;

	public Pantalones(Long id, String nombre, String talla, Float precio, String color, Long categoriaId) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.talla = talla;
		this.precio = precio;
		this.color = color;
		this.categoriaId = categoriaId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Long getCategoria() {
		return categoriaId;
	}

	public void setCategoria(Long categoria) {
		this.categoriaId = categoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoriaId, color, id, nombre, precio, talla);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pantalones other = (Pantalones) obj;
		return Objects.equals(categoriaId, other.categoriaId) && Objects.equals(color, other.color)
				&& Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(precio, other.precio) && Objects.equals(talla, other.talla);
	}

	@Override
	public String toString() {
		return "Pantalones [id=" + id + ", nombre=" + nombre + ", talla=" + talla + ", precio=" + precio + ", color="
				+ color + ", categoria=" + categoriaId + "]";
	}

}
