package cl.code.ms.drugstore.info.data.gateway;

import cl.code.ms.drugstore.info.common.config.ApiUtils;
import cl.code.ms.drugstore.info.common.exception.GatewayException;
import cl.code.ms.drugstore.info.common.model.DrugstoreInfoClient;
import cl.code.ms.drugstore.info.data.model.GatewayResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class DrugstoreInfoGateway {

    @Value("${services.drugstore.info.path}")
    public String url;

    @Autowired
    private RestTemplate restTemplate;

    private static Log logger = LogFactory.getLog(DrugstoreInfoGateway.class);

    public GatewayResponse getDrugStoreInfoByLocation(String locationId) throws GatewayException {
        try {
            ApiUtils.setMediaConverter(restTemplate);
            ResponseEntity<DrugstoreInfoClient[]> response = restTemplate.exchange(url+locationId, HttpMethod.GET, ApiUtils.getHeader(), DrugstoreInfoClient[].class);
            GatewayResponse gatewayResponse = new GatewayResponse(Arrays.asList(response.getBody()));
            return gatewayResponse;
        } catch (Exception e) {
            logger.error("Gateway: "+e.getMessage());
            throw new GatewayException("",e);
        }
    }

}
