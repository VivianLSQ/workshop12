package sg.nus.edu.visa.ssf.workshop12.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import sg.nus.edu.visa.ssf.workshop12.model.Image;
import sg.nus.edu.visa.ssf.workshop12.service.RandNumService;

@Controller
//@RequestMapping(path="api")
public class RandNumGeneratorController {
    //Two requests (Handle HTML and Submit button), so 2 methods

    //can create logger object to print logs (for debugging)

    @Autowired
    RandNumService service; 
    //Inject dependencies (aka autowiring) - there are other ways 
    //Use service object to call Service method -> inject service class dependency
    
    //for landing page
    @GetMapping("/home")
    public  String landingPage(){
        return "home"; 
    }

    //GET method is used for HTTP
    @GetMapping("/get")
    public  String generateRandNumbers(Model model, HttpServletRequest request){
        int number =Integer.parseInt(request.getParameter("number")); 

        System.out.println("Number input is" + number);
        
        if(number<1 || number >30){
            //create another line to show error message instead of hardcoding it to attributeValue
            String errorMessage = "Invalid Number: " + number;
            model.addAttribute("errorMessage", errorMessage);
            return "home";  
        }
    //Call service method 
       List<Integer> randomNumbers = service.generateRandNumbers(number); 
    
    //Populate image objects 
       List<Image> imageList = new ArrayList<Image>();

       for(int randomNumber: randomNumbers){
        imageList.add(new Image(Integer.toString(randomNumber),"/images/" + Integer.toString(randomNumber)+ ".png"));
       }
        
       System.out.println("--->"+imageList); //This is for us to check if imageList is created
       model.addAttribute(imageList); 
       
        return "display"; 
    }
    
    
}
