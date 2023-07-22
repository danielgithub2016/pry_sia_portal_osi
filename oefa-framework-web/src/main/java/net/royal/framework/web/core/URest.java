package net.royal.framework.web.core;

import java.util.Arrays;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class URest {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> T get(String url, Class clazz, Map<String, Object> parametros) {
		RestTemplate restTemplate = new RestTemplate();
		if (UValidador.esNulo(parametros))
			return (T) restTemplate.getForObject(url, clazz);
		else
			return (T) restTemplate.getForObject(url, clazz, parametros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> T post(String url, T objeto, Class clazz, Map<String, Object> parametros) {
		RestTemplate restTemplate = new RestTemplate();
		return (T) restTemplate.postForObject(url, objeto, clazz, parametros);
	}

	public void put(String url, Object objeto, Map<String, Object> parametros) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(url, objeto, parametros);
	}

	public static void delete(String url, Map<String, Object> parametros) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url, parametros);
	}

	public static byte[] getFile(String url, Map<String, Object> parametros) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new ByteArrayHttpMessageConverter());
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<byte[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, byte[].class, parametros);

		if (response.getStatusCode().equals(HttpStatus.OK)) {
			return response.getBody();
		}
		return null;
	}

}
