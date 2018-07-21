/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 23:14 2018/7/11
 * @Modified By:
 */
public class App {

    public static void main(String[] args) {
        Captain captain = new Captain(new FishingBoatAdapter());
        captain.row();
    }
}
