package com.example.demo.service;

import com.example.demo.integration.HelloIntegration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class HelloServiceTest {

    @Mock
    HelloIntegration helloIntegration;

    @InjectMocks
    HelloService helloService;

    @Test
    public void hello() {
        when(helloIntegration.hello()).thenReturn("hello");

        String result = helloService.hello();
        assertEquals("hello",result);

        verify(helloIntegration, times(1)).hello();
        verifyNoMoreInteractions(helloIntegration);
    }
}