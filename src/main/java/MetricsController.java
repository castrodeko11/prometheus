package com.prometheus.Counter.MetricsController;

import com.prometheus.Counter.Metrics.Metrics;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@RestController
@RequestMapping("/duecreate/v1.0")
public class MetricsController {

    @GetMapping("hello")
    @ResponseBody
    public String hello(@RequestHeader("Branch") String branch) {
//        Metrics.ProcessMetrics(branch);

        // cutoff date:
        Instant lastThirdDays = Instant.now().minus(30, ChronoUnit.DAYS);

        File p = new File("C:\\Users\\castrodeko11\\Pictures\\Map-aws.jpg");

        Path path = Paths.get(p.toURI());

        try {
            boolean b = Files.isRegularFile(path)
                    && Files.getLastModifiedTime(path).toInstant().isAfter(lastThirdDays);
            System.out.println("Last Update File 30 days : " + b);

        } catch (IOException e) {
            e.printStackTrace();
        }


        long fileModified = p.lastModified();
        String dateFileCurrent = new SimpleDateFormat("dd-MM-yyyy").format(new Date(fileModified));
        System.out.println("Last Update File: " + dateFileCurrent);



        Metrics.processGetRequest(branch);

        return "Hello, Spring!";
    }

}
