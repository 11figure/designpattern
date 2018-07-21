/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 1:07 2018/7/12
 * @Modified By:
 */
public class Letter extends LetterComposite {

    private char c;

    public Letter(char c) {
        this.c = c;
    }

    @Override
    protected void printThisBefore() {
        System.out.println(c);
    }


}
