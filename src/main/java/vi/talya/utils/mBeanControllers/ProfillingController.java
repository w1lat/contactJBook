package vi.talya.utils.mBeanControllers;

/**
 * Created by vitalii on 28.03.17.
 */
public class ProfillingController implements ProfillingControllerMBean{
    private boolean enable;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
