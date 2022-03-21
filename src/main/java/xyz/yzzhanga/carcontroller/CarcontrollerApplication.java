package xyz.yzzhanga.carcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@SpringBootApplication
@RestController
public class CarcontrollerApplication {

    @Autowired
    private RedisQueUtils queue;

    public static void main(String[] args) {
        SpringApplication.run(CarcontrollerApplication.class, args);
    }


    @RequestMapping(path = "/send",method = RequestMethod.GET,params = "command")
    public String sendCommand( String command) {
        CommandEnum commandOrder = CommandEnum.valOf(command);
        if (Optional.ofNullable(commandOrder).isPresent()) {
            queue.pushQ(commandOrder.returnCommand());
            return "success";
        }
        return "command error";

    }


}


