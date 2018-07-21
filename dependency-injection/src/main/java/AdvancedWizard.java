/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 1:12 2018/7/18
 * @Modified By:
 */
public class AdvancedWizard implements Wizard {

    private Tobacoo tobacoo;

    @Override
    public void smoke() {
        tobacoo.smoke(this);
    }
}
