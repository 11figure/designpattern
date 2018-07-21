/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 0:15 2018/7/12
 * @Modified By:
 */
public class OrcOfficer extends RequestHandler{


    public OrcOfficer(RequestHandler requestHandler) {
        super(requestHandler);
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getRequestType().equals(RequestType.COLLECT_TAX)) {
            printHandling(request);
            request.markHandled();
        } else {
            super.handleRequest(request);
        }
    }

    @Override
    public String toString() {
        return "Orc Officer";
    }
}
