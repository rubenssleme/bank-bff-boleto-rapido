package br.com.bank.rapd.bff.rapid.payment.adapter.monitoring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.availability.AvailabilityHealthContributorAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.availability.AvailabilityProbesAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.endpoint.EndpointAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.health.HealthEndpointAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.info.InfoEndpointAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.web.ManagementContextConfiguration;
import org.springframework.boot.actuate.autoconfigure.web.server.ManagementContextAutoConfiguration;
import org.springframework.boot.actuate.health.PingHealthIndicator;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.availability.ApplicationAvailabilityBean;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(
        classes = HealthCheckControllerTest.CustomApplicationContext.class,
        properties = {
                "management.endpoint.health.group.liveness.include=livenessState",
                "management.endpoint.health.group.readiness.include=readinessState"})
class HealthCheckControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void requisitaEndpointHealth_ViaGet_deveRetornar200ComServicoUP()
            throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/health"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("UP"));
    }

    @Test
    void requisitaEndpointHealthLiveness_ViaGet_deveRetornar200ComServicoUP()
            throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/health/liveness"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.status").value("UP"));
    }

    @Test
    void requisitaEndpointHealthReadiness_ViaGet_deveRetornar200ComServicoUP()
            throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/health/readiness"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.status").value("UP"));
    }

    @Test
    void requisitaEndpointMetrics_ViaGet_deveRetornar404()
            throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/metrics"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void requisitaEndpointInfo_ViaGet_deveRetornar404()
            throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/info"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void requisitaEndpointEnv_ViaGet_deveRetornar404()
            throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/env"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void requisitaEndpointHeapDump_ViaGet_deveRetornar404()
            throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/heapdump"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void requisitaEndpointMappings_ViaGet_deveRetornar404()
            throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/mappings"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Esta classe tem o objetivo de disponibilizar apenas os Auto-configurations específicos do Spring Boot Actuator.
     * <p>
     * Por default, a classe que possui @SpringBootApplication carrega todos os recursos do artefato desnessariamente,
     * ou seja, todos os Auto-configurations disponibilizaods pelas dependencias existentes no artefato. Quanto mais
     * dependencias inseridas no artefato, maior será o número de Auto-configurations carregados na execução dos
     * testes.
     *
     * <a href="https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#using.auto-configuration">...</a>
     */
    @Configuration
    @ManagementContextConfiguration
    @Import({
            EndpointAutoConfiguration.class,
            HealthEndpointAutoConfiguration.class,
            InfoEndpointAutoConfiguration.class,
            WebEndpointAutoConfiguration.class,
            ManagementContextAutoConfiguration.class,
            HealthCheckControllerTest.class,
            AvailabilityHealthContributorAutoConfiguration.class,
            AvailabilityProbesAutoConfiguration.class,
            PingHealthIndicator.class,
            ApplicationAvailabilityBean.class,
            MockMvcAutoConfiguration.class,
            WebMvcAutoConfiguration.class
    })
    public class CustomApplicationContext {

    }

}
