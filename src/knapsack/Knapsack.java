package knapsack;

public class Knapsack {  
    public static void main(final String... args) {  
        int[] arr = new int[5];  
        arr[0] = 11;  
        arr[1] = 8;  
        arr[2] = 7;  
        arr[3] = 5;  
        arr[4] = 3;  
        Knapsack k = new Knapsack();  
        System.out.println(k.knapsack(arr, 0, 20, 20));  
    }  
  
    /** 
     *@param arr    all of items in knapsack 
     *@param start  the start item to be put into the knapsack 
     *@param left   the remaining capacity of knapsack 
     *@param sum    capacity of knapsack 
     */  
    public boolean knapsack(int[] arr, int start, int left, int sum) {  
  
        if (arr.length == 0) {  
            return false;  
        }  
  
        // start from the next item in original array  
        if (start == arr.length) {  
            int[] tempArr = new int[arr.length - 1];  
            for (int i = 0; i < tempArr.length; i++) {  
                tempArr[i] = arr[i + 1];  
            }  
            return knapsack(tempArr, 0, sum, sum);  
        } else if (arr[start] > left) {  
            return knapsack(arr, start + 1, left, sum);  
        } else if (arr[start] == left) {  
            for (int i = 0; i < start + 1; i++) {  
                // print the answer out  
                System.out.print(arr[i] + "\t");  
            }  
            System.out.println();  
            return true;  
        } else {  
            return knapsack(arr, start + 1, left - arr[start], sum);  
        }  
    }  
} 
/**
问题描述：
有N件物品和一个容量为V的背包。第i件物品的费用是c，价值是w。求解将哪些物品装入背包可 使这些物品的费用总和不超过背包容量，且价值总和最大。 
基本思路：
这是最基础的背包问题，特点是：每种物品仅有一件，可以选择放或不放。 用子问题定义状态：即f[v]表示前i件物品恰放入一个容量为v的背包可以获得的最大价值。则 其状态转移方程便是：f[v]=max{f[v],f[v-c]+w}。
实现代码：
*/