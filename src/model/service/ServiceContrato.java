package model.service;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contrato;
import model.entities.Prestacao;

public class ServiceContrato {
	
		private TaxPagamento taxPagamento;

		public ServiceContrato() {
			
		}
		
		public ServiceContrato(TaxPagamento taxPagamento) {
			this.taxPagamento = taxPagamento;
		}

		
		public void processContrato(Contrato contrato, int meses){
			double valorBase = contrato.getValorTotal() / meses;
			
			for(int i = 1; i <= meses; i++) {
				Date d = addMes(contrato.getData(), i);
				double valorComJuros = valorBase + taxPagamento.juros(valorBase, i);
				double valorFinal = valorComJuros + taxPagamento.taxaPagamento(valorComJuros);
				
				contrato.addPrestacao(new Prestacao(d, valorFinal));
			}
		}
		
		public Date addMes(Date d, int i) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			cal.add(Calendar.MONTH, i);
			return cal.getTime();
		}
		
		
		
		
}
