/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 0:43 2018/7/18
 * @Modified By:
 */
public abstract class Task {
    public void executewith(Callback callback) {
        execute();
        if(null != callback){
            callback.call();
        }
    }

    protected abstract void execute();

}
