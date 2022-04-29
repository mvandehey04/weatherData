/**
 * Methods to create the data for the annual weather data of a city in Flordia, providing average temperature 
 * and total precipitation each month. 
 *
 * @author Madeline Vande Hey
 * @version 2/1/22
 */
public class CityWeatherV2
{
    private String [] month;
    private double [] temp;
    private double [] prec;
    
    public CityWeatherV2(String [] month, double [] temp, double [] prec) {
        this.month = month;
        this.temp = temp;
        this.prec = prec;
    }
    
    // getter/setter methods
    private void setMonth(String [] month) {
        this.month = month;
    }
    
    private void setTemp(double [] temp) {
        this.temp = temp;
    }
    
    private void setPrec(double [] prec) {
        this.prec = prec;
    }
    
    public String [] getMonth() {
        return month;
    }
    
    public double [] getTemp() {
        return temp;
    }
    
    public double [] getPrec() {
        return prec;
    }
    
    // average annual temperature
    public double getAvgTemp(){
        double avgTemp = 0.0;
        for(double t : temp){
            avgTemp += t;
        }
        avgTemp = avgTemp / 12.0;
        return avgTemp;
    }
    
    // total annual precipitation
    public double getTotPrec() {
        double totPrec = 0.0;
        for(double p : prec) {
            totPrec += p;
        }
        return totPrec;
    }
    
    // convert to Celsius 
    public double [] convertTempCelsius() {
        double [] tempCel = new double[12];
        int i = -1;
        for(double t : temp){
            i ++;
            tempCel[i] = Math.round(((t - 32) * 5.0/9)*100.0)/100.0;
        }
        
        temp = tempCel;
        return temp;
    }
    
    // convert to cm 
    public double [] convertPrecCm() {
        double [] precCm = new double[12];
        int i = -1;
        for(double p : prec){
            i ++;
            precCm[i] = Math.round((p * 2.54)*100.0)/100.0;
        }
        
        prec = precCm;
        return prec;
    }
    
    // printing method 
    public void printAnnualWeather(String city, String state, String tempLabel, String precLabel, double [] temp, double [] prec, double avgTemp, double totPrec) {
        System.out.println();
        System.out.printf("%27s%n", "Weather Data");
        System.out.printf("%35s", "Location: " + city + ", " + state);
        System.out.println();
        System.out.println("\nMonth   Temperature (" + tempLabel + ")" + "     Precipitation (" + precLabel + ".)");
        System.out.println("**************************************************");
        
        for(int i = 0; i < month.length; i++) {
            System.out.printf("%-12s %.1f %-12s %.1f\n", month[i], temp[i], "     ", prec[i]);
        }
        
        System.out.println("**************************************************");
        System.out.printf("%s %.1f %3s %.1f", "Average: ", avgTemp, " Total Precipitation: ", totPrec);
        System.out.println();
    }
}
