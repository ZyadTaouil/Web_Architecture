public class divisionModel implements InterfaceOperation {
	// ajouter exception pour division par 0
	@Override
	public double Calculer(double operandeGauche, double operandeDroite) {
		double result=operandeGauche / operandeDroite;
		return result;
	}
}
