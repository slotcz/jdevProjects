package cz.o2.tvs.stb;

import cz.o2.tvs.db.Category;
import cz.o2.tvs.db.CurrentStbVersionFw;

import cz.o2.tvs.db.ImageStb;
import cz.o2.tvs.db.Model;
import cz.o2.tvs.db.NG_STB_ServiceFacade;

import cz.o2.tvs.db.RegisterFw;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import oracle.adf.mbean.share.config.adfc.String;

public class CheckerVersion {

    List<CurrentStbVersionFw> listSTBs;
    List<RegisterFw> listRFW;
    List<Model> listModel;
    List<ImageStb> listImageStb;
    List<Category> listCategory;

    Map imgMap = new HashMap<String, Integer>();

    CurrentStbVersionFw[][][] versFW;

    private int countSTB;

    Logger log = Logger.getLogger(RequestSTB.class.getName());

    @SuppressWarnings("oracle.jdeveloper.java.nested-assignment")
    public CheckerVersion() {
        super();
        NG_STB_ServiceFacade srvcFacade = new NG_STB_ServiceFacade();
        listSTBs = srvcFacade.getCurrentStbVersionFwFindAll();

        listRFW = srvcFacade.getRegisterFwFindAll();

        listModel = srvcFacade.getModelFindAll();

        listImageStb = srvcFacade.getImageStbFindAll();
        for (ImageStb img : listImageStb) {
            imgMap.put(img.getName(), img.getId());
        }

        listCategory = srvcFacade.getCategoryFindAll();

        log.info("stbs=" + listSTBs.size() + " rfw=" + listRFW.size() + " model=" + listModel.size()); //
        countSTB = srvcFacade.getCountSTBbyMAC();
        versFW = new CurrentStbVersionFw[countSTB][listCategory.size() + 1][listImageStb.size() + 1];

        listSTBs.forEach(stb -> log.info(stb.toString()));
        //listSTBs.forEach(stb -> versFW[0][stb.getImage()][stb.getCategory()] = stb);
        int iMAC = 0;

        for (CurrentStbVersionFw itemSTB : listSTBs) {

            versFW[iMAC][itemSTB.getCategory()][itemSTB.getImage()] = itemSTB;
            log.info(" i=" + iMAC + " j=" + itemSTB.getImage() + " k=" + itemSTB.getCategory() + " ***** " + itemSTB.toString());
            if (itemSTB.getImage() == 3)
                iMAC++;
        }

        for (int i = 0; i < countSTB; i++) {
            for (int j = 0; j <= listCategory.size(); j++) {
                for (int k = 0; k <= listImageStb.size(); k++) {
                    if (versFW[i][j][k] != null) {
                        log.info(" i=" + i + " j=" + j + " k=" + k + " %%%%% " + versFW[i][j][k].toString());
                    }
                }
            }
        }

    }

    void verifyVersion() {
    }

    public java.lang.String verifyVersion(java.lang.String varMAC, java.lang.String pathImage, java.lang.String varFWversion) {
        java.lang.String result="";
      
        log.info("pathImage=" + pathImage);
        int k = (Integer) imgMap.get(pathImage.trim());
        for (int i = 0; i < countSTB; i++) {
            if (versFW[i][1][k].getMac().equals(varMAC)) {
                result = versFW[i][1][k].getVersion().toString();
            }
        }
        return result;
    }

   
}
