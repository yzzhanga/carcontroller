package xyz.yzzhanga.carcontroller;

public enum CommandEnum {
     LEFT("left","a"),RIGHT("right","d"),FORWARD("forward","w"),BACKWARD("backward","s"),STOP("stop","x");

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

     public static CommandEnum valOf(String arg){
         for (CommandEnum value : CommandEnum.values()) {
                if (value.arg.equals(arg)){
                    return value;
                }
         }
         return null;

     }

}
