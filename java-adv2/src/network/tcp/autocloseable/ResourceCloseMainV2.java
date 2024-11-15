package network.tcp.autocloseable;

public class ResourceCloseMainV2 {
    public static void main(String[] args) {
        try {
            logic();
        } catch (CallException e) {
            System.out.println("CallException 예외 처리");
            e.printStackTrace();
        } catch (CloseException e) {
            System.out.println("CloseException 예외 처리");
            e.printStackTrace();
        }
    }

    private static void logic() throws CloseException, CallException {
        ResourceV1 resource1 = null;
        ResourceV1 resource2 = null;

        try {
            // 객체 생성 시에도 예외가 발생할 수 있음 (ex: 존재하지 않는 파일)
            resource1 = new ResourceV1("resource1");
            resource2 = new ResourceV1("resource1");

            resource1.call();
            resource2.callEx();
        } catch (CallException e) {
            System.out.println("ex: " + e);
            throw e;
        } finally {
            System.out.println("자원 정리");
            if (resource2 != null) resource2.closeEx();
            if (resource1 != null) resource1.closeEx();
        }
    }
}
