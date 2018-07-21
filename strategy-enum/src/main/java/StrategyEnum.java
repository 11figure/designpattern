/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 22:08 2018/7/1
 * @Modified By:
 */
public enum StrategyEnum {
    A{
        @Override
        int caculate(int x ,int y){
            System.out.println("caculate A Style");
            return x + y;
        }
    },
    B{
        @Override
        int caculate(int x ,int y){
            System.out.println("caculate B Style");
            return x * 10 + y * 10;
        }
    };

    int caculate(int x ,int y){
        return 0;
    };
}
