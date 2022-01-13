package lab212.xiaoyin.fmmalll.order.config;

import com.github.wxpay.sdk.WXPayConfig;

import java.io.InputStream;

/**
 * @author yinck
 * @version 1.0
 * @date 2022-01-10 01:02
 */
public class MyPayConfig implements WXPayConfig {
    @Override
    public String getAppID() {
        return "wx632c8f211f8122c6";
    }

    @Override
    public String getMchID() {
        return "1497984412";
    }

    @Override
    public String getKey() {
        return "sbNCm1JnevqI36LrEaxFwcaT0hkGxFnC";
    }

    @Override
    public InputStream getCertStream() {
        return null;
    }

    @Override
    public int getHttpConnectTimeoutMs() {
        return 0;
    }

    @Override
    public int getHttpReadTimeoutMs() {
        return 0;
    }
}
