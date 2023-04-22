
public class additionModel implements InterfaceOperation {
	
	@Override 
	public double Calculer(double operandeGauche, double operandeDroite) {
		double result=operandeGauche+operandeDroite;
		return result;
	}
}
