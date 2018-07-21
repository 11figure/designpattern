import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 21:44 2018/7/11
 * @Modified By:
 */
public class Hammer implements Weapon {

    private static final Logger LOGGER = LoggerFactory.getLogger(Weapon.class);
    private final Enhantmant enhantmant;

    public Hammer(Enhantmant enhantmant) {
        this.enhantmant = enhantmant;
    }

    @Override
    public void wield() {
        LOGGER.info("The hammer is wield");
        enhantmant.onActivate();
    }

    @Override
    public void swing() {
        LOGGER.info("The hammer is swinged");
        enhantmant.apply();
    }

    @Override
    public void unwield() {
        LOGGER.info("The hammer is unwielded");
        enhantmant.onDeactive();
    }
}
