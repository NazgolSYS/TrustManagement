
package trust.management;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.PrintWriter;
import java.util.List;


public class WriteOutput {
    
    public static void writeSpsWhoProvidedServiceList(List<Device> randomRequestersList) {
        try {
            FileWriter writer = new FileWriter("SpsWhoProvidedServiceList.csv", false);
            BufferedWriter buffer1 = new BufferedWriter(writer);
            PrintWriter print = new PrintWriter(buffer1);
            print.println("srId" + "," + "srUserId" + "," + "spsWhoProvidedService");
            for(int i=0; i<randomRequestersList.size();i++){
                buffer1.write(randomRequestersList.get(i).intDeviceId + "," + randomRequestersList.get(i).intDeviceUserId+ ",");
                for(Device d : randomRequestersList.get(i).spsWhoProvidedService){
                    buffer1.write(d.intDeviceId + ",");
                }
                buffer1.write("\r\n");
            }
            buffer1.flush();
            buffer1.close();
        } catch (IOException ex) {
            Logger.getLogger(WriteOutput.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void writeSrsNeighborsList(List<Device> randomRequestersList) {
        try {
            FileWriter writer = new FileWriter("SrsNeighborsList.csv", true);
            BufferedWriter buffer1 = new BufferedWriter(writer);
            PrintWriter print = new PrintWriter(buffer1);
            print.println("srId" + "," + "SrsNeighborsId" );
            for(int i=0; i<randomRequestersList.size();i++){
                buffer1.write(randomRequestersList.get(i).intDeviceId + ",");
                for(Device d : randomRequestersList.get(i).deviceNeighbors){
                    buffer1.write(d.intDeviceId + ",");
                }
                buffer1.write("\r\n");
            }
            buffer1.flush();
            buffer1.close();
        } catch (IOException ex) {
            Logger.getLogger(WriteOutput.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void writeSrsSimilarity(List<Device> randomRequestersList) {
        try {
            FileWriter writer = new FileWriter("SrsSimilarity.csv", false);
            BufferedWriter buffer1 = new BufferedWriter(writer);
            PrintWriter print = new PrintWriter(buffer1);
            print.print("Id" + ",");
            for(int i=0; i<randomRequestersList.get(0).totalNumberOfDevices;i++){
                print.print(i + ",");
            }
            for(int i=0; i<randomRequestersList.size();i++){
                buffer1.write(randomRequestersList.get(i).intDeviceId + ",");
                for(Double k : randomRequestersList.get(i).srdeviceSimilarity){
                    buffer1.write(k + ",");
                }
                buffer1.write("\r\n");
            }
            buffer1.flush();
            buffer1.close();
        } catch (IOException ex) {
            Logger.getLogger(WriteOutput.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void writeSrsSIoT(List<Device> randomRequestersList) {
        try {
            FileWriter writer = new FileWriter("SrsSIoT.csv", false);
            BufferedWriter buffer1 = new BufferedWriter(writer);
            PrintWriter print = new PrintWriter(buffer1);
            print.print("srId" + ",");
            for(int i=0; i<randomRequestersList.get(0).totalNumberOfDevices;i++){
                print.print(i + ",");
            }
            for(int i=0; i<randomRequestersList.size();i++){
                buffer1.write(randomRequestersList.get(i).intDeviceId + ",");
                for(Double k : randomRequestersList.get(i).deviceSIoT){
                    buffer1.write(k + ",");
                }
                buffer1.write("\r\n");
            }
            buffer1.flush();
            buffer1.close();
        } catch (IOException ex) {
            Logger.getLogger(WriteOutput.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void writeSrsSimilarity2(List<Device> randomRequestersList) {
        try {
            FileWriter writer = new FileWriter("SrsSimilarity2.csv", false);
            BufferedWriter buffer1 = new BufferedWriter(writer);
            PrintWriter print = new PrintWriter(buffer1);
            print.print("Id" + ",");
            for(int i=0; i<randomRequestersList.get(0).totalNumberOfDevices;i++){
                print.print(i + ",");
            }
            for(int i=0; i<randomRequestersList.size();i++){
                buffer1.write(randomRequestersList.get(i).intDeviceId + ",");
                for(Double k : randomRequestersList.get(i).srdeviceSimilarity){
                    buffer1.write(k + ",");
                }
                buffer1.write("\r\n");
            }
            buffer1.flush();
            buffer1.close();
        } catch (IOException ex) {
            Logger.getLogger(WriteOutput.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void writeSrsSIoT2(List<Device> randomRequestersList) {
        try {
            FileWriter writer = new FileWriter("SrsSIoT2.csv", false);
            BufferedWriter buffer1 = new BufferedWriter(writer);
            PrintWriter print = new PrintWriter(buffer1);
            print.print("srId" + ",");
            for(int i=0; i<randomRequestersList.get(0).totalNumberOfDevices;i++){
                print.print(i + ",");
            }
            for(int i=0; i<randomRequestersList.size();i++){
                buffer1.write(randomRequestersList.get(i).intDeviceId + ",");
                for(Double k : randomRequestersList.get(i).deviceSIoT){
                    buffer1.write(k + ",");
                }
                buffer1.write("\r\n");
            }
            buffer1.flush();
            buffer1.close();
        } catch (IOException ex) {
            Logger.getLogger(WriteOutput.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void writeTrustListOfRequesters2(List<Device> randomRequesters) {
        try {
            for(Device d: randomRequesters){
            FileWriter writer = new FileWriter("2TrustListOfRequester" + d.intDeviceId + ".csv", true);
            BufferedWriter buffer2 = new BufferedWriter(writer);
            PrintWriter print = new PrintWriter(buffer2);
            print.println("SPId" + "," + "totalTrust" + "," + "dirTrust" + "," + "indTrust" + "," + "firstTrust" + "," + "recTrust" + "," + "predictedTrust" + "," + "predictionTrust");
            double[] doubleArray = new double[8];
            for(int i=0; i<d.trust.size();i++){
                doubleArray = d.trust.get(i);
                for(int j=0; j<8;j++){
                    buffer2.write(doubleArray[j] + ",");
                }
                buffer2.write("\r\n");
            }
            buffer2.flush();
            buffer2.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(WriteOutput.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void writeDirTrustComponentstListOfRequesters2(List<Device> randomRequesters) {
        try {
            for(Device d: randomRequesters){
            FileWriter writer = new FileWriter("2DirTrustComponentstListOfRequester" + d.intDeviceId + ".csv");
            BufferedWriter buffer2 = new BufferedWriter(writer);
            PrintWriter print = new PrintWriter(buffer2);
            print.println("SPId" + "," + "QoS" + "," + "cooperativeness" + "," + "honestyOfSpOwner" + "," + "devicesFriendship" + "," + "ownersFriendship" + "," + "dirTrust");
            double[] doubleArray = new double[7];
            for(int i=0; i<d.dirTrustComponents.size();i++){
                doubleArray = d.dirTrustComponents.get(i);
                for(int j=0; j<7;j++){
                    buffer2.write(doubleArray[j] + ",");
                }
                buffer2.write("\r\n");
            }
            buffer2.flush();
            buffer2.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(WriteOutput.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void writeSrRecommandationList2(List<Device> randomRequesters) {
        try {
            for(Device d: randomRequesters){
            FileWriter writer = new FileWriter("2recommandationListOfRequester" + d.intDeviceId + ".csv", true);
            BufferedWriter buffer2 = new BufferedWriter(writer);
            PrintWriter print = new PrintWriter(buffer2);
            print.println("RecommenderId" + "," + "RecommenderUserId" + "," + "SPId" + "," + "rec" + "," + "honestyRecOwner");
            double[] doubleArray = new double[d.totalNumberOfDevices];
            for(int i=0; i<d.recommandationList.size();i++){
                doubleArray = d.recommandationList.get(i);
                for(int j=0; j<d.totalNumberOfDevices;j++){
                    buffer2.write(doubleArray[j] + ",");
                }
                buffer2.write("\r\n");
            }
            buffer2.flush();
            buffer2.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(WriteOutput.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void writeSrsUserSIoT(List<Device> randomRequestersList) {
        try {
            FileWriter writer = new FileWriter("SrsUserSIoT.csv", false);
            BufferedWriter buffer1 = new BufferedWriter(writer);
            PrintWriter print = new PrintWriter(buffer1);
            print.print("srId" + "," + "srUserId" + ",");
            for(int i=0; i<randomRequestersList.get(0).totalNumberOfUsers;i++){
                print.print(i + ",");
                print.println();
            }
            for(int i=0; i<randomRequestersList.size();i++){
                buffer1.write(randomRequestersList.get(i).intDeviceId + "," + randomRequestersList.get(i).intDeviceUserId+ ",");
                for(Double k : randomRequestersList.get(i).deviceUser.userSIoT){
                    buffer1.write(k + ",");
                }
                buffer1.write("\r\n");
            }
            buffer1.flush();
            buffer1.close();
        } catch (IOException ex) {
            Logger.getLogger(WriteOutput.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public static void writeTrustListOfRequesters(List<Device> randomRequesters) {
        try {
            for(Device d: randomRequesters){
            FileWriter writer = new FileWriter("TrustListOfRequester" + d.intDeviceId + ".csv", true);
            BufferedWriter buffer2 = new BufferedWriter(writer);
            PrintWriter print = new PrintWriter(buffer2);
            print.println("SPId" + "," + "totalTrust" + "," + "dirTrust" + "," + "indTrust" + "," + "firstTrust" + "," + "recTrust" + "," + "predictedTrust" + "," + "predictionTrust");
            double[] doubleArray = new double[8];
            for(int i=0; i<d.trust.size();i++){
                doubleArray = d.trust.get(i);
                for(int j=0; j<8;j++){
                    buffer2.write(doubleArray[j] + ",");
                }
                buffer2.write("\r\n");
            }
            buffer2.flush();
            buffer2.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(WriteOutput.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void writeDirTrustComponentstListOfRequesters(List<Device> randomRequesters) {
        try {
            for(Device d: randomRequesters){
            FileWriter writer = new FileWriter("DirTrustComponentstListOfRequester" + d.intDeviceId + ".csv");
            BufferedWriter buffer2 = new BufferedWriter(writer);
            PrintWriter print = new PrintWriter(buffer2);
            print.println("SPId" + "," + "QoS" + "," + "cooperativeness" + "," + "honestyOfSpOwner" + "," + "devicesFriendship" + "," + "ownersFriendship" + "," + "dirTrust");
            double[] doubleArray = new double[7];
            for(int i=0; i<d.dirTrustComponents.size();i++){
                doubleArray = d.dirTrustComponents.get(i);
                for(int j=0; j<7;j++){
                    buffer2.write(doubleArray[j] + ",");
                }
                buffer2.write("\r\n");
            }
            buffer2.flush();
            buffer2.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(WriteOutput.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void writeSrRecommandationList(List<Device> randomRequesters) {
        try {
            for(Device d: randomRequesters){
            FileWriter writer = new FileWriter("recommandationListOfRequester" + d.intDeviceId + ".csv", true);
            BufferedWriter buffer2 = new BufferedWriter(writer);
            PrintWriter print = new PrintWriter(buffer2);
            print.println("RecommenderId" + "," + "RecommenderUserId" + "," + "SPId" + "," + "rec" + "," + "honestyRecOwner");
            double[] doubleArray = new double[d.totalNumberOfDevices];
            for(int i=0; i<d.recommandationList.size();i++){
                doubleArray = d.recommandationList.get(i);
                for(int j=0; j<d.totalNumberOfDevices;j++){
                    buffer2.write(doubleArray[j] + ",");
                }
                buffer2.write("\r\n");
            }
            buffer2.flush();
            buffer2.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(WriteOutput.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public static void writeFalseNegativeAndPositive(List<double[]> total,String fileName, String a){
        try {
            FileWriter writer = new FileWriter(fileName+".csv", false);
            BufferedWriter buffer = new BufferedWriter(writer);
            for(int i=0; i<total.size();i++){
                double[] p = new double[2];
                p = total.get(i);
                for(int j=0; j<2;j++){
                    buffer.write(p[j] + ",");
                }
                buffer.write("\r\n");
            }
            buffer.flush();
            buffer.close();
        } catch (IOException ex) {
            Logger.getLogger(OutputWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void writeTrustConvergence(List<double[]> trustConvergence,String fileName, String a){
        try {
            FileWriter writer = new FileWriter(fileName+".csv", false);
            BufferedWriter buffer = new BufferedWriter(writer);
            for(int i=0; i<trustConvergence.size();i++){
                double[] convergence = new double[2];
                convergence = trustConvergence.get(i);
                for(int j=0; j<2;j++){
                    buffer.write(convergence[j] + ",");
                }
                buffer.write("\r\n");
            }
            buffer.flush();
            buffer.close();
        } catch (IOException ex) {
            Logger.getLogger(OutputWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void writeMAE(List<double[]> MAE){
        try {
            FileWriter writer = new FileWriter("MAE.csv", false);
            BufferedWriter buffer = new BufferedWriter(writer);
            PrintWriter print = new PrintWriter(buffer);
            for(int i=0; i<MAE.size();i++){
                double[] mae = new double[2];
                mae = MAE.get(i);
                for(int j=0; j<2;j++){
                    buffer.write(mae[j] + ",");
                }
                buffer.write("\r\n");
            }
            buffer.flush();
            buffer.close();
            //print.close();
        } catch (IOException ex) {
            Logger.getLogger(OutputWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
