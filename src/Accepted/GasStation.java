package Accepted;

public class GasStation {

	public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        if (length == 0)
            return -1;
        
        int totalGas = 0;
        int totalCost = 0;
        
        for (int i = 0; i < length; i ++) {
            totalGas = gas[i] + totalGas;
            totalCost = cost[i] + totalCost;
        }
        
        if (totalGas < totalCost)
            return -1;
            
        int start = 0;
        int end = 0;
        
        int gasLeft = 0;
        while (end - start < length) {
            if (gasLeft + gas[end % length] - cost[end % length] < 0) {
                start = ++ end;
                gasLeft = 0;
            } else {
                gasLeft = gasLeft + gas[end % length] - cost[end % length];
                ++ end;
            }
        }
        
        return start % length;
    }
	
	public static void main(String[] args) {
		int[] gas = {1, 2, 3, 3};
		int[] cost = {2, 1, 5, 1};
		
		GasStation service = new GasStation();
		System.out.println(service.canCompleteCircuit(gas, cost));
	}
}
