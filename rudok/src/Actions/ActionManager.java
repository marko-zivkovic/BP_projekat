package Actions;



public class ActionManager {
    NewAction newAction;
    InfoAction infoAction;
    DodajCvorAkcija dodajCvorAkcija;
    RenameAutorAction renameAutorAction;
    NovaSlikaAction novaSlikaAction;

    public ActionManager() {
        this.newAction = new NewAction();
        this.infoAction = new InfoAction();
        this.dodajCvorAkcija = new DodajCvorAkcija();
        this. renameAutorAction = new RenameAutorAction();
        this.novaSlikaAction = new NovaSlikaAction();
    }

    public NovaSlikaAction getNovaSlikaAction() {
        return novaSlikaAction;
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

    public void setInfoAction(InfoAction infoAction) {
        this.infoAction = infoAction;
    }

    public DodajCvorAkcija getDodajCvorAkcija() {
        return dodajCvorAkcija;
    }

    public void setDodajCvorAkcija(DodajCvorAkcija dodajCvorAkcija) {
        this.dodajCvorAkcija = dodajCvorAkcija;
    }

    public RenameAutorAction getRenameAutorAction() {
        return renameAutorAction;
    }

    public void setRenameAutorAction(RenameAutorAction renameAutorAction) {
        this.renameAutorAction = renameAutorAction;
    }
}
