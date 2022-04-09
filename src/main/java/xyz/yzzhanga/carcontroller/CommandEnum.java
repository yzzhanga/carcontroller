package xyz.yzzhanga.carcontroller;

public enum CommandEnum {
    LEFT("left","a"),
    RIGHT("right","d"),
        LEFT_DIAGONAL("left_diagonal","q"),
    RIGHT_DIAGONAL("right_diagonal","e"),
    LEFT_CONCERNING("left_concerning","r"),
    RIGHT_CONCERNING("right_concerning","t"),
    FORWARD("up","w"),
    BACKWARD("down","s"),
    right_turnround("right_turnround","g"),
    turn_of_rear_axis("turn_of_rear_axis","f"),
    STOP("stop","x");

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
