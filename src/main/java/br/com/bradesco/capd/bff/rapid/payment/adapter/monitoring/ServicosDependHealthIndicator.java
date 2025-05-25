package br.com.bank.capd.bff.rapid.payment.adapter.monitoring;

import br.com.bank.capd.bff.rapid.payment.config.HealthCheckEndpointConfig;
import br.com.bank.capd.bff.rapid.payment.adapter.monitoring.entity.HealthCheckServDepend;
import br.com.bank.capd.bff.rapid.payment.adapter.monitoring.entity.HealthCheckServDependGeral;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * OPCIONAL:
 * - Pode ser removido caso entenda que nao seja necessário
 * - Lembrar de excluir também o mapeamento no arquivo application.yml - management.endpoint.health.group.readiness.include
 * <p>
 * NOTA:
 * Por default, o HealthCheck do Spring Actuator já está ativo
 * <p>
 * HealthCheck personalizado específico para obter saúde/health APENAS dos serviços dependentes que possam retornar
 * UP/DOWN. Conforme novos serviços dependentes sejam necessários, basta apenas atualizar o mapeamento no arquivo
 * application.yml.
 */
//Caso deseje desligar esse health check, basta alterar o valor da tag management.health.servicosDependentes.enabled para false
//Também recomenda-se retirar a configuração da tag management.endpoint.health.group.readines.include para não considerar o status dos servicosDependentes
@ConditionalOnProperty(prefix = "management.health.servicosDependentes", name = "enabled", havingValue = "true")
@Component
public class ServicosDependHealthIndicator implements HealthIndicator {

    private static final Logger LOGGER_TECNICO = LoggerFactory.getLogger(ServicosDependHealthIndicator.class);

    private final HealthCheckEndpointConfig healthCheckEndpointConfig;
    private RestTemplate restTemplate;

    @Autowired
    public ServicosDependHealthIndicator(HealthCheckEndpointConfig healthCheckEndpointConfig,
                                         RestTemplate restTemplate) {
        this.healthCheckEndpointConfig = healthCheckEndpointConfig;
        this.restTemplate = restTemplate;
    }

    @Override
    public Health health() {
        HealthCheckServDependGeral servicosDependentes = verificaSaudeServicosDependentes();
        if (!servicosDependentes.todosServicosUP()) {
            return Health.down().withDetails(Map.of("statusServicosDependentes", servicosDependentes))
                    .build();
        }
        return Health.up().build();
    }

    /**
     * Responsavel por requisitar endpoint /health de servicos dependentes e obter status
     *
     * @return Pair<Boolean, Map < String, String>>
     * boolean indicando se todos os serviços estão UP,
     * Map devolve status UP/DOWN e o host
     */
    private HealthCheckServDependGeral verificaSaudeServicosDependentes() {
        List<HealthCheckServDepend> listaHealthCheckServDepend = null;
        boolean flagTodosServicosUp = false;
        List<String> urlsDependenteList = this.healthCheckEndpointConfig.getEndpoints();

        if (!CollectionUtils.isEmpty(urlsDependenteList)) {

            listaHealthCheckServDepend =
                    urlsDependenteList.stream()
                            .map(url -> CompletableFuture.supplyAsync(() ->
                                    requisitaEndpoint(url)))
                            .map(CompletableFuture::join).toList();

            flagTodosServicosUp = listaHealthCheckServDepend.stream().allMatch(healthResponseEntity ->
                    healthResponseEntity.health().getStatus().equals(Status.UP));
        }

        return new HealthCheckServDependGeral(listaHealthCheckServDepend, flagTodosServicosUp);
    }

    private HealthCheckServDepend requisitaEndpoint(String urlEndpointHealth) {
        try {
            ResponseEntity<Object> response = restTemplate.getForEntity(urlEndpointHealth, Object.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                return new HealthCheckServDepend(urlEndpointHealth, new Health.Builder().up().build());
            }
            //handle other status codes
        } catch (RestClientException ex) {
            LOGGER_TECNICO.error("Error while trying to request endpoint /health from URL {}",
                    urlEndpointHealth, ex);
        }
        return new HealthCheckServDepend(urlEndpointHealth, new Health.Builder().down().build());
    }

}
