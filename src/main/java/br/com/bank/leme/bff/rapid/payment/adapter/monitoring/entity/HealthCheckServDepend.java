package br.com.bank.leme.bff.rapid.payment.adapter.monitoring.entity;

import org.springframework.boot.actuate.health.Health;

/**
 * Health Check customizado especifico para identificar a saude dos servicos dependentes
 */
public record HealthCheckServDepend(String url, Health health) {
}
