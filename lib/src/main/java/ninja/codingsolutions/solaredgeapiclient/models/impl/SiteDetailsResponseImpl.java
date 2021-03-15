package ninja.codingsolutions.solaredgeapiclient.models.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import ninja.codingsolutions.solaredgeapiclient.models.Details;
import ninja.codingsolutions.solaredgeapiclient.models.SiteDetailsResponse;

/**
 * Detailed site response from API
 */
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@Jacksonized
public class SiteDetailsResponseImpl extends ApiResponseImpl implements SiteDetailsResponse {
    private Details details;

    @Override
    public Object deepCopy() {
        return super.deepCopy(builder()
                .details(DetailsImpl.builder()
                        .status(this.getDetails().getStatus())
                        .type(this.getDetails().getType())
                        .ptoDate(this.getDetails().getPtoDate())
                        .peakPower(this.getDetails().getPeakPower())
                        .name(this.getDetails().getName())
                        .id(this.getDetails().getId())
                        .accountId(this.getDetails().getAccountId())
                        .notes(this.getDetails().getNotes())
                        .installationDate(this.getDetails().getInstallationDate())
                        .currency(this.getDetails().getCurrency())
                        .lastUpdateTime(this.getDetails().getLastUpdateTime())
                        .primaryModule(PrimaryModuleImpl.builder()
                                .temperatureCoef(this.getDetails().getPrimaryModule().getTemperatureCoef())
                                .modelName(this.getDetails().getPrimaryModule().getModelName())
                                .manufacturerName(this.getDetails().getPrimaryModule().getManufacturerName())
                                .maximumPower(this.getDetails().getPrimaryModule().getMaximumPower())
                                .build())
                        .location(LocationImpl.builder()
                                .zip(this.getDetails().getLocation().getZip())
                                .stateCode(this.getDetails().getLocation().getStateCode())
                                .country(this.getDetails().getLocation().getCountry())
                                .timeZone(this.getDetails().getLocation().getTimeZone())
                                .countryCode(this.getDetails().getLocation().getCountryCode())
                                .city(this.getDetails().getLocation().getCity())
                                .address2(this.getDetails().getLocation().getAddress2())
                                .address(this.getDetails().getLocation().getAddress())
                                .state(this.getDetails().getLocation().getState())
                                .build())
                        .publicSettings(PublicSettingsImpl.builder()
                                .isPublic(this.getDetails().getPublicSettings().isPublic())
                                .build())
                        .uris(UrisImpl.builder()
                                .details(this.getDetails().getUris().getDetails())
                                .dataPeriod(this.getDetails().getUris().getDataPeriod())
                                .overview(this.getDetails().getUris().getOverview())
                                .siteImage(this.getDetails().getUris().getSiteImage())
                                .build())
                        .build())
                .build());
    }
}
