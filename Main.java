package hotel_california;

import hotel_california.Quarto.AlreadyOccupiedRoomException;

public class Main {

	public static void main(String[] args) {
		// Quartos disponíveis
		Quarto q110 = new Quarto(110, true);
		Quarto q111 = new Quarto(111, true);
		Quarto q112 = new Quarto(112, true);
		Quarto q113 = new Quarto(113, true);
		Quarto q114 = new Quarto(114, true);
		
		// Clientes hospedados
		Cliente marcos = new Cliente("Marcos Meireles da Silva Lopes", false);
		Cliente luciana = new Cliente("Luciana Carmo das Dores", false);
		Cliente marisete = new Cliente("Marisete Albuquerque Conceição", false);
		Cliente nilo = new Cliente("Nilo Gonzaga Freitas", false);
		Cliente jean = new Cliente("Jean-Jacques Yves Desmoulins", false);
		Cliente flavia = new Cliente("Flávia Nunes Afonseca", false);
		
		// Reservas confirmadas
		try {
			q110.reservarQuarto(marcos);
			q111.reservarQuarto(luciana);
			q112.reservarQuarto(marisete);
		} catch (AlreadyOccupiedRoomException e) {
			e.printStackTrace();
		}
	}
}
