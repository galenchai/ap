package knapsack;

public class KnapsackProblemTest {

	public static void main(String[] args) {  
        
        Sack[] bags = new Sack[] {  
                new Sack(2,13), new Sack(1,10),  
                new Sack(3,24), new Sack(2,15),  
                new Sack(4,28), new Sack(5,33),  
                new Sack(3,20), new Sack(1, 8)  
        };  
        int totalWeight = 12;  
        KnapsackProblem kp = new KnapsackProblem(bags, totalWeight);  
          
        kp.solve();  
        System.out.println(" -------- The solution of the instance of the knapsack: --------- ");  
        System.out.println("The best Value: " + kp.getBestValue());   
        System.out.println("The best Solution: ");  
        System.out.println(kp.getBestSolution());  
        System.out.println("The matrix of best values: ");  
        int[][] bestValues = kp.getBestValues();  
        for (int i=0; i < bestValues.length; i++) {  
            for (int j=0; j < bestValues[i].length; j++) {  
                System.out.printf("%-5d", bestValues[i][j]);  
            }  
            System.out.println();  
        }  
    }  
}

