package hanoi;

public class Hanoi {  
    /** 
     *  
     * @param n the count of tray
     * @param A original tray 
     * @param B assistant tray 
     * @param C destination tray 
     */ 
    public void hanoi(int n, char A, char B, char C) {  
        if (n == 1) {  
            move(A, C);  
        } else {  
            hanoi(n - 1, A, C, B);  
            move(A, C);  
            hanoi(n - 1, B, A, C);  
        }  
    }  
   
    // print moving routing  
    private void move(char A, char C) {  
        System.out.println("Direction:" + A + "--->" + C);  
    }  
   
    public static void main(String[] args) {  
        Hanoi hanoi = new Hanoi();  
        hanoi.hanoi(3, '1', '2', '3');  
    }  
}
