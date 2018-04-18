package cn.steve.security.core.validate.code.sms;

import cn.steve.security.core.validate.code.ValidateCode;

import java.time.LocalDateTime;

/**
 * Created By SteveWoo
 */
public class SmsCode extends ValidateCode {
    public SmsCode(String code, int expireIn) {
        super(code, expireIn);
    }

    public SmsCode(String code, LocalDateTime expireTime) {
        super(code, expireTime);
    }
}
