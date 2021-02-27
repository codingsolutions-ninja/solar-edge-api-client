package ninja.codingsolutions.solaredgeapiclient.models;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Data
@Builder
@Jacksonized
public class SupportedVersionsResponse {
    private final List<Version> supported;
}
