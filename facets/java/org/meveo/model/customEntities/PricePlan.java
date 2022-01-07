package org.meveo.model.customEntities;

import org.meveo.model.CustomEntity;
import java.util.List;
import org.meveo.model.persistence.DBStorageType;
import org.meveo.model.customEntities.MeveoMatrix;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class PricePlan implements CustomEntity {

    public PricePlan() {
    }

    public PricePlan(String uuid) {
        this.uuid = uuid;
    }

    private String uuid;

    @JsonIgnore()
    private DBStorageType storages;

    private MeveoMatrix<Double> pricelist;

    @Override()
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public DBStorageType getStorages() {
        return storages;
    }

    public void setStorages(DBStorageType storages) {
        this.storages = storages;
    }

    public MeveoMatrix<Double> getPricelist() {
        return pricelist;
    }

    public void setPricelist(MeveoMatrix<Double> pricelist) {
        this.pricelist = pricelist;
    }

    @Override()
    public String getCetCode() {
        return "PricePlan";
    }
}
