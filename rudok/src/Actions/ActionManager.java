package Actions;



public class ActionManager {
    NewAction newAction;
    InfoAction infoAction;
    DodajCvorAkcija dodajCvorAkcija;
    RenameAutorAction renameAutorAction;
    NovaSlikaAction novaSlikaAction;
    BrisanjeCvoraAction brisanjeCvoraAction;
    PravougaonikA pravougaonikA;
    BojaA bojaA;
    EditSlotAction editSlotAction;
    SlideShowActuin slideShowActuin;
    DodajCvorAkcijaFactory dodajCvorAkcijaFactory;
    VelicinaStrokeA velicinaStrokeA;
    EditSlajdAction editSlajdAction;
    StartState startState;
    RedoAction redoAction;
    UndoAction undoAction;
    SaveAction saveAction;
    OpenAction openAction;

    public ActionManager() {
        this.newAction = new NewAction();
        this.infoAction = new InfoAction();
        this.dodajCvorAkcija = new DodajCvorAkcija();
        this. renameAutorAction = new RenameAutorAction();
        this.novaSlikaAction = new NovaSlikaAction();
        this.brisanjeCvoraAction = new BrisanjeCvoraAction();
        this.pravougaonikA = new PravougaonikA();
        this.bojaA = new BojaA();
        this.editSlotAction = new EditSlotAction();
        this.slideShowActuin = new SlideShowActuin();
        this.dodajCvorAkcijaFactory = new DodajCvorAkcijaFactory();
        this.velicinaStrokeA = new VelicinaStrokeA();
        this.editSlajdAction = new EditSlajdAction();
        this.startState = new StartState();
        this.redoAction = new RedoAction();
        this.undoAction = new UndoAction();
        this.saveAction = new SaveAction();
        this.openAction = new OpenAction();
    }

    public BrisanjeCvoraAction getBrisanjeCvoraAction() {
        return brisanjeCvoraAction;
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

    public PravougaonikA getPravougaonikA() {
        return pravougaonikA;
    }

    public BojaA getBojaA() {
        return bojaA;
    }

    public EditSlotAction getEditSlotAction() {
        return editSlotAction;
    }

    public SlideShowActuin getSlideShowActuin() {
        return slideShowActuin;
    }

    public DodajCvorAkcijaFactory getDodajCvorAkcijaFactory() {
        return dodajCvorAkcijaFactory;
    }

    public VelicinaStrokeA getVelicinaStrokeA() {
        return velicinaStrokeA;
    }

    public EditSlajdAction getEditSlajdAction() {
        return editSlajdAction;
    }

    public StartState getStartState() {
        return startState;
    }
    public RedoAction getRedoAction() {
        return redoAction;
    }
    public UndoAction getUndoAction() {
        return undoAction;
    }
    public SaveAction getSaveAction() {return saveAction;}
    public OpenAction getOpenAction() {return openAction;}
}
