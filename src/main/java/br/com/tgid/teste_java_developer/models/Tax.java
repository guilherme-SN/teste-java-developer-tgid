package br.com.tgid.teste_java_developer.models;

import java.math.BigDecimal;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Tax {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private BigDecimal percentual;

    @ManyToMany(mappedBy = "taxes")
    private Set<Company> companies;

    @Deprecated
    public Tax() { }

    public Tax(String type, BigDecimal percentual) {
        this.type = type;
        this.percentual = percentual;
    }

	public Long getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getPercentual() {
		return percentual;
	}

	public void setPercentual(BigDecimal percentual) {
		this.percentual = percentual;
	}
}
