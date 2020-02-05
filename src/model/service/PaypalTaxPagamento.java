package model.service;

public class PaypalTaxPagamento implements TaxPagamento {
	private static final double jurosMensal = 0.01;
	private static final double TaxaPagamento = 0.02;
	
	@Override
	public double juros(double montante, int meses) {
		return montante * (jurosMensal * meses);
	}
	
	@Override
	public double taxaPagamento(double montante) {
		return montante * TaxaPagamento;
	}
}
