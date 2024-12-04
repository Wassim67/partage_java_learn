package controller;

public class ChildController implements IController{
    private IController parentController;

    public void setParentController(IController parentController){
        this.parentController = parentController;
    }
}
