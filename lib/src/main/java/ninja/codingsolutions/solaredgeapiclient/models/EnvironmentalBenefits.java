package ninja.codingsolutions.solaredgeapiclient.models;

/**
 *
 */
public interface EnvironmentalBenefits {
    /**
     *
     */
    enum EmissionUnitType {
        /**
         *
         */
        LB
    }
    interface GasEmissionsSaved {
        /**
         *
         * @return
         */
        EmissionUnitType getEmissionUnitType();

        /**
         *
         * @return
         */
        double getCO2Emissions();

        /**
         *
         * @return
         */
        double getSO2Emissions();

        /**
         *
         * @return
         */
        double getNOXEmissions();
    }

    /**
     *
     * @return
     */
    GasEmissionsSaved getGasEmissionsSaved();

    /**
     *
     * @return
     */
    double getEquivalentTreesPlanted();

    /**
     *
     * @return
     */
    double getLightBulbs();
}
