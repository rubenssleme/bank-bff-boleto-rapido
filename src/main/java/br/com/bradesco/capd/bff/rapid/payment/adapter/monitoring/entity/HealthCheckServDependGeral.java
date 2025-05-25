package br.com.bank.capd.bff.rapid.payment.adapter.monitoring.entity;

import java.util.List;

/**
 * Health Check customizado especifico para identificar a saude dos servicos dependentes
 */
public record HealthCheckServDependGeral(List<HealthCheckServDepend> healthCheckServDependList,
                                         boolean todosServicosUP) {
}
