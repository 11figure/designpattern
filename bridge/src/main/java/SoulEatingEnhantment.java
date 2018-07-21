import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 21:55 2018/7/11
 * @Modified By:
 */
public class SoulEatingEnhantment implements Enhantmant {
    private static final Logger LOGGER = LoggerFactory.getLogger(SoulEatingEnhantment.class);

    @Override
    public void onActivate() {
        LOGGER.info("with SoulEatingEnhantment onActive");
    }

    @Override
    public void apply() {
        LOGGER.info("with SoulEatingEnhantment apply()");
    }

    @Override
    public void onDeactive() {
        LOGGER.info("with SoulEatingEnhantment ");
    }
}
