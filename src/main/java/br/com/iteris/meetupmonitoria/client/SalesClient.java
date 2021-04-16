package br.com.iteris.meetupmonitoria.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "SalesClient")
public interface SalesClient {
}
