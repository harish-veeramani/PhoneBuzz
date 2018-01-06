package controllers;

import com.twilio.twiml.voice.Gather;
import com.twilio.twiml.voice.Say;
import com.twilio.twiml.*;
import spark.Route;
import util.Config;
import util.Helper;

public class ReceiveCall {

    public static Route call = (request, response) -> {
        Say sayMessage = new Say.Builder("Hello! Please enter a number for Fizz Buzz. Enter # when finished.").build();
        Gather input = new Gather.Builder().timeout(3).say(sayMessage).action("/handle-number").build();
        VoiceResponse twiml = new VoiceResponse.Builder().gather(input).build();

        return twiml.toXml();
        };

    public static Route fizzBuzz = (request, response) -> {
        String digit = request.queryParams("Digits");
        String toNumber = request.queryParams("To");
        String sid = request.queryParams("CallSid");
        System.out.println("To: " + toNumber + " | Sid: " + sid);
        int number = Integer.parseInt(digit);
        Say message = Helper.fizzBuzz(number);
        VoiceResponse twiml = new VoiceResponse.Builder().say(message).build();

        if (!toNumber.equals(Config.TWILIO_NUMBER)){
            System.out.println("Here: after fizz buzz");
            Helper.addCallToLog(sid, digit);
        }

        return twiml.toXml();
    };

    public static Route createReplay = ((request, response) -> {
        String sid = request.queryParams("CallSid");
        String digit = Helper.getPhoneCall(sid).getCount();
        int number = Integer.parseInt(digit);
        Say message = Helper.fizzBuzz(number);
        VoiceResponse twiml = new VoiceResponse.Builder().say(message).build();
        Helper.addCallToLog(sid, null);
        return twiml.toXml();
    });
}
