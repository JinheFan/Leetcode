package OOD.ElevatorSystem;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
    private List<Button> buttons;
    private List<Integer> upStops;
    private List<Integer> downStops;
    private State state;
    private int level;
    private InternalRequest internalRequest;

    public Elevator( State state, int level, InternalRequest internalRequest) {
        this.buttons = new ArrayList<>();
        this.upStops = new ArrayList<>();
        this.downStops = new ArrayList<>();
        this.state = state;
        this.level = level;
        this.internalRequest = internalRequest;
    }

    private boolean isValidRequest(){
        //判断用户的请求是否是valid
        if(state == State.Up){

        }
        return true;
    }

    public void handleExternalRequest(ExternalRequest r){
        //电梯到达用户所在楼层
    }

    public void handleInternalRequest(InternalRequest r){
        //调用isValidRequest()方法， 处理当前请求
    }
}
