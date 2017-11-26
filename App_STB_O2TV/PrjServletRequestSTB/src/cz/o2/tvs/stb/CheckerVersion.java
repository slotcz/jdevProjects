package cz.o2.tvs.stb;

import cz.o2.tvs.db.CurrentStbVersionFw;

import cz.o2.tvs.db.NG_STB_ServiceFacade;

import cz.o2.tvs.db.RegisterFw;

import java.util.List;

public class CheckerVersion {
    
    List<CurrentStbVersionFw> listSTBs;
    List<RegisterFw> listRFW;
    
    public CheckerVersion() {
        super();
        NG_STB_ServiceFacade sf = new NG_STB_ServiceFacade();
        listSTBs = sf.getCurrentStbVersionFwFindAll();
        listRFW=sf.getRegisterFwFindAll();
    }

    void verifyVersion() {
    }

    void verifyVersion(String varMAC, String pathImage, String varFWversion) {
        
    }
}
