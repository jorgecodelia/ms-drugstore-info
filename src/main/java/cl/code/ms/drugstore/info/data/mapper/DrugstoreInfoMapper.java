package cl.code.ms.drugstore.info.data.mapper;

import cl.code.ms.drugstore.info.api.model.DrugstoreInfoApiResponse;
import cl.code.ms.drugstore.info.common.exception.MapperException;
import cl.code.ms.drugstore.info.common.model.DrugstoreInfoClient;
import cl.code.ms.drugstore.info.common.model.DrugstoreInfoModel;
import cl.code.ms.drugstore.info.data.model.GatewayResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

import static cl.code.ms.drugstore.info.common.util.Constant.DATA_EXCEPTION_MSG;
import static cl.code.ms.drugstore.info.common.util.Constant.SUCCESS_CODE;

@Component
public class DrugstoreInfoMapper {

    private static final Log logger = LogFactory.getLog(DrugstoreInfoMapper.class);
    private static final String ERROR_MSG = DATA_EXCEPTION_MSG+HttpStatus.NOT_FOUND.getReasonPhrase();

    public DrugstoreInfoApiResponse map(GatewayResponse gatewayResponse) throws MapperException{
        try{
            List<DrugstoreInfoClient> drugstoreInfoClientList = gatewayResponse.getDrugstoreInfoClientList();
            DrugstoreInfoApiResponse apiResponse=new DrugstoreInfoApiResponse(true,SUCCESS_CODE);
            for (DrugstoreInfoClient itemResponse: drugstoreInfoClientList) {
                DrugstoreInfoModel drugstoreInfo = new DrugstoreInfoModel();
                drugstoreInfo.setAddress(itemResponse.getLocal_direccion());
                drugstoreInfo.setLatitude(itemResponse.getLocal_lat());
                drugstoreInfo.setLongitude(itemResponse.getLocal_lng());
                drugstoreInfo.setName(itemResponse.getLocal_nombre());
                drugstoreInfo.setPhone(itemResponse.getLocal_telefono());
                apiResponse.addItem(drugstoreInfo);
            }
            if (apiResponse.getDrugstoreInfoList().size()==0) {
                MapperException e =new MapperException(ERROR_MSG);
                logger.error(ERROR_MSG+e.getMessage());
                throw e;
            }
            return apiResponse;
        }catch (Exception e){
            throw new MapperException(ERROR_MSG, e);
        }
    }
}
