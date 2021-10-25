package Actions;

public class ActionManager {
    NewAction newAction;

    public ActionManager() {
        this.newAction = new NewAction();
    }

    public NewAction getNewAction() {
        return newAction;
    }

    public void setNewAction(NewAction newAction) {
        this.newAction = newAction;
    }
}
