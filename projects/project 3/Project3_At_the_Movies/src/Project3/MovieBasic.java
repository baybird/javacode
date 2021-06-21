package Project3;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <pre>
 * File         MovieBasic.java
 * Project      At the Movies
 * Description  This class provides the basic movie data and methods.
 * Platform     Mac, Big Sur 11.2.3, jdk 1.8.0_241, NetBeans IDE 12.3
 * Date         6/3/2021
 * History Log
 * @author      <i>Robert Tang</i>
 * @version 1.0.0
 * </pre>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class MovieBasic {
    // Declars the constants and vars of the basic movie data.
    private final String MOVIE_PLACEHOLD = "<Select A Movie>";
    private final String TIME_PLACEHOLD = "Select Time";
    
    String movieName, movieTime, movieRating, movieRunTime;
    String transactionTimeDate;

    int adultTickets, childSeniorTickets;
    double amount;
    double tax;
    double amountDue;
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           Default constructor
     * Description      Creates new instance of MovieBasic
     * @author          <i>Robert Tang</i>
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public MovieBasic() {
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           Default constructor
     * Description      Creates new instance of MovieBasic
     * @author          <i>Robert Tang</i>
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public void clear() {
        adultTickets = 0;
        childSeniorTickets = 0;
        amount = 0;
        tax = 0;
        amountDue = 0;
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           getMoviePlacehold()
     * Description      Getter of getting the var of movie placehold
     * @return String
     * @author          <i>Robert Tang</i>
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public String getMoviePlacehold() {
        return MOVIE_PLACEHOLD;
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           getTimePlacehold()
     * Description      Getter of getting the var of the time placehold
     * @author          <i>Robert Tang</i>
     * @return String
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public String getTimePlacehold() {
        return TIME_PLACEHOLD;
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           getMovieName()
     * Description      Getter of getting the var of the movie name
     * @return String
     * @author          <i>Robert Tang</i>
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public String getMovieName() {
        return movieName;
    }   
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           setMovieName()
     * Description      setter of setting movie name
     * @param movieName-string
     * @author          <i>Robert Tang</i>
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           getMovieTime()
     * Description      getting movie time
     * @return String
     * @author          <i>Robert Tang</i>
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public String getMovieTime() {
        return movieTime;
    }
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           setMovieTime()
     * Description      setting movie time
     * @param movieTime -string
     * @author          <i>Robert Tang</i>
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public void setMovieTime(String movieTime) {
        this.movieTime = movieTime;
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           getAdultTickets()
     * Description      getting the ticket number os adult
     * @return String
     * @author          <i>Robert Tang</i>
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public int getAdultTickets() {
        return adultTickets;
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           setAdultTickets()
     * Description      setting the adult tickets
     * @param adultTickets-int
     * @author          <i>Robert Tang</i>
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public void setAdultTickets(int adultTickets) {
        this.adultTickets = adultTickets;
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           getChildSeniorTickets()
     * Description      getting the child/senior tickets
     * @return String
     * @author          <i>Robert Tang</i>
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public int getChildSeniorTickets() {
        return childSeniorTickets;
    }   
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           setChildSeniorTickets()
     * Description      settting the child/senior ticket numbers
     * @param childSeniorTickets-int
     * @author          <i>Robert Tang</i>
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public void setChildSeniorTickets(int childSeniorTickets) {
        this.childSeniorTickets = childSeniorTickets;
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           getAmount()
     * Description      getting the amount 
     * @return double
     * @author          <i>Robert Tang</i>
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public double getAmount() {
        return amount;
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           Default constructor
     * Description      setting the amount
     * @param amount -double
     * @author          <i>Robert Tang</i>
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           getTax()
     * Description      getting the tax
     * @return double
     * @author          <i>Robert Tang</i>
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public double getTax() {
        return tax;
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           setTax()
     * Description      setting tax.
     * @param tax-double
     * @author          <i>Robert Tang</i>
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public void setTax(double tax) {
        this.tax = tax;
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           getAmountDue()
     * Description      getting the amount due
     * @return double
     * @author          <i>Robert Tang</i>
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public double getAmountDue() {
        return amountDue;
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           setAmountDue()
     * Description      setting amount due
     * @param amountDue-double
     * @author          <i>Robert Tang</i>
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           getMovieRating()
     * Description      get movie rating
     * @return String
     * @author          <i>Robert Tang</i>
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public String getMovieRating() {
        return movieRating;
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           setMovieRating()
     * Description      set movie rating
     * @param movieRating-string
     * @author          <i>Robert Tang</i>
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           getMovieRunTime()
     * Description      get movie time
     * @return string
     * @author          <i>Robert Tang</i>
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public String getMovieRunTime() {
        return movieRunTime;
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           setMovieRunTime()
     * Description      set movie's run time.
     * @param movieRunTime-string
     * @author          <i>Robert Tang</i>
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public void setMovieRunTime(String movieRunTime) {
        this.movieRunTime = movieRunTime;
    }
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           getTransactionTimeDate()
     * Description      get transaction time and date
     * @return string
     * @author          <i>Robert Tang</i>
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public String getTransactionTimeDate() {
        return transactionTimeDate;
    }
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           setTransactionTimeDate()
     * Description      set transaction time and date.
     * @param transactionTimeDate -string
     * @author          <i>Robert Tang</i>
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public void setTransactionTimeDate(String transactionTimeDate) {
        this.transactionTimeDate = transactionTimeDate;
    }
}
