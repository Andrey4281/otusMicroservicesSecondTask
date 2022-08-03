package ru.otus.kubernetesshometasksecond.web.rest.error;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ErrorController {

    private final AtomicLong counter = new AtomicLong(0L);

    @GetMapping(value = "error")
    public ResponseEntity<Void> getRandomError() {
        ResponseEntity<Void> result;
        if (counter.get() % 3 == 0) {
            result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } else {
            result = ResponseEntity.ok().build();
        }
        counter.incrementAndGet();
        return result;
    }
}
