package com.bigdata.navigation.service;


import com.bigdata.navigation.database.Chart;
import com.bigdata.navigation.database.ChartRepository;
import com.bigdata.navigation.model.JsonNavigationData;
import com.bigdata.navigation.model.NavigationData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class NavigationManager {
    private final PublisherRabbitMq rabbitMq;
    private final DataGenerator dataGenerator;
    private final JsonConverter jsonConverter;
    private final ChartRepository chartRepository;

    @Autowired
    public NavigationManager(PublisherRabbitMq rabbitMq, DataGenerator dataGenerator, JsonConverter jsonConverter,
                             ChartRepository chartRepository) {
        this.rabbitMq = rabbitMq;
        this.dataGenerator = dataGenerator;
        this.jsonConverter = jsonConverter;
        this.chartRepository = chartRepository;
    }

    public void generateAndSend() {
        Thread thread = new Thread(() -> {
            try {
                NavigationData navigationData = dataGenerator.generateStartData();
                List<JsonNavigationData> jsonNavigationData = dataGenerator.generateCarTripMessages(navigationData);

                for (JsonNavigationData jsonNavigationDatum : jsonNavigationData) {
                    String json = jsonConverter.getJson(jsonNavigationDatum);
                    rabbitMq.sendData(json);
                }

//                FileWriter fileWriter = new FileWriter("test");
//
//                for (JsonNavigationData jsonNavigationDatum : jsonNavigationData) {
//                    String json = jsonConverter.getJson(jsonNavigationDatum);
//                    fileWriter.write(json);
//                }
//                fileWriter.close();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        thread.start();
    }

    public Chart saveImage(JsonNode image) throws IOException {
        byte[] bytes = image.get("bytes").binaryValue();
        String title = image.get("title").toString();

        Chart chart = new Chart();
        chart.setImage(bytes);
        chart.setTitle(title);

        return chartRepository.save(chart);
    }

    public List<Chart> findAll(JsonNode image) {
        return chartRepository.findAll();
    }
}
