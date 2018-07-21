/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 0:15 2018/7/12
 * @Modified By:
 */
public class OrcCommander extends RequestHandler{


    public OrcCommander(RequestHandler requestHandler) {
        super(requestHandler);
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getRequestType().equals(RequestType.DEFEND_CASTLE)) {
            printHandling(request);
            request.markHandled();
        } else {
            super.handleRequest(request);
        }
    }

    @Override
    public String toString() {
        return "Orc Commander";
    }
}
