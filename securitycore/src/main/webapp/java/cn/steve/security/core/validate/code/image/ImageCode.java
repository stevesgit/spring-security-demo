/**
 *
 */
package cn.steve.security.core.validate.code.image;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;


/**
 * @author SteveWoo
 */
public class ImageCode {

    private BufferedImage image;
    private String code;
    private LocalDateTime expireTime;

    public ImageCode(BufferedImage image, String code, int expireIn) {
        this.image = image;
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        this.image = image;
        this.code = code;
        this.expireTime = expireTime;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }
    public boolean isExpried() {
        return LocalDateTime.now().isAfter(expireTime);
    }
}
