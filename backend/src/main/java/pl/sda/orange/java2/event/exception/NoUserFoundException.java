package pl.sda.orange.java2.event.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NoUserFoundException extends RuntimeException{

   public NoUserFoundException(String message){
       super(message);
       log.error(message);
   }
}
