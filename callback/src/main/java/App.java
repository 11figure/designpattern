import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 0:46 2018/7/18
 * @Modified By:
 */
public class App {

    public static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {

        Callback  callback = () -> {
            LOGGER.info("callback doing");};
        Task task = new TaskImpl();
        task.executewith(callback);
    }
}
