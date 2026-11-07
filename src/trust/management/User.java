package trust.management;

import java.util.ArrayList;

public class User {

    public int intUserId;
    public int intUserHedId;
    public double doubleHedOfUserId;
    public int numOfDevicesForUser;
    public double doubleUserId;
    

    public enum userStatus {badUser, goodUser};
    public userStatus userstatus;
    
    public double ownerCooperativeness;
    
    public ArrayList<Integer> userFriend = new ArrayList<>();
    
    public ArrayList<Double> userSIoT = new ArrayList<>();
    public ArrayList<Double> userSimilarity = new ArrayList<>();
    
    public ArrayList<Device> userDevices = new ArrayList<>();
}
