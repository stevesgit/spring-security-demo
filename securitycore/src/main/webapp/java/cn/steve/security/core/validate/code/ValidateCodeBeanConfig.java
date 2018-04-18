package cn.steve.security.core.validate.code;

import cn.steve.security.core.properties.SecurityProperties;
import cn.steve.security.core.validate.code.ValidateCodeGenerator;
import cn.steve.security.core.validate.code.image.ImageCodeGenerator;
import cn.steve.security.core.validate.code.sms.DefaultSmsCodeSender;
import cn.steve.security.core.validate.code.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created By SteveWoo
 */
@Configuration
public class ValidateCodeBeanConfig {
    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    @ConditionalOnMissingBean(name = "imageCodeGenerator")
    public ValidateCodeGenerator imageCodeGenerator() {
        ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
        codeGenerator.setSecurityProperties(securityProperties);
        return codeGenerator;
    }

    //    @Bean
//    @ConditionalOnMissingBean(SmsCodeSender.class)
//    public SmsCodeSender() {
//        new
//    }
    @Bean
    @ConditionalOnMissingBean(SmsCodeSender.class)
    public SmsCodeSender smsCodeSender() {
        return new DefaultSmsCodeSender();
    }

}
