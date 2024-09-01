package br.com.tgid.teste_java_developer.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import br.com.tgid.teste_java_developer.enums.TransactionType;

public class TransactionRequest {
    @NotNull
    private Long clientId;
    @NotNull
    private Long companyId;
    @NotNull
    private TransactionType type;
    @NotNull
    @DecimalMin("0")
    private BigDecimal amount;

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}
