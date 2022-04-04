package xyz.yzzhanga.carcontroller;

public enum CommandEnum {
     LEFT("left","a"),RIGHT("right","d"),FORWARD("up","w"),BACKWARD("down","s"),STOP("stop","x");

    private final String arg;
    private final String command;

     CommandEnum(String arg, String command){
         this.arg = arg;
         this.command = command;
     }

     public String returnCommand()
     {
         return command;
     }

     public static CommandEnum valOf(String cmd){
             for (CommandEnum value : CommandEnum.values()) {
                if (value.arg.equals(cmd)){
                    return value;
                }
         }
         return null;

     }

}
