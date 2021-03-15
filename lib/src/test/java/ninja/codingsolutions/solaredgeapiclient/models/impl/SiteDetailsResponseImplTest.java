package ninja.codingsolutions.solaredgeapiclient.models.impl;

import ninja.codingsolutions.solaredgeapiclient.interfaces.DeepCopyable;

import java.util.Date;
import java.util.List;

public class SiteDetailsResponseImplTest extends BaseModelTest {
    @Override
    DeepCopyable buildRandomObject() {
        return SiteDetailsResponseImpl.builder().siteIds(List.of(random.nextInt()))
                .details(DetailsImpl.builder()
                        .accountId(random.nextInt())
                        .currency(getRandomString())
                        .id(random.nextInt())
                        .installationDate(new Date())
                        .lastUpdateTime(new Date())
                        .notes(getRandomString())
                        .name(getRandomString())
                        .peakPower(random.nextDouble())
                        .publicSettings(PublicSettingsImpl.builder().isPublic(true).build())
                        .uris(UrisImpl.builder()
                                .dataPeriod(getRandomString())
                                .overview(getRandomString())
                                .details(getRandomString())
                                .siteImage(getRandomString())
                                .build())
                        .location(LocationImpl.builder()
                                .address(getRandomString())
                                .address2(getRandomString())
                                .city(getRandomString())
                                .country(getRandomString())
                                .city(getRandomString())
                                .countryCode(getRandomString())
                                .stateCode(getRandomString())
                                .state(getRandomString())
                                .timeZone(getRandomString())
                                .stateCode(getRandomString())
                                .zip(getRandomString())
                        .build())
                        .primaryModule(PrimaryModuleImpl.builder()
                                .manufacturerName(getRandomString())
                                .maximumPower(random.nextDouble())
                                .manufacturerName(getRandomString())
                                .modelName(getRandomString())
                                .temperatureCoef(random.nextDouble())
                                .build())
                        .ptoDate(getRandomString())
                        .type(getRandomString())
                        .status(getRandomString())
                .build()).build();
    }

    @Override
    Class<?> getDeserializiableClass() {
        return SiteDetailsResponseImpl.class;
    }
}
