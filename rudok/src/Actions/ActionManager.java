package Actions;



public class ActionManager {
    NewAction newAction;
    InfoAction infoAction;

    public ActionManager() {
        this.newAction = new NewAction();
        this.infoAction = new InfoAction();
    }

    public NewAction getNewAction() {
        return newAction;
    }

    public void setNewAction(NewAction newAction) {
        this.newAction = newAction;
    }

    public InfoAction getInfoAction() {
        return infoAction;
    }
}
