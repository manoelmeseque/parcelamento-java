package model.service;

public interface TaxPagamento {
	double juros(double montante, int meses);
	double taxaPagamento(double montante);
}
