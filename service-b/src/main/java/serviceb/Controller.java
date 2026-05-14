package serviceb;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @PostMapping("/test")
    public ResponseEntity<Response> metodo(@RequestBody Request request){
        if (request.numero()>0){
            return ResponseEntity.ok(new Response("mayor que 0"));
        }
        return ResponseEntity.ok(new Response("menor o igual que 0"));
    }
}
