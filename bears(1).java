//Kyle Morgan
//This code just checks if its possible to win the bear game.

public static boolean bears(int n){
    if (n < 42){
        return false; 
    }
    if (n == 42){
        return true;
    }else{
    // 1. if n is divisible by 5
        if(n % 5 == 0){
            if(bears(n-42)){ //n = n-42
                return true;
            }
        }
    // 2. If n is even
        if(n % 2 == 0){
            if(bears(n / 2)){
                return true;
            }
        }
    // 3. If n is divisible by 3 or 4
        if(n % 3 ==  0 || n % 4 == 0){
            int lastDig = n % 10;
            int secondDig = ((n % 100)/10);
            int prod = lastDig * secondDig;

            if(bears(n - prod)){
                return true;
            }
        }
        return false;
    }
}