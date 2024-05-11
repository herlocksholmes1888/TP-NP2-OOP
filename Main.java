package hotel_california;

import hotel_california.Quarto.AlreadyOccupiedRoomException;
import hotel_california.Quarto.CheckOutWithoutCheckInException;

import java.time.LocalDate;

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
		Cliente jean = new Cliente("Jean-Jacques Yves Desmoulins", false);
		Cliente flavia = new Cliente("Flávia Nunes Afonseca", false);
		
		// Reservas confirmadas
		try {
			q110.reservarQuarto(marcos, LocalDate.of(2024, 6, 15), LocalDate.of(2024, 6, 30));
			q111.reservarQuarto(luciana, LocalDate.of(2024, 6, 16), LocalDate.of(2024, 5, 10));
			q112.reservarQuarto(marisete, LocalDate.of(2024, 12, 1), LocalDate.of(2025, 1, 30));
		} catch (AlreadyOccupiedRoomException e) {
			e.printStackTrace();
		}
		
		// Clientes que fizeram checkOut
		try {
			q111.liberarQuarto();
		} catch(CheckOutWithoutCheckInException e) {
			e.printStackTrace();
		}
		
		// AlreadyOccupiedRoomException
		try {
			q112.reservarQuarto(flavia, LocalDate.of(2025, 7, 14), LocalDate.of(2025, 8, 19));
		} catch(AlreadyOccupiedRoomException e) {
			e.printStackTrace();
		}
	}
}
