package ninja.codingsolutions.solaredgeapiclient.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import ninja.codingsolutions.solaredgeapiclient.interfaces.DeepCopyable;


import java.util.List;
import java.util.Optional;

/**
 * SolarEdge Api Response
 */
public interface ApiResponse extends DeepCopyable {
    /**
     * Get the list of site ids that pertain to the api response data
     * @return {List} list of site ids
     */
    @JsonProperty("siteIds")
    Optional<List<Integer>> getSiteIds();

    /**
     * Sets the set of of site ids that are related to this api response
     * @param siteIds list of integer site ids related to this api response
     */
    void setSiteIds(List<Integer> siteIds);
}
