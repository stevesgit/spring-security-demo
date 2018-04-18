package cn.steve.security.code;

import cn.steve.security.core.validate.code.ValidateCodeGenerator;
import cn.steve.security.core.validate.code.image.ImageCode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * Created By SteveWoo
 */
//@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {
    @Override
    public ImageCode generate(ServletWebRequest request) {
        System.out.println("验证码已经生产");
        return null;
    }
}
