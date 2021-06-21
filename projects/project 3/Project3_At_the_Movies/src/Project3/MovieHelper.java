package Project3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <pre>
 * File         MovieHelper.java
 * Project      At the Movies
 * Description  This class provides the methods to import movie data from 
 *              a external file, return the movie list in array.
 * Platform     Mac, Big Sur 11.2.3, jdk 1.8.0_241, NetBeans IDE 12.3
 * Date         6/3/2021
 * History Log
 * @author      <i>Robert Tang</i>
 * @version 1.0.0
 * </pre>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class MovieHelper {
    ArrayList<MovieBasic> movieList ;
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           MovieHelper()
     * Description      Default constructor
     * @author          <i>Robert Tang</i>
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public MovieHelper() {
    }
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           importMovieData()
     * Description      Import movie data from an external file.
     * @param filePath-string
     * @author          <i>Robert Tang</i>
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public void importMovieData(String filePath) {
        try {
            movieList = new ArrayList<>();
            
            BufferedReader bufferedReder = new BufferedReader(new FileReader(filePath));
            String strLine;
            
            while ((strLine = bufferedReder.readLine()) != null) {
                // add data to the movieList.
                List<String> item = Arrays.asList(strLine.split(","));
                
                MovieBasic movieItem = new MovieBasic();
                movieItem.setMovieName(item.get(0));
                movieItem.setMovieRating(item.get(1));
                movieItem.setMovieRunTime(item.get(2));
                movieList.add(movieItem);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MovieGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MovieGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MovieGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           getMovieList()
     * Description      Get the movie list where it stores the movie data.
     * @return ArrayList
     * @author          <i>Robert Tang</i>
     * Date 6/6/2021
     * </pre>
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    public ArrayList<MovieBasic> getMovieList() {
        return movieList;
    }
    
}
