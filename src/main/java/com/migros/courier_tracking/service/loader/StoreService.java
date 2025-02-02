package com.migros.courier_tracking.service.loader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.migros.courier_tracking.model.dto.StoreDTO;
import com.migros.courier_tracking.util.JsonUtil;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Component
@Slf4j
public class StoreService {
    private List<StoreDTO> storeDTOList;
    private final ResourceLoader resourceLoader;

    @PostConstruct
    public void init() {
        try {
            this.saveAllStoreList();
        } catch (IOException e) {
            log.error("Magaza listesi yuklenirken hata oluştu.");
        }
    }

    private void saveAllStoreList() throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        final Resource resource = resourceLoader.getResource("classpath:stores.json");
        final InputStream inputStream = resource.getInputStream();

        storeDTOList = Arrays.asList(mapper.readValue(inputStream, StoreDTO[].class));
    }

    public List<StoreDTO> getStoreList() {
        return storeDTOList;
    }
}
