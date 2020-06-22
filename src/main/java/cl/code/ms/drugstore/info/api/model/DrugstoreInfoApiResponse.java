package cl.code.ms.drugstore.info.api.model;

import cl.code.ms.drugstore.info.common.model.DrugstoreInfoModel;

import java.util.ArrayList;
import java.util.List;

public class DrugstoreInfoApiResponse extends DefaultResponse {

    private List<DrugstoreInfoModel> drugstoreInfoList = new ArrayList<DrugstoreInfoModel>();

    public DrugstoreInfoApiResponse(boolean status, String description) {
        super(status, description);
    }

    public DrugstoreInfoApiResponse(boolean status, String description, List<DrugstoreInfoModel> drugstoreInfoList) {
        super(status, description);
        this.drugstoreInfoList = drugstoreInfoList;
    }

    public List<DrugstoreInfoModel> getDrugstoreInfoList() {
        return drugstoreInfoList;
    }

    public DrugstoreInfoApiResponse addItem(DrugstoreInfoModel drugstoreInfoModelItem) {
        this.drugstoreInfoList.add(drugstoreInfoModelItem);
        return this;
    }
}
