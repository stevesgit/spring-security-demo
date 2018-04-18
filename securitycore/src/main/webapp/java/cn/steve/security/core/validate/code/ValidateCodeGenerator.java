package cn.steve.security.core.validate.code;

import cn.steve.security.core.validate.code.image.ImageCode;
import org.springframework.web.context.request.ServletWebRequest;

public interface ValidateCodeGenerator {
    ImageCode generate(ServletWebRequest request);

}
