package cn.steve.security.core.validate.code.sms;

import cn.steve.security.core.properties.SecurityProperties;
import cn.steve.security.core.validate.code.ValidateCode;
import cn.steve.security.core.validate.code.ValidateCodeGenerator;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * Created By SteveWoo
 */

@Component("smsCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {
    @Autowired
    private SecurityProperties properties;

    @Override
    public ValidateCode generate(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(properties.getCode().getSms().getLength());
        return new SmsCode(code, properties.getCode().getSms().getExpireIn());
    }
}
