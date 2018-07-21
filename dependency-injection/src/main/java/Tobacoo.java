import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 1:11 2018/7/18
 * @Modified By:
 */
public abstract class Tobacoo {

    public static final Logger LOGGER = LoggerFactory.getLogger(Tobacoo.class);
    public  void smoke(Wizard wizard){
        LOGGER.info("{} smoking {}", wizard.getClass().getSimpleName(),
            this.getClass().getSimpleName());
    }
}
