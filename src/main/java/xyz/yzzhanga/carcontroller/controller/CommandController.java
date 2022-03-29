package xyz.yzzhanga.carcontroller.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xyz.yzzhanga.carcontroller.CommandEnum;
import xyz.yzzhanga.carcontroller.RedisQueUtils;
import xyz.yzzhanga.carcontroller.protocol.Request;
import xyz.yzzhanga.carcontroller.protocol.Response;

import java.util.Optional;

@RestController
public class CommandController {

    @Autowired
    private RedisQueUtils queue;

    public Response<Integer,String> send(Request command) {

        return null;
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
