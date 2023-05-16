package sg.nus.edu.visa.ssf.workshop12.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class RandNumService {
    //Generate rand numbers using logic 

    public List<Integer> generateRandNumbers(int number){
        return new Random().ints(1, 31).distinct().limit(number).boxed().collect(Collectors.toList()); 
    }
}
