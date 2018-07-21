import java.util.Objects;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 23:41 2018/7/11
 * @Modified By:
 */
public class Request {

    private final RequestType requestType;
    private final String requestDescription;
    private boolean handled;
    public Request(RequestType requestType, final String requestDescription) {
        this.requestType = Objects.requireNonNull(requestType);
        this.requestDescription = Objects.requireNonNull(requestDescription);
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public String getRequestDescription() {
        return requestDescription;
    }

    public void markHandled() {
        this.handled = true;
    }

    public boolean isHandled() {
        return this.handled;
    }

    @Override
    public String toString() {
        return getRequestDescription();
    }
}
