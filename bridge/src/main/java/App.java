/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 21:58 2018/7/11
 * @Modified By:
 */
public class App {

    public static void main(String[] args) {
        Sword sword = new Sword(new FlyingEnhantment());
        sword.wield();
        sword.swing();
        sword.unwield();
        Hammer hammer = new Hammer(new SoulEatingEnhantment());
        hammer.wield();
        hammer.swing();
        hammer.unwield();
    }

}
