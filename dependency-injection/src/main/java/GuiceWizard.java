/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 1:16 2018/7/18
 * @Modified By:
 */
public class GuiceWizard implements Wizard {

    public Tobacoo tobacoo;

    public GuiceWizard(Tobacoo tobacoo) {
        this.tobacoo = tobacoo;
    }

    @Override
    public void smoke() {
        tobacoo.smoke(this);
    }
}
