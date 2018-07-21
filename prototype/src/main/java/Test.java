/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 23:25 2018/7/11
 * @Modified By:
 */
public class Test implements Cloneable {
    private String name;

    public Test(String name) {
        this.name = name;
    }

    public Test clone() {
        return new Test(this.name);
    }
}
