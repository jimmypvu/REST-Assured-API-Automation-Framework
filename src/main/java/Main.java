public class Main {
    public static void main(String[] args) {
        CoinFinder cf = new CoinFinder();
        int[] coins ={3,7,405,436};
        int target = 8839;

        int result = cf.coinChange(coins, target);
        System.out.println(result);
    }
}
