package com.autotransparent.controller;

import com.autotransparent.model.Vehicle;
import com.autotransparent.service.UstaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UstaController.class)
class UstaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UstaService ustaService;

    @Test
    void shouldReturnVehicleWhenPlateExists() throws Exception {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(1L);
        vehicle.setPlate("06ABC001");
        vehicle.setBrand("Toyota");
        vehicle.setModel("Corolla");

        when(ustaService.searchVehicleByPlate("06ABC001")).thenReturn(vehicle);

        mockMvc.perform(get("/api/usta/vehicles/search").param("plate", "06ABC001"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.plate").value("06ABC001"))
                .andExpect(jsonPath("$.brand").value("Toyota"))
                .andExpect(jsonPath("$.model").value("Corolla"));

        verify(ustaService).searchVehicleByPlate(eq("06ABC001"));
    }
}
