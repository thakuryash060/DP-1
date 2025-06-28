class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==0){
            return -1;
        }
        return recurse(coins,amount,0,0);
    }

    private int recurse(int coins[],int amount,int index,int coinUsed){
        if(index==coins.length || amount<0){
            return -1;
        }

        if(amount==0){
            return coinUsed;
        }


        int case1=recurse(coins,amount,index+1,coinUsed);
        int case2=recurse(coins,amount-coins[index],index,coinUsed+1);
        if(case1==-1){
            return case2;
        }
        if(case2==-1){
            return case1;
        }

    return Math.min(case1,case2);
    }
}
