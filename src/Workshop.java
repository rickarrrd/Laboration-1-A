import java.util.ArrayList;

public class Workshop {

    private VehicleCarrierBedHelper vehicleCarrierBedHelper;
    private int vehicleMaxAmount;
    ArrayList<String> whitelistedCarModels;
    public Workshop(int vehicleMaxAmount, ArrayList<String> whitelistedCarModels){
        this.vehicleCarrierBedHelper = new VehicleCarrierBedHelper(this);
        this.vehicleMaxAmount=vehicleCarrierBedHelper.setVehicleMaxAmount(vehicleMaxAmount);
        this.whitelistedCarModels=whitelistedCarModels
    }


}
