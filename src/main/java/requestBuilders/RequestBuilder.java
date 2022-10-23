package requestBuilders;

import io.restassured.specification.RequestSpecification;

public interface RequestBuilder {
    RequestSpecification build();
}
