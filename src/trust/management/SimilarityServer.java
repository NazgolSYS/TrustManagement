
package trust.management;

import java.util.ArrayList;
import java.util.List;


public class SimilarityServer {
    
    public static void updateUserSimilarity(List<User> users){
        for(int userIndex1 = 0; userIndex1 < users.size() ; userIndex1++){
            double size1;
            User u1;
            u1 = users.get(userIndex1);
            ArrayList<Integer> friends1 = new ArrayList<>();
            friends1 = u1.userFriend;
            size1 = friends1.size();
            for(int userIndex2 = 0; userIndex2 < users.size() ; userIndex2++){
                double intersection = 0;
                double sim; 
                double size2;
                User u2;
                u2 = users.get(userIndex2);
                ArrayList<Integer> friends2 = new ArrayList<>();
                friends2 = u2.userFriend;
                size2 = friends2.size();
                if(userIndex1 != userIndex2){
                    for(int i = 0; i < size1; i++){
                        for(int j = 0; j < size2; j++){
                            if(friends1.get(i)== friends2.get(j))
                                intersection++;
                        } 
                    }    
                    if((size1+size2) != 0){
                        sim = intersection/(size1+size2);
                    }
                    else{
                        sim = 0;
                    }
                    users.get(userIndex1).userSimilarity.remove(userIndex2);
                    users.get(userIndex1).userSimilarity.add(userIndex2, sim);
                }
            }
        }
    }
    
    public static void updateDeviceSimilarity(List<Device> devices){
        for(int deviceIndex1 = 0; deviceIndex1 < devices.size() ; deviceIndex1++){
            Device d1 = devices.get(deviceIndex1);
            ArrayList<Integer> friends1 = new ArrayList<>();
            ArrayList<Integer> sp1 = new ArrayList<>();
            ArrayList<Integer> sr1 = new ArrayList<>();
            ArrayList<Integer> loc1 = new ArrayList<>();
            friends1 = d1.deviceFriend;
            sp1 = d1.sps;
            sr1 = d1.srs;
            loc1 = d1.location;
            double sizeFriends1;
                sizeFriends1 = friends1.size();
            double sizeLoc1;
                sizeLoc1 = loc1.size();
            double sizeSP1;
                sizeSP1 = sp1.size();
            double sizeSR1;
                sizeSR1 = sr1.size();
            for(int deviceIndex2 = 0; deviceIndex2 < devices.size() ; deviceIndex2++){
                Device d2 = devices.get(deviceIndex2);
                double friendIntersection = 0;
                double locIntersection = 0;
                double spsIntersection = 0;
                double srsIntersection = 0;
                double friendSim;
                double locationSim;
                double spsSim;
                double srsSim;
                double spTotalSim;
                double srTotalSim;
                ArrayList<Integer> friends2 = new ArrayList<>();
                ArrayList<Integer> sp2 = new ArrayList<>();
                ArrayList<Integer> sr2 = new ArrayList<>();
                ArrayList<Integer> loc2 = new ArrayList<>();
                friends2 = d2.deviceFriend;
                sp2 = d2.sps;
                sr2 = d2.srs;
                loc2 =  d2.location;
                double sizeFriends2; 
                sizeFriends2 = friends2.size();
                double sizeLoc2;
                sizeLoc2 = loc2.size();
                double sizeSP2;
                sizeSP2 = sp2.size();
                double sizeSR2;
                sizeSR2 = sr2.size();
                if(deviceIndex1 != deviceIndex2){
                    for(int i = 0; i < sizeFriends1; i++){
                        for(int j = 0; j < sizeFriends2; j++){
                            if(friends1.get(i)== friends2.get(j))
                                friendIntersection++;
                        } 
                    }
                    for(int i = 0; i < sizeLoc1; i++){
                        for(int j = 0; j < sizeLoc2; j++){
                            if(loc2.get(j)== loc1.get(i))
                                locIntersection++;
                        } 
                    } 
                    for(int i = 0; i < sizeSP1; i++){
                        for(int j = 0; j < sizeSP2; j++){
                            if(sp1.get(i)== sp2.get(j))
                                spsIntersection++;
                        } 
                    } 
                    for(int i = 0; i < sizeSR1; i++){
                        for(int j = 0; j < sizeSR2; j++){
                            if(sr1.get(i)== sr2.get(j))
                                srsIntersection++;
                        } 
                    }
                    if((sizeFriends1+sizeFriends2) != 0){
                        friendSim = friendIntersection/(sizeFriends1+sizeFriends2);
                    }
                    else{
                        friendSim = 0;
                    }
                    if((sizeLoc1+sizeLoc2) != 0){
                        locationSim = locIntersection/(sizeLoc1+sizeLoc2);
                    }
                    else{
                        locationSim = 0;
                    }
                    if((sizeSP1+sizeSP2) != 0){
                        spsSim = spsIntersection/(sizeSP1+sizeSP2);
                    }
                    else{
                        spsSim = 0;
                    }
                    if((sizeSR1+sizeSR2) != 0){
                        srsSim = srsIntersection/(sizeSR1+sizeSR2);
                    }
                    else{
                        srsSim = 0;
                    }
                    spTotalSim = 0.33*friendSim + 0.33*locationSim + 0.34*spsSim;
                    d1.spdeviceSimilarity.remove(deviceIndex2);
                    d1.spdeviceSimilarity.add(deviceIndex2, spTotalSim);
                    srTotalSim = 0.33*friendSim + 0.33*locationSim + 0.34*srsSim;
                    d1.srdeviceSimilarity.remove(deviceIndex2);
                    d1.srdeviceSimilarity.add(deviceIndex2, srTotalSim);
                }
            }
        }
    }
          
    public static void onlySimRecUpdateDeviceSimilarity(List<Device> devices){
        for(int deviceIndex1 = 0; deviceIndex1 < devices.size() ; deviceIndex1++){
            Device d1 = devices.get(deviceIndex1);
            ArrayList<Integer> sp1 = new ArrayList<>();
            ArrayList<Integer> sr1 = new ArrayList<>();
            ArrayList<Integer> loc1 = new ArrayList<>();
            sp1 = d1.sps;
            sr1 = d1.srs;
            loc1 = d1.location;
            double sizeLoc1;
                sizeLoc1 = loc1.size();
            double sizeSP1;
                sizeSP1 = sp1.size();
            double sizeSR1;
                sizeSR1 = sr1.size();
            for(int deviceIndex2 = 0; deviceIndex2 < devices.size() ; deviceIndex2++){
                Device d2 = devices.get(deviceIndex2);
                double locIntersection = 0;
                double spsIntersection = 0;
                double srsIntersection = 0;
                double friendSim;
                double locationSim;
                double spsSim;
                double srsSim;
                double spTotalSim;
                double srTotalSim;
                ArrayList<Integer> friends2 = new ArrayList<>();
                ArrayList<Integer> sp2 = new ArrayList<>();
                ArrayList<Integer> sr2 = new ArrayList<>();
                ArrayList<Integer> loc2 = new ArrayList<>();
                friends2 = d2.deviceFriend;
                sp2 = d2.sps;
                sr2 = d2.srs;
                loc2 =  d2.location;
                double sizeLoc2;
                sizeLoc2 = loc2.size();
                double sizeSP2;
                sizeSP2 = sp2.size();
                double sizeSR2;
                sizeSR2 = sr2.size();
                if(deviceIndex1 != deviceIndex2){
                    for(int i = 0; i < sizeLoc1; i++){
                        for(int j = 0; j < sizeLoc2; j++){
                            if(loc2.get(j)== loc1.get(i))
                                locIntersection++;
                        } 
                    } 
                    for(int i = 0; i < sizeSP1; i++){
                        for(int j = 0; j < sizeSP2; j++){
                            if(sp1.get(i)== sp2.get(j))
                                spsIntersection++;
                        } 
                    } 
                    for(int i = 0; i < sizeSR1; i++){
                        for(int j = 0; j < sizeSR2; j++){
                            if(sr1.get(i)== sr2.get(j))
                                srsIntersection++;
                        } 
                    }
                    if((sizeLoc1+sizeLoc2) != 0){
                        locationSim = locIntersection/(sizeLoc1+sizeLoc2);
                    }
                    else{
                        locationSim = 0;
                    }
                    if((sizeSP1+sizeSP2) != 0){
                        spsSim = spsIntersection/(sizeSP1+sizeSP2);
                    }
                    else{
                        spsSim = 0;
                    }
                    if((sizeSR1+sizeSR2) != 0){
                        srsSim = srsIntersection/(sizeSR1+sizeSR2);
                    }
                    else{
                        srsSim = 0;
                    }
                    spTotalSim = 0.5*locationSim + 0.5*spsSim;
                    d1.spdeviceSimilarity.remove(deviceIndex2);
                    d1.spdeviceSimilarity.add(deviceIndex2, spTotalSim);
                    srTotalSim = 0.5*locationSim + 0.5*srsSim;
                    d1.srdeviceSimilarity.remove(deviceIndex2);
                    d1.srdeviceSimilarity.add(deviceIndex2, srTotalSim);
                }
            }
        }
    }
}
