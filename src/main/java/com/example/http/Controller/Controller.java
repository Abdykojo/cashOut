package com.example.http.Controller;
import com.example.http.request.*;
import com.example.http.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/cash")
@RequiredArgsConstructor
public class Controller {

    private final CheckService checkService;
    private final PayService service;
    private final CheckStatusService statusService;
    private final CardsService cardsService;
    private final AuthService authService;


    @PostMapping(value = "/check",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> sendCheck(@RequestBody CheckRequest request) {
                return ResponseEntity.ok(checkService.checkPayment(request));
            }

    @PostMapping(value = "/pay",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> sendCheck(@RequestBody PayRequest request) {
              return ResponseEntity.ok(service.pay(request));

    }

    @PostMapping(value = "/status",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> sendCheck(@RequestBody CheckStatusRequest request) {
              return ResponseEntity.ok(statusService.checkStatus(request));
         }

    @PostMapping(value = "/cards",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> getCards(@RequestBody CardsRequest request) {
        return ResponseEntity.ok(cardsService.createCard(request));
    }
    @PostMapping(value = "/register",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.registration(request));
    }

}
