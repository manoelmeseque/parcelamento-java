package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contrato;
import model.entities.Prestacao;
import model.service.PaypalTaxPagamento;
import model.service.ServiceContrato;

public class Main {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Entre com as informções do Contrato");
		System.out.print("Numero: ");
		int numero = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy) ");
		sc.nextLine();
		Date data = sdf.parse(sc.nextLine());
		System.out.print("Valor do Contrato: R$");
		double valorTotal = sc.nextDouble();
		
		Contrato contratos = new Contrato(numero, data, valorTotal);
		System.out.println("Quantos meses");
		int p = sc.nextInt();
		ServiceContrato serviceContrato = new ServiceContrato(new PaypalTaxPagamento());
		serviceContrato.processContrato(contratos, p);
		
		System.out.println("Mensalidades");
		for(Prestacao x: contratos.getList()) {
			System.out.println(x);
		}
	}

}
