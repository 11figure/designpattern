/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 23:38 2018/7/11
 * @Modified By:
 */
public class OrvKing {

    RequestHandler handlerChain;

    public OrvKing() {
       buildChain();
    }

    private void buildChain() {
        handlerChain =  new OrcCommander(new OrcOfficer(new OrcSoldier(null)));
    }

    public OrvKing(RequestHandler requestChain) {
        this.handlerChain = requestChain;
    }

    public void setHandlerChain(RequestHandler handlerChain) {
        this.handlerChain = handlerChain;
    }

    public void makeRequest(Request request) {
        handlerChain.handleRequest(request);
    }
}
