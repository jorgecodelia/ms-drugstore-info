package cl.code.ms.drugstore.info.data.model;

import cl.code.ms.drugstore.info.common.model.DrugstoreInfoClient;

import java.util.ArrayList;
import java.util.List;

public class GatewayResponse {

    private List<DrugstoreInfoClient> drugstoreInfoClientList = new ArrayList<DrugstoreInfoClient>();

    public GatewayResponse(List<DrugstoreInfoClient> drugstoreInfoClientList) {
        this.drugstoreInfoClientList = drugstoreInfoClientList;
    }

    public GatewayResponse() {
    }

    public List<DrugstoreInfoClient> getDrugstoreInfoClientList() {
        return drugstoreInfoClientList;
    }

    public void setDrugstoreInfoClientList(List<DrugstoreInfoClient> drugstoreInfoClientList) {
        this.drugstoreInfoClientList = drugstoreInfoClientList;
    }
}
