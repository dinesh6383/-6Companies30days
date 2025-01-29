package GoldmanSachs;

public class Number_Of_People_Aware_Of_Secret {
    public static int peopleAwareOfSecret(int n, int delay, int forget) {
        int m = 1000000007;
         long ans = 0;
         
         int[] dayTracker = new int[forget];
         
         dayTracker[0] = 1;
         
         for(int day = 2; day <= n ; day++){             
             for(int i = forget -1; i > 0 ; i--){
                 dayTracker[i] = dayTracker[i-1]; 
             }
             dayTracker[0] = 0;
             
             for(int i = delay; i < forget ; i++){
                 dayTracker[0] = (dayTracker[0]+dayTracker[i]) % m;
             }
         }
         
         for(int i  = 0; i < forget ; i++){
             ans+= dayTracker[i];
         }
         
         return (int)(ans % m); 
     }
    public static void main(String[] args) {
        int n = 6, delay = 2, forget = 4;
        int result = peopleAwareOfSecret(n, delay, forget);
        System.out.println(result);
    }
}
