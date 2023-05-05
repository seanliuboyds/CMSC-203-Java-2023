public class HolidayBonus {
    /**
     * Calculates the holiday bonus for each store.
     * 
     * @param sales       the two dimensional array of store sales
     * @param highBonus   bonus for the highest store in a category
     * @param lowBonus    bonus for the lowest store in a category
     * @param otherBonus  bonus for all other stores in a category
     * @return an array of the bonus for each store
     */
    public static double[] calculateHolidayBonus(double[][] sales, double highBonus, double lowBonus,
            double otherBonus) {
        int numStores = sales.length;
        double[] bonuses = new double[numStores];
        
        // Find the maximum number of categories (columns) in the sales array
        int maxCategories = 0;
        for (int i = 0; i < numStores; i++) {
            if (maxCategories < sales[i].length) {
                maxCategories = sales[i].length;
            }
        }
        
        for (int j = 0; j < maxCategories; j++) {
            // Calculate bonuses for highest and lowest store in this category
            int highIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(sales, j);
            int lowIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(sales, j);
            double highSales = TwoDimRaggedArrayUtility.getHighestInColumn(sales, j);
            double lowSales = TwoDimRaggedArrayUtility.getLowestInColumn(sales, j);
            
            if (highSales > 0) { // Only give bonus to stores with positive sales
                bonuses[highIndex] += highBonus;
            }
            if (lowSales > 0 && highIndex != lowIndex) { // Only give bonus to stores with different index and positive sales
                bonuses[lowIndex] += lowBonus;
            }
            
            // Add "other" bonus to all remaining stores in this category
            for (int i = 0; i < numStores; i++) {
                if (j >= sales[i].length || i == highIndex || i == lowIndex || sales[i][j] <= 0) {
                    // Skip if this store is already assigned a bonus, or if sales are non-positive
                    continue;
                } else {
                    bonuses[i] += otherBonus;
                }
            }
        }
        
        return bonuses;
    }

    /**
     * Calculates the total holiday bonuses.
     * 
     * @param sales       the two dimensional array of store sales
     * @param highBonus   bonus for the highest store in a category
     * @param lowBonus    bonus for the lowest store in a category
     * @param otherBonus  bonus for all other stores in a category
     * @return the total of all holiday bonuses
     */
    public static double calculateTotalHolidayBonus(double[][] sales, double highBonus, double lowBonus,
            double otherBonus) {
        double[] bonusArray = calculateHolidayBonus(sales, highBonus, lowBonus, otherBonus);
        double totalBonus = 0;
        
        for (double bonus : bonusArray) {
            totalBonus += bonus;
        }
        
        return totalBonus;
    }
}
