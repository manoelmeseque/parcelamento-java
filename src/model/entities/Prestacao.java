package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Prestacao {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Date vencData;
	private Double montante;
	
	public Prestacao() {
		
	}

	public Prestacao(Date vencData, Double montante) {
		this.vencData = vencData;
		this.montante = montante;
	}

	public Date getVencData() {
		return vencData;
	}

	public void setVencData(Date vencData) {
		this.vencData = vencData;
	}

	public Double getMontante() {
		return montante;
	}

	public void setMontante(Double montante) {
		this.montante = montante;
	}
	
	@Override
	public String toString() {
		return sdf.format(vencData) + " - " + String.format("%.2f", montante);
	}
	
	
	
	
}
