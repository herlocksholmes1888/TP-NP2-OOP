package hotel_california;

import java.time.LocalDate;

public class Quarto {
	private int numero;
	private boolean disponivel;
	private Cliente nomeCliente;
	private LocalDate dataCheckIn;
	private LocalDate dataCheckOut;
	private PeriodoQuartoIndisponivel periodoIndisponivel;
	
	public Quarto(int numero, boolean disponivel) {
		this.setNumero(numero);
		this.setDisponivel(disponivel);
	}
	
	// Responsável por administrar o número do quarto
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}
	
	// Responsável por dizer se o quarto está ou não está disponível para uso
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public boolean isDisponivel(LocalDate checkIn, LocalDate checkOut) {
		return disponivel;
	}
	
	// Responsável por atribuir um cliente a um quarto
	public void setNomeCliente(Cliente nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Cliente getNomeCliente() {
		return nomeCliente;
	}
	
	// Responsável por converter o nome do cliente para o tipo String, para que possa ser lido pelo responsável do sistema
	public String getNomeClienteString() {
		return nomeCliente.getNome();
	}
	
	// Responsável pela data de checkIn
	public void setDataCheckIn(LocalDate dataCheckIn) {
		this.dataCheckIn = dataCheckIn;
	}
	
	public LocalDate getDataCheckIn() {
		return dataCheckIn;
	}
	
	// Responsável pela data de checkOut
	public void setDataCheckOut(LocalDate dataCheckOut) {
		this.dataCheckOut = dataCheckOut;
	}

	public LocalDate getDataCheckOut() {
		return dataCheckOut;
	}
	
	// Responsável por guardar todos os dias em que o quarto estará indisponível devido a uma reserva
	public void setPeriodoIndisponivel(PeriodoQuartoIndisponivel periodoIndisponivel) {
		this.periodoIndisponivel = periodoIndisponivel;
	}
	
	public PeriodoQuartoIndisponivel getPeriodoIndisponivel() {
		return periodoIndisponivel;
	}
	
	// Responsável por reservar um quarto
	public void reservarQuarto(Cliente cliente, LocalDate dataCheckIn, LocalDate dataCheckOut) throws AlreadyOccupiedRoomException {
		try {
			// Verificar se a data de checkOut ocorre antes da data de checkIn/Verificar se a reserva está sendo feita para algum momento do futuro
			if(dataCheckIn.isBefore(LocalDate.now())) {
				throw new IllegalArgumentException("Erro: datas de reserva inválidas");
			}
			
			// Verificar se um quarto está atualmente disponível
			Quarto quarto = this;
			if (quarto.isDisponivel(dataCheckIn, dataCheckOut) == false) {
				throw new AlreadyOccupiedRoomException("Erro: O quarto que você escolheu está ocupado. Por favor, escolha outro.");
			}
			
			// Caso não esteja, realizar a reserva e atualizar o status do quarto como indisponível
			this.setNomeCliente(cliente);
			nomeCliente.setFezCheckIn(true);
			this.setDataCheckIn(dataCheckIn);
			this.setDataCheckOut(dataCheckOut);
			setDisponivel(false);
			
			// Período em que o quarto ficará indisponível
			PeriodoQuartoIndisponivel periodoReserva = new PeriodoQuartoIndisponivel(dataCheckIn, dataCheckOut);
			setPeriodoIndisponivel(periodoReserva);
			
		} catch (AlreadyOccupiedRoomException e) {
			throw e;
		}
	}
	
	// Responsável por liberar o quarto
	public void liberarQuarto() throws CheckOutWithoutCheckInException {
		try {
			if(nomeCliente.isFezCheckIn() == false) {
				throw new CheckOutWithoutCheckInException("Erro: Cliente nunca fez check-in");
			}
			
			this.setNomeCliente(null);
			setDisponivel(true);
		} catch(CheckOutWithoutCheckInException e) {
			throw e;
		}
	}

	// EXCEÇÕES
	public class AlreadyOccupiedRoomException extends Exception {
		private static final long serialVersionUID = 4187372206285427065L;
		public AlreadyOccupiedRoomException(String message) {
			super(message);
		}
	}
		
	public class CheckOutWithoutCheckInException extends Exception {
		private static final long serialVersionUID = -5405496225770011178L;
		public CheckOutWithoutCheckInException(String message) {
			super(message);
		}
	}
}
