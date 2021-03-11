package ninja.codingsolutions.solaredgeapiclient.models.impl;

import lombok.Data;
import ninja.codingsolutions.solaredgeapiclient.models.ApiResponse;

import java.util.List;
import java.util.Optional;

/**
 * Base response class that provides common functionality and/or properties
 * that are shared by most api response from the solar edge api
 */
@Data
public abstract class ApiResponseImpl implements ApiResponse {

    private List<Integer> siteIds;

    /**
     * Get the list of site IDs related to the data in the api response
     * @return a Optional list of integers of the site ids related to the data in the api response, if the response
     * data isn't related to any site id the optional will not have a value.
     */
    public Optional<List<Integer>> getSiteIds() {
        return Optional.ofNullable(siteIds);
    }
}
