package cl.code.ms.drugstore.info.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DefaultResponse {

    @JsonProperty("status")
    private boolean status;
    @JsonProperty("description")
    private String description;

    public DefaultResponse(boolean status, String description) {
        this.status = status;
        this.description = description;
    }

    public DefaultResponse() {
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
