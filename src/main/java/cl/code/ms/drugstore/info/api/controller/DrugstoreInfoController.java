package cl.code.ms.drugstore.info.api.controller;

import cl.code.ms.drugstore.info.api.model.DrugstoreInfoApiResponse;
import cl.code.ms.drugstore.info.domain.service.DrugstoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static cl.code.ms.drugstore.info.common.util.Constant.*;

@RestController
@RequestMapping(GENERAL_ENDPOINT)
public class DrugstoreInfoController {

    @Autowired
    private DrugstoreInfoService drugstoreInfoService;

    @GetMapping(value=GET_ENDPOINT)
    public ResponseEntity<DrugstoreInfoApiResponse> getDrugstoreInfo(@PathVariable("locationId") String locationId) {
        return ResponseEntity.ok(drugstoreInfoService.getDrugStoreInfo(locationId));
    }
}
