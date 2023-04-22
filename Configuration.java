import java.util.HashMap;
import java.util.Map;

public class Configuration {
private static String langue = "FR";

// hypothèse : Map avec pour type de valeurs InterfaceOperation accepte toutes les classes qui implementent interfaceOperation
public static Map<String, InterfaceOperation> operationMap= new HashMap<String, InterfaceOperation>();

public static void OperationConfiguration() {
	operationMap.put("+", new additionModel());
	operationMap.put("-", new soustractionModel());
	operationMap.put("*", new multiplicationModel());
	operationMap.put("/", new divisionModel());
}
}
