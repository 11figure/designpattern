import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 21:55 2018/7/11
 * @Modified By:
 */
public class FlyingEnhantment implements Enhantmant {
    private static final Logger LOGGER = LoggerFactory.getLogger(FlyingEnhantment.class);

    @Override
    public void onActivate() {
        LOGGER.info("with FLyingEnhantment onActive");
    }

    @Override
    public void apply() {
        LOGGER.info("with FLyingEnhantment apply()");
    }

    @Override
    public void onDeactive() {
        LOGGER.info("with FLyingEnhantment ");
    }
}
