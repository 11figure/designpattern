import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 0:44 2018/7/18
 * @Modified By:
 */
public class TaskImpl extends Task {

    public static final Logger logger = LoggerFactory.getLogger(TaskImpl.class);
    @Override
    protected void execute() {
        logger.info("execute task");
    }
}
