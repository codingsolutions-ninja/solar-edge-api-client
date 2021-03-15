package ninja.codingsolutions.solaredgeapiclient.models.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import ninja.codingsolutions.solaredgeapiclient.models.ApiResponse;
import ninja.codingsolutions.solaredgeapiclient.models.BaseModel;

import java.util.List;
import java.util.Optional;

/**
 * Base response class that provides common functionality and/or properties
 * that are shared by most api response from the solar edge api
 */
@Data
@SuperBuilder
public abstract class ApiResponseImpl implements ApiResponse, BaseModel {

    @JsonProperty("siteIds")
    private List<Integer> siteIds;

    /**
     * Get the list of site IDs related to the data in the api response
     * @return a Optional list of integers of the site ids related to the data in the api response, if the response
     * data isn't related to any site id the optional will not have a value.
     */
    @JsonProperty("siteIds")
    public Optional<List<Integer>> getSiteIds() {
        return Optional.ofNullable(siteIds);
    }

    /**
     * injects the values maintained by the ApiResponseImpl into the passed object that is being used for a
     * deep copy.
     * @param impl object that will be returned as a new deep copy of the object instance
     * @return mutated instance of the passed @param impl updated with deep copies of the values
     * present on the ApiResponseImpl instance
     */
    public Object deepCopy(ApiResponseImpl impl) {
        if(this.getSiteIds().isPresent())
            impl.setSiteIds(List.copyOf(this.getSiteIds().get()));
        return impl;
    }
}
