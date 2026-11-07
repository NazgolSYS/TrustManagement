package trust.management;

import java.util.ArrayList;
import java.util.List;

//if(totalTrust == -2)
    //System.out.println("computeTrust did not work");
//IndexOutOfBoundsException
 //throws IndexOutOfBoundsException

public class Head extends Device {
    public int intHeadId;
    public double doubleHeadId;
    
    public List<Device> onlyDirChoosSp(Device sr, List<Device> candidProviders){
        List<Device> candidSps = new ArrayList <Device>();
        for(int i=0;i<candidProviders.size();i++){
            Device sp = candidProviders.get(i);
            double ownersFriendship = ((sr.deviceUser).userSIoT).get((sp.deviceUser).intUserId);
            double devicesFriendship = (sr.deviceSIoT).get(sp.intDeviceId);
            if(sr.timesOfRequest == 1){
                if(ownersFriendship > 0 || devicesFriendship > 0){
                    candidSps.add(sp);
                }
            }    
        }
        return candidSps;
    }
    
    public void spAcceptedRequest(Device sr,Device sp){
//        Device serviceProvider = null;
        sr.selectedCandidProviders = onlyDirChoosSp(sr,sr.candidProviders);
        System.out.println(sr.selectedCandidProviders);
            boolean answer;
            Device candidDevice;
            int i = 0;
            TrustManagement trustManagement = new TrustManagement();
            while(i<sr.selectedCandidProviders.size()){
                candidDevice = sr.selectedCandidProviders.get(i);
                answer = trustManagement.askForprovidingService(candidDevice);
                if(answer == true){
//                    serviceProvider = candidDevice;
                    trustManagement.reciveService(sr,candidDevice);
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
}
