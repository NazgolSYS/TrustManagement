
package trust.management;

import java.util.ArrayList;
import java.util.List;


public class SIoTserver {
    
    public static void updateFriendLists(List<User> users, List<Device> devices){
        for(int userIndex1 = 0; userIndex1 < users.size() ; userIndex1++){
            User u1;
            u1 = users.get(userIndex1);
            u1.userFriend.clear();
            for(int userIndex2 = 0; userIndex2 < users.size() ; userIndex2++){
                if(userIndex1!= userIndex2){
                    double siot;
                    siot = u1.userSIoT.get(userIndex2);
                    if(siot > 0)
                        u1.userFriend.add(userIndex2);
                }
            }
        }
        for(int deviceIndex1 = 0; deviceIndex1 < devices.size() ; deviceIndex1++){
            (devices.get(deviceIndex1)).deviceFriend.clear();
            for(int deviceIndex2 = 0; deviceIndex2 < devices.size() ; deviceIndex2++){
                if(deviceIndex1!= deviceIndex2){
                    double siot;
                    siot = (devices.get(deviceIndex1)).deviceSIoT.get(deviceIndex2);
                    if(siot > 0)
                        (devices.get(deviceIndex1)).deviceFriend.add(deviceIndex2);
                }
            }
        }
    }
            
    public static void updateUserTrust(Device sr){
        ArrayList<User> recUsers = new ArrayList<>();
        ArrayList<User> spUsers = new ArrayList<>();
        for(Device r : sr.deviceNeighbors){
            User u = r.deviceUser;
            if(!recUsers.contains(u))
                recUsers.add(u);
        }
        for(Device sp : sr.spsWhoProvidedService){
            User u = sp.deviceUser;
            if(!spUsers.contains(u))
                spUsers.add(u);
        }
        for(User u : recUsers){
            int hCount = 0;
            double honesty;
            double ownerHonesty;
            ArrayList<Device> userDevice = u.userDevices; 
            for (Device d : userDevice){
                honesty = sr.honestyList.get(d.intDeviceId);
                if(honesty == 0) 
                    hCount++;
            }
            if(hCount > ((userDevice.size())/2))
                ownerHonesty = 0;
            else
                ownerHonesty = 1;
            double[] ownerArray = new double[3];
            ownerArray = sr.ownerTrustList.get(u.intUserId);
            ownerArray[2] = ownerHonesty;
            sr.ownerTrustList.remove(u.intUserId);
            sr.ownerTrustList.add(u.intUserId, ownerArray);
        SIoTserver.updateUserOfRecommanderSIoT(sr, ownerHonesty, u.intUserId);
        }
        for(Device r : sr.deviceNeighbors){
            double[] ownerArray = new double[3];
            ownerArray = sr.ownerTrustList.get(r.intDeviceUserId);
            double ownerHonesty = ownerArray[2];
            double[] dirTrustArray = new double[7];
            dirTrustArray = sr.dirTrustComponents.get(r.intDeviceId);
            dirTrustArray[3] = ownerHonesty;
            sr.dirTrustComponents.remove(r.intDeviceId);
            sr.dirTrustComponents.add(r.intDeviceId, dirTrustArray);
        }
        for(User u : spUsers){
            double Qos;
            double coo;
            int QosCount = 0;
            int cooCount = 0;
            double ownerQos;
            double ownerCooperativeness;
            ArrayList<Device> userDevice = u.userDevices;
            for (Device d : userDevice){
            Qos = sr.QosList.get(d.intDeviceId);
            coo = sr.CooList.get(d.intDeviceId);
            if(Qos >= 0 && Qos <= 0.5) 
                QosCount++;
            if(coo >= 0 && coo <= 0.5) 
                cooCount++;
            }
            if(QosCount > ((userDevice.size())/2))
                ownerQos = 0;
            else
                ownerQos = 1;
            if(cooCount > ((userDevice.size())/2))
                ownerCooperativeness = 0;
            else
                ownerCooperativeness = 1;
            double[] ownerArray = new double[3];
            ownerArray = sr.ownerTrustList.get(u.intUserId);
            ownerArray[0] = ownerCooperativeness;
            ownerArray[1] = ownerQos;
            sr.ownerTrustList.remove(u.intUserId);
            sr.ownerTrustList.add(u.intUserId, ownerArray);
            SIoTserver.updateUserOfSpSIoT(sr, ownerQos, ownerCooperativeness, u.intUserId);
            
        }   
    }
    
    public static void updateUserOfRecommanderSIoT(Device sr, double ownerHonesty, int userId){
        double siot;
        siot = sr.deviceUser.userSIoT.get(userId);
        if(ownerHonesty == 0){
            siot = siot - 0.03;
            if(siot < 0)
                siot = 0.0;
        }    
        else{
            siot = siot + 0.03;
            if(siot > 1)
                siot = 1.0;
        }    
        sr.deviceUser.userSIoT.remove(userId);
        sr.deviceUser.userSIoT.add(userId, siot);
    }
    public static void updateUserOfSpSIoT(Device sr,double ownerQos,double ownerCooperativeness, int userId){
        double siot;
        siot = sr.deviceUser.userSIoT.get(userId);       
        if(ownerQos == 0){
            siot = siot - 0.03;
            if(siot < 0)
                siot = 0.0;
        }    
        else{
            siot = siot + 0.03;
            if(siot > 1)
                siot = 1.0;
        }
        if(ownerCooperativeness == 0){
            siot = siot - 0.03;
            if(siot < 0)
                siot = 0.0;
        }    
        else{
            siot = siot + 0.03;
            if(siot > 1)
                siot = 1.0;
        }
        
        if(ownerQos == 0){
            siot = siot - 0.03;
            if(siot < 0)
                siot = 0.0;
        }    
        else{
            siot = siot + 0.03;
            if(siot > 1)
                siot = 1.0;
        }
        if(ownerCooperativeness == 0){
            siot = siot - 0.03;
            if(siot < 0)
                siot = 0.0;
        }    
        else{
            siot = siot + 0.03;
            if(siot > 1)
                siot = 1.0;
        }
        sr.deviceUser.userSIoT.remove(userId);
        sr.deviceUser.userSIoT.add(userId, siot);        
    }
    
    public static void updateSpDeviceSIoT(Device sr,Device sp,double spQoS,double spCooperativeness){
        double siot;
        siot = sr.deviceSIoT.get(sp.intDeviceId);
            if(spQoS >= 0 && spQoS <= 0.5){
            siot = siot - 0.03;
            if(siot < 0)
                siot = 0.0;
        }    
        else{
            siot = siot + 0.03;
            if(siot > 1)
                siot = 1.0;
        }
        if(spCooperativeness >= 0 && spCooperativeness <= 0.5){
            siot = siot - 0.03;
            if(siot < 0)
                siot = 0.0;
        }    
        else{
            siot = siot + 0.03;
            if(siot > 1)
                siot = 1.0;
        }  
        sr.deviceSIoT.remove(sp.intDeviceId);
        sr.deviceSIoT.add(sp.intDeviceId, siot);
    }
    public static void updateRecommanderDeviceSIoT(Device sr,Device recommander,double honesty){
        double siot;
        siot = sr.deviceSIoT.get(recommander.intDeviceId);
        if(honesty == 0){
            siot = siot - 0.03;
            if(siot < 0)
                siot = 0.0;
        }    
        else{
            siot = siot + 0.03;
            if(siot > 1)
                siot = 1.0;
        }
        sr.deviceSIoT.remove(recommander.intDeviceId);
        sr.deviceSIoT.add(recommander.intDeviceId, siot);
    }
}    