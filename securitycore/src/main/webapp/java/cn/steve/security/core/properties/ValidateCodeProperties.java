package cn.steve.security.core.properties;

/**
 * Created By SteveWoo
 */
public class ValidateCodeProperties {
    private ImageCodeProperties image = new ImageCodeProperties();
    private BrowserProperties browser = new BrowserProperties();

    public ImageCodeProperties getImage() {
        return image;
    }

    public void setImage(ImageCodeProperties image) {
        this.image = image;
    }

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }
}
