package com.code;

public class BitManipulation {

    public static void main(String[] args) {
        extractBit(22,4);
        System.out.println(setBit(21,4));   //29
        System.out.println(resetBit(21,3)); //17
        System.out.println(rightmostSetBit(8)); //4
        System.out.println(addOne(8)); //9
        System.out.println(magicNo(5)); //130
        System.out.println(pascalSum(3)); //7
        System.out.println(isPowerOfTwo(16)); //true
    }

    public static void extractBit(int n, int i){
        int mask = 1;

        mask = mask << i;

        n = n & mask;

        if(n != 0){
            System.out.println((i+1) + "th bit is 1");
        }
        else{
            System.out.println((i+1) + "th bit is 0");
        }
    }

    public static int setBit(int n, int i){
        int mask = 1;

        mask = mask << (i-1);

        n = n | mask;

        return n;
    }

    public static int resetBit(int n, int i){
        int tmask = 1;

        tmask = ~(1 << (i-1));


        n = n & tmask;

        return n;
    }

    public static int rightmostSetBit(int n){

        int pos = 1;

        int mask = 1;

        while((n & mask) == 0){
            pos++;
            mask = mask << 1;
        }
        return pos;
    }

    public static int addOne(int n){
        int mask = 1;

        //Condition used is exactly opposite to the one used in rightmostSetBit
        while((n & mask) != 0){

            //Used to reset all 1s unless a 0 bit is found
            n = n ^ mask;

            mask = mask << 1;
        }
        n = n ^ mask; //to set the rightmost 0 bit after all 1s have been reset in the loop
        return n;
    }

    public static int magicNo(int n){
        int pow = 1;
        int ans = 0;

        while(n != 0){
            pow = pow * 5;

            if((n & 1) == 1){
                ans += pow;
            }

            n = n >> 1;
        }
        return ans;
    }

    public static int pascalSum(int n){
        int ans = 1 << n;

        return (ans - 1);
    }

    public static boolean isPowerOfTwo(int n){

        if(n != 0){
            if((n & (n -1)) == 0){
                return true;
            }
        }
        return false;

    }
}
