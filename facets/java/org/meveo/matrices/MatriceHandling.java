package org.meveo.matrices;

import java.util.Map;

import org.meveo.service.script.Script;
import org.meveo.admin.exception.BusinessException;
import org.meveo.api.exception.BusinessApiException;
import org.meveo.model.storage.Repository;
import org.meveo.service.storage.RepositoryService;
import org.meveo.api.persistence.CrossStorageApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MatriceHandling extends Script {

	private static final Logger log = LoggerFactory.getLogger(MatriceHandling.class);

	@Inject
	private CrossStorageApi crossStorageApi;
	
    @Inject
	private RepositoryService repositoryService;

	private Repository defaultRepo = repositoryService.findDefaultRepository();

	@Override
	public void execute(Map<String, Object> parameters) throws BusinessException {
		super.execute(parameters);
		PricePlan priceplan = crossStorageApi.find(defaultRepo,"6b78eaf7-2951-4c33-8ec7-70195f2bb72b", PricePlan.class);
		MeveoMatrix<Double> pricelist = priceplan.getPricelist();
		//Retrieve a value : use the get(String... keys) method
		log.info("get Zone=06, number prefix=06: {}",pricelist.get("FR","06"));
		//Retrieve a value by closest match : use the getClosestMatch(String... keys) method
		log.info("getClosestMatch Zone=06, number prefix=06: {}",pricelist.getClosestMatch("FR","068"));
		//Set a new value : use the set(Object... keysAndValue) method where the first parameters corresponds to the keys and the last parameters to the value
	}
	
}