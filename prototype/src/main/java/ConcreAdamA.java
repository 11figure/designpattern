/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 23:19 2018/7/11
 * @Modified By:
 */
public class ConcreAdamA implements Adam {

    private String age;
    /**
     *
     * @return 浅拷贝
     */
    @Override
    public Adam copy() {
        return this;
    }
}
