package trust.management;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

 
public class TrustManagement {

    public double doubleTotalNumberOfDevices;
    public int totalNumberOfDevices;
    public int totalNumberOfUsers;
    
    public double totalPFN;
    public double totalPFP;
    public double totalPTN;
    public double totalPTP;
    public double totalTN;
    public double totalTP;
    public double totalFP;
    public double totalFN;
    public double totalPositive;
    public double totalNegative;
    public Device ChangedNode;
    public double GVtotalPFN;
    public double GVtotalPFP;
    public double GVtotalPTN;
    public double GVtotalPTP;
    public double GVtotalTN;
    public double GVtotalTP;
    public double GVtotalFP;
    public double GVtotalFN;
    public double GVtotalPositive;
    public double GVtotalNegative;
    //0 timeOfRun,1 pfn,pfp,.... 
    public List<double[]> totalFalseNegative = new ArrayList<>();
    public List<double[]> totalFalsePositive = new ArrayList<>();
    public List<double[]> totalTrueNegative = new ArrayList<>();
    public List<double[]> totalTruePositive = new ArrayList<>();
    public List<double[]> GVtotalFalseNegative = new ArrayList<>();
    public List<double[]> GVtotalFalsePositive = new ArrayList<>();
    public List<double[]> GVtotalTrueNegative = new ArrayList<>();
    public List<double[]> GVtotalTruePositive = new ArrayList<>();
    
    
    public List<Integer> goodNodes = new ArrayList<Integer>();
    public List<Integer> badNodes = new ArrayList<Integer>();
    public ArrayList<Device> goodUserDevices = new ArrayList<>();
    public ArrayList<Device> badUserDevices = new ArrayList<>();
    
    //0 timeOfRun,1 trustConvergence
    public List<double[]> trustConvergenceOfGoodNodes = new ArrayList<>();
    public List<double[]> trustConvergenceOfBadNodes = new ArrayList<>();
    public List<Double> convergenceOfGoodNodes = new ArrayList<>();
    public List<Double> convergenceOfBadNodes = new ArrayList<>();
    
    public List<double[]> GVtrustConvergenceOfGoodNodes = new ArrayList<>();
    public List<double[]> GVtrustConvergenceOfBadNodes = new ArrayList<>();
    public List<Double> GVconvergenceOfGoodNodes = new ArrayList<>();
    public List<Double> GVconvergenceOfBadNodes = new ArrayList<>();
    
    public List<Double> GVMAE = new ArrayList<>();
    public List<Double> GVRMSE = new ArrayList<>();
    public List<double[]> GVtotalMAE = new ArrayList<>();
    public List<double[]> GVtotalRMSE = new ArrayList<>();
    
    public List<Double> MAE = new ArrayList<>();
    public List<Double> RMSE = new ArrayList<>();
    public List<double[]> totalMAE = new ArrayList<>();
    public List<double[]> totalRMSE = new ArrayList<>();
    
    public List<Double> changeBehaviorTrust = new ArrayList<>();
    public List<double[]> totalChangeBehaviorTrust = new ArrayList<>();
    
    public List<User> users = new ArrayList<User>();
    public List<Head> heads = new ArrayList<Head>();
    public List<Device> devices = new ArrayList<Device>();
    public List<Device> tempDevices = new ArrayList<Device>();
    public List<Device> devicesInRadioRange = new ArrayList<Device>();
    public List<List<Device>> allDevicesInRadioRange = new ArrayList<List<Device>>();
    public List<Device> randomRequesters = new ArrayList<Device>();
    public List<Double> doubleDeviceIds = new ArrayList<>();
    public List<Double> tempDoubleDeviceIds = new ArrayList<>();
    public List<Double> doubleUserIds = new ArrayList<>();
    
    // 0 honesty t3,1 TQoS t1,2 Tcoo t2
    public double[] thereshould = new double[3];
    //0 WQoS ,1 Wcoo ,2 Wdir dirTrustUpdate of dir,3 wHon dirTrustUpdate of honestyDir
    public double[] dirTrustWeigh = new double[4];
    // 0 Wpre g,1 indUpdate e
    public double[] indTrustWeigh = new double[2];
    // 0 dirTrustUpdate u,1 indTrustUpdate B,2 first W
    public double[] totalTrustWeigh = new double[3];
    //0 m0,1 m1,2 m2,3 m3,4 numberOfNeighborsOfSp
    public int[] neighborNumbers = new int[5];
    
    public void initialFalseNegativeAndPositives(){
        totalPFN = 0;
        totalPFP = 0;
        totalPTN = 0;
        totalPTP = 0;
        totalTN = 0;
        totalTP = 0;
        totalFP = 0;
        totalFN = 0;
        totalPositive = 0;
        totalNegative = 0;
    }
    
    public void setdirTrustWeigh(double wQoS, double wCoo, double Wdir, double wHOw){
        dirTrustWeigh[0] = wQoS;
        dirTrustWeigh[1] = wCoo;
        dirTrustWeigh[2] = Wdir;
        dirTrustWeigh[3] = wHOw ;
    }    
    
    public void setThereshould (double honesty ,double TQoS ,double Tcoo){
        thereshould[0] = honesty;
        thereshould[1] = TQoS;
        thereshould[2] = Tcoo;
    }
    
    public void setindTrustWeigh(double Wpre,double indUpdate){
        indTrustWeigh[0] = Wpre;
        indTrustWeigh[1] = indUpdate;
    }
    
    public void setTotalTrustWeigh(double dirTrustUpdateu,double indTrustUpdateB,double firstW){
        totalTrustWeigh[0] = dirTrustUpdateu;
        totalTrustWeigh[1] = indTrustUpdateB;
        totalTrustWeigh[2] = firstW;
    }
    
    public void setNeighborNumbers(int m0,int m1,int m2,int m3,int numberOfNeighborsOfSp){
        neighborNumbers[0] = m0; 
        neighborNumbers[1] = m1;
        neighborNumbers[2] = m2;
        neighborNumbers[3] = m3;
        neighborNumbers[4] = numberOfNeighborsOfSp;
        }
    /*
    public void setWeighsForDevice(Device d){
        d.dirTrustWeigh[0] = dirTrustWeigh[0];
        d.dirTrustWeigh[1] = dirTrustWeigh[1];
        d.dirTrustWeigh[2] = dirTrustWeigh[2];
        d.dirTrustWeigh[3] = dirTrustWeigh[3];
        d.dirTrustWeigh[4] = dirTrustWeigh[4];
        d.dirTrustWeigh[5] = dirTrustWeigh[5];
        d.dirTrustWeigh[6] = dirTrustWeigh[6];
        d.dirTrustWeigh[7] = dirTrustWeigh[7];
        d.dirTrustWeigh[8] = dirTrustWeigh[8];
        d.indTrustWeigh[0] = indTrustWeigh[0];
        d.indTrustWeigh[1] = indTrustWeigh[1];
        d.indTrustWeigh[2] = indTrustWeigh[2];
        d.totalTrustWeigh[0] = totalTrustWeigh[0];
        d.totalTrustWeigh[1] = totalTrustWeigh[1];
        d.totalTrustWeigh[2] = totalTrustWeigh[2];
        d.neighborNumbers[0] = neighborNumbers[0]; 
        d.neighborNumbers[1] = neighborNumbers[1];
        d.neighborNumbers[2] = neighborNumbers[2];
        d.neighborNumbers[3] = neighborNumbers[3];
        d.neighborNumbers[4] = neighborNumbers[4];
    }
    */
    
    public void madeUsersAndHeadsAndDevicesAndAsignDevicesToUsers(int numberOfUsers,int maxNumOfDevicesForAnyUser,int numberOfHeads,double doubleNumberOfHeads){
        totalNumberOfUsers = numberOfUsers;
        doubleTotalNumberOfDevices = 0;
        maxNumOfDevicesForAnyUser--;
        double doubleId = 0;
        double doubleDeviceIndex = doubleNumberOfHeads;
        int deviceIndex = numberOfHeads;
        Device r = new Device();
        for(int userIndex = 0; userIndex < numberOfUsers ; userIndex++){
            User u = new User();
            u.intUserId = userIndex;
            u.intUserHedId = userIndex;
            u.doubleUserId = doubleId;
            u.doubleHedOfUserId = doubleId;
            Random asign = new Random();
            int num = 2 + asign.nextInt(maxNumOfDevicesForAnyUser);
            u.numOfDevicesForUser = num;
            users.add(u);
            doubleUserIds.add(userIndex, doubleId);
            totalNumberOfUsers++;
            Head h = new Head();
            h.intHeadId = userIndex;
            h.intDeviceId = userIndex;
            h.intDeviceHeadId = userIndex;
            h.intDeviceUserId = userIndex;
            h.doubleHeadId = doubleId;
            h.doubleDeviceId = doubleId;
            h.doubleDeviceUserId = doubleId;
            h.doubleDeviceHeadId = doubleId;
            h.deviceUser = u;
            heads.add(h);
            devices.add(userIndex, h);
            doubleDeviceIds.add(userIndex, doubleId);
            u.userDevices.add(h);
            doubleTotalNumberOfDevices++;
            for(int n = 1; n <= num ; n++){
                Device d = new Device();
                d.intDeviceId = deviceIndex;
                d.intDeviceHeadId = userIndex;
                d.intDeviceUserId = userIndex;
                d.doubleDeviceId = doubleDeviceIndex;
                d.doubleDeviceUserId = doubleId;
                d.doubleDeviceHeadId = doubleId;
                d.deviceUser = u;
                tempDevices.add(d);
                tempDoubleDeviceIds.add(doubleDeviceIndex);
                u.userDevices.add(d);
                deviceIndex++;
                doubleDeviceIndex++;
                doubleTotalNumberOfDevices++;
            }
            doubleId++;    
        }
        devices.addAll(tempDevices);
        doubleDeviceIds.addAll(tempDoubleDeviceIds);
        totalNumberOfDevices = devices.size();       
        setUserStatus(30);
        setNodeStatus(50);
        Random ran = new Random();
        double n;
        int num;
        int numberOfUserFriends = Math.round(numberOfUsers/5);
        int halfNumberOfUserFriends =  Math.round(numberOfUserFriends/2);;
        int numberOfUserSimilars =  Math.round(numberOfUsers/5);
        int halfNumberOfUserSimilars =  Math.round(numberOfUserSimilars/2);
        int numberOfDeviceFriends =  Math.round(totalNumberOfDevices/5);
        int halfNumberOfDeviceFriends =  Math.round(numberOfDeviceFriends/2);
        int numberOfDeviceSimilars =  Math.round(totalNumberOfDevices/5);
        int halfNumberOfDeviceSimilars =  Math.round(numberOfDeviceSimilars/2);
        for(int userIndex1 = 0; userIndex1 < numberOfUsers ; userIndex1++){
            List<Integer> siot = new ArrayList<Integer>();
            int k = 0;
            while(k < (numberOfUserFriends)){
                num = ran.nextInt(numberOfUsers);
                if(userIndex1 == num){
                    continue;
                    }
                else{
                    if(!siot.contains(num)){
                    siot.add(num);
                    k++;
                    }
                }
            }
            for(int userIndex2 = 0; userIndex2 < numberOfUsers ; userIndex2++){
                users.get(userIndex1).userSIoT.add(0.0);
            }
            for(int j = 0; j < numberOfUserFriends; j++){
                if(j <= halfNumberOfUserFriends){
                    n = 1+ ran.nextInt(5);
                }
                else{
                    n = 6 + ran.nextInt(5);
                }
                users.get(userIndex1).userSIoT.add(siot.get(j), n/10);
            }
        }
        for(int deviceIndex1 = 0; deviceIndex1 < totalNumberOfDevices ; deviceIndex1++){
            List<Integer> siot = new ArrayList<Integer>();
            int k = 0;
            while(k < numberOfDeviceFriends){
                num = ran.nextInt(totalNumberOfDevices);
                if(deviceIndex1 == num){
                    continue;
                    }
                else{
                    if(!siot.contains(num)){
                    siot.add(num);
                    k++;
                    }
                }
            }
            for(int deviceIndex2 = 0; deviceIndex2 < totalNumberOfDevices ; deviceIndex2++){
                devices.get(deviceIndex1).deviceSIoT.add(0.0);
            }
            for(int j = 0; j < numberOfDeviceFriends ; j++){
                if(j <= halfNumberOfDeviceFriends){
                    n = 1 + ran.nextInt(5);
                }
                else{
                    n = 6 + ran.nextInt(5);
                }
                devices.get(deviceIndex1).deviceSIoT.add(siot.get(j), n/10);
            } 
        }
        for(int userIndex1 = 0; userIndex1 < numberOfUsers ; userIndex1++){
            List<Integer> sim = new ArrayList<Integer>();
            int k = 0;
            while(k < (numberOfUserSimilars)){
                num = ran.nextInt(numberOfUsers);
                if(userIndex1 == num){
                    continue;
                    }
                else{
                    if(!sim.contains(num)){
                    sim.add(num);
                    k++;
                    }
                }
            }
            for(int userIndex2 = 0; userIndex2 < numberOfUsers ; userIndex2++){
                users.get(userIndex1).userSimilarity.add(0.0);
            }
            for(int j = 0; j < numberOfUserSimilars ; j++){
                if(j <= halfNumberOfUserSimilars){
                    n = 1 + ran.nextInt(5);
                }
                else{
                    n = 6 + ran.nextInt(5);
                }
                users.get(userIndex1).userSimilarity.add(sim.get(j), n/10);
            }   
        }
        for(int deviceIndex1 = 0; deviceIndex1 < totalNumberOfDevices ; deviceIndex1++){
            List<Integer> sim = new ArrayList<Integer>();
            int k = 0;
            while(k < numberOfDeviceSimilars){
                num = ran.nextInt(totalNumberOfDevices);
                if(deviceIndex1 == num){
                    continue;
                    }
                else{
                    if(!sim.contains(num)){
                    sim.add(num);
                    k++;
                    }
                }
            }
            for(int deviceIndex2 = 0; deviceIndex2 < totalNumberOfDevices ; deviceIndex2++){
                devices.get(deviceIndex1).spdeviceSimilarity.add(0.0);
                devices.get(deviceIndex1).srdeviceSimilarity.add(0.0);
            }
            for(int j = 0; j < numberOfDeviceSimilars ; j++){
                if(j <= halfNumberOfDeviceSimilars){
                    n = 1 + ran.nextInt(5);
                }
                else{
                    n = 6 + ran.nextInt(5);
                }
                devices.get(deviceIndex1).spdeviceSimilarity.add(sim.get(j), n/10);
                devices.get(deviceIndex1).srdeviceSimilarity.add(sim.get(j), n/10);
            }   
        }
        for(Device d: devices){
            d.totalNumberOfDevices = totalNumberOfDevices;
            d.totalNumberOfUsers = totalNumberOfUsers;
        }
        double firstTrust;
        double totalTrust;
        for(Device d: devices){
            for(Device dfirstTrust: devices){
                double[] srTrustArray = new double[8];
                Arrays.fill(srTrustArray, -1);
                if(d.intDeviceId != dfirstTrust.intDeviceId){
                    firstTrust = computefirstTrust(d,dfirstTrust); 
                    totalTrust = firstTrust;
                    srTrustArray[0] = dfirstTrust.doubleDeviceId;
                    srTrustArray[4] = firstTrust;   
                    srTrustArray[1] = totalTrust;
                    d.trust.add(srTrustArray);
                }    
                else{
                    srTrustArray[0] = d.doubleDeviceId;
                    d.trust.add(srTrustArray);
                }
                double[] spArray = new double[4];
                Arrays.fill(spArray, -1.0);
                d.spsQosList.add(spArray);
                d.spsCooperativenessList.add(spArray);
                d.recommanderHonestyList.add(spArray);
                d.CooList.add(-1.0);
                d.QosList.add(-1.0);
                d.honestyList.add(-1.0);
                double[] recArray = new double[totalNumberOfDevices];
                Arrays.fill(recArray, 0.0);
                d.recommandationList.add(recArray);
                d.numberOfSpServicesList.add(0);
                d.numberOfRecommandList.add(0);
            }
            selectFirstSrNeighborhood(d);
            d.timesOfRequest = 1;
            for(int userIndex1 = 0; userIndex1 < numberOfUsers ; userIndex1++){
                double[] ownerArray = new double[3];
                Arrays.fill(ownerArray, -1.0);
                d.ownerTrustList.add(ownerArray);
            }    
        } 
        for(Device d: devices){
            for(Device dfirstTrust: devices){
                double[] dirTrustArray = new double[7];
                Arrays.fill(dirTrustArray, -1.0);
                if(d.intDeviceId != dfirstTrust.intDeviceId){
                    dirTrustArray[0] = dfirstTrust.doubleDeviceId;
                    d.dirTrustComponents.add(dirTrustArray);
                }
                else{
                    dirTrustArray[0] = d.doubleDeviceId;
                    d.dirTrustComponents.add(dirTrustArray);
                }
            } 
        }
        double tempT;
        for(int deviceIndex1 = 0; deviceIndex1 < devices.size() ; deviceIndex1++){
            for(int deviceIndex2 = 0; deviceIndex2 < devices.size() ; deviceIndex2++){
                double[] tempTrust = new double[8];
                if(deviceIndex1 != deviceIndex2){
                        tempTrust = devices.get(deviceIndex1).trust.get(deviceIndex2);
                        tempT = tempTrust[1];
                    if(tempT == -1){
                        tempT = computefirstTrust(devices.get(deviceIndex1),devices.get(deviceIndex2));
                        if(tempT > 1)
                            tempT = 1;
                        tempTrust[1] = tempT;
                        devices.get(deviceIndex1).trust.remove(deviceIndex2);
                        devices.get(deviceIndex1).trust.add(deviceIndex2,tempTrust);
                    }
                }
            }
        }
        for(int deviceIndex1 = 0; deviceIndex1 < devices.size() ; deviceIndex1++){
            for(int deviceIndex2 = 0; deviceIndex2 < devices.size() ; deviceIndex2++){
                double[] tempTrust = new double[8];
                if(deviceIndex1 != deviceIndex2){
                    tempTrust = devices.get(deviceIndex1).trust.get(deviceIndex2);
                    tempT = tempTrust[1];
                }
            }
        }
//        WriteOutput.writeTrustListOfRequesters(devices);
//        WriteOutput.writeSrsSIoT(devices);
//        WriteOutput.writeSrsSimilarity(devices);
//        WriteOutput.writeSrsNeighborsList(devices);
//        WriteOutput.writeDirTrustComponentstListOfRequesters(devices);
//        WriteOutput.writeSpsGoodServiceAndRecommandationToSrRateList(devices);
//        WriteOutput.SpOwnerList(devices);
//        WriteOutput.writeSrRecommandationList(devices);
    }
        
    public void setUserStatus(int percentageOfMaliciousUsers){
        int i = 0;
        int numberOfMaliciousUsers = (users.size() * percentageOfMaliciousUsers) / 100;
        while(i < numberOfMaliciousUsers){
            users.get(i).userstatus = users.get(i).userstatus.badUser;
            i++;
        }
        while(i < users.size()){
            users.get(i).userstatus = users.get(i).userstatus.goodUser;
            i++;
        }
    }

    public void setNodeStatus( int percentageOfMaliciousDevices){
        int i = 0;
        int numberOfMaliciousDevices = (devices.size() * percentageOfMaliciousDevices) / 100;
        while(i < numberOfMaliciousDevices){
            devices.get(i).nodestatus = devices.get(i).nodestatus.badNode;
            badNodes.add(i);
            i++;
        }
        while(i < devices.size()){
            devices.get(i).nodestatus = devices.get(i).nodestatus.goodNode;
            goodNodes.add(i);
            i++;
        }
    }
    
    public void selectFirstSrNeighborhood(Device sr){
        List<Device> nd = new ArrayList<Device>();
        List<Device> ndu = new ArrayList<Device>();
        List<Device> tempUsersDevices = new ArrayList<Device>();
        List<User> nu = new ArrayList<User>();
        double[][] tempSrNeighbors = new double[totalNumberOfDevices][2];
        double[][] tempSrNeighborOwners = new double[totalNumberOfUsers][2];
        int count =0;
        int counter =0;
        for(Device d : devices){
            if(d != sr){
            tempSrNeighbors[count][0] = d.doubleDeviceId;
            tempSrNeighbors[count][1] = sr.spdeviceSimilarity.get(d.intDeviceId);
            count++;
            }
        }
        for(int i=0;i<totalNumberOfDevices;i++){
            for(int j=1;j<totalNumberOfDevices;j++){
                if(tempSrNeighbors[j-1][1]<tempSrNeighbors[j][1]){
                   double[] tempArray = new double[2];
                   tempArray = tempSrNeighbors[j-1];
                   tempSrNeighbors[j-1] = tempSrNeighbors[j];
                   tempSrNeighbors[j] = tempArray;
                }
            }           
        }
        for(int i=0;i<neighborNumbers[3];i++){
            for(int j=0;j<doubleDeviceIds.size();j++){
                if(tempSrNeighbors[i][0] == doubleDeviceIds.get(j)){
                    nd.add(devices.get(j));
                    continue;
                }  
            }
        }
        for(User u : users){
            if(u != sr.deviceUser){
            tempSrNeighborOwners[counter][0] = u.doubleUserId;
            tempSrNeighborOwners[counter][1] = sr.deviceUser.userSimilarity.get(u.intUserId);
            counter++;
            }
        }
        for(int i=0;i<totalNumberOfUsers;i++){
            for(int j=1;j<totalNumberOfUsers;j++){
                if(tempSrNeighborOwners[j-1][1]<tempSrNeighborOwners[i][1]){
                   double[] tempArray = new double[2];
                   tempArray = tempSrNeighborOwners[j-1];
                   tempSrNeighborOwners[j-1] = tempSrNeighborOwners[j];
                   tempSrNeighborOwners[j] = tempArray;
                }
            }           
        }
        for(int i=0;i<neighborNumbers[1];i++){
            for(int j=0;j<doubleUserIds.size();j++){
                if(tempSrNeighborOwners[i][0] == doubleUserIds.get(j)){
                    nu.add(users.get(j));
                    continue;
                }  
            }
        }
        for(User u : nu){
            for(Device d : u.userDevices){
            tempUsersDevices.add(d);
            }
        }
        count = 0;
        double [][] tempSrN = new double[tempUsersDevices.size()][2];
        for(Device d : tempUsersDevices){
            tempSrN[count][0] = d.doubleDeviceId;
            tempSrN[count][1] = sr.spdeviceSimilarity.get(d.intDeviceId);
            count++;
        }
        for(int i=0;i<tempUsersDevices.size();i++){
            for(int j=1;j<tempUsersDevices.size();j++){
                if(tempSrN[j-1][1]<tempSrN[j][1]){
                   double[] tempArray = new double[2];
                   tempArray = tempSrN[j-1];
                   tempSrN[j-1] = tempSrN[j];
                   tempSrN[j] = tempArray;
                }
            }           
        }
        for(int i=0;i<neighborNumbers[2];i++){
            for(int j=0;j<doubleDeviceIds.size();j++){
                if(tempSrNeighbors[i][0] == doubleDeviceIds.get(j)){
                    ndu.add(devices.get(j));
                    continue;
                }  
            }
        }    
        double[][] tempSelectSrNeighborhood = new double[(ndu.size()+nd.size())][2];
        int index = 0;
        for(int j=0;j<nd.size();j++){
            tempSelectSrNeighborhood[index][0] = nd.get(j).doubleDeviceId;
            double[] srTrustArray = new double[8];
            srTrustArray = sr.trust.get(nd.get(j).intDeviceId);
        if(srTrustArray[1] == -1){
            srTrustArray[1] = computefirstTrust(sr,nd.get(j));
            if(srTrustArray[1] > 1)
                srTrustArray[1] = 1;  
        }
        sr.trust.remove(nd.get(j).intDeviceId);
        sr.trust.add(nd.get(j).intDeviceId, srTrustArray);
            tempSelectSrNeighborhood[index][1] = srTrustArray[1];
            index++;
        }
        for(int k=0;k<ndu.size();k++){
            tempSelectSrNeighborhood[index][0] = ndu.get(k).doubleDeviceId;
            double[] srTrustArray = new double[8];
            srTrustArray = sr.trust.get(ndu.get(k).intDeviceId);
            if(srTrustArray[1] == -1){
                srTrustArray[1] = computefirstTrust(sr,ndu.get(k));
                if(srTrustArray[1] > 1)
                    srTrustArray[1] = 1;   
            }
            sr.trust.remove(ndu.get(k).intDeviceId);
            sr.trust.add(ndu.get(k).intDeviceId, srTrustArray);
            tempSelectSrNeighborhood[index][1] = srTrustArray[1];
            index++;
        }
        for(int i=0;i<(ndu.size()+nd.size());i++){
            for(int j=1;j<(ndu.size()+nd.size());j++){
                if(tempSelectSrNeighborhood[j-1][1]<tempSelectSrNeighborhood[j][1]){
                   double[] tempArray = new double[2];
                   tempArray = tempSelectSrNeighborhood[j-1];
                   tempSelectSrNeighborhood[j-1] = tempSelectSrNeighborhood[j];
                   tempSelectSrNeighborhood[j] = tempArray;
                }
            }           
        }
        for(int i=0;i<neighborNumbers[0];i++){
            for(int j=0;j<doubleDeviceIds.size();j++){
                if(tempSelectSrNeighborhood[i][0] == doubleDeviceIds.get(j)){
                    if(sr.deviceNeighbors.contains(devices.get(j)))
                        continue;
                    else{
                        sr.deviceNeighbors.add(devices.get(j));
                        continue;
                    }    
                }  
            }
        }
        List<Device> userDevice = sr.deviceUser.userDevices;
        for(int i=0;i<(userDevice.size());i++){
            if (sr!=userDevice.get(i)){
                sr.deviceNeighbors.add(userDevice.get(i));
            }
        }
    }
    
    public void setBusyDevices(int percentageOfBusyDevices){
        int numberOfBusyDevices = (devices.size() * percentageOfBusyDevices) / 100;
        List<Device> busyDevices = new ArrayList<Device>();
        busyDevices.clear();
        int i = 0;
        int num;
        Device busyDevice;
        Random busySP = new Random();
        while(i < numberOfBusyDevices){
            num = busySP.nextInt(devices.size());
            busyDevice = devices.get(num);
            if (!busyDevices.contains(busyDevice)){
                busyDevices.add(busyDevice);
                i++;
            }
        }
        for(Device d : devices){
            if(busyDevices.contains(d))
                d.busy = true;
            else
                d.busy = false;
        }
    }
           
    public void chooseDevicesInRadioRange(int percentageOfDevicesInRadioRange, int percentageOfBusyDevices, int time){
        int numberOfDevicesInRadioRange = (devices.size() * percentageOfDevicesInRadioRange) / 100;
        devicesInRadioRange.clear();
        int i = 0;
        Random radio = new Random();
        while(i < numberOfDevicesInRadioRange){
            int num = radio.nextInt(devices.size());
            Device radioD = devices.get(num);
            if(!devicesInRadioRange.contains(radioD)){
                devicesInRadioRange.add(radioD);
                i++;
            }
        }
        for(Device d : devicesInRadioRange){
                d.location.add(time);
        }
        setBusyDevices(percentageOfBusyDevices);
//        WriteOutput.writeDeviceList(devicesInRadioRange);
    }
        
    public void chooseRequesters(int percentageOfRequestersFromDevicesInRadioRange){
        int numberOfRequesters = (devicesInRadioRange.size() * percentageOfRequestersFromDevicesInRadioRange) / 100;
        randomRequesters.clear();
        int i = 0;
        Device srDevice;
        Random ran = new Random();
        while(i < numberOfRequesters){
            int num = ran.nextInt(devicesInRadioRange.size());
            srDevice = devicesInRadioRange.get(num);
            if (!randomRequesters.contains(srDevice)){
                randomRequesters.add(srDevice);
                i++;
            }
        }        
   //     WriteOutput.writeTrustListOfRequesters(randomRequesters);
   //     WriteOutput.writeSrsNeighborsList(randomRequesters);
    }
   
    public void services (List<Device> randomRequesters,List<Device> devicesInRadioRange){
        for(Device sr : randomRequesters){
            sr.candidProviders.clear();
            sr.counter = devicesInRadioRange.size();
            for(Device sp: devicesInRadioRange){
                if(sp != sr){
                    reciveRequest(sr,sp);
//                    sr.providers.add(sp);
                }           
            }
            
        }
    }
    /*
    public void sendServiceRequestAgaine (Device sr,List<Device> providers){
        sr.counter = providers.size();
        for(Device sp: providers){
            reciveRequest(sr,sp);
        }
    }
    */
    
    public void reciveRequest(Device sr,Device sp){
       if(sp.busy != true){
           sr.candidProviders.add(sp); 
       } 
       sr.counter--;
       if(sr.counter == 1)
           spAcceptedRequest(sr,sp);
    }
    
    public void spAcceptedRequest(Device sr,Device sp){
//        Device serviceProvider = null;
        sr.selectedCandidProviders = chooseTrustworthyNodes(sr,sr.candidProviders);
            boolean answer;
            Device candidDevice;
            int i = 0;
            while(i<sr.selectedCandidProviders.size()){
                candidDevice = sr.selectedCandidProviders.get(i);
                answer = askForprovidingService(candidDevice);
                if(answer == true){
//                    serviceProvider = candidDevice;
                    reciveService(sr,candidDevice);
//                    sr.recivedService = answer;
                    break;
                }
                i++;
            }
            /*
            if(sr.recivedService != true){
               sendServiceRequestAgaine(sr, sr.providers);
            }
            */
    }
    
    public boolean askForprovidingService(Device sp){
        if(sp.busy != true){
            sp.busy = true;
            return true;
        }
        else{
            return false;
        }
    }
    
    public void reciveService (Device sr,Device sp){
        int n;
        double spQos;
        double spCooperativeness;
        double ownersFriendship = sp.deviceUser.userSIoT.get(sr.deviceUser.intUserId);
        double devicesFriendship = sp.deviceSIoT.get(sr.intDeviceId);
        double[] spCooArray = new double[4];
        sr.spsWhoProvidedService.add(sp);
        sr.sps.add(sp.intDeviceId);
        sp.srs.add(sr.intDeviceId);
        sr.timesOfRequest++;
        sr.recivedService = true;
        
//        sr.SpProvider = sp;
//        sr.falseNegativeAndPositivesSp = sp;
        if(sp.nodestatus.equals(sp.nodestatus.goodNode)){
            spQos = 1;
            spCooperativeness = 1;
        }
        else{
            spQos = 0;
            spCooperativeness = 0;
        }
        /*
        spQos = reciveServiceFromBadnods (sr, sp);
        if(ownersFriendship > 0.5 || devicesFriendship > 0.5)
            spCooperativeness = 1;
        else
            spCooperativeness = 0;
        */          
        n = sr.numberOfSpServicesList.get(sp.intDeviceId);
        spCooArray = sr.spsCooperativenessList.get(sp.intDeviceId);
        if(n != 4){
            spCooArray[n] = spCooperativeness;
        }
        else{
            for(int i=1;i<4;i++){
                spCooArray[i-1] = spCooArray[i]; 
            }
            spCooArray[3] = spCooperativeness;
        }
        sr.spsCooperativenessList.remove(sp.intDeviceId);
        sr.spsCooperativenessList.add(sp.intDeviceId, spCooArray);
//        WriteOutput.writeSrRecommandationList(randomRequesters);
        sr.CooList.remove(sp.intDeviceId);
        sr.CooList.add(sp.intDeviceId, spCooperativeness);
        sr.QosList.remove(sp.intDeviceId);
        sr.QosList.add(sp.intDeviceId, spQos);
        SIoTserver.updateSpDeviceSIoT(sr, sp, spQos, spCooperativeness);
        saveServiceFeadback(sr,sp,spQos,spCooperativeness);
    }
    
    public double reciveServiceFromBadnods (Device sr,Device sp){
        double ownersFriendship = sp.deviceUser.userSIoT.get(sr.deviceUser.intUserId);
        double devicesFriendship = sp.deviceSIoT.get(sr.intDeviceId);
        double spQos;
        if(ownersFriendship > 0.5 || devicesFriendship > 0.5){
//        if(ownersFriendship > 0.0 || devicesFriendship > 0.0){
            spQos = 1;
        }
        else{
            spQos = 0;
        }
        return spQos;
    }   

    public List<Device> chooseTrustworthyNodes(Device sr, List<Device> candidProviders){
        ArrayList<Device> selectedSPs = new ArrayList<Device>();
        double [][] tempSelectedSPs = new double[candidProviders.size()][2];
        Device [] SelectedSPsDevice = new Device[candidProviders.size()];
        for(int i=0;i<candidProviders.size();i++){
            Device sp = candidProviders.get(i);
            SelectedSPsDevice[i] = sp;
            /*
            if(sr.timesOfRequest == 1){
                double[] srTrustArray = new double[8];
                srTrustArray = sr.trust.get(sp.intDeviceId);
                tempSelectedSPs[i][1] = srTrustArray[1];
            }
            else{
                tempSelectedSPs[i][1] = computeTrust(sr, sp);
            }
            */
            tempSelectedSPs[i][0] = sp.doubleDeviceId;
            tempSelectedSPs[i][1] = computeTrust(sr, sp);
        }
        for(int i=0;i<candidProviders.size();i++){
            for(int j=1;j<candidProviders.size();j++){
                if(tempSelectedSPs[j-1][1]<tempSelectedSPs[j][1]){
                   double[] tempArray = new double[2];
                   Device tempSelectedSP;
                   tempArray = tempSelectedSPs[j-1];
                   tempSelectedSPs[j-1] = tempSelectedSPs[j];
                   tempSelectedSPs[j] = tempArray;
                   tempSelectedSP = SelectedSPsDevice[j-1];
                   SelectedSPsDevice[j-1] = SelectedSPsDevice[j];
                   SelectedSPsDevice[j] = tempSelectedSP;
                }
            }           
        }
        for(int i=0;i<candidProviders.size();i++){
            selectedSPs.add(SelectedSPsDevice[i]);
        }
        return selectedSPs;
    }
    
    public double computefirstTrust(Device sr,Device sp){
        double ownersFriendship = sr.deviceUser.userSIoT.get(sp.intDeviceUserId);
        double devicesFriendship = sr.deviceSIoT.get(sp.intDeviceId);
        double firstTrust = (totalTrustWeigh[2])*devicesFriendship + (1-(totalTrustWeigh[2]))*ownersFriendship;      
//        TrustManagement.falseNegativeAndPositives(sr, sp, firstTrust);
        return firstTrust; 
    }
    
    public double computeTrust(Device sr,Device sp){
//        WriteOutput.writeTrustListOfRequesters(randomRequesters);
        double totalTrust;
        double indTrust = computeindTrust(sr, sp);
        double oldDirTrust;
        double oldIndTrust;
        double B = totalTrustWeigh [1];
        double[] srTrustArray = new double[8];
        srTrustArray = sr.trust.get(sp.intDeviceId);
        oldDirTrust = srTrustArray[2];  
        oldIndTrust = srTrustArray[3];
        if(oldDirTrust >= 0 && indTrust >= 0 && indTrust != oldIndTrust)
            totalTrust = B*indTrust + (1-B)*oldDirTrust;
        else{
            if(indTrust >= 0 && indTrust != oldIndTrust)
            totalTrust = indTrust;
            else{
                totalTrust = srTrustArray[1];
            }
        }
        if(totalTrust > 1)
            totalTrust = 1;
        srTrustArray[1] = totalTrust;
        srTrustArray[3] = indTrust;
        sr.trust.remove(sp.intDeviceId);
        sr.trust.add(sp.intDeviceId, srTrustArray);
//        WriteOutput.writeTrustListOfRequesters(randomRequesters);
//        TrustManagement.falseNegativeAndPositives(sr, sp, totalTrust);
        falseNegativeAndPositives(sp, totalTrust);
        if (sp.nodestatus.equals(sp.nodestatus.goodNode)){
            convergenceOfGoodNodes.add(totalTrust);
        }
        else{
            convergenceOfBadNodes.add(totalTrust);
        }
        if (sr.nodestatus.equals(sr.nodestatus.goodNode)){
            GoodVfp(sp, totalTrust);
            if (sp.nodestatus.equals(sp.nodestatus.goodNode)){
                GVconvergenceOfGoodNodes .add(totalTrust);
            }
            else{
                GVconvergenceOfBadNodes .add(totalTrust);
            }
        }    
        if (sp.intDeviceId == ChangedNode.intDeviceId)
            changeBehaviorTrust.add(totalTrust); 
        return totalTrust;
    }
    
    public double computeindTrust(Device sr,Device sp){
        double g = indTrustWeigh [0];
        double e = indTrustWeigh [1];
        double[] srTrustArray = new double[8];
        double indTrust;
        double predictionTrust;
        double itemBacedPredictedTrust = -2;
        double recTrust = computeRecTrust(sr,sp);
        if(!sr.spsWhoProvidedService.isEmpty()){
            itemBacedPredictedTrust = computeSpPredictedTrust(sr,sp);
            predictionTrust = g*itemBacedPredictedTrust + (1-g)*recTrust;
        }
        else{
            predictionTrust = recTrust;
        }
        if(predictionTrust > 1)
            predictionTrust = 1;
        srTrustArray = sr.trust.get(sp.intDeviceId);  
        double oldIndTrust = srTrustArray[3];
        if(oldIndTrust >= 0 && predictionTrust >= 0){
            indTrust = e*predictionTrust + (1-e)*oldIndTrust;
        }    
        else{
            if(predictionTrust >= 0)
            indTrust = predictionTrust;
            else{
                indTrust = oldIndTrust;
            }
        }
        srTrustArray[6] = predictionTrust;
        sr.trust.remove(sp.intDeviceId);
        sr.trust.add(sp.intDeviceId, srTrustArray);
        if(indTrust > 1)
            indTrust = 1;
        return indTrust;
    }
    
public double computeSpPredictedTrust(Device sr,Device sp){
        if(sr.timesOfRequest == 1 || sr.spsWhoProvidedService.isEmpty()){
            return 0.0;
        }
        else{
        List <Device> NewSPNeighborhood = new ArrayList<>();
        //j(SP Ids) 0,sim 1 
        double[][] oldSpsTemp = new double[sr.spsWhoProvidedService.size()][2];
        Device [] oldSpsDevice = new Device[sr.spsWhoProvidedService.size()];
        User [] oldSpUsers  = new User[sr.spsWhoProvidedService.size()];
        Device [] userDevice = new Device[sr.spsWhoProvidedService.size()];
        double[][] oldSpUsersTemp = new double[sr.spsWhoProvidedService.size()][2];
        for(Device oldSp : sr.spsWhoProvidedService){
            for(int i=0;i<sr.spsWhoProvidedService.size();i++){
                oldSpsDevice[i] = oldSp;
                oldSpUsers[i] = oldSp.deviceUser;
                userDevice[i] = oldSp;
                oldSpsTemp[i][0] = oldSp.doubleDeviceId;
                oldSpsTemp[i][1] = sp.srdeviceSimilarity.get(oldSp.intDeviceId);
                oldSpUsersTemp[i][0] = oldSp.doubleDeviceUserId;
                oldSpUsersTemp[i][1] = sp.deviceUser.userSimilarity.get(oldSp.intDeviceUserId);
            }
        }
        for(int i=0;i<sr.spsWhoProvidedService.size();i++){
            for(int j=1;j<sr.spsWhoProvidedService.size();j++){
                if(oldSpsTemp[j-1][1]<oldSpsTemp[j][1]){
                   double[] tempArray = new double[2];
                   Device tempoldSps;
                   tempArray = oldSpsTemp[j-1];
                   oldSpsTemp[j-1] = oldSpsTemp[j];
                   oldSpsTemp[j] = tempArray;                   
                   tempoldSps = oldSpsDevice[j-1];
                   oldSpsDevice[j-1] = oldSpsDevice[j];
                   oldSpsDevice[j] = tempoldSps;
                }
            }           
        }
        for(int i=0;i<sr.spsWhoProvidedService.size();i++){
            for(int j=1;j<sr.spsWhoProvidedService.size();j++){
                if(oldSpUsersTemp[j-1][1]<oldSpUsersTemp[j][1]){
                   double[] tempArray = new double[2];
                   Device tempuserDevice;
                   tempArray = oldSpUsersTemp[j-1];
                   oldSpUsersTemp[j-1] = oldSpUsersTemp[j];
                   oldSpUsersTemp[j] = tempArray;                   
                   tempuserDevice = userDevice[j-1];
                   userDevice[j-1] = userDevice[j];
                   userDevice[j] = tempuserDevice;
                }
            }           
        }
        
        int numberOfNeighborsOfSp =  Math.round(neighborNumbers[4]/2);
        for(int i=0;i<numberOfNeighborsOfSp && i<sr.spsWhoProvidedService.size();i++){
            NewSPNeighborhood.add(oldSpsDevice[i]);
        }
        for(int i=0;i<numberOfNeighborsOfSp && i<sr.spsWhoProvidedService.size();i++){
            if(!NewSPNeighborhood.contains(userDevice[i]))
            NewSPNeighborhood.add(userDevice[i]);
        }
        double[] wSimTemp = new double[NewSPNeighborhood.size()];
        double[] dirTrustTemp = new double[NewSPNeighborhood.size()];
        double predictedTrust = 0.0;  
        double sigma = 0.0;
        for(Device oldSP : NewSPNeighborhood){
            int i = 0;
            double oldSPSim = sp.srdeviceSimilarity.get(oldSP.intDeviceId);
            double ownerOfoldSPSim = sp.deviceUser.userSimilarity.get(oldSP.deviceUser.intUserId);
            double ownersFriendship = sp.deviceUser.userSIoT.get(oldSP.intDeviceUserId);
            double devicesFriendship = sp.deviceSIoT.get(oldSP.intDeviceId);
            double[] tempArray = new double[7];
            tempArray = sr.dirTrustComponents.get(oldSP.intDeviceId);
            double oldSPdirTrust = tempArray[6];
            double wSim = 0.2*oldSPSim + 0.2*ownerOfoldSPSim + 0.3*ownersFriendship + 0.3*devicesFriendship;
            wSimTemp[i] = wSim;
            dirTrustTemp[i] = oldSPdirTrust;
        }    
        for(int i=0;i<NewSPNeighborhood.size();i++){
            if(wSimTemp[i] > 1)
                    wSimTemp[i] = 1;
            sigma += wSimTemp[i];
        }
        if(sigma != 0){
            for(int i=0;i<NewSPNeighborhood.size();i++){
                if(dirTrustTemp[i] > 1)
                    dirTrustTemp[i] = 1;
                predictedTrust += dirTrustTemp[i] * (wSimTemp[i]/sigma);
            }
        }
        else
            predictedTrust = 0;
        if(predictedTrust > 1)
            predictedTrust = 1;
        return predictedTrust;
        }
    }

    public double computeRecTrust(Device sr,Device sp){
        double t1 = thereshould [1];
        double t2 = thereshould [2];
        double recQoS;
        double recCooperativeness;
        double recOwnerHonesty;
        double recommendersSim;
        double ownerOfRecommenderSim;
        double totalTrustForRecammander;
        double rec;
        double recTrust = 0.0;
        double wTrust;
        double wRec;
        int size = sr.deviceNeighbors.size();
        double[] wRecTemp = new double[size];
        double[] recTemp = new double[size];
        double sigma = 0.0;
        int count = 0;

        for(Device r : sr.deviceNeighbors){
            double[] srTrustArray = new double[8];
            recommendersSim = sr.spdeviceSimilarity.get(r.intDeviceId);
            ownerOfRecommenderSim = sr.deviceUser.userSimilarity.get(r.deviceUser.intUserId);            
            srTrustArray = sr.trust.get(r.intDeviceId);
            totalTrustForRecammander = srTrustArray[1];
            double[] tempArray = new double[7];
            tempArray = sr.dirTrustComponents.get(r.intDeviceId);
            recQoS = tempArray[1];
            recCooperativeness = tempArray[2];
            recOwnerHonesty = tempArray[3];
            if((recQoS<t1&&recQoS != -1)||(recCooperativeness<t2&&recCooperativeness != -1)||(recOwnerHonesty == 0&&recOwnerHonesty != -1))
                wTrust = 0.0;
                else
                wTrust = 1.0; 
            wRec = 0.2* recommendersSim + 0.2* ownerOfRecommenderSim + 0.6* totalTrustForRecammander * wTrust;
            if(wRec > 1)
                wRec = 1;           
            rec = askRecommendation(sr, r, sp);
            if(rec >= 0){
                wRecTemp[count] = wRec;
                recTemp[count] = rec;
                count++;
                double[] recArray = sr.recommandationList.get(r.intDeviceId);
                recArray[sp.intDeviceId] = rec;
                sr.recommandationList.remove(r.intDeviceId);
                sr.recommandationList.add(r.intDeviceId, recArray);
            }
        }
        double totalRecTemp = 0;
        for(int k=0;k<size;k++){
            sigma += wRecTemp[k];
            totalRecTemp += recTemp[k] * wRecTemp[k];
        }
        if(sigma != 0){
            for(int k=0;k<size;k++){
            recTrust = totalRecTemp/sigma;  
            }
        }
        else
            recTrust = 0;
        if(recTrust > 1)
            recTrust = 1;     
        return recTrust;
    }
     
    public double askRecommendation(Device sr, Device recommander,Device recOrSp){
        double rec ;
        double num;
        Random ran = new Random();
        double[] dirTrustArray = new double[7];
        dirTrustArray = recommander.dirTrustComponents.get(recOrSp.intDeviceId);
        if(recommander.nodestatus.equals(recommander.nodestatus.goodNode)){
            if(recommander.spsWhoProvidedService.contains(recOrSp)){
                rec = dirTrustArray[5];
            }
            else{
                double honesty;
                honesty = recommander.honestyList.get(recOrSp.intDeviceId);
                if(honesty > -1)
                    rec = honesty;
                else{
                    rec = -1;
                }
            }          
        }
        else{
            
            /*
            if(recOrSp.nodestatus.equals(recOrSp.nodestatus.goodNode)){
                num = ran.nextInt(3);
                rec = num/10;
                if(dirTrustArray[5] < rec)
                rec = dirTrustArray[5];
            }
            else{
                num = ran.nextInt(3);
                rec = num/10;
                if(dirTrustArray[5] > rec)
                rec = dirTrustArray[5];
            }
            */
            if(recOrSp.nodestatus.equals(recOrSp.nodestatus.goodNode)){
                if(recommander.spsWhoProvidedService.contains(recOrSp)){
                rec = dirTrustArray[5];
            }
            else{
                double honesty;
                honesty = recommander.honestyList.get(recOrSp.intDeviceId);
                if(honesty > -1)
                    rec = honesty;
                else{
                    //rec = 0;
                num = 3 + ran.nextInt(3);
                rec = num/10;
                }
            }
                //rec = 0;
                num = 3 + ran.nextInt(3);
                rec = num/10;
            }
            else{
                rec = 1;
            }          
        }
        if(rec > 1)
           rec = 1;
        return rec;  
    }    
    
    public double recommendedTrust(String attack, double totalTrust, Device recommander, Device recOrSp){
        double rec;
        double ownersFriendship = recommander.deviceUser.userSIoT.get(recOrSp.deviceUser.intUserId);
        double devicesFriendship = recommander.deviceSIoT.get(recOrSp.intDeviceId);
        Random ran = new Random();
        double num;
        double[] srTrustArray = new double[8];
        srTrustArray = recommander.trust.get(recOrSp.intDeviceId);
        if(totalTrust == -1){
            totalTrust = computefirstTrust(recommander,recOrSp);
            if(totalTrust > 1)
                totalTrust = 1;
            srTrustArray[1] = totalTrust;
            recommander.trust.remove(recOrSp.intDeviceId);
            recommander.trust.add(recOrSp.intDeviceId,srTrustArray);
         }
        switch(attack){
            case "Bad-mouthing attack":               
                if(recOrSp.nodestatus.equals(recOrSp.nodestatus.goodNode)){
                    num = ran.nextInt(3);
                    rec = num/10;
                    if(totalTrust < rec)
                        rec = totalTrust;
                }
                else{
                    rec = totalTrust;
                }    
                break;
            case "Ballot-stuffing attack":             
                if(ownersFriendship > 0.5 || devicesFriendship > 0.5 ||recOrSp.nodestatus.equals(recOrSp.nodestatus.badNode)){
                    num = 8 + ran.nextInt(3);
                    rec = num/10;
                    if(totalTrust > rec)
                        rec = totalTrust;
                }
                else{
                    rec = totalTrust;
                } 
                break;
            case "Ballot-stuffing attack && Bad-mouthing attack":               
                if(ownersFriendship > 0.5 || devicesFriendship > 0.5 ||recOrSp.nodestatus.equals(recOrSp.nodestatus.badNode)){
                    num = 8 + ran.nextInt(3);
                    rec = num/10;
                    if(totalTrust > rec)
                        rec = totalTrust;
                }
                else{
                    num = ran.nextInt(3);
                    rec = num/10;
                    if(totalTrust < rec)
                        rec = totalTrust;
                }
                break;
            default:
                rec = totalTrust;
                break;
        }
        if(rec > 1)
           rec = 1;
        return rec;
    }
    
    public void saveServiceFeadback(Device sr,Device sp,double spQos, double spCooperativeness){
        double Qos; 
        double Cooperativeness;
        double numberOfCooperativeness = 0;
        double numberOfGoodQoS = 0;
        double dir;
        double dirTrus;
        double oldDirTrus;
        double oldIndTrust;
        double totalTrust;
        double u = totalTrustWeigh [0];
        double wQos = dirTrustWeigh [0];
        double wCoo = dirTrustWeigh [1];
        double Wdir = dirTrustWeigh [2];
        int n;
        if(spQos > 1)
           spQos = 1;
        n = sr.numberOfSpServicesList.get(sp.intDeviceId);
        double[] spCooArray = new double[4];
        spCooArray = sr.spsCooperativenessList.get(sp.intDeviceId);
        double[] spQosArray = new double[4];
        spQosArray = sr.spsQosList.get(sp.intDeviceId);
        if(n != 4){
            spQosArray[n] = spQos;
        }
        else{
            for(int i=1;i<4;i++){
                spQosArray[i-1] = spQosArray[i]; 
            }
            spQosArray[3] = spQos;
        }
        sr.spsQosList.remove(sp.intDeviceId);
        sr.spsQosList.add(sp.intDeviceId, spQosArray);
        if(n < 4){
            n++;
            sr.numberOfSpServicesList.remove(sp.intDeviceId);
            sr.numberOfSpServicesList.add(sp.intDeviceId, n);
        }
        for(int i=0;i<n;i++){
            if(spCooArray[i] == 1)
                numberOfCooperativeness++;
        }
        for(int i=0;i<n;i++){
            if(spQosArray[i] == 1) 
                numberOfGoodQoS++;
        }
        Qos = numberOfGoodQoS/n;
        Cooperativeness = numberOfCooperativeness/n;
        if(Qos > 1)
            Qos = 1;
        if(Cooperativeness > 1)
            Cooperativeness = 1;
        //j(SPId)0,QoS 1,cooperativeness 2,honestySpOwner 3,devicesFriendship 4,ownersFriendship 5, dirT 6 :[7] 
        double[] dirTrustArray = new double[7];
        dirTrustArray = sr.dirTrustComponents.get(sp.intDeviceId);
        oldDirTrus = dirTrustArray[6];
        dir = wQos*Qos+wCoo*Cooperativeness;
        if(oldDirTrus != -1.0){
            dirTrus = Wdir*dir + (1-Wdir)*oldDirTrus;
        }    
        else{
            dirTrus = dir;
        }
        if(dirTrus > 1)
            dirTrus = 1; 
        cumputRecommanderHonestyAndTrust(sr, sp, spQos, dirTrus);
        dirTrustArray[1] = Qos; 
        dirTrustArray[2] = Cooperativeness;
        dirTrustArray[5] = dir;
        dirTrustArray[6] = dirTrus;
        sr.dirTrustComponents.remove(sp.intDeviceId);
        sr.dirTrustComponents.add(sp.intDeviceId, dirTrustArray);
        double[] srTrustArray = new double[8];
        srTrustArray = sr.trust.get(sp.intDeviceId);
        oldIndTrust  = srTrustArray[3];
        double aBS= Math.abs(srTrustArray[6] - dir);
        if (sr.nodestatus.equals(sr.nodestatus.goodNode)){
            GVMAE.add(aBS);
            GVRMSE.add(Math.pow(aBS,2));
        }
        MAE.add(aBS);
        RMSE.add(Math.pow(aBS,2));
        if(oldIndTrust >= 0)
            totalTrust = u*dirTrus + (1-u)*oldIndTrust;
        else
            totalTrust = dirTrus;
        if(totalTrust > 1)
            totalTrust = 1;
        srTrustArray[1] = totalTrust;
        srTrustArray[2] = dirTrus;
        sr.trust.remove(sp.intDeviceId);
        sr.trust.add(sp.intDeviceId, srTrustArray);
        falseNegativeAndPositives(sp, totalTrust);
        if (sp.nodestatus.equals(sp.nodestatus.goodNode)){
            convergenceOfGoodNodes.add(totalTrust);
        }
        else{
            convergenceOfBadNodes.add(totalTrust);
        }
        if (sr.nodestatus.equals(sr.nodestatus.goodNode)){
            GoodVfp(sp, totalTrust);
            if (sp.nodestatus.equals(sp.nodestatus.goodNode)){
                GVconvergenceOfGoodNodes .add(totalTrust);
            }
            else{
                GVconvergenceOfBadNodes .add(totalTrust);
            }
        }
        if (sp.intDeviceId == ChangedNode.intDeviceId)
            changeBehaviorTrust.add(totalTrust); 
    }
    public void cumputRecommanderHonestyAndTrust(Device sr,Device sp,double spQos,double calculatedDirTrus){
        double rHonesty;
        double honesty;
        double dirTrus;
        double oldDirTrus;
        double oldIndTrust;
        double totalTrust;
        double recommandedTrus;
        double u = totalTrustWeigh [0];
        double wHOw  = dirTrustWeigh [3];
        double t3 = thereshould[0];
        double numberOfhonest = 0;
        int n;

        for(Device r : sr.deviceNeighbors){
            double[] recArray = new double[sr.totalNumberOfDevices];    
            recArray = sr.recommandationList.get(r.intDeviceId);
            recommandedTrus = recArray[sp.intDeviceId];
            if((Math.abs(calculatedDirTrus - recommandedTrus))> t3)
                rHonesty = 0;
            else
                rHonesty = 1;
            SIoTserver.updateRecommanderDeviceSIoT(sr, r, rHonesty);
            sr.honestyList.remove(r.intDeviceUserId);
            sr.honestyList.add(r.intDeviceUserId, rHonesty); 
            n = sr.numberOfRecommandList.get(r.intDeviceId);
            double[] honestyArray = new double[4];
            honestyArray = sr.recommanderHonestyList.get(r.intDeviceId);
            if(n != 4){
                honestyArray[n] = rHonesty;
            }
            else{
                for(int i=1;i<4;i++){
                    honestyArray[i-1] = honestyArray[i]; 
                }
                honestyArray[3] = rHonesty;
            }
            sr.recommanderHonestyList.remove(r.intDeviceId);
            sr.recommanderHonestyList.add(r.intDeviceId, honestyArray);
            if(n < 4){
                n++;
                sr.numberOfRecommandList.remove(r.intDeviceId);
                sr.numberOfRecommandList.add(r.intDeviceId, n);
            }        
            for(int i=0;i<n;i++){
                if(honestyArray[i] == 1)
                    numberOfhonest++;
            }
            honesty = numberOfhonest/n;
            if(honesty > 1)
                honesty = 1;
            double[] dirTrustArray = new double[7];
            dirTrustArray = sr.dirTrustComponents.get(r.intDeviceId);
            oldDirTrus = dirTrustArray[6];
            if(oldDirTrus >= 0){
                dirTrus = wHOw *honesty + (1-wHOw )*oldDirTrus;
            }    
            else{
                dirTrus = honesty;
            }
            if(dirTrus > 1)
                dirTrus = 1;
            dirTrustArray[4] = honesty;
            dirTrustArray[6] = dirTrus;
            sr.dirTrustComponents.remove(r.intDeviceId);
            sr.dirTrustComponents.add(r.intDeviceId, dirTrustArray);
            double[] srTrustArray = new double[8];
            srTrustArray = sr.trust.get(r.intDeviceId);
            oldIndTrust  = srTrustArray[3];   
            if(oldIndTrust >= 0)
                totalTrust = u*dirTrus + (1-u)*oldIndTrust;
            else
                totalTrust = dirTrus;
            srTrustArray[1] = totalTrust;
            srTrustArray[2] = dirTrus;
            sr.trust.remove(r.intDeviceId);
            sr.trust.add(r.intDeviceId, srTrustArray);
            falseNegativeAndPositives(r, totalTrust);
            if (sp.nodestatus.equals(sp.nodestatus.goodNode)){
                convergenceOfGoodNodes.add(totalTrust);
            }
            else{
                convergenceOfBadNodes.add(totalTrust);
            }
            if (sr.nodestatus.equals(sr.nodestatus.goodNode)){
                GoodVfp(sp, totalTrust);
                if (sp.nodestatus.equals(sp.nodestatus.goodNode)){
                    GVconvergenceOfGoodNodes .add(totalTrust);
                }
                else{
                    GVconvergenceOfBadNodes .add(totalTrust);
                }
            } 
            if (sp.intDeviceId == ChangedNode.intDeviceId)
                    changeBehaviorTrust.add(totalTrust); 
        }
    }
    
    
    public void selectSrNeighborhood(Device sr){
        List<Device> nd = new ArrayList<Device>();
        List<Device> ndu = new ArrayList<Device>();
        List<Device> tempUsersDevices = new ArrayList<Device>();
        List<User> nu = new ArrayList<User>();       
        double [][] tempSrNeighbors = new double[totalNumberOfDevices][2];
        double [][] tempSrNeighborOwners = new double[totalNumberOfUsers][2];
        int count =0;
        int counter =0;
        for(Device d : devices){
            if(d != sr){
            tempSrNeighbors[count][0] = d.doubleDeviceId;
            tempSrNeighbors[count][1] = sr.spdeviceSimilarity.get(d.intDeviceId);
            count++;
            }
        }
        for(int i=0;i<totalNumberOfDevices;i++){
            for(int j=1;j<totalNumberOfDevices;j++){
                if(tempSrNeighbors[j-1][1]<tempSrNeighbors[j][1]){
                   double[] tempArray = new double[2];
                   tempArray = tempSrNeighbors[j-1];
                   tempSrNeighbors[j-1] = tempSrNeighbors[j];
                   tempSrNeighbors[j] = tempArray;
                }
            }           
        }
        for(int i=0;i<neighborNumbers[3];i++){
            for(int j=0;j<doubleDeviceIds.size();j++){
                if(tempSrNeighbors[i][0] == doubleDeviceIds.get(j)){
                    nd.add(devices.get(j));
                    continue;
                }  
            }
        }
        for(User u : users){
            if(u != sr.deviceUser){
            tempSrNeighborOwners[counter][0] = u.doubleUserId;
            tempSrNeighborOwners[counter][1] = sr.deviceUser.userSimilarity.get(u.intUserId);
            counter++;
            }
        }
        for(int i=0;i<totalNumberOfUsers;i++){
            for(int j=1;j<totalNumberOfUsers;j++){
                if(tempSrNeighborOwners[j-1][1]<tempSrNeighborOwners[i][1]){
                   double[] tempArray = new double[2];
                   tempArray = tempSrNeighborOwners[j-1];
                   tempSrNeighborOwners[j-1] = tempSrNeighborOwners[j];
                   tempSrNeighborOwners[j] = tempArray;
                }
            }           
        }
        for(int i=0;i<neighborNumbers[1];i++){
            for(int j=0;j<doubleUserIds.size();j++){
                if(tempSrNeighborOwners[i][0] == doubleUserIds.get(j)){
                    nu.add(users.get(j));
                    continue;
                }  
            }
        }
        for(User u : nu){
            for(Device d : u.userDevices){
            tempUsersDevices.add(d);
            }
        }
        count = 0;
        double [][] tempSrN = new double[tempUsersDevices.size()][2];
        for(Device d : tempUsersDevices){
            tempSrN[count][0] = d.doubleDeviceId;
            tempSrN[count][1] = sr.spdeviceSimilarity.get(d.intDeviceId);
            count++;
        }
        for(int i=0;i<tempUsersDevices.size();i++){
            for(int j=1;j<tempUsersDevices.size();j++){
                if(tempSrN[j-1][1]<tempSrN[j][1]){
                   double[] tempArray = new double[2];
                   tempArray = tempSrN[j-1];
                   tempSrN[j-1] = tempSrN[j];
                   tempSrN[j] = tempArray;
                }
            }           
        }
        for(int i=0;i<neighborNumbers[2];i++){
            for(int j=0;j<doubleDeviceIds.size();j++){
                if(tempSrNeighbors[i][0] == doubleDeviceIds.get(j)){
                    ndu.add(devices.get(j));
                    continue;
                }  
            }
        }
        //0 deviceid,1 trust    
        double[][] tempSelectSrNeighborhood = new double[(ndu.size()+nd.size())][2];
        int index = 0;
        for(int j=0;j<nd.size();j++){
            tempSelectSrNeighborhood[index][0] = nd.get(j).doubleDeviceId;
            tempSelectSrNeighborhood[index][1] = computeTrust(sr, nd.get(j));
            index++;
        }
        for(int k=0;k<ndu.size();k++){
            tempSelectSrNeighborhood[index][0] = ndu.get(k).doubleDeviceId;
            tempSelectSrNeighborhood[index][1] = computeTrust(sr, ndu.get(k));
            index++;
        }
        for(int i=0;i<(ndu.size()+nd.size());i++){
            for(int j=1;j<(ndu.size()+nd.size());j++){
                if(tempSelectSrNeighborhood[j-1][1]<tempSelectSrNeighborhood[j][1]){
                   double[] tempArray = new double[2];
                   tempArray = tempSelectSrNeighborhood[j-1];
                   tempSelectSrNeighborhood[j-1] = tempSelectSrNeighborhood[j];
                   tempSelectSrNeighborhood[j] = tempArray;
                }
            }           
        }
        sr.deviceNeighbors.clear();
        for(int i=0;i<neighborNumbers[0];i++){
            for(int j=0;j<doubleDeviceIds.size();j++){
                if(tempSelectSrNeighborhood[i][0] == doubleDeviceIds.get(j)){
                    if(sr.deviceNeighbors.contains(devices.get(j)))
                        continue;
                    else{
                        sr.deviceNeighbors.add(devices.get(j));
                        continue;
                    }    
                }  
            }
        }
        List<Device> userDevice = sr.deviceUser.userDevices;
        for(int i=0;i<(userDevice.size());i++){
            if (sr!=userDevice.get(i)){
                sr.deviceNeighbors.add(userDevice.get(i));
            }
        }
    }
    

    public void onlyComputeDirTrust(Device sr,Device sp,double spQos, double spCooperativeness){ 
        double Qos; 
        double Cooperativeness;
        double numberOfCooperativeness = 0;
        double numberOfGoodQoS = 0;
        double dir;
        double dirTrus;
        double oldDirTrus;
        double totalTrust;
        double wQos = dirTrustWeigh [0];
        double wCoo = dirTrustWeigh [1];
        double e = indTrustWeigh [1];
        int n;
        if(spQos > 1)
           spQos = 1;
        n = sr.numberOfSpServicesList.get(sp.intDeviceId);
        double[] spCooArray = new double[4];
        spCooArray = sr.spsCooperativenessList.get(sp.intDeviceId);
        double[] spQosArray = new double[4];
        spQosArray = sr.spsQosList.get(sp.intDeviceId);
        if(n != 4){
            spQosArray[n] = spQos;
        }
        else{
            for(int i=1;i<4;i++){
                spQosArray[i-1] = spQosArray[i]; 
            }
            spQosArray[3] = spQos;
        }
        sr.spsQosList.remove(sp.intDeviceId);
        sr.spsQosList.add(sp.intDeviceId, spQosArray);
        if(n < 4){
            n++;
            sr.numberOfSpServicesList.remove(sp.intDeviceId);
            sr.numberOfSpServicesList.add(sp.intDeviceId, n);
        }
        for(int i=0;i<n;i++){
            if(spCooArray[i] == 1)
                numberOfCooperativeness++;
        }
        for(int i=0;i<n;i++){
            if(spQosArray[i] == 1) 
                numberOfGoodQoS++;
        }
        Qos = numberOfGoodQoS/n;
        Cooperativeness = numberOfCooperativeness/n;
        if(Qos > 1)
            Qos = 1;
        if(Cooperativeness > 1)
            Cooperativeness = 1;
        //j(SPId)0,QoS 1,cooperativeness 2,honestySpOwner 3,devicesFriendship 4,ownersFriendship 5, dirT 6 :[7] 
        double[] dirTrustArray = new double[7];
        dirTrustArray = sr.dirTrustComponents.get(sp.intDeviceId);
        oldDirTrus = dirTrustArray[6];
        dir = wQos*Qos+wCoo*Cooperativeness;
        if(oldDirTrus != -1.0){
            dirTrus = e*dir + (1-e)*oldDirTrus;
        }    
        else{
            dirTrus = dir;
        }
        if(dirTrus > 1)
            dirTrus = 1;
        dirTrustArray[1] = Qos; 
        dirTrustArray[2] = Cooperativeness;;
        dirTrustArray[6] = dirTrus;
        sr.dirTrustComponents.remove(sp.intDeviceId);
        sr.dirTrustComponents.add(sp.intDeviceId, dirTrustArray);
        double[] srTrustArray = new double[8];
        srTrustArray = sr.trust.get(sp.intDeviceId);
        double aBS= Math.abs(srTrustArray[6] - dir);
//        MAE.add(aBS);
 //       RMSE.add(Math.pow(aBS,2));
        totalTrust = dirTrus;
        if(totalTrust > 1)
            totalTrust = 1;
        srTrustArray[1] = totalTrust;
        srTrustArray[2] = dirTrus;
        sr.trust.remove(sp.intDeviceId);
        sr.trust.add(sp.intDeviceId, srTrustArray);
        falseNegativeAndPositives(sp, totalTrust);
        if (sp.nodestatus.equals(sp.nodestatus.goodNode)){
            convergenceOfGoodNodes.add(totalTrust);
        }
        else{
            convergenceOfBadNodes.add(totalTrust);
        }
        if (sr.nodestatus.equals(sr.nodestatus.goodNode)){
            GoodVfp(sp, totalTrust);
            if (sp.nodestatus.equals(sp.nodestatus.goodNode)){
                GVconvergenceOfGoodNodes .add(totalTrust);
            }
            else{
                GVconvergenceOfBadNodes .add(totalTrust);
            }
        }
    }
    public void onlyRecSystemNeighbors(Device sr){    
        double [][] tempSrNeighbors = new double[totalNumberOfDevices][2];
        int count =0;
        for(Device d : devices){
            if(d != sr){
            tempSrNeighbors[count][0] = d.doubleDeviceId;
            tempSrNeighbors[count][1] = sr.spdeviceSimilarity.get(d.intDeviceId);
            count++;
            }
        }
        for(int i=0;i<totalNumberOfDevices;i++){
            for(int j=1;j<totalNumberOfDevices;j++){
                if(tempSrNeighbors[j-1][1]<tempSrNeighbors[j][1]){
                   double[] tempArray = new double[2];
                   tempArray = tempSrNeighbors[j-1];
                   tempSrNeighbors[j-1] = tempSrNeighbors[j];
                   tempSrNeighbors[j] = tempArray;
                }
            }           
        }
        //0 deviceid,1 trust
        sr.deviceNeighbors.clear();
        for(int i=0;i<neighborNumbers[0];i++){
            for(int j=0;j<doubleDeviceIds.size();j++){
                if(tempSrNeighbors[i][0] == doubleDeviceIds.get(j)){
                    sr.deviceNeighbors.add(devices.get(j));
                    continue;    
                }  
            }
        }
        List<Device> userDevice = sr.deviceUser.userDevices;
        for(int i=0;i<(userDevice.size());i++){
            if (sr!=userDevice.get(i)){
                sr.deviceNeighbors.add(userDevice.get(i));
            }
        }
    }
    
    public double onlySimilarityRecSystemUserBaced(Device sr,Device sp){
        double recommendersSim;
        double ownerOfRecommenderSim;
        double rec;
        double recTrust = 0.0;
        double wRec;
        int size = sr.deviceNeighbors.size();
        double[] wRecTemp = new double[size];
        double[] recTemp = new double[size];
        double sigma = 0.0;
        int count = 0;
        for(Device r : sr.deviceNeighbors){
            recommendersSim = sr.spdeviceSimilarity.get(r.intDeviceId);
            ownerOfRecommenderSim = sr.deviceUser.userSimilarity.get(r.deviceUser.intUserId);
            wRec = 0.5* recommendersSim + 0.5* ownerOfRecommenderSim;
            if(wRec > 1)
                wRec = 1;           
            rec = askRecommendation(sr, r, sp);
            if(rec > 1)
                rec = 1;
            if(rec >= 0){
                wRecTemp[count] = wRec;
                recTemp[count] = rec;
                count++;
                double[] recArray = sr.recommandationList.get(r.intDeviceId);
                recArray[sp.intDeviceId] = rec;
                sr.recommandationList.remove(r.intDeviceId);
                sr.recommandationList.add(r.intDeviceId, recArray);
            }
        }
        double totalRecTemp = 0;
        for(int k=0;k<size;k++){
            sigma += wRecTemp[k];
            totalRecTemp += recTemp[k] * wRecTemp[k];
        }
        if(sigma != 0){
            for(int k=0;k<size;k++){
            recTrust = totalRecTemp/sigma;  
            }
        }
        else
            recTrust = 0;
        if(recTrust > 1)
            recTrust = 1;      
        return recTrust;
    }
    

    public void falseNegativeAndPositives(Device sp, double trust){
        if(sp.nodestatus.equals(sp.nodestatus.badNode)){
            totalNegative++;           
        }
        else{
            totalPositive++;          
        }
        if(trust > 0.5 && sp.nodestatus.equals(sp.nodestatus.badNode)){
            totalFN++;
        }
        else{
            if(trust < 0.5 && sp.nodestatus.equals(sp.nodestatus.badNode)){
            totalTN++;
            }
        }
        if(trust < 0.5 && sp.nodestatus.equals(sp.nodestatus.goodNode)){
            totalFP++;
        }
        else{
            if(trust > 0.5 && sp.nodestatus.equals(sp.nodestatus.goodNode)){
            totalTP++;
            }
        }
    }
    
    public void GoodVfp(Device sp, double trust){
        if(sp.nodestatus.equals(sp.nodestatus.badNode)){
            GVtotalNegative++;          
        }
        else{
            GVtotalPositive++;           
        }
        if(trust > 0.5 && sp.nodestatus.equals(sp.nodestatus.badNode)){
            GVtotalFN++;
        }
        else{
            if(trust < 0.5 && sp.nodestatus.equals(sp.nodestatus.badNode)){
            GVtotalTN++;
            }
        }
        if(trust < 0.5 && sp.nodestatus.equals(sp.nodestatus.goodNode)){
            GVtotalFP++;
        }
        else{
            if(trust > 0.5 && sp.nodestatus.equals(sp.nodestatus.goodNode)){
            GVtotalTP++;
            }
        }
    }
    
    public void totalGoodVfp( int timeOfRun){
        double[] FN = new double[2];
        FN[0] = timeOfRun;
        if(GVtotalNegative != 0){
            GVtotalPFN = GVtotalFN/GVtotalNegative;
            FN[1] = GVtotalPFN;
            GVtotalFalseNegative.add(FN);         
        }
        else{
            GVtotalPFN = 0;
            FN[1] = GVtotalPFN;
            GVtotalFalseNegative.add(FN);        
        }
        double[] FP = new double[2];
        FP[0] = timeOfRun;
        if(GVtotalPositive != 0){
            GVtotalPFP = GVtotalFP/GVtotalPositive;
            FP[1] = GVtotalPFP;
            GVtotalFalsePositive.add(FP);          
        }
        else{
            GVtotalPFP = 0;
            FP[1] = GVtotalPFP;
            GVtotalFalsePositive.add(FP);           
        }
        double[] TN = new double[2];
        TN[0] = timeOfRun;
        if(GVtotalNegative != 0){
            GVtotalPTN = GVtotalTN/GVtotalNegative;
            TN[1] = GVtotalPTN;
            GVtotalTrueNegative.add(TN);          
        }
        else{
            GVtotalPTN = 0;
            TN[1] = GVtotalPTN;
            GVtotalTrueNegative.add(TN);          
        }
        double[] TP = new double[2];
        TP[0] = timeOfRun;
        if(GVtotalPositive != 0){
            GVtotalPTP = GVtotalTP/GVtotalPositive;
            TP[1] = GVtotalPTP;
            GVtotalTruePositive.add(TP);          
        }
        else{
            GVtotalPTP = 0;
            TP[1] = GVtotalPTP;
            GVtotalTruePositive.add(TP);         
        }
    }
    
    public void totalFalseNegativeAndPositive( int timeOfRun){
        double[] FN = new double[2];
        FN[0] = timeOfRun;
        if(totalNegative != 0){
            totalPFN = totalFN/totalNegative;
            FN[1] = totalPFN;
            totalFalseNegative.add(FN);            
        }
        else{
            totalPFN = 0;
            FN[1] = totalPFN;
            totalFalseNegative.add(FN);         
        }
        double[] FP = new double[2];
        FP[0] = timeOfRun;
        if(totalPositive != 0){
            totalPFP = totalFP/totalPositive;
            FP[1] = totalPFP;
            totalFalsePositive.add(FP);         
        }
        else{
            totalPFP = 0;
            FP[1] = totalPFP;
            totalFalsePositive.add(FP);          
        }
        double[] TN = new double[2];
        TN[0] = timeOfRun;
        if(totalNegative != 0){
            totalPTN = totalTN/totalNegative;
            TN[1] = totalPTN;
            totalTrueNegative.add(TN);          
        }
        else{
            totalPTN = 0;
            TN[1] = totalPTN;
            totalTrueNegative.add(TN);         
        }
        double[] TP = new double[2];
        TP[0] = timeOfRun;
        if(totalPositive != 0){
            totalPTP = totalTP/totalPositive;
            TP[1] = totalPTP;
            totalTruePositive.add(TP);          
        }
        else{
            totalPTP = 0;
            TP[1] = totalPTP;
            totalTruePositive.add(TP);          
        }
    }
    
    public void trustConvergence( int timeOfRun){
        double[] conOfGoodNodes = new double[2];
        double[] conOfBadNodes = new double[2];
        conOfGoodNodes[0] = timeOfRun;
        conOfBadNodes[0] = timeOfRun;
        double sigmaTrustForGoodNodes = 0;
        double sigmaTrustForBadNodes = 0;
        double[] GVconOfGoodNodes = new double[2];
        double[] GVconOfBadNodes = new double[2];
        GVconOfGoodNodes[0] = timeOfRun;
        GVconOfBadNodes[0] = timeOfRun;
        double GVsigmaTrustForGoodNodes = 0;
        double GVsigmaTrustForBadNodes = 0;
        
        double[] totalC = new double[2];
        totalC [0] = timeOfRun;
        double sigmachangeBehaviorTrust = 0;
        for(int i = 0; i < changeBehaviorTrust .size(); i++){
            sigmachangeBehaviorTrust = sigmachangeBehaviorTrust + changeBehaviorTrust .get(i);
        }
        if(changeBehaviorTrust .size() != 0){
            totalC[1] = (sigmachangeBehaviorTrust/changeBehaviorTrust .size());
            totalChangeBehaviorTrust .add(totalC);
        }
        for(int i = 0; i < convergenceOfGoodNodes.size(); i++){
            sigmaTrustForGoodNodes = sigmaTrustForGoodNodes + convergenceOfGoodNodes.get(i);
        }
        for(int i = 0; i < convergenceOfBadNodes.size(); i++){
            sigmaTrustForBadNodes = sigmaTrustForBadNodes + convergenceOfBadNodes.get(i);
        }
        if(convergenceOfGoodNodes.size() != 0){
            conOfGoodNodes[1] = (sigmaTrustForGoodNodes/convergenceOfGoodNodes.size());
            trustConvergenceOfGoodNodes.add(conOfGoodNodes);
        }
        if(convergenceOfBadNodes.size() != 0){
            conOfBadNodes[1] = (sigmaTrustForBadNodes/convergenceOfBadNodes.size());
            trustConvergenceOfBadNodes.add(conOfBadNodes);
        }
        for(int i = 0; i < GVconvergenceOfGoodNodes.size(); i++){
            GVsigmaTrustForGoodNodes = GVsigmaTrustForGoodNodes + GVconvergenceOfGoodNodes.get(i);
        }
        for(int i = 0; i < GVconvergenceOfBadNodes.size(); i++){
            GVsigmaTrustForBadNodes = GVsigmaTrustForBadNodes + GVconvergenceOfBadNodes.get(i);
        }
        if(GVconvergenceOfGoodNodes.size() != 0){
            GVconOfGoodNodes[1] = (GVsigmaTrustForGoodNodes/GVconvergenceOfGoodNodes.size());
            GVtrustConvergenceOfGoodNodes.add(GVconOfGoodNodes);
        }
        if(GVconvergenceOfBadNodes.size() != 0){
            GVconOfBadNodes[1] = (GVsigmaTrustForBadNodes/GVconvergenceOfBadNodes.size());
            GVtrustConvergenceOfBadNodes.add(GVconOfBadNodes);
        }       
    }
    
    public void trustConvergence2( int timeOfRun){
        double[] convergenceOfGoodNodes = new double[2];
        double[] convergenceOfBadNodes = new double[2];
        convergenceOfGoodNodes[0] = timeOfRun;
        convergenceOfBadNodes[0] = timeOfRun;
        double sigmaTrustForGoodNodes = 0;
        double sigmaTrustForBadNodes = 0;
        int countForGoodNodes = 0;
        int countForBadNodes = 0;
        double tempT;
        for(int i = 0; i < goodNodes.size() ; i++){
            int deviceIndex2 = goodNodes.get(i);
            for(int deviceIndex1 = 0; deviceIndex1 < totalNumberOfDevices ; deviceIndex1++){
                double[] tempTrust = new double[8];
                if(deviceIndex1 != deviceIndex2){
                        tempTrust = devices.get(deviceIndex1).trust.get(deviceIndex2);
                        tempT = tempTrust[1];
                    if(tempT == -1){
                        tempT = computefirstTrust(devices.get(deviceIndex1),devices.get(deviceIndex2));
                        if(tempT > 1)
                            tempT = 1;
                        tempTrust[1] = tempT;
                        devices.get(deviceIndex1).trust.remove(deviceIndex2);
                        devices.get(deviceIndex1).trust.add(deviceIndex2,tempTrust);
                    }
                    if(tempTrust[1] != -1){
                        sigmaTrustForGoodNodes = sigmaTrustForGoodNodes + tempTrust[1];
                        countForGoodNodes++;
                    }
                }
            }
        }
        for(int i = 0; i < badNodes.size() ; i++){
            int deviceIndex2 = badNodes.get(i);
            for(int deviceIndex1 = 0; deviceIndex1 < totalNumberOfDevices ; deviceIndex1++){
                double[] tempTrust = new double[8];
                if(deviceIndex1 != deviceIndex2){
                    tempTrust = devices.get(deviceIndex1).trust.get(deviceIndex2);
                        tempT = tempTrust[1];
                    if(tempT == -1){
                        tempT = computefirstTrust(devices.get(deviceIndex1),devices.get(deviceIndex2));
                        if(tempT > 1)
                            tempT = 1;
                        tempTrust[1] = tempT;
                        devices.get(deviceIndex1).trust.remove(deviceIndex2);
                        devices.get(deviceIndex1).trust.add(deviceIndex2,tempTrust);
                    }
                    if(tempTrust[1] != -1){
                        sigmaTrustForBadNodes = sigmaTrustForBadNodes + tempT;
                        countForBadNodes++;                    
                    }
                }
            }
        }
        convergenceOfGoodNodes[1] = (sigmaTrustForGoodNodes/countForGoodNodes);
        convergenceOfBadNodes[1] = (sigmaTrustForBadNodes/countForBadNodes);

        trustConvergenceOfGoodNodes.add(convergenceOfGoodNodes);
        trustConvergenceOfBadNodes.add(convergenceOfBadNodes);
    }
    
    public void recSystemEvaluation( int timeOfRun){
        double[] totalM = new double[2];
        double[] totalR = new double[2];
        totalM[0] = timeOfRun;
        totalR[0] = timeOfRun;
        double sigmaMAE = 0;
        double sigmaRMSE = 0;
        for(int i = 0; i < MAE.size(); i++){
            sigmaMAE = sigmaMAE + MAE.get(i);
        }
        for(int i = 0; i < RMSE.size(); i++){
            sigmaRMSE = sigmaRMSE + RMSE.get(i);
        }
//System.out.println("MAE.size(): "+ MAE.size());
        if(MAE.size() != 0){
            totalM[1] = (sigmaMAE/MAE.size());
//System.out.println("totalMAE[1]: "+ totalM[1]);
            totalMAE.add(totalM);
        }
        if(RMSE.size() != 0){
            totalR[1] = Math.sqrt(sigmaRMSE/RMSE.size());
            totalRMSE.add(totalR);
        }
        double[] GVtotalM = new double[2];
        double[] GVtotalR = new double[2];
        GVtotalM[0] = timeOfRun;
        GVtotalR[0] = timeOfRun;
        double GVsigmaMAE = 0;
        double GVsigmaRMSE = 0;
        for(int i = 0; i < GVMAE.size(); i++){
            GVsigmaMAE = GVsigmaMAE + GVMAE.get(i);
        }
        for(int i = 0; i < GVRMSE.size(); i++){
            GVsigmaRMSE = GVsigmaRMSE + GVRMSE.get(i);
        }
        if(GVMAE.size() != 0){
            GVtotalM[1] = (GVsigmaMAE/GVMAE.size());
            GVtotalMAE.add(GVtotalM);
        }
        if(GVRMSE.size() != 0){
            GVtotalR[1] = Math.sqrt(GVsigmaRMSE/GVRMSE.size());
            GVtotalRMSE.add(GVtotalR);
        }
    }
    public void timesOfRuns(int percentageOfDevicesInRadioRange, int percentageOfBusyDevices, int percentageOfRequestersFromDevicesInRadioRange, int times, int numberOfNewBadNodes, int timeOfChangingBehavior){
        for(int i=0;i<times;i++){
System.out.println("timesOfRun: "+ i);
                initialFalseNegativeAndPositives();
            /*
            int j = 0;
            if(i == timeOfChangingBehavior){
                while(j < numberOfNewBadNodes){
                    if(!goodNodes.isEmpty()){
                        devices.get(goodNodes.get(0)).nodestatus = devices.get(goodNodes.get(0)).nodestatus.badNode;
                        badNodes.add(goodNodes.get(0));
                        goodNodes.remove(0);
                    }
                    else
                        break;
                }
            }
            */
            chooseDevicesInRadioRange(percentageOfDevicesInRadioRange, percentageOfBusyDevices, i);
            if(i == 0){
                for(int k=0; k<devicesInRadioRange.size(); k++){
                Device node;
                node = devicesInRadioRange.get(k);
                    if(node.nodestatus.equals(node.nodestatus.goodNode)){
                        ChangedNode = node;
                        break;
                    }
                }
            } 
                /*
            if(i == timeOfChangingBehavior){
                ChangedNode.nodestatus = ChangedNode.nodestatus.badNode;
            }
            */
            chooseRequesters(percentageOfRequestersFromDevicesInRadioRange);
            for(Device sr : randomRequesters){
                if(sr.timesOfRequest > 1){
                    selectSrNeighborhood(sr);
//                    onlyRecSystemNeighbors( sr);          
                }
            }
            MAE.clear();
            RMSE.clear();
            convergenceOfGoodNodes.clear();
            convergenceOfBadNodes.clear();
            changeBehaviorTrust.clear();
            GVMAE.clear();
            GVRMSE.clear();
            GVconvergenceOfGoodNodes.clear();
            GVconvergenceOfBadNodes.clear();
            services(randomRequesters, devicesInRadioRange);
            for(Device sr : randomRequesters){
                SIoTserver.updateUserTrust(sr);
            }
            SIoTserver.updateFriendLists(users, devices);
            SimilarityServer.updateUserSimilarity(users);
            SimilarityServer.updateDeviceSimilarity(devices);
//          SimilarityServer.onlySimRecUpdateDeviceSimilarity(devices);
            totalFalseNegativeAndPositive(i);
            totalGoodVfp(i);
            trustConvergence(i);
            recSystemEvaluation(i);
            WriteOutput.writeFalseNegativeAndPositive(totalFalseNegative , "PFN", "PFN");
            WriteOutput.writeFalseNegativeAndPositive(totalFalsePositive, "PFP", "PFP");
//          WriteOutput.writeFalseNegativeAndPositive(totalTrueNegative, "PTN", "PTN");
//          WriteOutput.writeFalseNegativeAndPositive(totalTruePositive, "PTP", "PTP");
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
       
        }
    }

    public static void main(String[] args){
        TrustManagement m = new TrustManagement();
        /*
        // 0 honesty t3,1 TQoS t1,2 Tcoo t2
        m.setThereshould (0.8, 0.5, 0.5);
        // 0 dirTrustUpdate u,1 indTrustUpdate B,2 first W
        m.setTotalTrustWeigh(0.8, 0.8, 0.5);
        //0 WQoS ,1 Wcoo ,2 Wdir dirTrustUpdate of dir,3 wHon dirTrustUpdate of honestyDir
        m.setdirTrustWeigh(0.5, 0.5, 0.5, 0.7);
        // 0 Wpre g,1 indUpdate e
        m.setindTrustWeigh(0.7, 0.5);
        //0 m0,1 m1,2 m2,3 m3,4 numberOfNeighborsOfSp
        //m.setNeighborNumbers(5, 10, 10, 10, 5);
        m.setNeighborNumbers(10, 15, 15, 15, 10);
        */
        // 0 honesty t3,1 TQoS t1,2 Tcoo t2
        m.setThereshould (0.3, 0.5, 0.5);
        // 0 dirTrustUpdate u,1 indTrustUpdate B,2 first W
        m.setTotalTrustWeigh(1, 0.3, 0.5);
        //0 WQoS ,1 Wcoo ,2 Wdir dirTrustUpdate of dir,3 wHon dirTrustUpdate of honestyDir
        m.setdirTrustWeigh(0.5, 0.5, 0.8, 0.3);
        // 0 Wpre g,1 indUpdate e
        m.setindTrustWeigh(0.5, 0.5);
        //0 m0,1 m1,2 m2,3 m3,4 numberOfNeighborsOfSp
        //m.setNeighborNumbers(5, 10, 10, 10, 5);
        m.setNeighborNumbers(10, 15, 15, 15, 10);
        //(int numberOfUsers,int maxNumOfDevicesForAnyUser,int numberOfHeads,double doubleNumberOfHeads)
        //m.madeUsersAndHeadsAndDevicesAndAsignDevicesToUsers(50, 6, 50, 50);
        m.madeUsersAndHeadsAndDevicesAndAsignDevicesToUsers(20, 6, 20, 20);
        //m.madeUsersAndHeadsAndDevicesAndAsignDevicesToUsers(15, 6, 15, 15);
        //(InRadioRange, BusyDevices, Requesters, int times, int numberOfNewBadNodes, int timeOfChangingBehavior)
        //m.timesOfRuns(50, 20, 20, 200, 0, 100);
        m.timesOfRuns(80, 20, 80, 301, 0, 0);
    
    }
}
