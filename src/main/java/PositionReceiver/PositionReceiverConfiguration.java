package PositionReceiver;

public class PositionReceiverConfiguration {

    public PositionReceiverFacade positionReceiverFacade() {
        return new PositionReceiverFacade();
    }

    public PositionReceiverFacade positionReceiverFacadeTest() {
        return new PositionReceiverFacade();
    }
}
