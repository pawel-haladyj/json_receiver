package pl.haladyj.wzjsontemplate.resource;

import org.springframework.web.bind.annotation.*;
import pl.haladyj.wzjsontemplate.model.Wz;
import pl.haladyj.wzjsontemplate.service.WzService;
import pl.haladyj.wzjsontemplate.service.dto.WzDto;

@RestController
@RequestMapping("/api")
public class WzResource {

    private final WzService wzService;

    public WzResource(WzService wzService) {
        this.wzService = wzService;
    }

    @PostMapping("/wz")
    public Wz createWz(@RequestBody WzDto wzDto){
        return wzService.createWz(wzDto);
    }
}
