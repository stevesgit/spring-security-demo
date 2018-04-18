package cn.steve.security.browser.support;

/**
 * Created By SteveWoo
 */
public class SimpleResponse {
    private Object content;

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public SimpleResponse(Object content) {

        this.content = content;
    }


}
