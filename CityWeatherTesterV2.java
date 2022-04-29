import java.util.Scanner;
/**
 * Annual weather data for a city in Flordia, providing average temperature and total precipitation each month. (currently set
 * to provide data on Daytona Beach, Florida) Collects user input to display in preferred measurents for the temperature
 * and the precipitation.
 *
 * @author Madeline Vande Hey
 * @version 2/1/22
 */
public class CityWeatherTesterV2
{
    public static void main(String [] args) {
        // collect user input on C vs F and cm vs in
        Scanner cVsF = new Scanner(System.in);
        System.out.println("Type Celsius or Fahrenheit to indicate which temperature label you would like to see.");
        String tempLabel = cVsF.nextLine();
        
        Scanner cmVsIn = new Scanner(System.in);
        System.out.println("Type cm or in to indicate which precipitation label you would like to see.");
        String precLabel = cmVsIn.nextLine();
        
        // set city and state
        // Tallahassee data
        //String city = "Tallahassee";
        String city = "Daytona Beach";
        String state = "Florida";
        
        // set avg temp and tot prec
        double avgTemp = 0.0;
        double totPrec = 0.0;
        
        // arrays
        String [] month = {"Jan.", "Feb.", "Mar.", "Apr.", "May", "Jun.", "Jul.", "Aug.", "Sep.", "Oct.", "Nov.", "Dec."};
        // Tallahassee data
        //double [] temp = {51.8, 54.8, 61.1, 66.4, 74.4, 80.4, 82.4, 82.1, 78.9, 69.1, 60.4, 53.7};
        //double [] prec = {5.4, 4.6, 6.5, 3.6, 5.0, 6.9, 8.0, 7.0  , 5.0, 3.3, 3.9, 4.1};
        double [] temp = {58.4, 60.0, 64.7, 68.9, 74.8, 79.7, 81.7, 81.5, 79.9, 74.0, 67.0, 60.8};
        double [] prec = {3.1, 2.7, 3.8, 2.5, 3.3, 5.7, 5.2, 6.1, 6.6, 4.5, 3.0, 2.7};
        
        // instantiate AnnualWeatherV2 object
        CityWeatherV2 AnnualWeatherV2 = new CityWeatherV2(month, temp, prec);
        
        // input to decide F/C and in/cm - to be completed in 6.02
        if(tempLabel.toLowerCase().equals("celsius") && precLabel.toLowerCase().equals("cm")) {
            tempLabel = "C";
            precLabel = "cm";
            AnnualWeatherV2.printAnnualWeather(city, state, tempLabel, precLabel, AnnualWeatherV2.convertTempCelsius(), AnnualWeatherV2.convertPrecCm(), AnnualWeatherV2.getAvgTemp(), AnnualWeatherV2.getTotPrec());
        }
        else if(tempLabel.toLowerCase().equals("fahrenheit") && precLabel.toLowerCase().equals("cm")) {
            tempLabel = "F";
            precLabel = "cm";
            AnnualWeatherV2.printAnnualWeather(city, state, tempLabel, precLabel, temp, AnnualWeatherV2.convertPrecCm(), AnnualWeatherV2.getAvgTemp(), AnnualWeatherV2.getTotPrec());
        }
        else if(tempLabel.toLowerCase().equals("celsius") && precLabel.toLowerCase().equals("in")) {
            tempLabel = "C";
            precLabel = "in";
            AnnualWeatherV2.printAnnualWeather(city, state, tempLabel, precLabel, AnnualWeatherV2.convertTempCelsius(), prec, AnnualWeatherV2.getAvgTemp(), AnnualWeatherV2.getTotPrec());
        }
        else if (tempLabel.toLowerCase().equals("fahrenheit") && precLabel.toLowerCase().equals("in")){
            // method call to print results
            tempLabel = "F";
            precLabel = "in";
            AnnualWeatherV2.printAnnualWeather(city, state, tempLabel, precLabel, temp, prec, AnnualWeatherV2.getAvgTemp(), AnnualWeatherV2.getTotPrec());
        }
        else {
            System.out.println("The data you entered was incorrect");
        }
    }
}
