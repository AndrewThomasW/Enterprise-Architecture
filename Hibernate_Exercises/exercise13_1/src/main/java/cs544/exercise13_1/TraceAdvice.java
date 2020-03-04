package cs544.exercise13_1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDate;
import org.springframework.util.StopWatch;

@Aspect
public class TraceAdvice {
    @After("execution(* cs544.exercise13_1.EmailSender.sendEmail(..)) && args(email,message)")
    public void traceAfterMethod(JoinPoint joinPoint, String email, String message) {

        LocalDate today = LocalDate.now();
        String outgoingMailServer = ((EmailSender) joinPoint.getTarget()).getOutgoingMailServer();

        System.out.print(today + " method= " + joinPoint.getSignature().getName());
        System.out.print(" address= " + email + " message= " + message);
        System.out.print(" outgoingMailServer = " + outgoingMailServer);

    }
    @Around("execution(* cs544.exercise13_1.CustomerDAO.save(..))")
    public Object invoke(ProceedingJoinPoint call) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();

        long totaltime = sw.getLastTaskTimeMillis();
        // print the time to the console
        System.out.println("Time to execute save = " + totaltime + " ms");

        return retVal;
    }

}
