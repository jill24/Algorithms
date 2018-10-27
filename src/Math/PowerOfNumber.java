package Math;

public class PowerOfNumber {
    public static void main(String[] args){
        int num = 2;
        int pow = 5;
        System.out.println(" power of numbe:"+num+" to "+pow +" is "+ computePower(num, pow));
        num = 5;
        pow = 2;
        System.out.println(" power of numbe:"+num+" to "+pow +" is "+ computePower(num, pow));
    }
    // time and space complexity: log(n)

    private static int computePower(int num, int pow) {
        int result = power(Math.abs(num), pow);

        // to handle negative power
        if(pow < 0){
            return 1/result;
        }
        return result;
    }

    private static int power(int num, int power){
        if(power == 0){
            return 1;
        }
        if(power == 1){
            return num;
        }

        if(power % 2 >0){
            return num * power(num, power/2) *  power(num, power/2);
        }else{
            return power(num, power/2) * power(num, power/2);
        }
    }
}
