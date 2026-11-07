package trust.management;

import java.util.ArrayList;
import java.util.List;

public class Device {
    
    public TrustManagement m;
    
    public Device SpProvider;
    public int intDeviceId;
    public int intDeviceUserId;
    public int intDeviceHeadId;
    public double doubleDeviceId;
    public double doubleDeviceUserId;
    public double doubleDeviceHeadId;
    public User deviceUser;
    public int totalNumberOfDevices;
    public int totalNumberOfUsers;
    
    public int counter;
    public int timesOfRequest; 
    
    public enum nodeStatus {badNode, goodNode};
    public nodeStatus nodestatus;
    
    public boolean busy = false;
    public boolean recivedService;
    
    public double deviceCooperativeness;
    //srId 0, neighborRecTrust 1:[2]
    public ArrayList<double[]> srTrustToFirstNeighbor = new ArrayList<>();
    //srId 0, totalTrustForRecammander 1:[2]
    public ArrayList<double[]> totalTrustForRecammanderArray = new ArrayList<>();
    public double neighborRecTrust;
    public double wRecTemp;
    public double recTemp;
    
    public ArrayList<Integer> deviceFriend = new ArrayList<>();
    public ArrayList<Integer> location = new ArrayList<>();
    public ArrayList<Integer> sps = new ArrayList<>();
    public ArrayList<Integer> srs = new ArrayList<>();
    
    //j(SPId) 0,totalTrust 1,dirT 2,indT 3,firstT 4,recTrust 5,preInd =(recTrust+predictionTrust) 6, predictionTrust 7:[8]
    public ArrayList<double[]> trust = new ArrayList<>();

    //j(SPId)0,QoS 1,cooperativeness 2,honestySpOwner 3,honestyDevice 4,dir 5, dirT 6 :[7] 
    public ArrayList<double[]> dirTrustComponents = new ArrayList<>();

    //k(RecommenderId) 0,ownerk(intDeviceUserId) 1,j(SPId) 2,rec 3,honestyRecOwner 4:[5]   
//    public ArrayList<double[]> recommandationList = new ArrayList<>();
    //[4]
    public ArrayList<Integer> numberOfSpServicesList = new ArrayList<>();
    public ArrayList<Integer> numberOfRecommandList = new ArrayList<>();
    public ArrayList<double[]> spsQosList = new ArrayList<>();
    public ArrayList<double[]> spsCooperativenessList = new ArrayList<>();
    public ArrayList<double[]> recommanderHonestyList = new ArrayList<>();
    public ArrayList<Double> honestyList = new ArrayList<>();
    public ArrayList<Double> QosList = new ArrayList<>();
    public ArrayList<Double> CooList = new ArrayList<>();

    //0 cooperativenessTrus,1 QoSTrus,2 honestyTrus:[3]
    public List<double[]> ownerTrustList = new ArrayList<double[]>();
    public ArrayList<double[]> recommandationList = new ArrayList<>();
    
    public ArrayList<Device> spsWhoProvidedService = new ArrayList<>();
    public ArrayList<Device> deviceNeighbors = new ArrayList<>();
    public ArrayList<Device> srDevicesInRadioRange = new ArrayList<>();
    public ArrayList<Device> srRequesters = new ArrayList<>();
    public ArrayList<Double> deviceSIoT = new ArrayList<>();
    public ArrayList<Double> srdeviceSimilarity = new ArrayList<>();
    public ArrayList<Double> spdeviceSimilarity = new ArrayList<>();
    
    public List<Device> providers = new ArrayList <Device>();  
    public List<Device> candidProviders = new ArrayList <Device>();
    public List<Device> selectedCandidProviders = new ArrayList<Device>();
    public List<Device> requestedProviders = new ArrayList<Device>();
    /*
    // 0 honesty t3,1 TQoS t1,2 Tcoo t2
    public double[] thereshould = new double[3];
    //0 WQoS ,1 Wcoo ,2 Wdir dirTrustUpdate of dir,3 wHon dirTrustUpdate of honestyDir
    public double[] dirTrustWeigh = new double[4];
    // 0 Wpre g,1 indtrustSPUpdate e
    public double[] indTrustWeigh = new double[2];
    // 0 dirTrustUpdate u,1 indTrustUpdate B,2 first W
    public double[] totalTrustWeigh = new double[3];
    //0 m0,1 m1,2 m2,3 m3,4 numberOfNeighborsOfSp
    public int[] neighborNumbers = new int[5];
    */

}
 
/*
WriteOutput.writeFalseNegativeAndPositive(totalFalseNegative , "PFN", "PFN");
            WriteOutput.writeFalseNegativeAndPositive(totalFalsePositive, "PFP", "PFP");
            WriteOutput.writeFalseNegativeAndPositive(totalTrueNegative, "PTN", "PTN");
            WriteOutput.writeFalseNegativeAndPositive(totalTruePositive, "PTP", "PTP");
            WriteOutput.writeTrustConvergence(trustConvergenceOfBadNodes, "trustConvergenceOfBadNodes", "ConvergenceOfBadNodes");
            WriteOutput.writeTrustConvergence(trustConvergenceOfGoodNodes , "trustConvergenceOfGoodNodes ", "ConvergenceOfGoodNodes");
            WriteOutput.writeMAE(totalMAE);
            WriteOutput.writeTrustConvergence(totalRMSE, "RMSE", "RMSE");
            WriteOutput.writeTrustConvergence(totalChangeBehaviorTrust, "changeBehaviorTime", "changeBehaviorTime");
            WriteOutput.writeFalseNegativeAndPositive(GVtotalFalseNegative , "GVPFN", "GVPFN");
            WriteOutput.writeFalseNegativeAndPositive(GVtotalFalsePositive, "GVPFP", "GVPFP");
            WriteOutput.writeTrustConvergence(GVtrustConvergenceOfBadNodes, "GVtrustConvergenceOfBadNodes", "GVConvergenceOfBadNodes");
            WriteOutput.writeTrustConvergence(GVtrustConvergenceOfGoodNodes , "GVtrustConvergenceOfGoodNodes ", "GVConvergenceOfGoodNodes");
            WriteOutput.writeMAE(GVtotalMAE);
            WriteOutput.writeTrustConvergence(GVtotalRMSE, "GVRMSE", "GVRMSE");
*/


