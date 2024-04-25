package hotel_california;

public class Cliente {
	private String nome;
	private boolean fezCheckIn;
	
	public Cliente(String nome, boolean fezCheckIn) {
		this.setNome(nome);
		this.setFezCheckIn(fezCheckIn);
	}

	public void setFezCheckIn(boolean fezCheckIn) {
		this.fezCheckIn = fezCheckIn;
	}
	
	public boolean isFezCheckIn() {
		return fezCheckIn;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
