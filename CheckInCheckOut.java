package hotel_california;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CheckInCheckOut {
	private Cliente cliente;
	private Quarto quarto;
	private LocalDate checkIn;
	private LocalDate checkOut;

	public CheckInCheckOut(Cliente cliente) {
		this.setCliente(cliente);
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public Quarto getQuatro() {
		return quarto;
	}
	
	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}
	
	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}
	
	public void realizarCheckIn() {
		try {
			  // Pergunta ao usuário qual quarto ele gostaria
			  Scanner scanner = new Scanner(System.in);
			  System.out.println("Digite a data que gostaria de fazer checkIn, no formato yyyy-mm-dd");
			  String dataCheckIn = scanner.next();
					
			  // Converte String para LocalDate
			  LocalDate checkIn = LocalDate.parse(dataCheckIn);
					
			  // Confirma a reserva
			  setCheckIn(checkIn);
			  System.out.println("Você reservou o quarto com sucesso!");
					
			  scanner.close();
			} catch (IllegalArgumentException e) {
			        System.out.println("Exception: " + e);
			} 
			  catch (DateTimeParseException e) {
			        System.out.println("Exception: " + e);
			}
	}
	
	public void realizarCheckOut() throws CheckOutWithoutCheckInException {
		try {
			if (!cliente.isFezCheckIn()) {
				throw new CheckOutWithoutCheckInException("Erro: cliente nunca fez check-in");
			} else {
			    try {
			    	// Pergunta ao usuário quando será o checkOut
					Scanner scanner = new Scanner(System.in);
					System.out.println("Digite a data que gostaria de fazer checkOut, no formato yyyy-mm-dd");
					String dataCheckOut = scanner.next();
					
					// Converte String para LocalDate
					LocalDate checkOut = LocalDate.parse(dataCheckOut);
					
					// Confirma o checkOut
					quarto.liberarQuarto();
					setCheckOut(checkOut);
					System.out.println("Você fez checkOut! Agradecemos sua preferência, e volte sempre!");
					
					scanner.close();
			      } 
			      catch (IllegalArgumentException e) {
			        System.out.println("Exception: " + e);
			      } 
			      catch (DateTimeParseException e) {
			    	System.out.println("Exception: " + e);
			      }
			}
		} catch(CheckOutWithoutCheckInException e) {
			throw e;
		}
	}
	
	// Exceções
	public class CheckOutWithoutCheckInException extends Exception {
		private static final long serialVersionUID = -5405496225770011178L;
		public CheckOutWithoutCheckInException(String message) {
			super(message);
		}
	}
}
