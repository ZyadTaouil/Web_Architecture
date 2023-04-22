
public class Factory {

	public static InterfaceOperation initOperation(String operation) {
		Configuration.OperationConfiguration();
		return Configuration.operationMap.get(operation);
	}
}

