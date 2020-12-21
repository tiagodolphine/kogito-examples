package org.kie.kogito;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private MockService mockService;

    private String resourceName;

    BaseService() {
    }

    public BaseService(MockService mockService, String resourceName) {
        this.mockService = mockService;
        this.resourceName = resourceName;
    }

    public Response create(String id, String failService) {
        final Response response = mockService.execute(failService, this.getClass());
        logger.info("Created {} for {} with Id: {}", resourceName, id, response.getResourceId());
        return response;
    }

    public Response cancel(String id) {
        logger.warn("Cancel {} for {}", resourceName, id);
        return new Response(Response.Type.SUCCESS, id);
    }
}
