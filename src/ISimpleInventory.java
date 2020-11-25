import java.util.ArrayList;

public interface ISimpleInventory {

    void load(ILoadable loadable);

    void unload(boolean firstInFirstOut);

    ArrayList<ILoadable> getCarriedTransportables();

    int getCarsMaxAmount();

}
