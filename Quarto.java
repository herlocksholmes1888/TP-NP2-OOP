package hotel_california;

public class Quarto {
	private int numero;
	private boolean disponivel;
	private Cliente nomeCliente;
	
	public Quarto(int numero, boolean disponivel) {
		this.setNumero(numero);
		this.setDisponivel(disponivel);
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}
	
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public boolean isDisponivel() {
		return disponivel;
	}
	
	public void setNomeCliente(Cliente nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Cliente getNomeCliente() {
		return nomeCliente;
	}
	
	public String getNomeClienteString() {
		return nomeCliente.getNome();
	}
	
	public void reservarQuarto(Cliente cliente) throws AlreadyOccupiedRoomException {
		try {
			boolean disponivel = isDisponivel();
			if (disponivel == false) {
				throw new AlreadyOccupiedRoomException("Erro: o quarto que você escolheu já está ocupado por outra pessoa. Por favor, escolha outro.");
			} else {
				this.setNomeCliente(cliente);
				setDisponivel(false);
			}
		} catch (AlreadyOccupiedRoomException e) {
			throw e;
		}
	}
	
	public void liberarQuarto() {
		this.setNomeCliente(null);
		setDisponivel(true);
	}
	
	public class AlreadyOccupiedRoomException extends Exception {
		private static final long serialVersionUID = 4187372206285427065L;
		public AlreadyOccupiedRoomException(String message) {
			super(message);
		}
	}
}
