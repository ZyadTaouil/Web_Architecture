// pas utilisée
public class IHM implements InterfaceCalculatrice {
	static double operandeGauche;
	static double operandeDroite;
	static String operation;
	
	public IHM(int operandeGauche, String operation, int operandeDroite) {
		this.operandeGauche = operandeGauche;
		this.operation = operation;
		this.operandeDroite = operandeDroite;
	}
	
	
	public static double getOperandeGauche() {
		return operandeGauche;
	}


	public void setOperandeGauche(int operandeGauche) {
		this.operandeGauche = operandeGauche;
	}


	public static double getOperandeDroite() {
		return operandeDroite;
	}


	public void setOperandeDroite(int operandeDroite) {
		this.operandeDroite = operandeDroite;
	}


	public static String getOperation() {
		return operation;
	}


	public void setOperation(String operation) {
		this.operation = operation;
	}

	// pas utilisée
	@Override
	public void displayResult(String message) {
		System.out.println(message);
	}
}


	