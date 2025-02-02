package com.migros.courier_tracking.controller;

import com.migros.courier_tracking.model.request.CourierLocationUpdateRequest;
import com.migros.courier_tracking.model.response.OperationResult;
import com.migros.courier_tracking.service.business.CourierOperationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = CourierOperationController.class)
@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = CourierOperationController.class)
class CourierOperationControllerTest {
    @MockBean
    private CourierOperationService courierOperationService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testUpdateLocation() throws Exception {
        //given
        CourierLocationUpdateRequest request = new CourierLocationUpdateRequest();
        request.setCourierId(1L);
        request.setLatitude(17.78797);
        request.setLongitude(17.8797);

        when(courierOperationService.updateLocation(request)).thenReturn(new OperationResult());

        final String requestJSON = objectMapper.writeValueAsString(request);

        //when
        final MvcResult mvcResult = mockMvc.perform(post("/courier-operation/courier-location")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJSON))
                .andExpect(status().isOk())
                .andReturn();

        //then
        Assertions.assertNotNull(mvcResult);
        Mockito.verify(courierOperationService, Mockito.times(1)).updateLocation(Mockito.any(CourierLocationUpdateRequest.class));
    }

    @Test
    void testGetTotalTravelDistance() throws Exception {
        //given
        Long courierId = 1L;
        Double distance = 10.0;

        when(courierOperationService.getTotalTravelDistance(courierId)).thenReturn(distance);

        //when
        MvcResult mvcResult = mockMvc.perform(get("/courier-operation/distance/{courierId}", courierId.intValue()))
                .andExpect(status().isOk())
                .andReturn();

        //then
        Assertions.assertNotNull(mvcResult);
    }
}