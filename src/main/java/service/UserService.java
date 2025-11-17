package service;

import io.grpc.stub.StreamObserver;
import stub.UserGrpc;
import stub.UserOuterClass.*;

public class UserService extends UserGrpc.UserImplBase {
    @Override
    public void login(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
        String username=request.getUserName();
        String password=request.getPassWord();
        LoginResponse.Builder response= LoginResponse.newBuilder();
        if(username.equals(password)) {
            response.setIdResponse(0).setMsgResponse("SUCCES");
        }
        else
            response.setIdResponse(100).setMsgResponse("NON VALIDE");
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
