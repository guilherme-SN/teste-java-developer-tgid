package br.com.tgid.teste_java_developer.dto;

import java.math.BigDecimal;

import br.com.tgid.teste_java_developer.models.Tax;

public class TaxDTO {
    private String type;
    private BigDecimal percentual;

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

    public Tax toTax() {
        return new Tax(this.type, this.percentual);
    }
}
