package cl.code.ms.drugstore.info.domain.service;

import cl.code.ms.drugstore.info.api.model.DrugstoreInfoApiResponse;
import cl.code.ms.drugstore.info.common.exception.ServiceException;
import cl.code.ms.drugstore.info.data.gateway.DrugstoreInfoGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrugstoreInfoService {

    @Autowired
    private DrugstoreInfoGateway quotesGateway;

    @Autowired
    private cl.code.ms.drugstore.info.data.mapper.DrugstoreInfoMapper drugstoreInfoMapper;

    public DrugstoreInfoApiResponse getDrugStoreInfo(String locationId) throws ServiceException {
        return drugstoreInfoMapper.map(quotesGateway.getDrugStoreInfoByLocation(locationId));
    }
}
