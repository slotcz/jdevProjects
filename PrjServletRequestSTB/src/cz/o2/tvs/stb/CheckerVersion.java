package cz.o2.tvs.stb;

import cz.o2.tvs.accessory.Version;
import cz.o2.tvs.accessory.VersionValidator;
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

public class CheckerVersion {


    private VersionValidator versionValidator;

    private List<CurrentStbVersionFw> listSTBs;
    private List<RegisterFw> listRFW;
    private List<Model> listModel;
    private List<ImageStb> listImageStb;
    private List<Category> listCategory;

    private Map imgMap = new HashMap<String, Integer>();

    private CurrentStbVersionFw[][][] versFW;

    private int countSTB;

    Logger LOG = Logger.getLogger(RequestSTB.class.getName());

    @SuppressWarnings("oracle.jdeveloper.java.nested-assignment")
    public CheckerVersion() {
        super();
        versionValidator = new VersionValidator();

        NG_STB_ServiceFacade srvcFacade = new NG_STB_ServiceFacade();
        listSTBs = srvcFacade.getCurrentStbVersionFwFindAll();

        listRFW = srvcFacade.getRegisterFwFindAll();

        listModel = srvcFacade.getModelFindAll();

        listImageStb = srvcFacade.getImageStbFindAll();
        for (ImageStb img : listImageStb) {
            imgMap.put(img.getName(), img.getId());
        }

        listCategory = srvcFacade.getCategoryFindAll();

        LOG.info("stbs=" + listSTBs.size() + " rfw=" + listRFW.size() + " model=" + listModel.size()); //
        countSTB = srvcFacade.getCountSTBbyMAC();
        versFW = new CurrentStbVersionFw[countSTB][listCategory.size() + 1][listImageStb.size() + 1];

        listSTBs.forEach(stb -> LOG.info(stb.toString()));
        int iMAC = 0;

        for (CurrentStbVersionFw itemSTB : listSTBs) {

            versFW[iMAC][itemSTB.getCategory()][itemSTB.getImage()] = itemSTB;
            LOG.info(" i=" + iMAC + " j=" + itemSTB.getImage() + " k=" + itemSTB.getCategory() + " ***** " + itemSTB.toString());
            if (itemSTB.getImage() == 3)
                iMAC++;
        }

        for (int i = 0; i < countSTB; i++) {
            for (int j = 0; j <= listCategory.size(); j++) {
                for (int k = 0; k <= listImageStb.size(); k++) {
                    if (versFW[i][j][k] != null) {
                        LOG.info(" i=" + i + " j=" + j + " k=" + k + " %%%%% " + versFW[i][j][k].toString());
                    }
                }
            }
        }
    }

    private int verifyVersion(String varFWversion, String fwVersion) { // 1 from strb ; 2 from DB
        int result = -1;
        Version version = new Version(varFWversion);
        if (version.compareTo(fwVersion) > 0) {
            result = 1;
        }
        return result;
    }

    public java.lang.String getNewVersion(java.lang.String varMAC, java.lang.String pathImage, java.lang.String varFWversion) {

        java.lang.String result = "";

        if (!varFWversion.isEmpty() && !versionValidator.validate(varFWversion)) {
            LOG.warning("Bad format version=" + varFWversion + " for NAC=" + varMAC);
            varFWversion = "";
        }


        LOG.info("pathImage=" + pathImage);
        int k = (Integer) imgMap.get(pathImage.trim());
        for (int i = 0; i < countSTB; i++) {
            if (versFW[i][1][k].getMac().equals(varMAC)) {
                result = versFW[i][1][k].getVersion().toString();
                if (!varFWversion.isEmpty()) {
                    if (verifyVersion(varFWversion, result) <= 0) {
                        result = "";
                    }
                }
            }
        }

        return result;
    }


}
