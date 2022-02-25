package com.prometheus.Counter.Metrics;

import io.prometheus.client.Counter;
import io.prometheus.client.hotspot.DefaultExports;

public class Metrics {

    public static final Counter requests = Counter.build()
            .name("requests_total").help("Total requests.").register();

    static final Counter branch = Counter.build()
            .name("Branch").help("branches.")
            .labelNames("Branch").register();

    private static int i = 0;

    public static void processGetRequest(String name) {
//        DefaultExports.initialize();

        branch.labels(name).inc();
        requests.inc();

        i += 1;
        System.out.println("Aqui: " + i );
    }

}
